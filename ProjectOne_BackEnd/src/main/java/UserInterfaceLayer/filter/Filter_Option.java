package UserInterfaceLayer.filter;

import UserInterfaceLayer.View.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限管理
 * 1.先要设置前端axios-admin.js和axios-client.js文件配置
 * @auther tian
 * @date 2020/8/6 1:28 上午
 * @JDK_version JDK1.8
 */
@WebFilter("/api/admin/*")
public class Filter_Option implements Filter
{
	public void destroy()
	{

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
	{
		//将ServletRequset和ServletResponse转换为HttpServlet
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("utf-8");
		//因为后台主要提供数据，传递的是参数数据，所以最好提供utf-8类型，设置ContentType容易出一些问题
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//跨域设置
		response.setHeader("Access-Control-Allow-Origin","http://localhost:8085");
		response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
		response.setHeader("Access-Control-Allow-Credentials","true");

		//跳过Option
		if(!request.getMethod().equalsIgnoreCase("OPTIONS"))
		{
			if(auth(request))
			{
				//获取username信息
				String user = (String) request.getSession().getAttribute("user");
				//如果为空，则要求重新登陆
				if (user == null)
				{
					response.getWriter().println(Result.error("请重新登陆"));
					return;
				}
			}
		}
		//执行过滤
		chain.doFilter(request, response);
	}

	private boolean auth(HttpServletRequest request)
	{
		//跳过登陆和注销
		if("/api/admin/admin/login".equalsIgnoreCase(request.getRequestURI())
				|| "/api/admin/admin/logoutAdmin".equalsIgnoreCase(request.getRequestURI()))
			return false;
		else
			return true;
	}

	public void init(FilterConfig config) throws ServletException
	{

	}

}
