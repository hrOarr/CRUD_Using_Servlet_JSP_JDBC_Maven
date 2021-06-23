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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>

  <div class="container">
    
    <h3 class="text-center" style="padding-top: 30px;">List of Users</h3>
    <hr>
    
    <div class="row">
      <a href="<%= request.getContextPath()%>/new" class="btn btn-primary">Add New User</a>
    </div>
    <br>
    
    <table class="table table-bordered">
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
        	    <a href="<%=request.getContextPath()%>/edit?id=<%=user.getId()%>">Edit</a>
        	    &nbsp;&nbsp;
        	    <a href="<%=request.getContextPath()%>/delete?id=<%=user.getId()%>">Delete</a>
        	  </td>
        	</tr>
        	
        	<%
        }
        %>
      </tbody>
    </table>
  </div>
  
</body>
</html>