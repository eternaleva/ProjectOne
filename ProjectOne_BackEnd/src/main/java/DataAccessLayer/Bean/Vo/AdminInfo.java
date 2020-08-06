package DataAccessLayer.Bean.Vo;

/**
 * @auther tian
 * @date 2020/8/6 10:48 下午
 * @JDK_version JDK1.8
 */
public class AdminInfo
{
	private String id;

	private String email;

	private String nickname;

	private String pwd;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
}
