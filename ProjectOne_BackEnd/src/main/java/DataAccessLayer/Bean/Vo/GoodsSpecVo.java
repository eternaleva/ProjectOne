package DataAccessLayer.Bean.Vo;/**
 *  商品规格表，是商品表的子类
 *  主要为了获取商品规格信息的时候不用重复计算，直接到该表中获取
 *  @auther tian
 *  @date 2020/8/10 1:56 下午
 *  @JDK_version JDK1.8
 *
 */public class GoodsSpecVo
{
	private Integer id;

	private Integer goodsId;

	private String specName;

	private Integer StockNum;

	private Double unitPrice;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodId(Integer goodsId)
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
		return StockNum;
	}

	public void setStockNum(Integer stockNum)
	{
		StockNum = stockNum;
	}

	public Double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public GoodsSpecVo()
	{

	}

	public GoodsSpecVo(Integer id, Integer goodsId, String specName, Integer stockNum, Double unitPrice)
	{
		this.id = id;
		this.goodsId = goodsId;
		this.specName = specName;
		StockNum = stockNum;
		this.unitPrice = unitPrice;
	}
}
