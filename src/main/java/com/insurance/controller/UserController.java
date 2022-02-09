package com.insurance.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.bean.User;
import com.insurance.service.userService;

@Controller
@RequestMapping("user")

public class UserController {
	@Autowired
	private userService userservice;
	
	@ResponseBody
	@RequestMapping("url/login")
	public Map<String,Object> login(User user, HttpServletResponse response) throws IOException{
			
		String id = user.getUserid();
		String password = user.getPassword();
		System.out.println(id);
		Map<String,Object> map = new HashMap<String, Object>();
		 
		user = userservice.queryUser(id);
		if(user == null) {
			map.put("message", "账号不存在,请重新输入");
			map.put("status", -1);
			return map;
			
		} else if ( !password.equals(user.getPassword()) ) {
			map.put("message", "密码错误，请重新输入");
			map.put("status", -2);
			return map;
			
		} else {	
			map.put("message","登录成功");
			map.put("status", 0);
			map.put("name",user.getName());
			Cookie cookie1 = new Cookie("name",user.getName());
			Cookie cookie2 = new Cookie("id",user.getUserid());
		    Cookie cookie3 = new Cookie("password",user.getPassword());
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			return map;
		}		
	}

	@RequestMapping(value="url/findAllUser")
	@ResponseBody
	public Map<String,Object> findByPage1(@RequestParam(required=true,defaultValue="1") Integer pageNo, HttpServletResponse response)throws Exception{
		PageHelper.startPage(pageNo,5);
		//紧跟着的第一个方法会被分页
		List<User> list=userservice.findall();
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(list,5);	//5表示页面需要连续显示的页码
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("list",list);
		map.put("page",page);
		return map;
	}
	
	@RequestMapping(value="url/deleteUser")
	@ResponseBody
	public Map<String,Object> deleteUserById(String Userid) {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.deleteUserById(Userid);
		map.put("msg","删除成功");
		map.put("status", 0);
		return map;
		
	}
	
	@RequestMapping(value="url/deleteUsers")
	@ResponseBody
	public Map<String,Object> deleteUsers(String ids) {
		//批量删除
		Map<String,Object> map = new HashMap<String, Object>();
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(string);
			}
			userservice.deleteUserByIds(del_ids);
			map.put("msg","删除成功");
			map.put("status", 0);
			return map;
		}else {
			map.put("msg","删除失败");
			map.put("status", -1);
			return map;
		}	
	}
	
	@RequestMapping(value="url/insertUser")
	@ResponseBody
	public Map<String,Object> insertUser(User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		System.out.println(date);
		user.setCreateTime(date);
		user.setUppTime(date);
		userservice.insertUser(user);
		map.put("msg","添加成功");
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/queryUser")
	@ResponseBody
	public Map<String,Object> queryUserOne(String Userid,@RequestParam(required=true,defaultValue="1") Integer pageNo, HttpServletResponse response) {
		PageHelper.startPage(pageNo,5);
		//紧跟着的第一个方法会被分页
		List<User> list=userservice.queryUserOne(Userid);
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(list,5);	//5表示页面需要连续显示的页码
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("list",list);
		map.put("page",page);
		return map;
	}
	
	@RequestMapping(value="url/queryUserOne")
	@ResponseBody
	public Map<String,Object> queryUser(String Userid) {
		Map<String,Object> map = new HashMap<String, Object>();
		User user = userservice.queryUser(Userid);
		map.put("user",user);
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.updateUser(user);
		
		map.put("msg","修改成功");
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/updatepassword")
	@ResponseBody
	public Map<String,Object> updatepassword(User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		user.setUppTime(date);
		userservice.updatepassword(user);
		
		map.put("msg","修改成功");
		map.put("status", 0);
		return map;
	}

}
