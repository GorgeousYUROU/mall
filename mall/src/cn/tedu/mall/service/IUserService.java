package cn.tedu.mall.service;

import cn.tedu.mall.entity.User;
import cn.tedu.mall.service.exception.EmailNullException;
import cn.tedu.mall.service.exception.NameNullException;
import cn.tedu.mall.service.exception.PasConfirmException;

import cn.tedu.mall.service.exception.PasNullException;
import cn.tedu.mall.service.exception.UserExistException;



public interface IUserService {
	public void register(String name,
	String password,
	String confirm,
	String email,
	String mobile
	) throws UserExistException,PasConfirmException,EmailNullException
	,NameNullException,PasNullException;

	public User login(String name, String password);
	public boolean ExistUser(String name);
	public void deleteUsers(Integer... id);

	public void renewPaw(String newPaw, int id);
	public void checkPaw(String oldPaw,User user);



}
