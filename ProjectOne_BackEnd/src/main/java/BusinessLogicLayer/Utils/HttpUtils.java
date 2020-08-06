package BusinessLogicLayer.Utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @auther tian
 * @date 2020/8/6 8:15 下午
 * @JDK_version JDK1.8
 */
public class HttpUtils
{
	public static String requestBodyToString(HttpServletRequest request) throws IOException
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
		return byteArrayOutputStream.toString("utf-8");
	}
}
