package cn.tedu.mall.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.mall.entity.Goods;
import cn.tedu.mall.mapper.GoodsMapper;
import cn.tedu.mall.service.IGoodsService;
import cn.tedu.mall.service.exception.ServiceException;

@Service
public class GoodsService implements IGoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	public List<Goods> getGoods(Integer categoryId) {
		List<Goods> list=goodsMapper.getGoods(categoryId);
		if(list==null){
			throw new ServiceException("∑÷¿‡id¥ÌŒÛ");
		}
		return list;
	}

}
