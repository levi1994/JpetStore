package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.dto.ViewOrderDTO;
import com.levi.jpstore.bean.LineItemBean;
import com.levi.jpstore.bean.OrdersBean;
import com.levi.jpstore.dao.LineItemDao;
import com.levi.jpstore.dao.OrdersDao;
import com.levi.jpstore.dao.ViewOrderDao;

public class ViewOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderid = (String) request.getParameter("orderid");
		// 获得单个的订单信息
		OrdersBean orderbean = OrdersDao.getOrder(orderid);
		// 获得订单中所有物品的列表信息
		List<ViewOrderDTO> lineitemlist = ViewOrderDao.getLineItemList(orderid);
		// 获得总价
		double total = 0;
		for (ViewOrderDTO bean : lineitemlist) {
			total += bean.getUnitprice();
		}
		// 将信息传入页面
		request.getSession().setAttribute("orderbean", orderbean);
		request.getSession().setAttribute("lineitemlist", lineitemlist);
		request.getSession().setAttribute("total", total);

		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>"
				+ "window.location.href='order/ViewOrder.jsp';" + "</script>");
	}
}
