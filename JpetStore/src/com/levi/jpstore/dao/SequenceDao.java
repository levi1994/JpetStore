package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.dto.CartDTO;
import com.levi.jpstore.db.DBUtil;

public class SequenceDao {
   public static int getOrderid(){
	   int t = 0;
	   ResultSet rs ;
	   try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select * from sequence where name='ordernum'";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	t = rs.getInt("nextid");
		    }
		    t +=1;
		    System.out.println(t);
		    String sql1 = "update  sequence set nextid="+t+" where name='ordernum'";
		    sta.executeUpdate(sql1);
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return t;
   }
   public static int getLineid(){
	   int t = 0;
	   ResultSet rs ;
	   try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select * from sequence where name='linenum'";
		    rs = sta.executeQuery(sql);
		  
		    while(rs.next()){
		    	t = rs.getInt("nextid");
		    }
		    t +=1;
		    System.out.println(t);
		    String sql1 = " update sequence set nextid="+t+"  where name='linenum'";
		    sta.executeUpdate(sql1);
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return t;
   }
}
