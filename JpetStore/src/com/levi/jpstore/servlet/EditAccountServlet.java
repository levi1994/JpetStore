package com.levi.jpstore.servlet;
/*
 * 这是用户信息更改表格所使用过的servlet
 * account/EditAccountForm.jsp
 */
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

public class EditAccountServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	AccountBean bean = new AccountBean();
	ProfileBean pro = new ProfileBean();
	//从页面取值
	bean.setAddr1((String) request.getParameter("account.addr1"));
	bean.setAddr2((String) request.getParameter("account.addr2"));
	bean.setCity((String) request.getParameter("account.city"));
	bean.setCountry((String) request.getParameter("account.country"));
	bean.setEmail((String) request.getParameter("account.email"));
	bean.setFirstname((String) request.getParameter("account.firstname"));
	bean.setLastname((String) request.getParameter("account.lastname"));
	bean.setPhone( request.getParameter("account.phone"));
	bean.setState((String) request.getParameter("account.state"));
	bean.setStatus((String) request.getParameter("account.status"));
	bean.setUserid((String) request.getParameter("account.userid"));
	bean.setZip((String) request.getParameter("account.zip"));
	//对profile进行赋值，对checkbox之进行判断
	if(request.getParameter("account.bannerOption")=="true")
    {pro.setBanneropt(1);}else{
    	pro.setBanneropt(0);
    }
	if(request.getParameter("account.listOption")=="true")
    {pro.setMylistopt(1);}else{
    	pro.setMylistopt(0);
    }
	pro.setUserid((String) request.getParameter("account.userid"));
	pro.setFavcategory(request.getParameter("account.favouriteCategoryId"));
	pro.setLangpref(request.getParameter("account.languagePreference"));
	//将值传入数据库
	AccountDao.setAccountInfo(bean);
	ProfileDao.setProfile(pro);
//	AccountDao.setAccountInfo(account);
	PrintWriter out  = response.getWriter();
	out.print("<script language='javascript'>alert('edit success');window.location.href='catalog/Main.jsp';</script>");
}
}
