package cn.tedu.mall.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.mall.entity.Address;
import cn.tedu.mall.entity.User;
import cn.tedu.mall.service.IOrderService;


@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {
	
	//列表显示功能
	@Resource
	IOrderService orderService;
	@RequestMapping("/addressAdmin.do")
	public String addressAdmin(ModelMap map,HttpSession session)
	{
		User user = (User)session.getAttribute("loginUser");
		List<Address> list=orderService.getAllAddressByUId(user.getId());
		
		map.put("addresses",list);
		return "addressAdmin";
	}
	
	@RequestMapping("/addAddressAdmin.do")
	@ResponseBody
	public Result addAddress( String recv_name,String recv_province,String recv_city,String recv_area,
			String recv_district,String recv_addr,String recv_phone,String recv_tel,
			String recv_zip,String recv_tag,HttpSession session)
	{
		
		User user = (User) session.getAttribute("loginUser");
		List<Address> address=orderService.addAddress(recv_name,recv_province,recv_city,recv_area,
			recv_addr,recv_phone,recv_tel,
			recv_zip,recv_tag,user);
		
		return new Result(address);
	}
	
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public Result setDefault(Integer is_default,Integer id,HttpSession session)
	{
		User user = (User) session.getAttribute("loginUser");
		orderService.setDefault(is_default,id,user.getId());
		return new Result("ok");
	}
	
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public Result deleteAddress(Integer id,HttpSession session){
		orderService.deleteAddress(id);
		User user = (User)session.getAttribute("loginUser");
		List<Address> list=orderService.getAllAddressByUId(user.getId());
		return new Result(list);
	}
	
	
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public Result getAddress(Integer id){
		Address list=orderService.getAddressById(id);
		return new Result(list);
	}
	
	
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public Result updateAddress( String recv_name,String recv_province,String recv_city,String recv_area,
			String recv_district,String recv_addr,String recv_phone,String recv_tel,
			String recv_zip,String recv_tag,Integer id,HttpSession session){
		    User user = (User)session.getAttribute("loginUser");
		    List<Address> list=orderService.updateAddress(recv_name,recv_province,recv_city,recv_area,
					recv_addr,recv_phone,recv_tel,
					recv_zip,recv_tag,user,id);
		    return new Result(list);
	}
	
	
	
}
