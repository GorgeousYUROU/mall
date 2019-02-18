package cn.tedu.mall.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/pages")
public class PagesController extends BaseController {
	
	@RequestMapping("/index.do")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/OrdersManagement.do")
	public String orders()
	{
		return "OrdersManagement";
	}
	
	

}
