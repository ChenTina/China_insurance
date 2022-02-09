package com.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.bean.TRight;
import com.insurance.mapper.trightDao;

@Service
public class trightServiceImpl implements trightService{
	@Autowired
	private trightDao trightdao;
	
	public List<TRight> queryTRightOne(String menuId) {
		// TODO Auto-generated method stub
		return trightdao.queryTRightOne(menuId);
	}

	public List<TRight> findall() {
		// TODO Auto-generated method stub
		return trightdao.findall();
	}

	public void deleteTRightById(String menuId) {
		// TODO Auto-generated method stub
		trightdao.deleteTRightById(menuId);
	}

	public void deleteTRightByIds(List<String> ids) {
		// TODO Auto-generated method stub
		trightdao.deleteTRightByIds(ids);
	}

	public void insertTRight(TRight tright) {
		// TODO Auto-generated method stub
		trightdao.insertTRight(tright);
	}

	public void updateTRight(TRight tright) {
		// TODO Auto-generated method stub
		trightdao.updateTRight(tright);
	}

	public TRight queryTRight(String menuId) {
		// TODO Auto-generated method stub
		return trightdao.queryTRight(menuId);
	}

	public List<Map<String,Object>> queryright(String Userid) {
		// TODO Auto-generated method stub
		return trightdao.queryright(Userid);
	}

}
