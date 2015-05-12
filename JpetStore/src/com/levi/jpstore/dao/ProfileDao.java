package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.jpstore.bean.ProfileBean;
import com.levi.jpstore.db.DBUtil;

public class ProfileDao {
	public ProfileDao() {
		// TODO Auto-generated constructor stub
	}
	public static ProfileBean getAccountInfo(String username){
		ProfileBean bean = new ProfileBean();
		ResultSet rs = null;
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select * from profile where userid='" +username+"'";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	bean.setUserid(rs.getString("userid"));
		    	bean.setBanneropt(rs.getInt("banneropt"));
		    	bean.setFavcategory(rs.getString("favcategory"));
		    	bean.setLangpref(rs.getString("langpref"));
		    	bean.setMylistopt(rs.getInt("mylistopt"));
		    	System.out.println(rs.getString("userid"));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
	public static void setProfile(ProfileBean bean){
		String favcategory = bean.getFavcategory();
		String langpref = bean.getLangpref();
		String userid = bean.getUserid();
		int banneropt = bean.getBanneropt();
		int mylistopt = bean.getMylistopt();

        String sql = "update profile set favcategory=?,langpref=?,banneropt=?,mylistopt=? where userid=?";
        Connection conn;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, favcategory);
			sta.setString(2, langpref);
			sta.setInt(3, banneropt);
			sta.setInt(4, mylistopt);
			sta.setString(5, userid);
			int t = sta.executeUpdate();
			System.out.println("profile update执行成功，"+t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
	}
  

}
