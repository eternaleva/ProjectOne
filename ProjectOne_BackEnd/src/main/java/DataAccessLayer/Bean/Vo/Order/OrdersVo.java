package DataAccessLayer.Bean.Vo.Order;

import java.sql.Date;

/**
 * @auther tian
 * @date 2020/8/12 12:05 下午
 * @JDK_version JDK1.8
 */
public class OrdersVo
{
	private Integer userId;

	private String nickname;

	private String name;

	private String address;

	private String phone;

	private String goods;

	private Integer goodsId;

	private String spec;

	//就是specId
	private Integer goodsDetailId;

	private Integer goodsNum;

	private Double price;

	private Double amount;

	private Integer stateId;

	private Date createDate;

	private Date updateDate;

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

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

	public String getGoods()
	{
		return goods;
	}

	public void setGoods(String goods)
	{
		this.goods = goods;
	}

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getSpec()
	{
		return spec;
	}

	public void setSpec(String spec)
	{
		this.spec = spec;
	}

	public Integer getGoodsDetailId()
	{
		return goodsDetailId;
	}

	public void setGoodsDetailId(Integer goodsDetailId)
	{
		this.goodsDetailId = goodsDetailId;
	}

	public Integer getGoodsNum()
	{
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum)
	{
		this.goodsNum = goodsNum;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
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

	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}
}
