package DataAccessLayer.DaoInterface;

import DataAccessLayer.Bean.Bo.Goods.GoodsSpecBo;
import DataAccessLayer.Bean.Vo.Goods.GoodsInfoVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsTypeVo;
import DataAccessLayer.Bean.Vo.Goods.GoodsVo;

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

	int deleteGoods(String requestParameter);

	int updateGoods(GoodsVo goodsVo, List<GoodsSpecVo> goodsSpecVoList);

	GoodsInfoVo getGoodsInfo(Integer id);

	int addSpec(GoodsSpecBo goodsSpecBo);

	int deleteSpec(GoodsSpecBo goodsSpecBo);

	int deleteType(int typeId);
}
