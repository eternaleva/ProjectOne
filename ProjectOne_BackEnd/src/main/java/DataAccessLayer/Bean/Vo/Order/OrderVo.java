package DataAccessLayer.Bean.Vo.Order;

import DataAccessLayer.Bean.Vo.Goods.GoodsSpecVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/12 4:50 下午
 * @JDK_version JDK1.8
 */
public class OrderVo
{
	private Integer id;

	private Double amount;

	private Integer num;

	private Integer goodsDetailId;

	private Integer state;

	private String goods;

	//商品规格集合
	private List<GoodsSpecVo> spec;

	//匿名内部类创建states的List集合
	private List<StatesVo> states = new ArrayList<StatesVo>()
	{
		{
			add(0, new StatesVo(0, "未付款"));
			add(1,new StatesVo(1,"未发货"));
			add(2,new StatesVo(2,"已发货"));
			add(3,new StatesVo(3,"已完成订单"));
		}
	};

	private curStateVo curState = new curStateVo();

	private curSpecVo curSpec = new curSpecVo();

	public Integer getGoodsDetailId()
	{
		return goodsDetailId;
	}

	public void setSpecId(Integer specId)
	{
		this.goodsDetailId = specId;
		curSpec.setId(specId);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Double getAmount()
	{
		return amount;
	}

	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

	public Integer getNum()
	{
		return num;
	}

	public void setGoodsNum(Integer goodsNum)
	{
		this.num = goodsNum;
	}

	public void setGoodsDetailId(Integer goodsDetailId)
	{
		this.goodsDetailId = goodsDetailId;
	}

	public Integer getState()
	{
		return state;
	}

	public void setStateId(Integer stateId)
	{
		this.state = stateId;
		curState.setId(stateId);
	}

	public String getGoods()
	{
		return goods;
	}

	public void setGoods(String goods)
	{
		this.goods = goods;
	}

	public List<GoodsSpecVo> getSpec()
	{
		return spec;
	}

	public void setSpecList(List<GoodsSpecVo> specList)
	{
		this.spec = specList;
	}

	public curStateVo getCurState()
	{
		return curState;
	}

	public void setCurState(curStateVo curState)
	{
		this.curState = curState;
	}

	public curSpecVo getCurSpec()
	{
		return curSpec;
	}

	public void setCurSpec(curSpecVo curSpec)
	{
		this.curSpec = curSpec;
	}
}
