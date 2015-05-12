package com.levi.jpstore.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements javax.servlet.Filter{
    
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest request = (HttpServletRequest)servletRequest;  
        HttpServletResponse response = (HttpServletResponse)servletResponse;  
        HttpSession session = request.getSession();  
        String username = (String) session.getAttribute("userid");
        if(checkInList(request) && username==null){  
             //重定向到指定页面  
        	  System.out.println("尚未登录，跳转到登录页面");
        	  PrintWriter out = response.getWriter();
		      out.print("<script language='javascript'>alert('please login first');window.location.href='account/SignonForm.jsp';</script>");
        }else{  
            //继续响应请求  
            chain.doFilter(servletRequest, servletResponse);  
        }  
    }  
      
	@Override
	public void init(FilterConfig fConfig) throws ServletException {  
       
    }  
	 /** 
     * 校验当前请求是否在不过滤的列表中 
     * @param request 
     * @return 
     */  
    private boolean checkInList(HttpServletRequest request)           
    {           
        String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
        if(uri.contains("EditAccountForm.jsp")||uri.contains("GetAccountInfoServlet")||uri.contains("CartServlet")){
        	return true;
        }
        return false;
    }      

}
