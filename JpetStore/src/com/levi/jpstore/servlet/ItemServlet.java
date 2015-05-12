package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.dto.ProductItemDTO;
import com.levi.jpstore.dao.ProductItemDao;

public class ItemServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productid = request.getParameter("productid");
		PrintWriter out  = response.getWriter();
		List<ProductItemDTO> productInfo = ProductItemDao.getProduct(productid);
		request.getSession().setAttribute("productInfo", productInfo);
		out.print("<script language='javascript'>window.location.href='catalog/Product.jsp';</script>");
		return;
	}
}
