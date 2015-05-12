package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levi.dto.CartDTO;
import com.levi.jpstore.db.DBUtil;

public class CartDao {
	public static List<CartDTO> getCart(String userid) {
		ResultSet rs = null;
		List<CartDTO> list = new ArrayList<CartDTO>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
		    String sql = "select item.itemid,item.productid,item.listprice,cart.amount,"
		    		+ "product.descn from item,product,cart where cart.userid='"+userid+"' and "
		    				+ " cart.itemid=item.itemid and item.productid=product.productid";
		    rs = sta.executeQuery(sql);
		    while(rs.next()){
		    	CartDTO bean = new CartDTO();
		    	bean.setItemid(rs.getString("itemid"));
		    	bean.setDescn(rs.getString("descn"));
		    	bean.setListprice(rs.getDouble("listprice"));
		    	bean.setProductid(rs.getString("productid"));
		    	bean.setAmount(rs.getInt("amount"));
		    	double unitprice = rs.getDouble("listprice")*rs.getInt("amount");
		    	bean.setUnitprice(unitprice);
		    	list.add(bean);
		    }
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void removeCart(String itemid,String userid){
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sql = "DELETE FROM  cart WHERE userid='"+userid+"' and itemid='"+itemid+"'";
			int t = sta.executeUpdate(sql);
			System.out.println("购物车商品移除成功，影响" +t+"行");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void removeCart(String userid){
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sql = "DELETE FROM  cart WHERE userid='"+userid+"'";
			int t = sta.executeUpdate(sql);
			System.out.println("购物车商品移除成功，影响" +t+"行");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void addCart(String userid,String itemid){
		System.out.println("进入addCart");
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sqlget = "select * from cart where userid='"+userid+"' and itemid='"+itemid+"'";
			System.out.println(sqlget);
			ResultSet rs = sta.executeQuery(sqlget);
			if(rs.next()){
				int t = rs.getInt("amount");
				t++;
				String sql = "UPDATE  cart  t "
						+ "set t.amount= "+t
						+ " WHERE t.itemid='"+itemid+"' and t.userid='"+userid+"'";
				System.out.println(sql);
				int s = sta.executeUpdate(sql);
				System.out.println("购物车商品添加成功，影响" +s+"行");
			}else{
				String sql = "INSERT INTO  cart VALUES('"+itemid+"','"+userid+"',1)";
				int t = sta.executeUpdate(sql);
				System.out.println("购物车商品添加成功，影响" +t+"行");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
