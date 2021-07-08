package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ArticleDao;
import com.model.Article;
import com.model.User;

public class ArticleServiceImp implements ArticleDao {
	
	private static String jdbcURL = "jdbc:mysql://localhost/database_crud";
	private static String Username = "root";
	private static String Password = "";
	private static Connection connection;
	private static ArticleServiceImp articleServiceImp;
	
	private ArticleServiceImp() {}
	
	public static ArticleServiceImp getInstance() {
		if(articleServiceImp == null) {
			synchronized (ArticleServiceImp.class) {
				if(articleServiceImp == null) {
					articleServiceImp = new ArticleServiceImp();
				}
			}
		}
		return articleServiceImp;
	}
	
	@Override
	public Connection getConnection() {
		if(connection == null) {
			synchronized (Connection.class) {
				if(connection == null) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						connection = DriverManager.getConnection(jdbcURL, Username, Password);
					} catch (Exception e) {
						System.out.println("Error from ArticleServiceImp (getConnection)" + e.getMessage());
					}
				}
			}
		}
		
		return connection;
	}

	@Override
	public void insertArticle(Article article) {
		try {
			Connection connection = getConnection();
			
			String sql = "INSERT INTO articles (title, body, user_id) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setString(2, article.getBody());
			preparedStatement.setInt(3, article.getUser_id());
			
			preparedStatement.executeUpdate();
			
		}
		catch(SQLException e) {
			System.out.println("Error from UserDao.java(insertUser) " + e.getMessage());
		}
	}

	@Override
	public List<Article> getArticleList() {
		List<Article> articles = new ArrayList<Article>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from articles");
			ResultSet rs = preparedStatement.executeQuery();
						
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String username = "";
				
				String sql = "SELECT (name) FROM users WHERE id = ?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
				preparedStatement2.setInt(1, user_id);
				ResultSet resultSet = preparedStatement2.executeQuery();
				if(resultSet.next()) {
					username = resultSet.getString("name");
				}
				articles.add(new Article(id, username, title, body));
			}
									
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return articles;
	}

	@Override
	public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
			
			ResultSet rs = preparedStatement.executeQuery();
						
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				users.add(new User(id, name, email, country));
			}
						
		}
		catch(SQLException e) {
			System.out.println("Error from ArticleServiceImp.getAllUsers " + e.getMessage());
		}
		
		return users;
	}

}
