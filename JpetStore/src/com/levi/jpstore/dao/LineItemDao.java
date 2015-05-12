package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levi.jpstore.bean.LineItemBean;
import com.levi.jpstore.db.DBUtil;


public class LineItemDao {
	public static List<LineItemBean> getLineItem(String orderid) {
		ResultSet rs = null;
		List<LineItemBean> list = new ArrayList<LineItemBean>();
		try {
			Connection conn = DBUtil.getConnection();
		    String sql = "select * from lineitem where orderid='"+orderid+"'";
		    Statement sta = conn.createStatement();
		    System.out.println(sql);
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	LineItemBean bean = new LineItemBean();
		    	bean.setItemid(rs.getString("itemid"));
		    	bean.setLinenum(rs.getInt("linenum"));
		    	bean.setOrderid(rs.getInt("orderid"));
		    	bean.setQuantity(rs.getInt("quantity"));
		    	bean.setUnitprice(rs.getDouble("unitprice"));
		    	list.add(bean);
		    }
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void addLineItem(LineItemBean bean){
		
        String sql = "insert into lineitem(itemid,linenum,orderid,quantity,unitprice) values(?,?,?,?,?)";
        Connection conn;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, bean.getItemid());
			sta.setInt(2, bean.getLinenum());
			sta.setInt(3, bean.getOrderid());
			sta.setInt(4, bean.getQuantity());
			sta.setDouble(5, bean.getUnitprice());
			int t = sta.executeUpdate();
			System.out.println("add lineitem update执行成功，"+t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
	}

}
