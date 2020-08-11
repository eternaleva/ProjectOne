package UserInterfaceLayer.Controller;

import BusinessLogicLayer.ServiceImp.GoodsServiceImp;
import BusinessLogicLayer.ServiceInterface.GoodsService;
import BusinessLogicLayer.Utils.FileUploadUtils;
import BusinessLogicLayer.Utils.HttpUtils;
import DataAccessLayer.Bean.Bo.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Vo.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.GoodsVo;
import UserInterfaceLayer.View.Result;
import com.google.gson.Gson;

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
 * @date 2020/8/8 12:27 下午
 * @JDK_version JDK1.8
 */
@WebServlet("/api/admin/goods/*")
public class Servlet_Goods extends HttpServlet
{
	//一个goodService
	private GoodsService goodsService = new GoodsServiceImp();

	private Gson gson = new Gson();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/goods/", "");
		if("imgUpload".equals(action))
		{
			imgUpload(request, response);
		}
		else if("addGoods".equals(action))
		{
			addGoods(request, response);
		}
		else if("addType".equals(action))
		{
			addType(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/goods/", "");
		if("getType".equals(action))
		{
			getType(request, response);
		}
		else if("getGoodsByType".equals(action))
		{
			getGoodsByType(request, response);
		}
	}

	private void addType(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestParameter = HttpUtils.requestBodyToString(request);
		GoodsVo goodsVo = gson.fromJson(requestParameter, GoodsVo.class);
		int addTypeResult = goodsService.addGoodsType(goodsVo);
		if(addTypeResult == 0)
			response.getWriter().println(Result.ok("添加成功"));
		else
			response.getWriter().println((Result.error("添加失败")));
	}

	private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestParameter = request.getParameter("typeId");
		Integer typeId = Integer.parseInt(requestParameter);
		List<GoodsVo> goods = goodsService.getGoodsByType(typeId);
		response.getWriter().println(Result.ok(goods));
	}

	private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		List<GoodsTypeVo> goodTypes = goodsService.getType();
		response.getWriter().println(Result.ok(goodTypes));
	}

	private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//获取文件上传的Map参数
		Map<String, Object> postParameter = FileUploadUtils.fileUpload(request);
		String goodFilePath = (String) postParameter.get("uploadFile");
		//因为如果没写端口号，默认就是从浏览器对应的访问端口获取数据（本例中为8085，而实际数据上传在8004）
		//因此，可以使用全路径，将domain写在Context域中，需要时候从中获取并且拼接
		//创建listener，在创建Servlet的时候，创建Context就将domain内容存放进去
		Object domain = getServletContext().getAttribute("domain");
		response.getWriter().println(Result.ok(domain + goodFilePath));
	}

	private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//把获取的post请求的json对象封装成Java对象
		String requestBody = HttpUtils.requestBodyToString(request);
		AddGoodsBo addGoodsBo = gson.fromJson(requestBody, AddGoodsBo.class);
		goodsService.addGood(addGoodsBo);
		response.getWriter().println(Result.ok());
	}

}
