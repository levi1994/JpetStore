package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.dto.CartDTO;
import com.levi.jpstore.bean.LineItemBean;
import com.levi.jpstore.bean.OrdersBean;
import com.levi.jpstore.dao.CartDao;
import com.levi.jpstore.dao.LineItemDao;
import com.levi.jpstore.dao.OrdersDao;
import com.levi.jpstore.dao.SequenceDao;

/*
 * 提交订单信息的servlet
 */
public class SubmitOrderServlet extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(req, resp);
		}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	OrdersBean bean ;
	//1.获取订单对象
	bean = (OrdersBean) request.getSession().getAttribute("order");
	System.out.println(bean.getBillzip());
	//2.将订单存入数据库
	OrdersDao.addOrder(bean);
	//3.获取购物车数据
	List<CartDTO> list = (List<CartDTO>) request.getSession().getAttribute("cartlist");
	//4.将购物车的数据传入lineitem表
	for(CartDTO cart : list){
		LineItemBean lineitem = new LineItemBean();
		lineitem.setItemid(cart.getItemid());
		int linenum = SequenceDao.getLineid();
		lineitem.setLinenum(linenum);
		lineitem.setOrderid(bean.getOrderid());
		lineitem.setQuantity(cart.getAmount());
		lineitem.setUnitprice(cart.getUnitprice());
		LineItemDao.addLineItem(lineitem);
	}
	//5.清空购物车数据
	CartDao.removeCart((String) request.getSession().getAttribute("userid"));
	PrintWriter out = response.getWriter();
	out.print("<script language='javascript'>"
			+ "window.location.href='ListOrdersServlet';"
			+ "</script>");
	return;
}
}
