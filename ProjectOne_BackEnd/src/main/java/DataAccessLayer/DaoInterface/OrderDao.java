package DataAccessLayer.DaoInterface;

import DataAccessLayer.Bean.Bo.Order.ChangeOrderBo;
import DataAccessLayer.Bean.Bo.Order.OrderPageBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Order.OrderVo;
import DataAccessLayer.Bean.Vo.Order.OrdersPageVo;
import DataAccessLayer.Bean.Vo.Order.curSpecVo;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/11 11:32 下午
 * @JDK_version JDK1.8
 */
public interface OrderDao
{
//	List<OrdersPageVo> ordersByPage(OrderPageBo orderPageBo);

	Integer getTotalOrders(OrderPageBo orderPageBo);

	List<OrdersPageVo> ordersByPage(OrderPageBo orderPageBo);

	List<GoodsSpecVo> getGoodsSpecList(Integer id);

	OrderVo order(Integer id);

	Integer exchange(Integer id);

	int changeOrder(ChangeOrderBo changeOrderBo);

	int deleteOrder(Integer orderId);
}
