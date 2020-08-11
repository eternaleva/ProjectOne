package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.GoodsService;
import DataAccessLayer.Bean.Bo.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Bo.AddGoods.GoodsSpecificationBo;
import DataAccessLayer.Bean.Vo.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.GoodsVo;
import DataAccessLayer.DaoImp.GoodsDaoImp;
import DataAccessLayer.DaoInterface.GoodsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/8 12:30 下午
 * @JDK_version JDK1.8
 */
public class GoodsServiceImp implements GoodsService
{
	private GoodsDao goodsDao = new GoodsDaoImp();

	@Override
	public List<GoodsTypeVo> getType()
	{
		return goodsDao.getType();
	}

	@Override
	public List<GoodsVo> getGoodsByType(Integer typeId)
	{
		return goodsDao.GetGoodsByType(typeId);
	}

	@Override
	public void addGood(AddGoodsBo addGoodsBo)
	{
		//获取Post请求体的List表单
		List<GoodsSpecificationBo> specList = addGoodsBo.getSpecList();
		//取商品最小规格的价格
		//取商品中规格最少数量
		double price = specList.get(0).getUnitPrice();
		int stockNum = specList.get(0).getStockNum();
		for (int i = 1; i < specList.size(); i++)
		{
			if(price > specList.get(i).getUnitPrice())
				price = specList.get(i).getUnitPrice();
			if(stockNum > specList.get(i).getStockNum())
				stockNum = specList.get(i).getStockNum();
		}
		//创建GoodsVo对象（将List中的规格值传递给该对象）
		GoodsVo goodsVo = new GoodsVo(null,
				addGoodsBo.getTypeId(),
				addGoodsBo.getImg(),
				addGoodsBo.getName(),
				price,
				stockNum,
				addGoodsBo.getDesc());

		goodsDao.addGood(goodsVo);
		//获取Goods新增的id
		int id = goodsDao.lastInsertId();
		//再把商品信息的规格，保存在规格表
		List<GoodsSpecVo> goodsSpecVos = new ArrayList<>();
		for (GoodsSpecificationBo goodsSpecificationBo : specList)
		{
			GoodsSpecVo goodsSpec = new GoodsSpecVo(null,
					id,
					goodsSpecificationBo.getSpecName(),
					goodsSpecificationBo.getStockNum(),
					goodsSpecificationBo.getUnitPrice());
			goodsSpecVos.add(goodsSpec);
		}
		goodsDao.addGoodsSpec(goodsSpecVos);
	}

	@Override
	public int addGoodsType(GoodsVo goodsVo)
	{
		return goodsDao.addGoodsType(goodsVo);
	}
}
