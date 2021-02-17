<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>${product.name}</title>
</head>
<body>
<div class="row">
			<div class="span6">
				<ul class="nav nav-tabs">
					
					<li><a> | </a></li>
					<li><a>Welcome: ${fn},${ln}</a></li>
					<li><a href="../buyerIndex.htm" class="btn btn-primary">
					<span class="glyphicon glyphicon-home"></span> Shop Index</a></li>
					<li><a href="../cart.htm" class="btn btn-warning">
					<span class="glyphicon glyphicon-shopping-cart"></span> Your Cart</a></li>
					<li><a href="../buyerOrder.htm" class="btn btn-success btn-md">
					<span class="glyphicon glyphicon-th-list"></span> Your Order</a></li>
					<li><a href="../index.htm" class="btn btn-danger">
					<span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
				</ul>
			</div>
		</div>

	
	<img  style="width:50%"  alt="image" src="${product.filepath}"/><br> 
	<br> <h3 class="card-text">Name: ${product.name}</h3>
	<br> <h3 class="card-text">Detail: ${product.detail}</h3>
	<br><h3 class="card-text"> Category: ${product.category}</h3>
	<br> <h3 class="card-text">Stock:${product.stock}</h3>
	<br> <h3 class="card-text">Price: ${product.price}USD</h3>
	<br>
	
	<c:if test="${product.stock > 0}">
	<a href="../addCart/${product.id}.htm" class="btn btn-warning btn-large">
	<span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</a>
	</c:if>
	
	<c:if test="${product.stock == 0}">
	<a  class="btn btn-light">
	<span class="glyphicon glyphicon-shopping-cart"></span> Out Of Stock</a>
	</c:if>
	<a href="../cart.htm" class="btn btn-success btn-md">
	<span class="glyphicon glyphicon-hand-right"></span> View Cart</a>

	<script src="<c:url value="/js/controller.js" /> "></script>
</body>
</html>