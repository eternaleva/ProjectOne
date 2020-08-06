package UserInterfaceLayer.View;

import com.google.gson.Gson;

/**
 * 返回参数 code
 * 如果code值异常，则返回message信息
 * 如果code值正确，则返回对应Object对象data
 * @auther tian
 * @date 2020/8/6 7:01 下午
 * @JDK_version JDK1.8
 */
public class Result
{
	private Integer code;

	private Object data;

	private String message;

	public Result(Integer code, Object data, String message)
	{
		this.code = code;
		this.data = data;
		this.message = message;
	}

	@Override
	public String toString()
	{
		return "{" +
				"code=" + code +
				", data=" + data +
				", message='" + message + '\'' +
				'}';
	}

	public static String ok()
	{
		return new Gson().toJson(new Result(0, null, null));
	}

	public static String ok(Object data)
	{
		return new Gson().toJson(new Result(0, data, "登陆成功"));
	}

	public static String error(String message)
	{
		return new Gson().toJson(new Result(10000, null, message));
	}

}
