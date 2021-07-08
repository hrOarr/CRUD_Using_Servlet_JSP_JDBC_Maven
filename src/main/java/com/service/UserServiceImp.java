package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class UserServiceImp implements UserDao {
	
	private static String jdbcURL = "jdbc:mysql://localhost/database_crud";
	private static String Username = "root";
	private static String Password = "";
	private static UserServiceImp userServiceImp;
	private static Connection connection;
	
	public static UserServiceImp getServiceImp() {
		if(userServiceImp == null) {
			synchronized (UserServiceImp.class) {
				if(userServiceImp == null) {
					userServiceImp = new UserServiceImp();
				}
			}
		}
		return userServiceImp;
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
						System.out.println("Error from UserDao.java (getConnection)" + e.getMessage());
					}
				}
			}
		}
		
		return connection;
	}

	@Override
	public void InsertUser(User user) {
		try {
			Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name, email, country) values (?, ?, ?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
			preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("Error from UserDao.java(insertUser) " + e.getMessage());
		}
	}

	@Override
	public User selectUser(int id) {
		User user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				user = new User(id, name, email, country);
			}
		}
		catch(SQLException e) {
			System.out.println("Error from UserDao.java(selectUser) " + e.getMessage());
		}
		
		return user;
	}

	@Override
	public List<User> allUsers() {
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
			System.out.println("Error from UserDao.java (allUsers)" + e.getMessage());
		}
		
		return users;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updated = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("update users set name=?, email=?, country=? where id=?");
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			
			updated = preparedStatement.executeUpdate() > 0;
			
		}
		catch(SQLException e) {
			System.out.println("Error from UserDao.java (updateUser)" + e.getMessage());
		}
		
		return updated;
	}

	@Override
	public boolean deleteUser(int id) {
        boolean deleted = false;
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
			
			preparedStatement.setInt(1, id);
			
			deleted = preparedStatement.executeUpdate() > 0;
			
		}
		catch(SQLException e) {
			System.out.println("Error from UserDao.java (deleteUser)" + e.getMessage());
		}
		
		return deleted;
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
