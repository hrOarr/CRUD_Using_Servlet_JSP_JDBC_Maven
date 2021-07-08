package com.dao;

import java.sql.Connection;
import java.util.List;

import com.model.Article;
import com.model.User;

public interface ArticleDao {
	public Connection getConnection();
	public void insertArticle(Article article);
	public List<Article> getArticleList();
	public List<User> getUserList();
}
