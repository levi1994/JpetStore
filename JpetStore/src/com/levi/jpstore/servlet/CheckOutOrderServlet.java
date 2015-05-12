package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.bean.AccountBean;
import com.levi.jpstore.dao.AccountDao;



public class CheckOutOrderServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String userid = (String) request.getSession().getAttribute("userid");
	//获得账号信息在页面显示
	AccountBean account = AccountDao.getAccountInfo(userid);
	//获取当前时间
	Date date = new Date();
	request.getSession().setAttribute("accountInfo", account);
	request.getSession().setAttribute("date", date);
	PrintWriter out = response.getWriter();
	out.print("<script language='javascript'>"
			+ "window.location.href='order/NewOrderForm.jsp';"
			+ "</script>");
	return;
}
}
