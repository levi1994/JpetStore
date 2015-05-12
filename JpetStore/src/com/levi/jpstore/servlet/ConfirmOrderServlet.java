package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.dto.CartDTO;
import com.levi.jpstore.bean.AccountBean;
import com.levi.jpstore.bean.CartBean;
import com.levi.jpstore.bean.OrdersBean;
import com.levi.jpstore.bean.SupplierBean;
import com.levi.jpstore.dao.AccountDao;
import com.levi.jpstore.dao.CartDao;
import com.levi.jpstore.dao.SequenceDao;
import com.levi.jpstore.dao.SupplierDao;

public class ConfirmOrderServlet extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doPost(req, resp);
		}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//1.获取用户信息
	String userid = (String) request.getSession().getAttribute("userid");
	AccountBean account = AccountDao.getAccountInfo(userid);
	//2.获取购物购物车信息
	List<CartDTO> list = CartDao.getCart(userid);
	//3.获取订单中的itemid信息
	//这里默认取第一个信息的itemid取地址信息
	String itemid = list.get(0).getItemid();
	//4.根据itemid获取supplier信息
	SupplierBean supplier = SupplierDao.getSupplierInfo(itemid);
	//5.将信息传入界面
	//6.获取所有订单信息
	OrdersBean bean = new OrdersBean();
	bean.setBilladdr1(request.getParameter("order.billToFirstName"));
	bean.setBilladdr2(request.getParameter("order.billToLastName"));
	bean.setBillcity(request.getParameter("order.billCity"));
	bean.setBillcountry(request.getParameter("order.billCountry"));
	bean.setBillstate(request.getParameter("order.billState"));
	bean.setBilltofirstname(request.getParameter("order.billToFirstName"));
	bean.setBilltolastname(request.getParameter("order.billToLastName"));
	bean.setBillzip(request.getParameter("order.billZip"));
	bean.setCardtype(request.getParameter("order.cardType"));
	bean.setCourier("EMS");
	bean.setCreditcard(request.getParameter("order.creditCard"));
	bean.setExprdate(request.getParameter("order.expiryDate"));
	bean.setLocale("TTT");
//	System.out.println(request.getParameter("order.expiryDate"));
//	bean.setOrderdate(java.sql.Date.valueOf(request.getParameter("order.expiryDate")));
	//获取生成id
	bean.setOrderid(SequenceDao.getOrderid());
	bean.setShipaddr1(request.getParameter("order.billAddress1"));
	bean.setShipaddr2(request.getParameter("order.billAddress2"));
	bean.setShipcity(request.getParameter("order.billCity"));
	bean.setShipcountry(request.getParameter("order.billCountry"));
	bean.setShipstate(request.getParameter("order.billState"));
	bean.setShiptofirstname(request.getParameter("order.billToFirstName"));
	bean.setShiptolastname(request.getParameter("order.billToLastName"));
	bean.setShipzip(request.getParameter("order.billZip"));
	bean.setTotalprice( (Double) request.getSession().getAttribute("cartlistsum"));
	bean.setUserid(userid);
	
	request.getSession().setAttribute("supplier", supplier);
	request.getSession().setAttribute("accountInfo", account);
	request.getSession().setAttribute("order", bean);
	System.out.println("total = "+bean.getTotalprice());
	//7.跳转至界面
	PrintWriter out = response.getWriter();
	out.print("<script language='javascript'>"
			+ "window.location.href='order/ConfirmOrder.jsp';"
			+ "</script>");
	return;
	
}
}
