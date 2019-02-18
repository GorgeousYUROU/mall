package cn.tedu.mall.service.implement;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.mall.entity.User;
import cn.tedu.mall.mapper.MapperUser;
import cn.tedu.mall.service.IUserService;
import cn.tedu.mall.service.exception.EmailNullException;
import cn.tedu.mall.service.exception.NameNullException;
import cn.tedu.mall.service.exception.PasConfirmException;
import cn.tedu.mall.service.exception.PasErrorException;
import cn.tedu.mall.service.exception.PasNullException;
import cn.tedu.mall.service.exception.ServiceException;
import cn.tedu.mall.service.exception.UserExistException;
import cn.tedu.mall.service.exception.UserNotFoundException;

@Service
@Transactional
public class UserService implements IUserService {
	@Resource
	private MapperUser mapperUser;
	@Value("#{cfg.salt}")
	private String salt;
	
	public UserService() {
		// TODO Auto-generated constructor stub
		
	}
	public void register(String name,String password,String confirm,String email,String mobile) 
			throws UserExistException,PasConfirmException,EmailNullException,
			NameNullException,PasNullException
			
	{
		if(name.isEmpty() || name.trim().isEmpty())
		{
			throw new NameNullException("用户名不能为空");
		}
		if(password.isEmpty() || password.trim().isEmpty())
		{
			throw new PasNullException("密码不能为空");
		}
		if(email.isEmpty() || password.trim().isEmpty())
		{
			throw new EmailNullException("邮箱不能为空");
		}
		if(!password.equals(confirm))
		{
			throw new PasConfirmException("两次输入密码不一致");
		}
		
		User user=mapperUser.getUserByName(name);
		if(user!=null)
		{
			throw new UserExistException("用户名已经存在");
		}
		Date date=new Date();
		SimpleDateFormat fm=new SimpleDateFormat("yyyyMMddHHmmss");
		String time=fm.format(date);
		String pwd = DigestUtils.md5Hex(password)+salt;
		user=new User(0,name,pwd,email,mobile,"",0,name,time,name,time);
		int n=mapperUser.addUser(user);
		if(n!=1)
		{
			throw new ServiceException("数据库错误");
		}
		
		
	}
	public boolean ExistUser(String name) {
		// TODO Auto-generated method stub
		User user = mapperUser.getUserByName(name);
		return user!=null;
	}
	
	public User login(String name,String password){
		if(name.isEmpty() || name.trim().isEmpty())
		{
			throw new NameNullException("用户名不能为空");
		}
		if(password.isEmpty() || password.trim().isEmpty())
		{
			throw new PasNullException("密码不能为空");
		}
		
		User user = mapperUser.getUserByName(name);
		if(user==null){
			throw new UserNotFoundException("用户名不存在");
		}
		String pwd = DigestUtils.md5Hex(password)+salt;
		if(!pwd.equals(user.getPassword())){
			System.out.println(user.getPassword());
			throw new PasErrorException("密码错误");
		}
		return user;
	}
	
	
	public void deleteUsers(Integer... id){
		for(Integer i:id){
			Integer n = mapperUser.deleteUserById(i);
			if(n!=1){
				throw new ServiceException("查无此id");
			}
		}
		
	}
	
	public void renewPaw(String newPaw, int id){
		newPaw = DigestUtils.md5Hex(newPaw)+salt;
		mapperUser.renewPaw(newPaw,id);
	}
	
	public void checkPaw(String oldPaw,User user){
		String pwd = DigestUtils.md5Hex(oldPaw)+salt;
		if(!pwd.equals(user.getPassword())){
			throw new PasErrorException("密码错误");
		}
	}
	

}
