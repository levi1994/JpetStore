package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.db.DBUtil;

public class RegisterServlet extends HttpServlet{
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
	  String result = "";
	  // 获取用户名

	  String sUserName = request.getParameter ( "username" );
	  if ( sUserName == "" || sUserName == null || sUserName.length ( ) > 20 )
	  {
	   try
	   {
	    result = "请输入用户名（不超过20字符）！";
	    request.setAttribute ( "ErrorUserName", result );
	    response.sendRedirect ( "account/SignonForm.html" );
	   } catch ( Exception e )
	   {
	   }
	  }
	  // 获取密码

	  String sPasswd = request.getParameter ( "password" );
	  if ( sPasswd == "" || sPasswd == null || sPasswd.length ( ) > 20 )
	  {
	   try
	   {
	    result = "请输入密码（不超过20字符）！";
	    request.setAttribute ( "ErrorPassword", result );
	    response.sendRedirect ( "login.html" );
	   } catch ( Exception e )
	   {
	   }
	  }
	  Connection conn;
	  try {
			conn = DBUtil.getConnection();
		    Statement sta = conn.createStatement();
		    String sql = "select * from signon where username='" + sUserName
		    	     +"'";
		    ResultSet rs = sta.executeQuery(sql);
		    if(rs.next()){
		    	request.getSession ( ).setAttribute ( "UserName", sUserName );
		    	System.out.println("用户名已存在");
		    	PrintWriter out = response.getWriter();
		    	out.print("<script language='javascript'>alert('username hava exist');window.location.href='account/NewAccountForm.html';</script>");
		    }else{
		    	System.out.println("注册用户");
		    	PrintWriter out = response.getWriter();
		    	String sql1 = "insert into signon (username, password)values ('"+sUserName+"','"+sPasswd+"')";
		    	sta.execute(sql1);
		    	out.print("<script language='javascript'>alert('Register success!!!');window.location.href='account/SignonForm.jsp';</script>");
		    }
		    DBUtil.replease(conn, sta, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	}

}
