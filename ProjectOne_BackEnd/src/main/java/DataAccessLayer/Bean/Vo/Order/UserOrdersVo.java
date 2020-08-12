package DataAccessLayer.Bean.Vo.Order;

/**
 * @auther tian
 * @date 2020/8/12 1:00 下午
 * @JDK_version JDK1.8
 */
public class UserOrdersVo
{
	private String nickname;

	private String name;

	private String address;

	private String phone;

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
}
