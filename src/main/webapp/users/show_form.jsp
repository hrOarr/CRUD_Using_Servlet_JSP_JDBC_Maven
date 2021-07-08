<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form</title>
</head>

<%@ page import="com.model.User" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

<body>
   <div class="flex container h-screen bg-blue-300">
    <div class="shadow-lg mt-20 rounded-lg p-8 mb-24 bg-white mx-auto my-auto">
      <%
      String path;
      User user = (User) request.getAttribute("user");
      
      if(user!=null){
    	  path = "update";
    	  %>
    	  
    	  <form action="<%=path%>" method="post">
         
          <div class="relative mb-4">
              <input type="text"  name="name" value="<%=user.getName()%>" required="required" placeholder="Enter name" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
          </div>
          
          <div class="relative mb-4">
              <input type="text"  name="email" value="<%=user.getEmail()%>" required="required" placeholder="Enter email" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
          </div>
          
          <div class="relative mb-4">
              <input type="text"  name="country" value="<%=user.getCountry()%>" required="required" placeholder="Enter country" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
          </div>
          
          <input type="hidden" value="<%=user.getId()%>" name="id">
          
          <div class="text-center">
             <button type="submit" class="bg-purple-600 px-2 py-2 hover:bg-purple-700 focus:outline-none text-white rounded-sm">Submit</button>
           </div>
         </form>
         <%
      }
      else{
    	  path = "insert";
    	  
    	  %>
    	  
    	 <form action="<%=path%>" method="post">
    	    <div class="relative mb-4">
              <input type="text"  name="name" required="required" placeholder="Enter name" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
            </div>
            
            <div class="relative mb-4">
              <input type="text"  name="email" required="required" placeholder="Enter email" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
            </div>
            
            <div class="relative mb-4">
              <input type="text"  name="country" required="required" placeholder="Enter country" class="py-1 px-3 w-full bg-white rounded border border-gray-300 outline-none "/>
            </div>
           
           <div class="text-center">
             <button type="submit" class="bg-purple-600 px-2 py-2 hover:bg-purple-700 focus:outline-none text-white rounded-sm">Submit</button>
           </div>
         </form>
    	  
    	  <%
      }
      %>
      
    </div>
   </div>
</body>
</html>