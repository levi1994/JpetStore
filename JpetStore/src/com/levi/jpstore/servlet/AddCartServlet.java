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
import com.levi.jpstore.dao.CartDao;
import com.levi.jpstore.dao.ProfileDao;

public class AddCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = (String) request.getSession().getAttribute("userid");
		String itemid = (String) request.getParameter("itemid");
		System.out.println(itemid);
		CartDao.addCart(userid, itemid);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>"
				+ "window.location.href='CartServlet';"
				+ "</script>");
		return;
	}
}
