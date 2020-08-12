package DataAccessLayer.Bean.Bo.Goods.AddGoods;

import java.util.List;

/**
 * 上传商品规格时候，post提交的Json格式
 * @auther tian
 * @date 2020/8/10 7:50 上午
 * @JDK_version JDK1.8
 */
public class AddGoodsBo
{
	private String name;

	private Integer typeId;

	private String img;

	private String desc;

	private List<AddGoodsSpecBo> specList;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public List<AddGoodsSpecBo> getSpecList()
	{
		return specList;
	}

	public void setSpecList(List<AddGoodsSpecBo> specList)
	{
		this.specList = specList;
	}
}
