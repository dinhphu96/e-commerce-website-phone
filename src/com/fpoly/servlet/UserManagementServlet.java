package com.fpoly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.DAO.UserDAO;
import com.fpoly.model.User;

@WebServlet("/management-users")
public class UserManagementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		List<User> userList = userDAO.findAll();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/users-management.jsp").forward(req, resp);
	}
}
