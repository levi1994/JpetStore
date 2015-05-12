package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.bean.OrdersBean;
import com.levi.jpstore.dao.OrdersDao;

public class ListOrdersServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String userid = (String) request.getSession().getAttribute("userid");
	List<OrdersBean> orderslist = OrdersDao.getOrders(userid);
	request.getSession().setAttribute("orderslist", orderslist);
	PrintWriter out = response.getWriter();
	out.print("<script language='javascript'>"
			+ "window.location.href='order/ListOrders.jsp';"
			+ "</script>");
}
}
