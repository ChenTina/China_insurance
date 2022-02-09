package com.insurance.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.bean.AUuser;
import com.insurance.service.auuserService;

@Controller
@RequestMapping("user")
public class GetRight {
	
	@Autowired
	private auuserService auuserservice;
	
	@RequestMapping(value="url/queryAUuser")
	@ResponseBody
	public Map<String,Object> queryAUuser(String Userid,@RequestParam(required=true,defaultValue="1") Integer pageNo) {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo,5);
		List<Map<String, Object>> auuser = auuserservice.queryAUuser(Userid);
		PageInfo<Map<String, Object>> page=new PageInfo<Map<String, Object>>(auuser,5);	//5表示页面需要连续显示的页码
		//System.out.println(auuser.getUrlName());
		map.put("page",page);
		map.put("status", 0);
		return map;
	}
	
	
	@RequestMapping(value="url/findAllAUuser")
	@ResponseBody
	public Map<String,Object> findByPage1(@RequestParam(required=true,defaultValue="1") Integer pageNo, HttpServletResponse response)throws Exception{
		PageHelper.startPage(pageNo,5);
		//紧跟着的第一个方法会被分页
		List<Map<String, Object>> auusers=auuserservice.findall();
		//使用pageInfo包装查询后的结果
		PageInfo<Map<String, Object>> page=new PageInfo<Map<String, Object>>(auusers,5);	//5表示页面需要连续显示的页码
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("list",list);
		map.put("page",page);
		return map;
	}
	
	@RequestMapping(value="url/insertAUusers")
	@ResponseBody
	public Map<String,Object> batchInsert(@RequestBody List<String> lists) throws CloneNotSupportedException {
		//批量插入
		System.out.println(lists);
		Map<String,Object> map = new HashMap<String, Object>();
		List<String> menuids = new ArrayList<String>();
		List<AUuser> auusers = new ArrayList<AUuser>();
		AUuser auuser = new AUuser();
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis); 
		if(lists!=null) {
		for(String list : lists) {
			if(list.contains("-")){
				
				String[] list1 = list.split("-");
				//System.out.println(list1);
				//组装id的集合			
				for (String menuid : list1) { 
					System.out.println(menuid);
					menuids.add(menuid); 
					auuser.setUrl(menuid);
					auuser.setUserid(lists.get(1));
					auuser.setAUtime(date);
					AUuser auuser1 =  auuser.clone();
					auusers.add(auuser1);
					System.out.println(auusers);
					}
				System.out.println(menuids);
				System.out.println(auusers);
			}
		}
			
			auuserservice.batchInsert(auusers);
			map.put("msg","插入成功");
			map.put("status", 0);
			return map;
			
		}
		else {
			map.put("msg","插入失败");
			map.put("status", -1);
			return map;
		}

	
	}
}
