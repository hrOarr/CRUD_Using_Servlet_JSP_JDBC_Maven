package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoConnection {
	private static String jdbcURL = "jdbc:mysql://localhost/database_crud";
	private static String Username = "root";
	private static String Password = "";
	private static Connection connection;
	private static final Object lockObject = new Object();
	private static DaoConnection daoConnection;
	private static final Object lock = new Object();
	
	private DaoConnection() {}
	
	public static DaoConnection getInstance() {
		DaoConnection current = daoConnection;
		if(current==null) {
			synchronized (lock) {
				current = daoConnection;
				if(current == null) {
					current = new DaoConnection();
					daoConnection = current;
				}
			}
		}
		return current;
	}
	
	public static Connection getConnection() {
		Connection current = connection;
		if(current == null) {
			synchronized (lockObject) {
				current = connection;
				if(current == null) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						current = DriverManager.getConnection(jdbcURL, Username, Password);
					} catch (Exception e) {
						System.out.println("Error from UserDao.java (getConnection)" + e.getMessage());
					}
					connection = current;
				}
			}
		}
		return current;
	}
}
