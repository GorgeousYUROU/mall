package cn.tedu.mall.service.implement;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.mall.entity.GoodsCategory;
import cn.tedu.mall.mapper.GoodsCategoryMapper;
import cn.tedu.mall.service.IGoodsCategoriesService;
import cn.tedu.mall.service.exception.ServiceException;

@Service
public class GoodsCategoriesService implements IGoodsCategoriesService{

	@Resource
	public GoodsCategoryMapper goodsCategoryMapper;
	

	public List<GoodsCategory> getCategories(Integer rootId)
	{
		if(rootId == null){
			throw new ServiceException("��id����Ϊnull");
		}
		GoodsCategory goodsCategory = goodsCategoryMapper.getCategoryById(rootId);
		if(goodsCategory.getId()==null || goodsCategory.getParentId()!=0){
			throw new ServiceException("����rootId");
		}
		
		List<GoodsCategory> list = goodsCategoryMapper.getCategories(rootId);
		return list;
			
		
	}
	
	public GoodsCategory findCategoryById(Integer categoryId){
		GoodsCategory goodsCategory = goodsCategoryMapper.getCategoryById(categoryId);
		if(goodsCategory.getId()==null ){
			throw new ServiceException("����rootId");
		}
		return goodsCategory;
	}

}
