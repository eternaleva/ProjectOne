package DataAccessLayer.Bean.Bo.Goods;

/**
 * @auther tian
 * @date 2020/8/11 3:22 下午
 * @JDK_version JDK1.8
 */
public class GoodsSpecBo
{
	private Integer goodsId;

	private String specName;

	private Integer stockNum;

	private Double unitPrice;

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
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
