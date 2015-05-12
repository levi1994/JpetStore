package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.jpstore.bean.ItemBean;
import com.levi.jpstore.db.DBUtil;

public class ItemDao {
	//根据productid获取相关信息的方法
	public static ItemBean getItem(String productid) {
		ResultSet rs = null;
		ItemBean bean = new ItemBean();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select * from item where productid='"+productid+"'";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	bean.setAttr1(rs.getString("attr1"));
		    	bean.setAttr2(rs.getString("attr2"));
		    	bean.setAttr3(rs.getString("attr3"));
		    	bean.setAttr4(rs.getString("attr4"));
		    	bean.setAttr5(rs.getString("attr5"));
		    	bean.setItemid(rs.getString("itemid"));
		    	bean.setListprice(rs.getDouble("listprice"));
		    	bean.setProductid(rs.getString("productid"));
		    	bean.setStatus(rs.getString("status"));
		    	bean.setSupplier(rs.getInt("supplier"));
		    	bean.setUnitcost(rs.getDouble("unitcost"));
		    }
			DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
