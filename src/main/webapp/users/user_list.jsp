<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<%@ page import="com.model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

<body>

  <div class="container bg-blue-300">
      
    <h3 class="text-center pt-10 text-4xl font-bold">List of Users</h3>
    <hr>
    <div class="flex md:flex-row justify-center pt-2">
      <div>
       <a href="new"><button class="bg-blue-600 px-2 py-2 hover:bg-blue-700 focus:outline-none text-white rounded-sm">Add New User</button></a>
      </div>
      <div class="ml-4">
       <a href="<%=request.getContextPath()%>/article_list"><button class="bg-purple-600 px-2 py-2 hover:bg-purple-700 focus:outline-none text-white rounded-sm">Show All Articles</button></a>
      </div>
    </div>
    <br>
    
    <div class="flex">
    <table class="table table-bordered bg-white shadow-lg">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
          <th>Country</th>
          <th>Action</th>
        </tr>
      </thead>
      
      <tbody>
        <%
        List<User> users = (List) request.getAttribute("allUsers");
        
        for(User user:users){
        	%>
        	
        	<tr>
        	  <td><%=user.getId()%></td>
        	  <td><%=user.getName()%></td>
        	  <td><%=user.getEmail()%></td>
        	  <td><%=user.getCountry()%></td>
        	  <td>
        	    <a href="<%=request.getContextPath()%>/users/edit?id=<%=user.getId()%>" style="text-decoration: none;">
        	     <button class="bg-green-600 px-2 py-2 hover:bg-green-700 focus:outline-none text-white rounded-sm">Edit</button>
        	    </a>
        	    &nbsp;&nbsp;
        	    <a href="<%=request.getContextPath()%>/users/delete?id=<%=user.getId()%>">
        	     <button class="bg-red-400 px-2 py-2 hover:bg-red-500 focus:outline-none text-white rounded-sm">Delete</button>
        	    </a>
        	  </td>
        	</tr>
        	
        	<%
        }
        %>
      </tbody>
    </table>
    </div>
  </div>
  
</body>
</html>