package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levi.jpstore.bean.ProductBean;
import com.levi.jpstore.db.DBUtil;

public class ProductDao {

	public static List<ProductBean> getProduct() {
		ResultSet rs = null;
		List<ProductBean> list = new ArrayList<ProductBean>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sql = "select * from product";
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setCategory(rs.getString("category"));
				bean.setDescn(rs.getString("descn"));
				bean.setName(rs.getString("name"));
				bean.setProductid(rs.getString("productid"));
				list.add(bean);
			}
			DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return list;

	}

	public static List<ProductBean> getProduct(String category) {
		ResultSet rs = null;
		List<ProductBean> list = new ArrayList<ProductBean>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sql = "select * from product where category='" + category
					+ "'";
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setCategory(rs.getString("category"));
				bean.setDescn(rs.getString("descn"));
				bean.setName(rs.getString("name"));
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

	public static List<ProductBean> searchProduct(String name) {
		ResultSet rs = null;
		List<ProductBean> list = new ArrayList<ProductBean>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement sta = conn.createStatement();
			String sql = "select * from product";
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setCategory(rs.getString("category"));
				bean.setDescn(rs.getString("descn"));
				bean.setName(rs.getString("name"));
				bean.setProductid(rs.getString("productid"));
				if (bean.getName().toLowerCase().contains(name.toLowerCase())) {
					list.add(bean);
				}
			}
			DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return list;

	}

}
