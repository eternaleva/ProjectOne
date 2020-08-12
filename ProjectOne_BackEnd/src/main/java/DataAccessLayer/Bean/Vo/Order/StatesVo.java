package DataAccessLayer.Bean.Vo.Order;

/**
 * @auther tian
 * @date 2020/8/12 4:58 下午
 * @JDK_version JDK1.8
 */
public class StatesVo
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

	public StatesVo()
	{
	}

	public StatesVo(Integer id, String name)
	{
		this.id = id;
		this.name = name;
	}
}
