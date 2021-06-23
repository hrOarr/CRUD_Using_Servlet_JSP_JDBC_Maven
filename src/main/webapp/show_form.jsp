<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form</title>
</head>

<%@ page import="com.model.User" %>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
   <div class="container col-md-6" style="padding-top: 20px;">
    <div class="card" style="padding: 20px;">
      <%
      String path;
      User user = (User) request.getAttribute("user");
      
      if(user!=null){
    	  path = "update";
    	  %>
    	  
    	  <form action="<%=path%>" method="post">
          <fieldset class="form-group">
            <label>User Name</label>
            <input type="text" value="<%=user.getName()%>" name="name" required="required">
          </fieldset>
          
          <fieldset class="form-group">
            <label>User Email</label>
            <input type="text" value="<%=user.getEmail()%>" name="email" required="required">
          </fieldset>
          
          <fieldset class="form-group">
            <label>User Country</label>
            <input type="text" value="<%=user.getCountry()%>" name="country" required="required">
          </fieldset>
          
          <input type="hidden" value="<%=user.getId()%>" name="id">
          
          <button type="submit" class="btn btn-success">Submit</button>
         </form>
         <%
      }
      else{
    	  path = "insert";
    	  
    	  %>
    	  
    	 <form action="<%=path%>" method="post">
           <fieldset class="form-group">
            <label>User Name</label>
            <input type="text" name="name" required="required">
           </fieldset>
        
           <fieldset class="form-group">
            <label>User Email</label>
            <input type="text" name="email" required="required">
           </fieldset>
        
           <fieldset class="form-group">
            <label>User Country</label>
            <input type="text" name="country" required="required">
           </fieldset>
           
           <button type="submit" class="btn btn-success">Submit</button>
         </form>
    	  
    	  <%
      }
      %>
      
    </div>
   </div>
</body>
</html>