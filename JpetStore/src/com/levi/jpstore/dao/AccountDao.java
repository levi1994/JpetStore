package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.jpstore.bean.AccountBean;
import com.levi.jpstore.db.DBUtil;

public class AccountDao {
	
	
	public static AccountBean getAccountInfo(String username){
		AccountBean bean = new AccountBean();
		ResultSet rs = null;
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select * from account where userid='" +username+"'";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	bean.setUserid(rs.getString("userid"));
		    	bean.setAddr1(rs.getString("addr1"));
		    	bean.setAddr2(rs.getString("addr2"));
		    	bean.setCity(rs.getString("city"));
		    	bean.setEmail(rs.getString("email"));
		    	bean.setFirstname(rs.getString("firstname"));
		    	bean.setLastname(rs.getString("lastname"));
		    	bean.setStatus(rs.getString("status"));
		    	bean.setState(rs.getString("state"));
		    	bean.setZip(rs.getString("zip"));
		    	bean.setCountry(rs.getString("country"));
		    	bean.setPhone(rs.getString("phone"));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
	public static void setAccountInfo(AccountBean bean){
		String addr1 = bean.getAddr1();
		String addr2 = bean.getAddr2();
		String city = bean.getCity();
		String country = bean.getCountry();
		String email = bean.getEmail();
		String firstname = bean.getFirstname();
		String lastname = bean.getLastname();
		String phone = bean.getPhone();
		String state = bean.getState();
        String status = bean.getStatus();
        String userid = bean.getUserid();
        String zip = bean.getZip();
        String sql = "update account set addr1=?,addr2=?,city=?,country=?,email=?,firstname=?,lastname=?,"
        		+ "phone=?,state=?,status=?,zip=?"
        		+ "where userid=?";
        Connection conn;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, addr1);
			sta.setString(2, addr2);
			sta.setString(3, city);
			sta.setString(4, country);
			sta.setString(5, email);
			sta.setString(6, firstname);
			sta.setString(7, lastname);
			sta.setString(8, phone);
			sta.setString(9, state);
			sta.setString(10, status);
			sta.setString(11, zip);
			sta.setString(12, userid);
			int t = sta.executeUpdate();
			System.out.println("update执行成功，"+t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
	}

}
