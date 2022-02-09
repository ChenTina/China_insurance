package com.insurance.bean;

import java.sql.Date;

public class User {
	private String Userid;		//工号
	private String password;
	private String name;
	private String sex;
	private String institutions;	//机构
	private Date createTime;	//账号添加时间
	private Date uppTime;	//密码最后修改时间
	
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		this.Userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getInstitutions() {
		return institutions;
	}
	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUppTime() {
		return uppTime;
	}
	public void setUppTime(Date uppTime) {
		this.uppTime = uppTime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "User [Userid=" + Userid + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", institutions=" + institutions + ", createTime=" + createTime + ", uppTime=" + uppTime + "]";
	}
	
	

}
