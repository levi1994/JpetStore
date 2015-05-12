package com.levi.jpstore.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.jpstore.db.DBUtil;

public class SignonDao {
	 
	 public static boolean signon(String username,String password){
		 boolean bool=false;
		 Connection conn;
			try {
				conn = DBUtil.getConnection();
			    Statement sta = conn.createStatement();
			    String sql = "select * from signon where username='" + username
			    	     + "' and password = '" + password + "'";
			    ResultSet rs = sta.executeQuery(sql);
			    if(rs.next()){
			    	System.out.println("登陆成功");
			    	bool = true;
			    }else{
			    	System.out.println("登陆失败");
			    	bool = false;
			    }
			    DBUtil.replease(conn, sta, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bool;
	 }

}
