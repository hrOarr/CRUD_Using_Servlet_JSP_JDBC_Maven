package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserServiceImp;

@WebServlet(urlPatterns = 
{"/users/user_list", "/users/new", "/users/insert", "/users/edit","/users/update", "/users/delete"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp userServiceImp;
		
	public UserController() {
		this.userServiceImp = UserServiceImp.getServiceImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		switch(path) {
		case "/users/new":
			showNewForm(request, response);
			break;
		case "/users/insert":
			insertUser(request, response);
			break;
		case "/users/update":
			updateUser(request, response);
			break;
		case "/users/edit":
			showEditForm(request, response);
			break;
		case "/users/delete":
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
		User user = userServiceImp.selectUser(id);
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("show_form.jsp");
		rd.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User user = new User(name, email, country);
		userServiceImp.InsertUser(user);
		
		response.sendRedirect("user_list");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User user = new User(id, name, email, country);
		userServiceImp.updateUser(user);
		
		response.sendRedirect("user_list");
	}
	
	private void allUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<User> users = userServiceImp.allUsers();
		request.setAttribute("allUsers", users);
				
		RequestDispatcher rd = request.getRequestDispatcher("user_list.jsp");
		rd.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		userServiceImp.deleteUser(id);
		
		response.sendRedirect("user_list");
	}

}
