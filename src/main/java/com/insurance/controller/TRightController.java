package com.insurance.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.bean.TRight;
import com.insurance.bean.User;
import com.insurance.service.trightService;


@Controller
@RequestMapping("user")
public class TRightController {
	@Autowired
	private trightService trightservice;
	
	
	@RequestMapping(value="url/findAllTRight")
	@ResponseBody
	public Map<String,Object> findByPage1(@RequestParam(required=true,defaultValue="1") Integer pageNo, HttpServletResponse response)throws Exception{
		PageHelper.startPage(pageNo,5);
		//紧跟着的第一个方法会被分页
		List<TRight> list=trightservice.findall();
		//使用pageInfo包装查询后的结果
		PageInfo<TRight> page=new PageInfo<TRight>(list,5);	//5表示页面需要连续显示的页码
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("list",list);
		map.put("page",page);
		return map;
	}
	
	/* 查询用户没有被分配到的信息 */
	@RequestMapping(value="url/queryright")
	@ResponseBody
	public Map<String,Object> queryright(String Userid) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> tright = trightservice.queryright(Userid);
		map.put("tright",tright);
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/queryTRightOne")
	@ResponseBody
	public Map<String,Object> queryTRight(String menuId) {
		Map<String,Object> map = new HashMap<String, Object>();
		TRight tright = trightservice.queryTRight(menuId);
		System.out.println(tright.getUrlName());
		map.put("tright",tright);
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/deleteTRight")
	@ResponseBody
	public Map<String,Object> deleteUserById(String menuId) {
		Map<String,Object> map = new HashMap<String, Object>();
		trightservice.deleteTRightById(menuId);
		map.put("msg","删除成功");
		map.put("status", 0);
		return map;
		
	}
	
	@RequestMapping(value="url/deleteTRights")
	@ResponseBody
	public Map<String,Object> deleteTRights(String ids) {
		//批量删除
		Map<String,Object> map = new HashMap<String, Object>();
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(string);
			}
			trightservice.deleteTRightByIds(del_ids);
			map.put("msg","删除成功");
			map.put("status", 0);
			return map;
		}else {
			map.put("msg","删除失败");
			map.put("status", -1);
			return map;
		}	
	}
	
	@RequestMapping(value="url/insertTRight")
	@ResponseBody
	public Map<String,Object> insertUser(TRight tright) {
		Map<String,Object> map = new HashMap<String, Object>();
		trightservice.insertTRight(tright);
		map.put("msg","添加成功");
		map.put("status", 0);
		return map;
	}
	
	@RequestMapping(value="url/queryTRight")
	@ResponseBody
	public Map<String,Object> queryUserOne(String menuId,@RequestParam(required=true,defaultValue="1") Integer pageNo, HttpServletResponse response) {
		PageHelper.startPage(pageNo,5);
		//紧跟着的第一个方法会被分页
		List<TRight> list=trightservice.queryTRightOne(menuId);
		//使用pageInfo包装查询后的结果
		PageInfo<TRight> page=new PageInfo<TRight>(list,5);	//5表示页面需要连续显示的页码
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("list",list);
		map.put("page",page);
		return map;
	}
	
	@RequestMapping(value="url/updateTRight")
	@ResponseBody
	public Map<String,Object> updateUser(TRight tright) {
		Map<String,Object> map = new HashMap<String, Object>();
		trightservice.updateTRight(tright);
		
		map.put("msg","修改成功");
		map.put("status", 0);
		return map;
	}

}

