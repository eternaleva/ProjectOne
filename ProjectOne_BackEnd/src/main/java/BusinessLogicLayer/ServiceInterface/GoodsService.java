package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Bo.Goods.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Bo.Goods.GoodsSpecBo;
import DataAccessLayer.Bean.Bo.Goods.updateGoods.UpdateGoodsBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsInfoVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsVo;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/8 12:30 下午
 * @JDK_version JDK1.8
 */
public interface GoodsService
{
	List<GoodsTypeVo> getType();

	List<GoodsVo> getGoodsByType(Integer typeId);

	void addGood(AddGoodsBo addGoodsBo);

	int addGoodsType(GoodsVo goodsVo);

	int deleteGoods(String requestParameter);

	int updateGoods(UpdateGoodsBo goodsBo);

	GoodsInfoVo getGoodsInfo(Integer id);

	int addSpec(GoodsSpecBo goodsSpecBo);

	int deleteSpec(GoodsSpecBo goodsSpecBo);

	int deleteType(int typeId);
}
