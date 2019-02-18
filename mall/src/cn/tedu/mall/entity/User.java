package cn.tedu.mall.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -3830901374268256344L;
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String mobile;
	private String image;
	private int gender;
	private String create_user;
	private String create_time;
	private String modify_user;
	private String modify_time;
	
	
	public User(int id, String name, String password, String email, String mobile, String image, int gender,
			String create_user, String create_time, String modify_user, String modify_time) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.image = image;
		this.gender = gender;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCreateUserby() {
		return create_user;
	}
	public void setCreateUserby(String create_user) {
		this.create_user = create_user;
	}
	public String getCreateTime() {
		return create_time;
	}
	public void setCreateTime(String create_time) {
		this.create_time = create_time;
	}
	public String getModifyUserby() {
		return modify_user;
	}
	public void setModifyUserby(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getModifyTime() {
		return modify_time;
	}
	public void setModifyTime(String modify_time) {
		this.modify_time = modify_time;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", image=" + image + ", gender=" + gender + ", create_user=" + create_user
				+ ", create_time=" + create_time + ", modify_user=" + modify_user + ", modify_time=" + modify_time + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
