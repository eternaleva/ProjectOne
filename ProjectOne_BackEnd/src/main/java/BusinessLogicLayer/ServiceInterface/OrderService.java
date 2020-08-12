package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Bo.Order.ChangeOrderBo;
import DataAccessLayer.Bean.Bo.Order.OrderPageBo;
import DataAccessLayer.Bean.Vo.Order.OrderVo;

import java.util.Map;

/**
 * @auther tian
 * @date 2020/8/11 10:37 下午
 * @JDK_version JDK1.8
 */
public interface OrderService
{
	Map<String, Object> ordersByPage(OrderPageBo orderPageBo);

	OrderVo order(Integer id);

	int changeOrder(ChangeOrderBo changeOrderBo);

	int deleteOrder(Integer orderId);
}
