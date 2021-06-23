package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/")
public class UserController extends HttpServlet {
	
	private UserDao userDao;
		
	public UserController() {
		this.userDao = new UserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		
		switch(path) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		default:
			allUsers(request, response);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("show_form.jsp");
		rd.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDao.selectUser(id);
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("show_form.jsp");
		rd.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User user = new User(name, email, country);
		userDao.insertUser(user);
		
		response.sendRedirect("user_list");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User user = new User(id, name, email, country);
		userDao.updateUser(user);
		
		response.sendRedirect("user_list");
	}
	
	private void allUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<User> users = userDao.allUsers();
		request.setAttribute("allUsers", users);
				
		RequestDispatcher rd = request.getRequestDispatcher("user_list.jsp");
		rd.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		
		response.sendRedirect("user_list");
	}

}
