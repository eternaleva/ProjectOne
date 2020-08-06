package UserInterfaceLayer.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther tian
 * @date 2020/8/6 1:28 上午
 * @JDK_version JDK1.8
 */
@WebFilter("/*")
public class Filter_Option implements Filter
{
	public void destroy()
	{
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("utf-8");
		//因为后台主要提供数据，传递的是参数数据，所以最好提供utf-8类型，设置ContentType容易出一些问题
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, response);
		//跨域设置
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
		response.setHeader("Access-Control-Allow-Credentials","true");



	}

	public void init(FilterConfig config) throws ServletException
	{

	}

}
