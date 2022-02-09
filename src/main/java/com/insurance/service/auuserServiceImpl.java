package com.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.bean.AUuser;
import com.insurance.mapper.auuserDao;

@Service
public class auuserServiceImpl implements auuserService{

	@Autowired
	private auuserDao auuserdao;

	public List<Map<String, Object>> queryAUuser(String Userid) {
		// TODO Auto-generated method stub
		return auuserdao.queryAUuser(Userid);
	}

	public List<Map<String,Object>> findall() {
		// TODO Auto-generated method stub
		return auuserdao.findall();
	}

	public void batchInsert(List<AUuser> list) {
		// TODO Auto-generated method stub
		auuserdao.batchInsert(list);
	}

	public List<String> queryurl(String Userid) {
		// TODO Auto-generated method stub
		return auuserdao.queryurl(Userid);
	}
	

}
