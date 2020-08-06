package DataAccessLayer.Bean.Vo;

/**
 * @auther tian
 * @date 2020/8/6 7:15 下午
 * @JDK_version JDK1.8
 */
public class AdminVo
{
	private String token;

	private String name;

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "AdminVo{" +
				"token='" + token + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public AdminVo(String token, String name)
	{
		this.token = token;
		this.name = name;
	}
}
