package DataAccessLayer.Bean.Bo.Goods.updateGoods;

/**
 * @auther tian
 * @date 2020/8/11 11:06 上午
 * @JDK_version JDK1.8
 */
public class UpdateGoodsSpecBo
{
	//该id是商品id（goodsId)
	private Integer id;

	private String specName;

	private Integer stockNum;

	private Double unitPrice;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getSpecName()
	{
		return specName;
	}

	public void setSpecName(String specName)
	{
		this.specName = specName;
	}

	public Integer getStockNum()
	{
		return stockNum;
	}

	public void setStockNum(Integer stockNum)
	{
		this.stockNum = stockNum;
	}

	public Double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}
}
