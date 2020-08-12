package DataAccessLayer.Bean.Vo.Goods;/**
 *  商品规格表，是商品表的子类
 *  主要为了获取商品规格信息的时候不用重复计算，直接到该表中获取
 *  @auther tian
 *  @date 2020/8/10 1:56 下午
 *  @JDK_version JDK1.8
 *
 */public class GoodsSpecVo
{
	private Integer id;

	private String specName;

	private Integer stockNum;

	private Double unitPrice;

	private Integer goodsId;

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

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public GoodsSpecVo()
	{

	}

	public GoodsSpecVo(Integer id, Integer goodsId, String specName, Integer stockNum, Double unitPrice)
	{
		this.id = id;
		this.goodsId = goodsId;
		this.specName = specName;
		this.stockNum = stockNum;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString()
	{
		return "{" +
				"id=" + id +
				", goodsId=" + goodsId +
				", specName='" + specName + '\'' +
				", StockNum=" + stockNum +
				", unitPrice=" + unitPrice +
				'}';
	}
}
