package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levi.dto.ViewOrderDTO;
import com.levi.jpstore.db.DBUtil;

public class ViewOrderDao {
	//这是为ViewOrder.jsp显示信息写的方法
	public static List<ViewOrderDTO> getLineItemList(String orderid) {
		ResultSet rs = null;
		List<ViewOrderDTO> list = new ArrayList<ViewOrderDTO>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select lineitem.itemid,product.descn,lineitem.quantity,item.listprice,"
		    		+ " lineitem.unitprice  "
		    		+ " from lineitem,product,item  "
		    		+ " where lineitem.orderid='"+orderid+"'"
		    		+ "  and lineitem.itemid=item.itemid  "
		    		+ " and item.productid=product.productid";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	ViewOrderDTO bean = new ViewOrderDTO();
		    	bean.setItemid(rs.getString("itemid"));
		    	bean.setDescn(rs.getString("descn"));
		    	bean.setListprice(rs.getDouble("listprice"));
		    	bean.setQuantity(rs.getInt("quantity"));
		    	bean.setUnitprice(rs.getDouble("unitprice"));
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
