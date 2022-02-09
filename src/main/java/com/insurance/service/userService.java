package com.insurance.service;

import java.util.List;

import com.insurance.bean.User;

public interface userService {
	public List<User> queryUserOne(String Userid);
	public User queryUser(String Userid);
	public List<User> findall();
	public void deleteUserById(String Userid);
	public void deleteUserByIds(List<String> ids);
	public void insertUser(User user);
	public void updateUser(User user);
	public void updatepassword(User user);
}
