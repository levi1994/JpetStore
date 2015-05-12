package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.bean.AccountBean;
import com.levi.jpstore.bean.ProfileBean;
import com.levi.jpstore.dao.AccountDao;
import com.levi.jpstore.dao.ProfileDao;

public class GetAccountInfoServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String userid = (String) request.getSession().getAttribute("userid");
	AccountBean userInfo = AccountDao.getAccountInfo(userid);
	ProfileBean profileInfo = ProfileDao.getAccountInfo(userid);
	request.getSession().setAttribute("userInfo",userInfo);
	request.getSession().setAttribute("profileInfo", profileInfo);
	PrintWriter out = response.getWriter();
	out.print("<script language='javascript'>"
			+ "window.location.href='account/EditAccountForm.jsp';"
			+ "</script>");
	return;
}
}
