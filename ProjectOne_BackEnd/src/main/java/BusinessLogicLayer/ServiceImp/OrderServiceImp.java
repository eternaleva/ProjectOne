package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.OrderService;
import DataAccessLayer.Bean.Bo.Order.ChangeOrderBo;
import DataAccessLayer.Bean.Bo.Order.OrderPageBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Order.OrderVo;
import DataAccessLayer.Bean.Vo.Order.OrdersPageVo;
import DataAccessLayer.DaoImp.OrderDaoImp;
import DataAccessLayer.DaoInterface.OrderDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther tian
 * @date 2020/8/11 10:37 下午
 * @JDK_version JDK1.8
 */
public class OrderServiceImp implements OrderService
{
	private OrderDao orderDao = new OrderDaoImp();

	@Override
	public Map<String, Object> ordersByPage(OrderPageBo orderPageBo)
	{
		//分页查询
		Integer totalNum = orderDao.getTotalOrders(orderPageBo);
		List<OrdersPageVo> ordersPageList = orderDao.ordersByPage(orderPageBo);
		Map map = new HashMap();
		map.put("total", totalNum);
		map.put("orders", ordersPageList);
		return map;
	}

	@Override
	public OrderVo order(Integer id)
	{
		//id是订单id，先根据订单id获取orderVo信息
		OrderVo orderVo = orderDao.order(id);
		//把订单id转换为商品id
		Integer goodsId = orderDao.exchange(id);
		List<GoodsSpecVo> goodsSpecVoList = orderDao.getGoodsSpecList(goodsId);
		orderVo.setSpecList(goodsSpecVoList);

		return orderVo;
	}

	@Override
	public int changeOrder(ChangeOrderBo changeOrderBo)
	{
		return orderDao.changeOrder(changeOrderBo);
	}

	@Override
	public int deleteOrder(Integer orderId)
	{
		return orderDao.deleteOrder(orderId);
	}
}
