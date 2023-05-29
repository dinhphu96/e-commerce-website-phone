package com.fpoly.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.model.*;
@WebFilter(filterName = "AuthFilter" , urlPatterns = {"/AccountManagementServlet/*","/AccountManagementServlet"})
public class AuthFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String uri = req.getRequestURI();
		User user = (User) req.getSession().getAttribute("user");
		String error = "";
		System.out.println("AuthFilter running");
		if(user == null) {
			error = resp.encodeURL("Please login to use this function!");
			System.out.println("Vui lòng đăng nhập!");
		}
		else if(!user.getRole() && uri.contains("AccountManagementServlet")) {
			System.out.println("Vui lòng đăng nhập với vai trò admin");
			error = resp.encodeURL("Please login with admin role");
			
		}
		if(!error.isEmpty()) {
//			req.getSession().setAttribute("securi", uri);
			req.getSession().setAttribute("securi", error);
			System.out.println("Error!");
			resp.sendRedirect("sign-in?error="+resp.encodeURL(error));
		}else {
			System.out.println("No Error!");
			chain.doFilter(req, resp);
		}
	}

}
