package UserInterfaceLayer.Controller.Admin;

import BusinessLogicLayer.ServiceImp.OrderServiceImp;
import BusinessLogicLayer.ServiceInterface.OrderService;
import BusinessLogicLayer.Utils.HttpUtils;
import DataAccessLayer.Bean.Bo.Order.ChangeOrderBo;
import DataAccessLayer.Bean.Bo.Order.OrderPageBo;
import DataAccessLayer.Bean.Vo.Order.OrderVo;
import UserInterfaceLayer.View.Result;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @auther tian
 * @date 2020/8/11 10:32 下午
 * @JDK_version JDK1.8
 */
@WebServlet("/api/admin/order/*")
public class Servlet_Order extends HttpServlet
{
	private OrderService orderService = new OrderServiceImp();

	private Gson gson = new Gson();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/order/", "");
		if("ordersByPage".equals(action))
		{
			ordersByPage(request, response);
		}
		else if("changeOrder".equals(action))
		{
			changeOrder(request, response);
		}
 	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/order/", "");
		if("order".equals(action))
		{
			order(request, response);
		}
		else if("deleteOrder".equals(action))
		{
			deleteOrder(request, response);
		}
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestParameter = request.getParameter("id");
		Integer orderId = Integer.parseInt(requestParameter);
		int deleteOrderResult = orderService.deleteOrder(orderId);
		if(deleteOrderResult == 0)
			response.getWriter().println(Result.ok("删除成功"));
		else
			response.getWriter().println(Result.error("删除失败"));
	}

	private void changeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestBody = HttpUtils.requestBodyToString(request);
		ChangeOrderBo changeOrderBo = gson.fromJson(requestBody, ChangeOrderBo.class);
		int changeOrderResult = orderService.changeOrder(changeOrderBo);
		if(changeOrderResult == 0)
			response.getWriter().println(Result.ok("修改成功"));
		else
			response.getWriter().println(Result.error("修改失败"));
	}

	private void order(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestParameter = request.getParameter("id");
		Integer orderId = Integer.parseInt(requestParameter);
		OrderVo order = orderService.order(orderId);
		response.getWriter().println(Result.ok(order));
	}

	private void ordersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestBody = HttpUtils.requestBodyToString(request);
		OrderPageBo orderPageBo = null;
		try
		{
			orderPageBo = gson.fromJson(requestBody, OrderPageBo.class);
			//如果传来的不是Double类型的值，就进行报错处理
			if(!StringUtils.isEmpty(orderPageBo.getMoneyLimit1()))
			{
				Double.parseDouble(orderPageBo.getMoneyLimit1());
			}
			if(!StringUtils.isEmpty(orderPageBo.getMoneyLimit1()))
			{
				Double.parseDouble(orderPageBo.getMoneyLimit1());
			}
		} catch(Exception e)
		{
			response.getWriter().println(Result.error("参数类型不正确"));
			return;
		}

		Map<String, Object> ordersMap = orderService.ordersByPage(orderPageBo);
		//因为Map就是健值对形式存在，所以封装在data中就是json形式
		response.getWriter().println(Result.ok(ordersMap));
	}

}
