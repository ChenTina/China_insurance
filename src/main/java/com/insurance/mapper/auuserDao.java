package com.insurance.mapper;

import java.util.List;
import java.util.Map;

import com.insurance.bean.AUuser;

public interface auuserDao {
	public List<Map<String,Object>> queryAUuser(String Userid);
	
	public List<Map<String,Object>> findall();
	
	public void batchInsert(List<AUuser> list);
	
	public List<String> queryurl(String Userid);
}
