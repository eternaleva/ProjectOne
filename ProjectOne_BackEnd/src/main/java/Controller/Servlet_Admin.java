package Controller;

import Bo.AdminBo;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @auther tian
 * @date 2020/8/6 1:18 上午
 * @JDK_version JDK1.8
 */
@WebServlet("/api/admin/admin/*")
public class Servlet_Admin extends HttpServlet
{
	private Gson gson;

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
	}

	/**
	 * 处理管理员的登陆逻辑
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//获取request的请求体输入流
		ServletInputStream inputStream = request.getInputStream();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int length = 0;
		byte[] bytes = new byte[1024];
		while((length = inputStream.read(bytes)) != -1)
		{
			byteArrayOutputStream.write(bytes, 0, length);
		}
		//将获取的输request请求体输出为String字符串，编码格式设置为utf-8
		String requestString = byteArrayOutputStream.toString("utf-8");
		//因为请求体是json字符串对象，所以将json对象转换为java对象（该对象使用Bo模型）
		AdminBo adminBo = gson.fromJson(requestString, AdminBo.class);
		//判断adminBo内容是否为空
		if(StringUtils.isEmpty(adminBo.getEmail()) || StringUtils.isEmpty(adminBo.getPwd()))
		{
			//返回响应结果(响应结果交给view模块来处理，这里Controller不做处理）

			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("222");
	}
}
