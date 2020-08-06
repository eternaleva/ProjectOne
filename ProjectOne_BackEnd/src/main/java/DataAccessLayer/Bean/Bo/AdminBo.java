package DataAccessLayer.Bean.Bo;

/**
 * @auther tian
 * @date 2020/8/6 9:43 上午
 * @JDK_version JDK1.8
 */
public class AdminBo
{
	private String email;

	private String pwd;

	public String getEmail()
	{
		return email;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	@Override
	public String toString()
	{
		return "AdminBo{" +
				"email='" + email + '\'' +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
