<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ page import="com.model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
  <div class="container bg-blue-300">
     <div class="row justify-center p-20">
       
       <div class="col-md-12"><h1 class="text-center text-4xl">New Article</h1></div>
       
       <div class="pt-3">
       <form action="add_article" method="POST">
         
         <label class="block text-sm font-medium text-gray-700">Enter title</label>
         <input type='text' name="title" placeholder="Enter title" class="w-full mt-2 mb-6 px-4 py-2 border rounded-lg text-gray-700 focus:outline-none focus:border-green-500" />
         
         <div>
              <label for="body" class="block text-sm font-medium text-gray-700">
                Content
              </label>
              <div class="mt-1">
                <textarea id="body" name="body" rows="3" cols="48" class="w-full px-3 py-2 text-gray-700 border rounded-lg focus:outline-none" placeholder="Enter contents"></textarea>
              </div>
         </div>
         
         <div>
         <select class="form-select" name="user_id" required="required" id="user">
            <option selected>Select User</option>
            <%
              List<User> users = (List)request.getAttribute("allUsers");
            
            for(User user:users){
            	%>
            	<option value="<%=user.getId()%>"><%=user.getName()%></option>
            	<%
            }
            %>
         </select>
         </div>
         
         <div class="justify-center">
           <button type="submit" class="btn btn-primary mt-2">Submit</button>
         </div>
       </form>
       </div>
     </div>
  </div>
</body>
</html>