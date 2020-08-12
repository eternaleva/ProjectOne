package UserInterfaceLayer.Controller.Admin;

import BusinessLogicLayer.ServiceImp.UserServiceImp;
import BusinessLogicLayer.ServiceInterface.UserService;
import DataAccessLayer.Bean.Vo.User.UserVo;
import UserInterfaceLayer.View.Result;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/7 3:16 下午
 * @JDK_version JDK1.8
 */
@WebServlet("/api/admin/user/*")
public class Servlet_User extends HttpServlet
{
	private Gson gson  = new Gson();
	private UserService userService = new UserServiceImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String action = requestURI.replace("/api/admin/user/", "");
		if("allUser".equals(action))
		{
			getAllUsers(response);
		}
		else if("deleteUser".equals(action))
		{
			deleteUser(request, response);
		}
		else if("searchUser".equals(action))
		{
			searchUser(request, response);
		}
	}

	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String nickname = request.getParameter("word");
		if(nickname.isEmpty())
		{
			getAllUsers(response);
		}
		else
		{
			List<UserVo> users = userService.searchUser(nickname);
			response.getWriter().println(Result.ok(users));
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String id = request.getParameter("id");
		if(id != null)
		{
			int deleteResult = userService.deleteUser(id);
			if(deleteResult == 0)
			{
				response.getWriter().println(Result.ok("删除成功"));
				response.setHeader("refresh","1");
			}
			else
			{
				response.getWriter().println(Result.error("删除失败"));
			}
		}
		else
		{
			response.getWriter().println(Result.error("id有误，请检查"));
		}
	}

	private void getAllUsers(HttpServletResponse response) throws IOException
	{
		List<UserVo> users = userService.getAllUsers();
		response.getWriter().println(Result.ok(users));
	}
}
