package cn.tedu.mall.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.mall.entity.User;

public interface MapperUser {
	public int addUser(User user);

	public User getUserByName(String name);

	public Integer deleteUserById(@Param("id") Integer... id);

	public void renewPaw(@Param("newPaw") String newPaw,@Param("id") int id);
}
