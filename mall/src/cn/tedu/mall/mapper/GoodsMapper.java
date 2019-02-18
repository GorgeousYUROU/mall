package cn.tedu.mall.mapper;

import java.util.List;

import cn.tedu.mall.entity.Goods;

public interface GoodsMapper {

	List<Goods> getGoods(Integer categoryId);

}
