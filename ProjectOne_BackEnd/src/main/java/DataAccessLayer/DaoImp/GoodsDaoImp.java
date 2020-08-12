package DataAccessLayer.DaoImp;

import BusinessLogicLayer.Utils.DruidUtils;
import DataAccessLayer.Bean.Bo.Goods.GoodsSpecBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsInfoVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsVo;
import DataAccessLayer.DaoInterface.GoodsDao;
import com.google.gson.Gson;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/8 12:31 下午
 * @JDK_version JDK1.8
 */
public class GoodsDaoImp implements GoodsDao
{
	private QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
	private Gson gson = new Gson();
	@Override
	public List<GoodsTypeVo> getType()
	{
		List<GoodsTypeVo> goodTypes = new ArrayList<>();
		try
		{
			goodTypes = runner.query("select * from goods_type", new BeanListHandler<>(GoodsTypeVo.class));
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return goodTypes;
	}

	@Override
	public List<GoodsVo> GetGoodsByType(Integer typeId)
	{
		List<GoodsVo> goods = new ArrayList<>();
		try
		{
			goods = runner.query("select * from goods where typeId = ?",
					new BeanListHandler<>(GoodsVo.class),
					typeId);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return goods;
	}

	@Override
	public void addGood(GoodsVo goodsVo)
	{
		try
		{
			//返回值是改变的行数，所以需要另取id值
			runner.update("insert into goods values(null, ?, ?, ?, ?, ?, ?)",
					goodsVo.getTypeId(),
					goodsVo.getImg(),
					goodsVo.getName(),
					goodsVo.getPrice(),
					goodsVo.getStockNum(),
					goodsVo.getDesc()
					);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
	}

	@Override
	public int lastInsertId()
	{
		BigInteger id = null;
		try
		{
			//线程级，返回刚刚新插入的id，不受其他并发线程影响，返回的是BigInteger
			id = runner.query("select last_insert_id()", new ScalarHandler<>());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return id.intValue();
	}

	@Override
	public void addGoodsSpec(List<GoodsSpecVo> goodsSpecVos)
	{
		for (GoodsSpecVo goodsSpecVo : goodsSpecVos)
		{
			try
			{
				runner.update("insert into goods_spec values (null, ?, ?, ?, ?)",
						goodsSpecVo.getSpecName(),
						goodsSpecVo.getStockNum(),
						goodsSpecVo.getUnitPrice(),
						goodsSpecVo.getGoodsId());
			} catch (SQLException throwables)
			{
				throwables.printStackTrace();
			}
		}

	}

	@Override
	public int addGoodsType(GoodsVo goodsVo)
	{
		try
		{
			runner.update("insert into goods_type values (null, ?)",
					goodsVo.getName());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		};
		return 0;
	}

	@Override
	public int deleteGoods(String requestParameter)
	{
		try
		{
			Long stockNum = runner.query("select count(stockNum) from goods_spec where goodsId = ?",
					new ScalarHandler<>(),
					Integer.parseInt(requestParameter));
			if(stockNum > 0)
				return -2;
			runner.update("delete from goods where id = ?",
					Integer.parseInt(requestParameter));
			runner.update("delete from goods_spec where goodsId = ?",
					Integer.parseInt(requestParameter));
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int updateGoods(GoodsVo goodsVo, List<GoodsSpecVo> goodsSpecVoList)
	{
		try
		{
			runner.update("update goods set typeId = ?, img = ?, name = ?, price = ?, stockNum = ?, `desc` = ? where id = ?",
					goodsVo.getTypeId(),
					goodsVo.getImg(),
					goodsVo.getName(),
					goodsVo.getPrice(),
					goodsVo.getStockNum(),
					goodsVo.getDesc(),
					goodsVo.getId());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		try
		{
			runner.update("delete from goods_spec where goodsId = ?",
					goodsVo.getId());
			for (GoodsSpecVo goodsSpecVo : goodsSpecVoList)
			{
				runner.update("insert into goods_spec values(id, ?, ?, ?, ?)",
						goodsSpecVo.getSpecName(),
						goodsSpecVo.getStockNum(),
						goodsSpecVo.getUnitPrice(),
						goodsSpecVo.getGoodsId());
			}

		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -2;
		}

		return 0;
	}

	@Override
	public GoodsInfoVo getGoodsInfo(Integer id)
	{
		GoodsVo goodsVo = null;
		List<GoodsSpecVo> goodsSpecVoList = new ArrayList<>();
		try
		{
			goodsVo = runner.query("select * from goods where id = ?",
					new BeanHandler<>(GoodsVo.class),
					id);
			goodsSpecVoList = runner.query("select * from goods_spec where goodsId = ?",
					new BeanListHandler<>(GoodsSpecVo.class),
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsSpecVoList, goodsVo);
		return goodsInfoVo;
	}

	@Override
	public int addSpec(GoodsSpecBo goodsSpecBo)
	{
		try
		{
			long IsDuplicate = runner.query("select count(id) from goods_spec where specName = ? and goodsId = ?",
					new ScalarHandler<>(),
					goodsSpecBo.getSpecName(),
					goodsSpecBo.getGoodsId());
			if(IsDuplicate > 0)
				return -2;
			runner.update("insert into goods_spec values (null, ?, ?, ?, ?)",
					goodsSpecBo.getSpecName(),
					goodsSpecBo.getStockNum(),
					goodsSpecBo.getUnitPrice(),
					goodsSpecBo.getGoodsId());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int deleteSpec(GoodsSpecBo goodsSpecBo)
	{
		try
		{
			runner.update("delete from goods_spec where goodsId = ? and specName = ?",
					goodsSpecBo.getGoodsId(),
					goodsSpecBo.getSpecName());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int deleteType(int typeId)
	{
		try
		{
			long goodsNum = runner.query("select count(id) from goods where typeId = ?",
					new ScalarHandler<>(),
					typeId);
			if(goodsNum > 0)
				return -1;
			runner.update("delete from goods_type where id = ?",
					typeId);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -2;
		}
		return 0;
	}
}
