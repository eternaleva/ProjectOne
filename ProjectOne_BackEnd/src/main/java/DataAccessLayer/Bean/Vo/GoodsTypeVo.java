package DataAccessLayer.Bean.Vo;

/**
 * 商品大类表
 * @auther tian
 * @date 2020/8/8 12:35 下午
 * @JDK_version JDK1.8
 */
public class GoodsTypeVo
{
	private Integer id;

	private String name;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
