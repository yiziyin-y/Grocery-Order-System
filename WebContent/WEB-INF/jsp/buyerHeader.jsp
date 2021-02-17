<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="row">
			<div class="span6">
				<ul class="nav nav-tabs">
					<c:if test="${cata == 'All'}">
					<li class="active"><a href="buyerIndex.htm">All Category</a></li>
					<li><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					
					<c:if test="${cata == 'Fruits'}">
					<li><a href="buyerIndex.htm">All Category</a></li>
					<li class="active"><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					
					<c:if test="${cata == 'Meats'}">
					<li><a href="buyerIndex.htm">All Category</a></li>
					<li><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li class="active"><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					
					<c:if test="${cata == 'Dairy'}">
					<li><a href="buyerIndex.htm">All Category</a></li>
					<li><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li class="active"><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					
					<c:if test="${cata == 'Vegetables'}">
					<li><a href="buyerIndex.htm">All Category</a></li>
					<li><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li class="active"><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					
					<c:if test="${cata == 'Drinks'}">
					<li><a href="buyerIndex.htm">All Category</a></li>
					<li><a href="buyerIndex/Fruits.htm">Fruits</a></li>
					<li><a href="buyerIndex/Meats.htm">Meats </a></li>
					<li><a href="buyerIndex/Dairy.htm">Dairy</a></li>
					<li><a href="buyerIndex/Vegetables.htm">Vegetables</a></li>
					<li class="active"><a href="buyerIndex/Drinks.htm">Drinks</a></li>
					</c:if>
					

					<li><a> | </a></li>
					<li><a>Welcome: ${fn},${ln}</a></li>
					<li><a href="buyerIndex.htm" class="btn btn-primary">
					<span class="glyphicon glyphicon-home"></span> Shop Index</a></li>
					<li><a href="cart.htm" class="btn btn-warning">
					<span class="glyphicon glyphicon-shopping-cart"></span> Your Cart</a></li>
					<li><a href="buyerOrder.htm" class="btn btn-success btn-md">
					<span class="glyphicon glyphicon-th-list"></span> Your Order</a></li>
					<li><a href="index.htm" class="btn btn-danger">
					<span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
				</ul>
			</div>
		</div>


</body>
</html>