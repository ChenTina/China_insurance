package com.insurance.mapper;

import java.util.List;
import java.util.Map;

import com.insurance.bean.TRight;


public interface trightDao {
	public List<TRight> queryTRightOne(String menuId);
	public List<TRight> findall();
	public void deleteTRightById(String menuId);
	public void deleteTRightByIds(List<String> ids);
	public void insertTRight(TRight tright);
	public void updateTRight(TRight tright);
	public TRight queryTRight(String menuId);
	
	public List<Map<String,Object>> queryright(String Userid);
}
