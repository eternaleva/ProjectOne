package DataAccessLayer.DaoImp;

import BusinessLogicLayer.Utils.DruidUtils;
import DataAccessLayer.Bean.Bo.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Vo.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.GoodsVo;
import DataAccessLayer.DaoInterface.GoodsDao;
import org.apache.commons.dbutils.QueryRunner;
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
	QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

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
			//线程级，返回刚刚新插入的id，不受其他并发线程影响
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
}
