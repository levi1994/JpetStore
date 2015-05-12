package com.levi.jpstore.bean;

public class ProfileBean {
   private String userid;
   private String langpref;
   private String favcategory;
   private int mylistopt;
   private int  banneropt;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getLangpref() {
	return langpref;
}
public void setLangpref(String langpref) {
	this.langpref = langpref;
}
public String getFavcategory() {
	return favcategory;
}
public void setFavcategory(String favcategory) {
	this.favcategory = favcategory;
}
public int getMylistopt() {
	return mylistopt;
}
public void setMylistopt(int mylistopt) {
	this.mylistopt = mylistopt;
}
public int getBanneropt() {
	return banneropt;
}
public void setBanneropt(int banneropt) {
	this.banneropt = banneropt;
}
   
}
