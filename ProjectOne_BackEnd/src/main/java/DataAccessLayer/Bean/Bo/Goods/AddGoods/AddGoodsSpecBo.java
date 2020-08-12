package DataAccessLayer.Bean.Bo.Goods.AddGoods;

/**
 * Post请求体的json中的List的单个规格集
 * @auther tian
 * @date 2020/8/10 7:53 上午
 * @JDK_version JDK1.8
 */
public class AddGoodsSpecBo
{
	private String specName;

	private Integer stockNum;

	private Double unitPrice;

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

	@Override
	public String toString()
	{
		return "{" +
				"specName='" + specName + '\'' +
				", stockNum=" + stockNum +
				", unitPrice=" + unitPrice +
				'}';
	}
}
