<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
<script src="<c:url value="js/controller.js" /> "></script>

<meta charset="ISO-8859-1">
<title>Your Cart</title>
</head>
<body>
<%@include file="buyerHeader.jsp" %>

	<table class="table table-striped table-hover table-bordered">

		<thead>
			<tr class="bg-success">
				<th>Photo</th>
				<th>Item Name</th>
				<th>Detail</th>
				<th>Category</th>
				<th>Num</th>
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
				<td class="warning">${product.num}<br><br><br>
				<c:if test="${product.num > 1}">
				<a href="minusNum/${product.name}.htm" ><span class="glyphicon glyphicon-minus"></span></a>
				</c:if>
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<c:if test="${product.num lt product.stock}">
				<a href="plusNum/${product.name}.htm"><span class="glyphicon glyphicon-plus"></span></a>
				</c:if>
				</td>
				<td class="success">${product.price}USD</td>
				<td class="info">&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delCart/${product.name}.htm"> <span class="glyphicon glyphicon-remove"></span></a>

				</td>
			</tr>
		</c:forEach>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th>Grand Total:</th>
			<th>${total}</th>
			<th><a href="addOrder.htm" class="btn btn-warning btn-large"><span
					class="glyphicon glyphicon-shopping-cart"></span> Check out</a></th>
		</tr>
	</table>

</body>
</html>