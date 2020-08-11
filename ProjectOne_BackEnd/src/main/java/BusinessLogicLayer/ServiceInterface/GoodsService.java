package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Bo.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Vo.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.GoodsVo;

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
}
