package DataAccessLayer.Bean.Bo.Order;

/**
 * 用于分页显示订单的Post json接收
 * @auther tian
 * @date 2020/8/11 11:45 下午
 * @JDK_version JDK1.8
 */
public class OrderPageBo
{
	private Integer state;

	private Integer currentPage;

	private Integer pagesize;
	//因为moneyLimit可以不写，所以要接收，就用String
	//即写为String类型的值，可以不传，默认为null
	private String moneyLimit1;

	private String moneyLimit2;

	private String goods;

	private String address;

	private String name;

	private String id;

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Integer getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public Integer getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(Integer pagesize)
	{
		this.pagesize = pagesize;
	}

	public String getMoneyLimit1()
	{
		return moneyLimit1;
	}

	public void setMoneyLimit1(String moneyLimit1)
	{
		this.moneyLimit1 = moneyLimit1;
	}

	public String getMoneyLimit2()
	{
		return moneyLimit2;
	}

	public void setMoneyLimit2(String moneyLimit2)
	{
		this.moneyLimit2 = moneyLimit2;
	}

	public String getGoods()
	{
		return goods;
	}

	public void setGoods(String goods)
	{
		this.goods = goods;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
