package com.jsp.ums.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ums.dao.UserDao;
import com.jsp.ums.entity.User;

@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet {
	
	UserDao dao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userId"));
		
		User user = dao.getUserById(id);
		if(user!=null) {
			String msg = dao.deleteUser(user);
			req.setAttribute("msg", msg);
			
			req.setAttribute("users", dao.getAllUsers());
			req.getRequestDispatcher("view-users.jsp").forward(req, resp);
		}else {
			
			System.out.println("There is no user to delete");
			
		}
	}
}
