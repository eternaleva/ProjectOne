package DataAccessLayer.DaoInterface;

import DataAccessLayer.Bean.Bo.AddGoods.AddGoodsBo;
import DataAccessLayer.Bean.Vo.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.GoodsVo;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/8 12:31 下午
 * @JDK_version JDK1.8
 */
public interface GoodsDao
{
	List<GoodsTypeVo> getType();

	List<GoodsVo> GetGoodsByType(Integer typeId);

	void addGood(GoodsVo goodsVo);

	int lastInsertId();

	void addGoodsSpec(List<GoodsSpecVo> goodsSpecVos);

	int addGoodsType(GoodsVo goodsVo);
}
