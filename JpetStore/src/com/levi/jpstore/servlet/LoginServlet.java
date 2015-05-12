package com.levi.jpstore.servlet;
/*
 * 这是登录表格所使用的servlet
 * account/SignonLogin
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.levi.jpstore.bean.AccountBean;
import com.levi.jpstore.dao.AccountDao;
import com.levi.jpstore.dao.SignonDao;
import com.levi.jpstore.db.DBUtil;

public class LoginServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	  response.setContentType ( "text/html" );
	  // 获取用户名,密码
	  String username = request.getParameter ( "username" );
	  String password = request.getParameter ( "password" );
	  PrintWriter out = response.getWriter();
	  if(SignonDao.signon(username, password)){
		  System.out.println("登陆成功");
		    request.getSession().setAttribute("userid", username);
	    	out.print("<script language='javascript'>alert('login success');window.location.href='catalog/Main.jsp';</script>");
	    	return;
	  }else{
		    System.out.println("登陆失败");
	    	out.print("<script language='javascript'>alert('login default');window.location.href='account/SignonForm.jsp';</script>");
	    	return;
	  }

	}
}
