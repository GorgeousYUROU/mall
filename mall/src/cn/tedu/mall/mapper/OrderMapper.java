package cn.tedu.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.mall.entity.Address;

public interface OrderMapper {

	int addAddress(Address address);

	String getProvinceIdByName(String recv_province);

	String getCityIdByName(@Param("recv_city") String recv_city,@Param("recv_province_id") String recv_province_id);

	String getAreaIdByName(@Param("recv_area") String recv_area,@Param("recv_city_id") String recv_city_id);
	List<Address> getAllAddressByUId(Integer uid);

	Integer deleteDefault(Integer uid);

	Integer addDefault(Integer id);

	int deleteAddressById(Integer id);

	Address getAddressById(Integer id);

	int updateAddress(Address address);

}
