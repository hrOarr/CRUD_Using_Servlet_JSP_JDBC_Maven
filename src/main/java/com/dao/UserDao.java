package com.dao;

import java.sql.Connection;
import java.util.List;

import com.model.User;

public interface UserDao {
	public Connection getConnection();
	public void InsertUser(User user);
	public User selectUser(int id);
	public List<User> allUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
