
package com.jsp.ums.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ums.dao.UserDao;
import com.jsp.ums.entity.User;

@WebServlet("/update-user")
public class UserUpdateService extends HttpServlet {

	UserDao dao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = dao.getUserById(Integer.parseInt(req.getParameter("userId")));

//		if (user != null) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("update-user.jsp").forward(req, resp);
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUserId(Integer.parseInt(req.getParameter("userId")));
		user.setUsername(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("pwd"));

		String msg = dao.updateUser(user);

		req.setAttribute("msg", msg);
		req.setAttribute("users", dao.getAllUsers());

		req.getRequestDispatcher("view-users.jsp").forward(req, resp);
	}
}
