package cn.tedu.mall.service.implement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.mall.entity.Address;
import cn.tedu.mall.entity.User;
import cn.tedu.mall.mapper.OrderMapper;
import cn.tedu.mall.service.IOrderService;
import cn.tedu.mall.service.exception.ServiceException;

@Service
public class OrderService implements IOrderService {

	@Resource
	OrderMapper orderMapper;
	public List<Address> addAddress(String recv_name, String recv_province, String recv_city, String recv_area,
			 String recv_addr, String recv_phone, String recv_tel, String recv_zip,
			String recv_tag,User user) {
		
		if(recv_name==null || recv_name.trim().isEmpty())
		{
			throw new ServiceException("收货人姓名为空");
		}
		if(recv_province==null || recv_province.trim().isEmpty())
		{
			throw new ServiceException("省份为空");
		}
		if(recv_city==null || recv_city.trim().isEmpty())
		{
			throw new ServiceException("城市为空");
		}
		if(recv_area==null || recv_area.trim().isEmpty())
		{
			throw new ServiceException("县为空");
		}
		
		if(recv_addr==null || recv_addr.trim().isEmpty())
		{
			throw new ServiceException("收货人地址为空");
		}
		if(recv_phone==null || recv_phone.trim().isEmpty() )
		{
			throw new ServiceException("收货人手机号为空");
		}
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = fm.format(date);
		
		String recv_province_id =orderMapper.getProvinceIdByName(recv_province.trim());
		String recv_city_id =orderMapper.getCityIdByName(recv_city.trim(),recv_province_id);
		String recv_area_id =orderMapper.getAreaIdByName(recv_area.trim(),recv_city_id);
		String recv_district = recv_province + recv_city + recv_area;
		
		Address address = new Address(null,user.getId(),recv_name, recv_province_id, 
				recv_city_id, recv_area_id,recv_district, recv_addr, recv_phone, 
				recv_tel, recv_zip,
				recv_tag,0,user.getName(),time,user.getName(),time);
		
		
		int n = orderMapper.addAddress(address);
		if(n!=1)
		{
			throw new ServiceException("数据库错误");
		}
		List<Address> list = orderMapper.getAllAddressByUId(user.getId());
		return list;
	}
	
	public List<Address> getAllAddressByUId(int uid){
		List<Address> list = orderMapper.getAllAddressByUId(uid);
		return list;
	}
	
	public Address getAddressById(Integer id){
		Address address = orderMapper.getAddressById(id);
		return address;
	}
	
	public void setDefault(Integer is_default,Integer id,Integer uid)
	{
		int n=orderMapper.deleteDefault(uid);
		n=n+orderMapper.addDefault(id);
		if(n!=2){
			throw new ServiceException("设置默认值失败");
		}
	}
	
	public void deleteAddress(Integer id){
		int n = orderMapper.deleteAddressById(id);
		if(n!=1){
			throw new ServiceException("删除失败");
		}
	}
	
	public List<Address> updateAddress(String recv_name, String recv_province, String recv_city, String recv_area,
			String recv_addr, String recv_phone, String recv_tel, String recv_zip,
			String recv_tag, User user,Integer id){
		
		String recv_province_id =orderMapper.getProvinceIdByName(recv_province.trim());
		String recv_city_id =orderMapper.getCityIdByName(recv_city.trim(),recv_province_id);
		String recv_area_id =orderMapper.getAreaIdByName(recv_area.trim(),recv_city_id);
		String recv_district = recv_province + recv_city + recv_area;
		
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = fm.format(date);
		
		Address address = new Address(id,user.getId(),recv_name, recv_province_id, 
				recv_city_id, recv_area_id,recv_district, recv_addr, recv_phone, 
				recv_tel, recv_zip,
				recv_tag,0,user.getName(),time,user.getName(),time);
		int n = orderMapper.updateAddress(address);
		if(n!=1)
		{
			throw new ServiceException("数据库错误");
		}
		List<Address> list = orderMapper.getAllAddressByUId(user.getId());
		return list;
	}

}
