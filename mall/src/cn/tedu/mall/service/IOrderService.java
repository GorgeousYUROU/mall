package cn.tedu.mall.service;



import java.util.List;

import cn.tedu.mall.entity.Address;
import cn.tedu.mall.entity.User;

public interface IOrderService {

	List<Address> addAddress(String recv_name, String recv_province, String recv_city, String recv_area, 
			String recv_addr, String recv_phone, String recv_tel, String recv_zip, String recv_tag,User user);

	List<Address> getAllAddressByUId(int uid);

	void setDefault(Integer is_default,Integer id,Integer uid);

	

	void deleteAddress(Integer id);

	Address getAddressById(Integer id);

	List<Address> updateAddress(String recv_name, String recv_province, String recv_city, String recv_area,
			String recv_addr, String recv_phone, String recv_tel, String recv_zip,
			String recv_tag, User user,Integer id);

}
