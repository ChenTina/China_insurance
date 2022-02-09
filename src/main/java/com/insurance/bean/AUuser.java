package com.insurance.bean;

import java.sql.Date;

public class AUuser implements Cloneable{
	private String Userid;
	private String url;
	private Date AUtime;
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getAUtime() {
		return AUtime;
	}
	public void setAUtime(Date aUtime) {
		AUtime = aUtime;
	}
	
	public AUuser clone() throws CloneNotSupportedException
	{
		return (AUuser) super.clone();
	}
	@Override
	public String toString() {
		return "AUuser [Userid=" + Userid + ", url=" + url + ", AUtime=" + AUtime + "]";
	}
	
}
