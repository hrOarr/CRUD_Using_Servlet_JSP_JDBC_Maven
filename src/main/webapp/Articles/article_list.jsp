<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

<%@ page import="com.model.Article" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

</head>
<body>
  
  <div class="container bg-blue-300">
    <div class="flex md:flex-row flex-col md:justify-center justify-center  pt-20">
       <div>
        <a href="<%=request.getContextPath()%>/new_article"><button class="bg-blue-600 px-2 py-2 hover:bg-blue-700 focus:outline-none text-white rounded-sm">Add New Article</button></a>
       </div>
       <div class="pl-4">
         <a href="<%=request.getContextPath()%>/users/user_list"><button class="bg-purple-600 px-2 py-2 hover:bg-purple-700 focus:outline-none text-white rounded-sm">Show Users</button></a>
       </div>
    </div>
    
    <div class="row pl-20 pt-10 pr-20 pb-20">
      <%
         List<Article> articles = (List) request.getAttribute("allArticles");
         System.out.println(articles);
      
       for(Article article: articles){
    	   %>
      <div class="mx-auto py-4 px-8 mt-3 bg-white justify-center shadow-lg rounded-lg">
         <h2 class="text-4xl"><a href="#" class="no-underline"><%=article.getTitle()%></a></h2>
         <div><span class="italic">published by</span> <span class="font-bold"><%=article.getUsername()%></span></div>
         <p class="pt-2">
           <%=article.getBody()%>
         </p>
      </div>
      
      <% } %>
    </div>
  </div>
  
</body>
</html>