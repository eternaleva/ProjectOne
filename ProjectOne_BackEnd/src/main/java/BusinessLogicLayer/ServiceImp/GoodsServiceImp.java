package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.GoodsService;
import DataAccessLayer.Bean.Bo.Goods.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Bo.Goods.AddGoods.AddGoodsSpecBo;
import DataAccessLayer.Bean.Bo.Goods.GoodsSpecBo;
import DataAccessLayer.Bean.Bo.Goods.updateGoods.UpdateGoodsBo;
import DataAccessLayer.Bean.Bo.Goods.updateGoods.UpdateGoodsSpecBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsInfoVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsVo;
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
		List<AddGoodsSpecBo> specList = addGoodsBo.getSpecList();
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
		for (AddGoodsSpecBo addGoodsSpecBo : specList)
		{
			GoodsSpecVo goodsSpec = new GoodsSpecVo(null,
					id,
					addGoodsSpecBo.getSpecName(),
					addGoodsSpecBo.getStockNum(),
					addGoodsSpecBo.getUnitPrice());
			goodsSpecVos.add(goodsSpec);
		}
		goodsDao.addGoodsSpec(goodsSpecVos);
	}

	@Override
	public int addGoodsType(GoodsVo goodsVo)
	{
		return goodsDao.addGoodsType(goodsVo);
	}

	@Override
	public int deleteGoods(String requestParameter)
	{
		return goodsDao.deleteGoods(requestParameter);
	}

	@Override
	public int updateGoods(UpdateGoodsBo updateGoodsBo)
	{
		List<UpdateGoodsSpecBo> updateGoodsSpecBoList = updateGoodsBo.getSpecList();
		Double price = updateGoodsSpecBoList.get(0).getUnitPrice();
		Integer stockNum = updateGoodsSpecBoList.get(0).getStockNum();
		for (int i = 1; i < updateGoodsSpecBoList.size(); i++)
		{
			if(price > updateGoodsSpecBoList.get(i).getUnitPrice())
				price = updateGoodsSpecBoList.get(i).getUnitPrice();
			if(stockNum > updateGoodsSpecBoList.get(i).getStockNum())
				stockNum = updateGoodsSpecBoList.get(i).getStockNum();
		}
		GoodsVo goodsVo = new GoodsVo(updateGoodsBo.getId(),
				updateGoodsBo.getTypeId(),
				updateGoodsBo.getImg(),
				updateGoodsBo.getName(),
				price,
				stockNum,
				updateGoodsBo.getDesc()
				);

		List<GoodsSpecVo> updateGoodsSpecVoList = new ArrayList<>();
		for (UpdateGoodsSpecBo updateGoodsSpecBo : updateGoodsSpecBoList)
		{
			GoodsSpecVo goodsSpecVo = new GoodsSpecVo(null,
					updateGoodsBo.getId(),
					updateGoodsSpecBo.getSpecName(),
					updateGoodsSpecBo.getStockNum(),
					updateGoodsSpecBo.getUnitPrice());
			updateGoodsSpecVoList.add(goodsSpecVo);
		}
		return goodsDao.updateGoods(goodsVo, updateGoodsSpecVoList);
	}

	@Override
	public GoodsInfoVo getGoodsInfo(Integer id)
	{
		return goodsDao.getGoodsInfo(id);
	}

	@Override
	public int addSpec(GoodsSpecBo goodsSpecBo)
	{
		return goodsDao.addSpec(goodsSpecBo);
	}

	@Override
	public int deleteSpec(GoodsSpecBo goodsSpecBo)
	{
		return goodsDao.deleteSpec(goodsSpecBo);
	}

	@Override
	public int deleteType(int typeId)
	{
		return goodsDao.deleteType(typeId);
	}
}
