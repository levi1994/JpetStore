package com.levi.jpstore.dao;
/*
 * 是为product.jsp显示信息所写的dao
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levi.dto.ProductItemDTO;
import com.levi.jpstore.db.DBUtil;

public class ProductItemDao {
	//这是为product.jsp显示信息写的方法
	public static List<ProductItemDTO> getProduct(String productid) {
		ResultSet rs = null;
		List<ProductItemDTO> list = new ArrayList<ProductItemDTO>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select item.itemid,item.productid,item.listprice,"
		    		+ "product.descn from item,product where item.productid='"+productid+"' and "
		    				+ " item.productid=product.productid";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	ProductItemDTO bean = new ProductItemDTO();
		    	bean.setItemid(rs.getString("itemid"));
		    	bean.setDescn(rs.getString("descn"));
		    	bean.setListprice(rs.getDouble("listprice"));
		    	bean.setProductid(rs.getString("productid"));
		    	list.add(bean);
		    }
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
