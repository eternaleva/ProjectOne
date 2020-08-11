package BusinessLogicLayer.Listener; /**
 * @auther tian
 * @date 2020/8/10 7:18 上午
 * @JDK_version JDK1.8
 * 用作文件上传时候的域名配置
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener()
public class ListenerDomain implements ServletContextListener
{

	// Public constructor is required by servlet spec
	public ListenerDomain()
	{
	}

	// -------------------------------------------------------
	// ServletContextListener implementation
	// -------------------------------------------------------
	public void contextInitialized(ServletContextEvent sce)
	{
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
		//读取domain的配置文件
		InputStream resourceAsStream = ListenerDomain.class.getClassLoader().getResourceAsStream("domain.properties");
		Properties properties = new Properties();
		//获取配置属性值
		try
		{
			properties.load(resourceAsStream);
			String domain = properties.getProperty("domain");
			//将属性值存入到Context域里
			sce.getServletContext().setAttribute("domain", domain);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent sce)
	{
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
	}
}
