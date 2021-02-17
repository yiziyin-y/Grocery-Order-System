<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Products</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/normalize.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/normalize.css">
<link rel="stylesheet" href="/css/carousel.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="row">
			<div class="span6">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">This is seller's page</a></li>
					<li><a>Welcome: ${fn},${ln}</a></li>
					<li><a href="sellerIndex.htm" class="btn btn-warning">
					<span class="glyphicon glyphicon-log-out"></span> Go Index</a></li>
					<li><a href="addProduct.htm" class="btn btn-warning">
					<span class="glyphicon glyphicon-plus-sign"></span> Add Product</a></li>

				</ul>
			</div>00 
		</div>
		
		
         <table class="table table-striped table-hover table-bordered">
           <thead>
              <tr class="bg-success">
                 <th>Photo</th>
                 <th>Item Name</th>
                 <th>Detail</th>
                 <th>Category</th>
                 <th>Stock</th>
                 <th>Price</th>
                 <th>Operation</th>
              </tr>
           
           </thead>
          
           <c:forEach items="${products}" var="product">
               <tr>

		              <td><img  style="width:50%"  alt="image" src="<c:url value="${product.filepath}"/>" /></td>
		              <td class="success">${product.name}</td>
		              <td class="info">${product.detail}</td>
		              <td class="info">${product.category}</td>
		              <td  class="warning">${product.stock}</td>
		              <td class="success">${product.price} USD</td>
		              <td class="info"> 
					  &nbsp;
		              <a href="updateProduct/${product.id}.htm"> <span class="glyphicon glyphicon-pencil"></span></a>
		              &nbsp;&nbsp;&nbsp;&nbsp;
		              <a href="deleteProduct/${product.id}.htm" onclick="return confirm('are you sure to delete product?')"><span class="glyphicon glyphicon-remove"></span></a>
		               
		              </td>
                     
                      
              </tr>  
           </c:forEach>

         </table>
</body>
</html>