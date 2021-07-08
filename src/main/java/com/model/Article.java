package com.model;

public class Article {
	private int id;
	private String title;
	private String body;
	private String username;
	private int user_id;
	public Article() {
	}
	public Article(String title, String body) {
		this.title = title;
		this.body = body;
	}
	public Article(int id, String username, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.username = username;
	}
	public Article(String title, String body, int user_id) {
		this.title = title;
		this.body = body;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
