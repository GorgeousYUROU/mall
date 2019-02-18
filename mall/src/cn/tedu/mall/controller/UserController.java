package cn.tedu.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.mall.entity.Address;
import cn.tedu.mall.entity.User;
import cn.tedu.mall.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;

	@RequestMapping("/register.do")
	@ResponseBody //返回值是一个Json对象
	public Result UserControllerRegister(String name,String password,String confirm,String email,
			String mobile)
	{
	
		userService.register(name, password, confirm, email, mobile);
		return new Result("ok");

	}
	
	@RequestMapping("/checkName.do")
	@ResponseBody //返回值是一个Json对象
	public Result CheckName(String name)
	{
		if(!userService.ExistUser(name))
			return new Result(Result.SUCCESS,"ok",null);
		else{
			return new Result(Result.ERROR,"error",null);
		}
		
		
	}
	
	
	@RequestMapping("/login.do")
	@ResponseBody //返回值是一个Json对象
	public Result Login(String name,String password,HttpSession session)
	{
		User user=userService.login(name, password);
		session.setAttribute("loginUser", user);
		return new Result("登录成功");
		
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	@ResponseBody
	public Result upload(MultipartFile image1,MultipartFile image2) throws IOException
	{
		File dir=new File("F:/test");
		dir.mkdir();
		String file1=image1.getOriginalFilename();
		String file2=image2.getOriginalFilename();
		
		image1.transferTo(new File(dir,file1));
		image2.transferTo(new File(dir,file2));
		return new Result("ok");
	}
	
	@RequestMapping(value="/upload2.do",method=RequestMethod.POST)
	@ResponseBody
	public Result upload2(MultipartFile images[]) throws IOException
	{
		File dir=new File("F:/test");
		dir.mkdir();
		for(MultipartFile image:images)
		{
			String file1=image.getOriginalFilename();
			image.transferTo(new File(dir,file1));
		}
		
		
		
		return new Result("ok");
	}
	
	@RequestMapping("/updatePassword.do")
	public String updatePassword(){	    
		    return "updatePassword";
	}
	
	@RequestMapping("/rewewPassword.do")
	@ResponseBody
	public Result rewewPassword( String newPaw,HttpSession session){
		    User user = (User)session.getAttribute("loginUser");
		    userService.renewPaw(newPaw,user.getId());
		    return new Result("ok");
	}
	
	@RequestMapping("/checkPassword.do")
	@ResponseBody
	public Result checkPassword( String oldPaw,HttpSession session){
		    User user = (User)session.getAttribute("loginUser");
		    userService.checkPaw(oldPaw,user);
		   
		    return new Result("ok");
	}
	
	


}
