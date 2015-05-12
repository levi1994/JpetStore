package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.levi.jpstore.bean.SupplierBean;
import com.levi.jpstore.db.DBUtil;

public class SupplierDao {
	//这里可能会出现问题！！！！当传如订单的itemid多个时可能会出错
	public static SupplierBean getSupplierInfo(String itemid){
		SupplierBean bean = new SupplierBean();
		ResultSet rs = null;
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select supplier.suppid,supplier.name,supplier.status,supplier.addr1,supplier.addr2,"
		    		+ "supplier.city,supplier.state,supplier.zip,supplier.phone,supplier.country,"
		    		+ "supplier.firstname,supplier.lastname  "
		    		+ "from supplier,item "
		    		+ " where item.itemid='"+itemid+"'"
		    		+ " and supplier.suppid=item.supplier ";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	bean.setAddr1(rs.getString("addr1"));
		    	bean.setAddr2(rs.getString("addr2"));
		    	bean.setCity(rs.getString("city"));
		    	bean.setStatus(rs.getString("status"));
		    	bean.setState(rs.getString("state"));
		    	bean.setZip(rs.getString("zip"));
		    	bean.setPhone(rs.getString("phone"));
		    	bean.setName(rs.getString("name"));
		    	bean.setSuppid(rs.getInt("suppid"));
		    	bean.setFirstname(rs.getString("firstname"));
		    	bean.setLastname(rs.getString("lastname"));
		    	bean.setCountry(rs.getString("country"));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
