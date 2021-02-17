<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Users</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/normalize.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/normalize.css">
<link rel="stylesheet" href="/css/carousel.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
     <table class="table table-striped table-hover table-bordered">
           <thead>
              <tr class="bg-success">
                 <th>First Name</th>
                 <th>Last Name</th>
                 <th>Email</th>
                 <th>Password</th>
                 <th>Role</th>
                 <th>Approved</th>
                 <th>Operation</th>
              </tr>
           
           </thead>
          
           <c:forEach items="${users}" var="user">
               <tr>

		              <td class="info">${user.fname}</td>
		              <td class="info">${user.lname}</td>
		              <td  class="warning">${user.email}</td>
		              <td class="success">${user.pw}</td>
		              <td class="success">${user.bors}</td>
		              <td class="success">${user.approved}</td>
		              <td class="info"> 
					  &nbsp;
		              <a href="approve/${user.id}.htm" onclick="return confirm('are you sure to approve?')"> <span class="glyphicon glyphicon-ok-circle"></span></a>
		              &nbsp;&nbsp;&nbsp;&nbsp;
		              <a href="deleteUser/${user.id}.htm" onclick="return confirm('are you sure to delete user?')"><span class="glyphicon glyphicon-remove"></span></a>
		               
		              </td>
                     
                      
              </tr>  
           </c:forEach>

         </table>
</body>
</html>