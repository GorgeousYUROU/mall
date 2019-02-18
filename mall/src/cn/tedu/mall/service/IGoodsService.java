package cn.tedu.mall.service;

import java.util.List;

import cn.tedu.mall.entity.Goods;



public interface IGoodsService {

	List<Goods> getGoods(Integer categoryId);

}
