package DataAccessLayer.Bean.Bo.Order;

/**
 * @auther tian
 * @date 2020/8/12 7:14 下午
 * @JDK_version JDK1.8
 */
public class ChangeOrderBo
{
	private Integer id;

	private Integer state;

	//对应数据库的SpecId
	private Integer spec;

	private Integer num;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Integer getSpec()
	{
		return spec;
	}

	public void setSpec(Integer spec)
	{
		this.spec = spec;
	}

	public Integer getNum()
	{
		return num;
	}

	public void setNum(Integer num)
	{
		this.num = num;
	}
}
