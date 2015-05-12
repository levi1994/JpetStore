package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.bean.ProductBean;
import com.levi.jpstore.dao.ProductDao;

/**
 * Servlet implementation class ProductServlet
 */

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清空之前的产品信息
		request.getSession().removeAttribute("productList");
		//获取用户访问的分类信息，则获取产品列表
		String category = request.getParameter("category");
		List<ProductBean> productList;
		//如果用户填入的分类信息为空的话(有可能用户直接访问jsp页面)
		if(category==""){
			//访问所有产品
			productList = ProductDao.getProduct();
		}else{
			//访问指定分类产品
		    productList = ProductDao.getProduct(category);
		}
		request.getSession().setAttribute("productList", productList);
		PrintWriter out  = response.getWriter();
		out.print("<script language='javascript'>window.location.href='catalog/Category.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
