package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.bean.User;
import com.insurance.mapper.userDao;

@Service
public class userServiceImpl implements userService{
	@Autowired
	private userDao userdao;

	public List<User> queryUserOne(String Userid) {
		
		return userdao.queryUserOne(Userid);
	}

	public List<User> findall() {
		
		return userdao.findall();
	}

	public void deleteUserById(String Userid) {
		// TODO Auto-generated method stub
		userdao.deleteUserById(Userid);
	}

	public void deleteUserByIds(List<String> ids) {
		// TODO Auto-generated method stub
		userdao.deleteUserByIds(ids);
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userdao.insertUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}

	public User queryUser(String Userid) {
		// TODO Auto-generated method stub
		return userdao.queryUser(Userid);
	}

	public void updatepassword(User user) {
		// TODO Auto-generated method stub
		userdao.updatepassword(user);
	}

}
