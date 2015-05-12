package com.levi.jpstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.levi.jpstore.bean.OrdersBean;
import com.levi.jpstore.db.DBUtil;

public class OrdersDao {
	public static void addOrder(OrdersBean bean){
		String billaddr1 = bean.getBilladdr1();
		String billaddr2 = bean.getBilladdr2();
		String billcity = bean.getBillcity();
		String billcountry = bean.getBillcountry();
		String billstate = bean.getBillstate();
		String billtofirstname = bean.getBilltofirstname();
		String billtolastname = bean.getBilltolastname();
		String billzip = bean.getBillzip();
		String cardtype = bean.getCardtype();
		String courier = bean.getCourier();
		String creditcard = bean.getCreditcard();
		String exprdate = bean.getExprdate();
		String locale = bean.getLocale();
		String orderdate = bean.getOrderdate();
		String shipaddr1 = bean.getShipaddr1();
		String shipaddr2  =bean.getShipaddr2();
		String shipcity = bean.getShipcity();
		String shipcountry = bean.getShipcountry();
		String shipstate = bean.getShipstate();
		String shiptofirstname = bean.getShiptofirstname();
		String shiptolastname = bean.getShiptolastname();
		String shipzip = bean.getShipzip();
		Double totalprice = bean.getTotalprice();
		String userid = bean.getUserid();
		int orderid = bean.getOrderid();
	
        String sql = "insert into orders(billaddr1,billaddr2,billcity,billcountry,billstate,billtofirstname,billtolastname,billzip,"
        		+ "cardtype,courier,creditcard,exprdate,locale,orderdate,shipaddr1,shipaddr2,"
        		+ "shipcity,shipcountry,shipstate,shiptofirstname,shiptolastname,shipzip,totalprice,userid,orderid) values("
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, billaddr1);
			sta.setString(2, billaddr2);
			sta.setString(3, billcity);
			sta.setString(4, billcountry);
			sta.setString(5, billstate);
			sta.setString(6, billtofirstname);
			sta.setString(7, billtolastname);
			sta.setString(8, billzip);
			sta.setString(9, cardtype);
			sta.setString(10, courier);
			sta.setString(11, creditcard);
			sta.setString(12, exprdate);
			sta.setString(13, locale);
			Calendar c = Calendar.getInstance();
			String date =""+c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DATE);
			sta.setString(14,date);
			sta.setString(15, shipaddr1);
			sta.setString(16, shipaddr2);
			sta.setString(17, shipcity);
			sta.setString(18, shipcountry);
			sta.setString(19, shipstate);
			sta.setString(20, shiptofirstname);
			sta.setString(21, shiptolastname);
			sta.setString(22, shipzip);
			sta.setDouble(23, totalprice);
			sta.setString(24, userid);
			sta.setInt(25,orderid);
			int t = sta.executeUpdate();
			System.out.println("update执行成功，"+t);
			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	public static List<OrdersBean> getOrders(String userid){
		List<OrdersBean> orderslist = new ArrayList<OrdersBean>();
		Connection conn;
		ResultSet rs;
		 String sql = "select *  from orders where userid=?";
		 try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, userid);
			rs = sta.executeQuery();
			while(rs.next()){
				OrdersBean bean = new OrdersBean();
				bean.setBilladdr1(rs.getString("billaddr1"));
				bean.setBilladdr2(rs.getString("billaddr2"));
				bean.setBillcity(rs.getString("billcity"));
				bean.setBillcountry(rs.getString("billcountry"));
				bean.setBillstate(rs.getString("billstate"));
				bean.setBilltofirstname(rs.getString("billtofirstname"));
				bean.setBilltolastname(rs.getString("billtolastname"));
				bean.setBillzip(rs.getString("billzip"));
				bean.setCardtype(rs.getString("cardtype"));
				bean.setCourier(rs.getString("cardtype"));
				bean.setCreditcard(rs.getString("creditcard"));
				bean.setExprdate(rs.getString("exprdate"));
				bean.setLocale(rs.getString("exprdate"));
				bean.setLocale(rs.getString("locale"));
				bean.setOrderdate(rs.getString("orderdate"));
				bean.setOrderid(rs.getInt("orderid"));
				bean.setShipaddr1(rs.getString("shipaddr1"));
				bean.setShipaddr2(rs.getString("shipaddr2"));
				bean.setShipcity(rs.getString("shipcity"));
				bean.setShipcountry(rs.getString("shipcountry"));
				bean.setShipstate(rs.getString("shipstate"));
				bean.setShiptofirstname(rs.getString("shiptofirstname"));
				bean.setShiptolastname(rs.getString("shiptofirstname"));
				bean.setShipzip(rs.getString("shipzip"));
				bean.setTotalprice(rs.getDouble("totalprice"));
				bean.setUserid(rs.getString("userid"));
				orderslist.add(bean);
			}
			DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return orderslist;
	}
	public static OrdersBean getOrder(String orderid){
		OrdersBean bean = new OrdersBean();
		Connection conn;
		ResultSet rs;
		String sql ="select *  from orders where orderid=?";
		try {
			conn = DBUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, orderid);
			rs = sta.executeQuery();
			while(rs.next()){
				bean.setBilladdr1(rs.getString("billaddr1"));
				bean.setBilladdr2(rs.getString("billaddr2"));
				bean.setBillcity(rs.getString("billcity"));
				bean.setBillcountry(rs.getString("billcountry"));
				bean.setBillstate(rs.getString("billstate"));
				bean.setBilltofirstname(rs.getString("billtofirstname"));
				bean.setBilltolastname(rs.getString("billtolastname"));
				bean.setBillzip(rs.getString("billzip"));
				bean.setCardtype(rs.getString("cardtype"));
				bean.setCourier(rs.getString("cardtype"));
				bean.setCreditcard(rs.getString("creditcard"));
				bean.setExprdate(rs.getString("exprdate"));
				bean.setLocale(rs.getString("exprdate"));
				bean.setLocale(rs.getString("locale"));
				bean.setOrderdate(rs.getString("orderdate"));
				bean.setOrderid(rs.getInt("orderid"));
				bean.setShipaddr1(rs.getString("shipaddr1"));
				bean.setShipaddr2(rs.getString("shipaddr2"));
				bean.setShipcity(rs.getString("shipcity"));
				bean.setShipcountry(rs.getString("shipcountry"));
				bean.setShipstate(rs.getString("shipstate"));
				bean.setShiptofirstname(rs.getString("shiptofirstname"));
				bean.setShiptolastname(rs.getString("shiptofirstname"));
				bean.setShipzip(rs.getString("shipzip"));
				bean.setTotalprice(rs.getDouble("totalprice"));
				bean.setUserid(rs.getString("userid"));
			}
			DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return bean;
	}

}
