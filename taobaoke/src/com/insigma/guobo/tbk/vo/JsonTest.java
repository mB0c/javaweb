package com.insigma.guobo.tbk.vo;

public class JsonTest {
	String xsbh;
	String UserName;
	String Sex;
	String SchoolYear;
	
	public JsonTest(String xsbh, String UserName, String Sex, String SchoolYear){
		this.SchoolYear = SchoolYear;
		this.Sex = Sex;
		this.UserName = UserName;
		this.xsbh = xsbh;
	}
	
	public String getXsbh() {
		return xsbh;
	}
	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getSchoolYear() {
		return SchoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		SchoolYear = schoolYear;
	}
	
	
}
