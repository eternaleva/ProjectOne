package DataAccessLayer.Bean.Vo;

/**
 * 商品表，一些数据需要从商品规格表中拿
 * @auther tian
 * @date 2020/8/8 2:19 下午
 * @JDK_version JDK1.8
 */
public class GoodsVo
{
	private Integer id;

	private Integer typeId;

	private String img;

	private String name;

	private double price;

	private Integer stockNum;

	private String desc;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getTypeId()
	{
		return typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

	public String getImg()
	{
		return img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public Integer getStockNum()
	{
		return stockNum;
	}

	public void setStockNum(Integer stockNum)
	{
		this.stockNum = stockNum;
	}

	public String getDesc()
	{
		return desc;
	}

	@Override
	public String toString()
	{
		return "{" +
				"id=" + id +
				", typeId=" + typeId +
				", img='" + img + '\'' +
				", name='" + name + '\'' +
				", price=" + price +
				", stockNum=" + stockNum +
				'}';
	}

	public GoodsVo()
	{
	}

	public GoodsVo(Integer id, Integer typeId, String img, String name, double price, Integer stockNum, String desc)
	{
		this.id = id;
		this.typeId = typeId;
		this.img = img;
		this.name = name;
		this.price = price;
		this.stockNum = stockNum;
		this.desc = desc;
	}
}