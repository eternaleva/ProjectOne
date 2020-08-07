package UserInterfaceLayer.Controller;

import BusinessLogicLayer.Utils.HttpUtils;
import DataAccessLayer.Bean.Bo.AdminBo;
import BusinessLogicLayer.ServiceInterface.AdminService;
import BusinessLogicLayer.ServiceImp.AdminServiceImp1;
import DataAccessLayer.Bean.Vo.AdminInfo;
import DataAccessLayer.Bean.Vo.AdminVo;
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

/**
 * @auther tian
 * @date 2020/8/6 1:18 上午
 * @JDK_version JDK1.8
 */
@WebServlet("/api/admin/admin/*")
public class Servlet_Admin extends HttpServlet
{
	private Gson gson = new Gson();
	//创建一个Service对象，用作业务逻辑处理
	private AdminService adminService = new AdminServiceImp1();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//获取所有管理员用户信息
		//获取URI，然后分发逻辑
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/admin/", "");
		if("allAdmins".equals(action))
		{
			//分发给getAllAdmins处理
			getAllAdmins(request, response);
		}
		else if("deleteAdmins".equals(action))
		{
			deleteAdmin(request, response);
		}
		else if("getAdminsInfo".equals(action))
		{
			getAdminInfo(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//做Post分发处理
		//获取requestURI（不能getContext，因为是/*，获取不到）
		String requestURI = request.getRequestURI();
		//删掉多余字符
		String action = requestURI.replace("/api/admin/admin/", "");
		//分发到login方法
		if("login".equals(action))
		{
			login(request, response);
		}
		else if("addAdminss".equals(action))
		{
			addAdmin(request, response);
		}
		else if("updateAdminss".equals(action))
		{
			alterAdminInfo(request, response);
		}
		else if("getSearchAdmins".equals(action))
		{
			getSearchAdmins(request, response);
		}
	}

	private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestBody = HttpUtils.requestBodyToString(request);
		AdminInfo adminInfo = gson.fromJson(requestBody, AdminInfo.class);
		//如果数据为空，则不搜索，显示全部对象
		if("".equals(adminInfo.getEmail()) && "".equals(adminInfo.getNickname()))
		{
			getAllAdmins(request, response);
			return;
		}
		List<AdminInfo> adminUsers = adminService.getSearchAdmins(adminInfo);
		response.getWriter().println(Result.ok(adminUsers));
	}

	private void getAdminInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String id = request.getParameter("id");
		AdminInfo adminfo = adminService.getAdminInfo(id);
		if("".equals(adminfo.getId()))
		{
			response.getWriter().println(Result.error("访问失败"));
		}
		else
			response.getWriter().println(Result.ok(adminfo));
	}

	private void alterAdminInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requesetBody = HttpUtils.requestBodyToString(request);
		AdminInfo adminInfo = gson.fromJson(requesetBody, AdminInfo.class);
		int alterResult = adminService.alterAdminInfo(adminInfo);
		if(alterResult == 0)
		{
			response.getWriter().println(Result.ok("修改成功"));
		}
		else
			response.getWriter().println(Result.error("修改失败"));

	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//获取要删除的id
		String id = request.getParameter("id");
		//交给service处理
		int deleteResult = adminService.deleteAdmin(id);
		if(deleteResult == 0)
		{
			response.getWriter().println(Result.ok("删除成功"));
		}
		else
			response.getWriter().println(Result.error("删除失败，请刷新重试"));
	}



	/**
	 * 添加管理员
	 * @param request
	 * @param response
	 */
	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//获取请求体内容
		String requesetBody = HttpUtils.requestBodyToString(request);
		AdminInfo adminInfo = gson.fromJson(requesetBody, AdminInfo.class);
		//先判空
		if(StringUtils.isEmpty(adminInfo.getEmail()) || StringUtils.isEmpty(adminInfo.getPwd()) || StringUtils.isEmpty(adminInfo.getNickname()))
		{
			response.getWriter().println(Result.error("输入不能为空"));
		}
		int addResult = adminService.addAdmin(adminInfo);
		if(addResult == 0)
		{
			response.getWriter().println(Result.ok("添加成功"));
		}
		else
			response.getWriter().println(Result.error("该用户已存在，请更换用户名"));

	}

	/**
	 * 处理管理员的登陆逻辑
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String requestString = HttpUtils.requestBodyToString(request);
		//因为请求体是json字符串对象，所以将json对象转换为java对象（该对象使用Bo模型，即只使用用户能接触到的数据）
		AdminBo adminBo = gson.fromJson(requestString, AdminBo.class);
		//判断adminBo内容是否为空，为空则调用View层逻辑，返回对应结果
		if(StringUtils.isEmpty(adminBo.getEmail()) || StringUtils.isEmpty(adminBo.getPwd()))
		{
			response.getWriter().println(Result.error("输入不能为空"));
			return;
		}
		//交给Service处理，Service会调用Dao对象
		int loginResult = adminService.login(adminBo);
		//如果登陆成功（loginResult==0），调用view层逻辑，返回data数据
		if(loginResult == 0)
		{
			response.getWriter().println(Result.ok(new AdminVo(adminBo.getEmail(), adminBo.getEmail())));
		}
		else
		{

			response.getWriter().println(Result.error("用户名密码不正确"));
		}
	}

	private void getAllAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//交给Service来处理
		List<AdminInfo> allAdmins = adminService.getAllAdmins();
		//因为，还要返回code值，所以要调用Result的静态方法
		response.getWriter().println(Result.ok(allAdmins));
	}
}
