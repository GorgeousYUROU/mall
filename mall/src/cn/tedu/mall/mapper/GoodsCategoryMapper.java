package cn.tedu.mall.mapper;

import java.util.List;

import cn.tedu.mall.entity.GoodsCategory;

public interface GoodsCategoryMapper {
	
	public List<GoodsCategory> getCategories(Integer rootId);

	public GoodsCategory getCategoryById(Integer rootId);
}
