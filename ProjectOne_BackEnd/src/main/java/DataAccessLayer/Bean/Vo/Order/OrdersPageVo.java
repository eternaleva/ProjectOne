package DataAccessLayer.Bean.Vo.Order;

/**
 * 用于分页显示的订单数据Vo
 * @auther tian
 * @date 2020/8/12 12:56 下午
 * @JDK_version JDK1.8
 */
public class OrdersPageVo
{
	private Integer id;

	private Integer userId;

	private Integer goodsDetailId;

	private String goods;

	private String spec;

	private Integer goodsNum;

	private Double amount;

	private Integer stateId;

	private String state;

	//用户订单Vo(需要新建一个该对象)
	private UserOrdersVo user = new UserOrdersVo();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getGoodsDetailId()
	{
		return goodsDetailId;
	}

	public void setSpecId(Integer specId)
	{
		this.goodsDetailId = specId;
	}

	public String getGoods()
	{
		return goods;
	}

	public void setGoods(String goods)
	{
		this.goods = goods;
	}

	public Integer getGoodsNum()
	{
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum)
	{
		this.goodsNum = goodsNum;
	}

	public Double getAmount()
	{
		return amount;
	}

	public void setAmount(Double amount)
	{
		this.amount = amount;
	}


	public Integer getStateId()
	{
		return stateId;
	}

	//利用反射在该处进行一些操作
	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;

		if(stateId == 0)
		{
			setState("未付款");
		}
		else if(stateId == 1)
		{
			setState("未发货");
		}
		else if(stateId == 2)
		{
			setState("已发货");
		}
		else if(stateId == 3)
		{
			setState("已到货");
		}
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public UserOrdersVo getUser()
	{
		return user;
	}

	//利用反射设置user的属性
	public void setNickname(String nickname)
	{
		user.setNickname(nickname);
	}

	public void setName(String name)
	{
		user.setName(name);
	}

	public void setAddress(String address)
	{
		user.setAddress(address);
	}

	public void setPhone(String phone)
	{
		user.setPhone(phone);
	}

	public void setUser(UserOrdersVo user)
	{
		this.user = user;
	}

	public String getSpec()
	{
		return spec;
	}

	public void setSpec(String spec)
	{
		this.spec = spec;
	}
}
