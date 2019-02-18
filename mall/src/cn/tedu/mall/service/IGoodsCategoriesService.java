package cn.tedu.mall.service;

import java.util.List;

import cn.tedu.mall.entity.GoodsCategory;


public interface IGoodsCategoriesService {

	List<GoodsCategory> getCategories(Integer rootId);

	GoodsCategory findCategoryById(Integer categoryId);

}
