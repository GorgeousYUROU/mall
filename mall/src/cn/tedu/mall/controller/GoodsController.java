package cn.tedu.mall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.mall.entity.Goods;
import cn.tedu.mall.entity.GoodsCategory;
import cn.tedu.mall.service.IGoodsCategoriesService;
import cn.tedu.mall.service.IGoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	
	
	@Resource 
	public IGoodsCategoriesService   goodsCategoriesService;
	@Resource 
	public IGoodsService   goodsService;
	
	@RequestMapping("/categories.do")
	@ResponseBody
	public Result getCategories(Integer rootId)
	{
		List<GoodsCategory> goods = goodsCategoriesService.getCategories(rootId);
		return new Result(goods);
	}
	
	@RequestMapping("/list.do")
	public String getGoods(Integer categoryId,ModelMap map)
	{
		GoodsCategory category = goodsCategoriesService.findCategoryById(categoryId);
		GoodsCategory branch = goodsCategoriesService.findCategoryById(category.getParentId());
		GoodsCategory root = goodsCategoriesService.findCategoryById(branch.getParentId());
		List<Goods> goods = goodsService.getGoods(categoryId);
		map.put("category",category);
		map.put("branch",branch);
		map.put("root",root);
		map.put("goods",goods);
		return "page_detail";
	}

}
