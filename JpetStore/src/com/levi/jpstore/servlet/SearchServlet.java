package com.levi.jpstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Documented;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levi.jpstore.bean.ProductBean;
import com.levi.jpstore.dao.ProductDao;

public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清空之前的搜索信息
		request.getSession().removeAttribute("searchList");
		//获取用户访问的分类信息，则获取产品列表
		String keyword = request.getParameter("keyword");
		List<ProductBean> searchList;
		//如果用户填入的分类信息为空的话(有可能用户直接访问jsp页面)
		if(keyword==""){
			//访问所有产品
			searchList = ProductDao.getProduct();
		}else{
			//访问指定分类产品
			searchList = ProductDao.searchProduct(keyword);
		}
		//就使用product的页面
		request.getSession().setAttribute("productList", searchList);
		PrintWriter out  = response.getWriter();
		out.print("<script language='javascript'>window.location.href='catalog/Category.jsp';</script>");
	}

}
