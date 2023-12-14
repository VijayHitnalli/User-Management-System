package com.jsp.ums.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ums.dao.UserDao;
import com.jsp.ums.entity.User;

@WebServlet("/users")
public class UserService extends HttpServlet {
	
	UserDao dao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUsername(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("pwd"));
		
		String msg = dao.saveUser(user);
		
//		PrintWriter writer = resp.getWriter();	
//		writer.print("<h1>"+msg+"</h1>");
		
//		resp.sendRedirect("home.jsp");
		
		req.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = dao.getAllUsers();
		req.setAttribute("users", users);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view-users.jsp");
		dispatcher.forward(req, resp);
	}
}
