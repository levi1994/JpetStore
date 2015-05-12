package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.dto.CartDTO;
import com.levi.jpstore.dao.CartDao;


public class CartServlet extends HttpServlet {
	/**
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = (String) request.getSession().getAttribute("userid");
		double sum=0;
		List<CartDTO> cartlist = CartDao.getCart(userid);
		for(CartDTO a : cartlist){
			sum+=a.getUnitprice();
		}
		request.getSession().setAttribute("cartlistsum", sum);
		request.getSession().setAttribute("cartlist",cartlist);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>"
				+ "window.location.href='cart/Cart.jsp';"
				+ "</script>");
		return;
	}
}
