package DataAccessLayer.Bean.Vo;

/**
 * @auther tian
 * @date 2020/8/7 3:23 下午
 * @JDK_version JDK1.8
 */
public class UserVo
{
	private Integer id;

	private String email;

	private String nickname;

	private String pwd;

	private String recipient;

	private String address;

	private String phone;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public String getNickName()
	{
		return nickname;
	}

	public void setNickName(String nickname)
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

	public String getRecipient()
	{
		return recipient;
	}

	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Override
	public String toString()
	{
		return "{" +
				"id=" + id +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", pwd='" + pwd + '\'' +
				", recipient='" + recipient + '\'' +
				", address='" + address + '\'' +
				", phone=" + phone +
				'}';
	}
}
