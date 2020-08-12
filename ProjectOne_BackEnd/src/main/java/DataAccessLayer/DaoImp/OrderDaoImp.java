package DataAccessLayer.DaoImp;

import BusinessLogicLayer.Utils.DruidUtils;
import DataAccessLayer.Bean.Bo.Order.ChangeOrderBo;
import DataAccessLayer.Bean.Bo.Order.OrderPageBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Order.OrderVo;
import DataAccessLayer.Bean.Vo.Order.OrdersPageVo;
import DataAccessLayer.Bean.Vo.Order.curSpecVo;
import DataAccessLayer.DaoInterface.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther tian
 * @date 2020/8/11 11:32 下午
 * @JDK_version JDK1.8
 */
public class OrderDaoImp implements OrderDao
{
	QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

	@Override
	public Integer getTotalOrders(OrderPageBo orderPageBo)
	{
		Map<String, Object> sqlParams = getDynamicSql(orderPageBo);
		String sql = (String) sqlParams.get("sql");
		List params = (List) sqlParams.get("params");

		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		Long totalNum = null;
		try
		{
			totalNum = runner.query("select Count(id) from orders" + sql,
					new ScalarHandler<>(),
					params.toArray());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return totalNum.intValue();
	}

	@Override
	public List<OrdersPageVo> ordersByPage(OrderPageBo orderPageBo)
	{
		Map<String, Object> sqlParams = getDynamicSql(orderPageBo);
		String sql = (String) sqlParams.get("sql");
		List params = (List) sqlParams.get("params");
		params.add(orderPageBo.getPagesize());
		params.add((orderPageBo.getCurrentPage() - 1) * orderPageBo.getPagesize());
		QueryRunner runner = new QueryRunner((DruidUtils.getDataSource()));
		List<OrdersPageVo> ordersPageVoList = new ArrayList<>();
		try
		{
			ordersPageVoList = runner.query("select * from orders" + sql + " limit ? offset ?",
					new BeanListHandler<OrdersPageVo>(OrdersPageVo.class),
					params.toArray());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return ordersPageVoList;
	}

	@Override
	public List<GoodsSpecVo> getGoodsSpecList(Integer id)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		List<GoodsSpecVo> goodsSpecVoList = new ArrayList<>();
		try
		{
			goodsSpecVoList = runner.query("select * from goods_spec where goodsId = ?",
					new BeanListHandler<GoodsSpecVo>(GoodsSpecVo.class),
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return goodsSpecVoList;
	}

	@Override
	public OrderVo order(Integer id)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		OrderVo orderVo = new OrderVo();

		try
		{
			orderVo	 = runner.query("select * from orders where id = ?",
					new BeanHandler<OrderVo>(OrderVo.class),
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return orderVo;
	}

	@Override
	public Integer exchange(Integer id)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		Integer goodsId = null;
		try
		{
			goodsId = runner.query("select goodsId from orders where id = ?",
					new ScalarHandler<>(),
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return goodsId;
	}

	@Override
	public int changeOrder(ChangeOrderBo changeOrderBo)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		try
		{
			runner.update("update orders set stateId = ?, specId = ?, goodsNum = ?",
					changeOrderBo.getState(),
					changeOrderBo.getSpec(),
					changeOrderBo.getNum());
			double price = runner.query("select price from orders where id = ?",
					new ScalarHandler<>(),
					changeOrderBo.getId());
			runner.update("update orders set amount = ?",
					price * changeOrderBo.getNum());
		}catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int deleteOrder(Integer orderId)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
		try
		{
			runner.update("delete from orders where id = ?",
					orderId);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	private Map<String, Object> getDynamicSql(OrderPageBo orderPageBo)
	{
		String baseSql = " where 1 = 1 ";
		//
		List<Object> list = new ArrayList<>();
		if(orderPageBo.getState() != -1)
		{
			baseSql += "and stateId = ?";
			list.add(orderPageBo.getState());
		}
		if(!StringUtils.isEmpty(orderPageBo.getGoods()))
		{
			baseSql += "and goods like ?";
			list.add("%" + orderPageBo.getGoods() + "%");
		}
		if(!StringUtils.isEmpty(orderPageBo.getMoneyLimit1()))
		{
			baseSql += "and amount <= ?";
			list.add(orderPageBo.getMoneyLimit1());
		}
		if(!StringUtils.isEmpty(orderPageBo.getMoneyLimit2()))
		{
			baseSql += "and amount >= ?";
			list.add(orderPageBo.getMoneyLimit2());
		}
		if(!StringUtils.isEmpty(orderPageBo.getName()))
		{
			baseSql += "and name like ?";
			list.add(orderPageBo.getName());
		}
		if(!StringUtils.isEmpty(orderPageBo.getId()))
		{
			baseSql += "and id = ?";
			list.add(orderPageBo.getId());
		}
		if(!StringUtils.isEmpty(orderPageBo.getAddress()))
		{
			baseSql += "and address like ?";
			list.add("%" + orderPageBo.getAddress() + "%");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("sql", baseSql);
		map.put("params", list);

		return map;
	}
}
