package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Article;
import com.model.User;
import com.service.ArticleServiceImp;

@WebServlet("/")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleServiceImp articleServiceImp;
   
    public ArticleController() {
    	this.articleServiceImp = ArticleServiceImp.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if(path.equals("/new_article")) {
			show_newForm(request, response);
		}
		else if(path.equals("/add_article")) {
			insertArticle(request, response);
		}
		else {
			AllArticles(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void show_newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = articleServiceImp.getUserList();
		request.setAttribute("allUsers", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Articles/article_form.jsp");
		rd.forward(request, response);
	}
	
	public void AllArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = articleServiceImp.getArticleList();
		request.setAttribute("allArticles", articles);
				
		RequestDispatcher rd = request.getRequestDispatcher("/Articles/article_list.jsp");
		rd.forward(request, response);
	}
	
	public void insertArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		articleServiceImp.insertArticle(new Article(title, body, user_id));
		response.sendRedirect("article_list");
	}

}
