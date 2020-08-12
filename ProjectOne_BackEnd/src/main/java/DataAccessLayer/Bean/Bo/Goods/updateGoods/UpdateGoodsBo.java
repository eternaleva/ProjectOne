package DataAccessLayer.Bean.Bo.Goods.updateGoods;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/11 10:29 上午
 * @JDK_version JDK1.8
 */
public class UpdateGoodsBo
{
	private Integer id;

	private Integer typeId;

	private String img;

	private String name;

	private List<UpdateGoodsSpecBo> specList;

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

	public List<UpdateGoodsSpecBo> getSpecList()
	{
		return specList;
	}

	public void setSpecList(List<UpdateGoodsSpecBo> specList)
	{
		this.specList = specList;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
}
