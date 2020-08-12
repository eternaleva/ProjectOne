package DataAccessLayer.Bean.Vo.Goods;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/11 12:12 下午
 * @JDK_version JDK1.8
 */
public class GoodsInfoVo
{
	//字段名要和前端对应
	private List<GoodsSpecVo> specs;

	private GoodsVo goods;

	public List<GoodsSpecVo> getSpecs()
	{
		return specs;
	}

	public void setSpecs(List<GoodsSpecVo> specs)
	{
		this.specs = specs;
	}

	public GoodsVo getGoods()
	{
		return goods;
	}

	public void setGoods(GoodsVo goods)
	{
		this.goods = goods;
	}

	public GoodsInfoVo()
	{

	}

	public GoodsInfoVo(List<GoodsSpecVo> specs, GoodsVo goods)
	{
		this.specs = specs;
		this.goods = goods;
	}
}
