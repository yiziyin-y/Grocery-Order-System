<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
<div class="row">
			<div class="span6">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">This is admin page</a></li>
					<li><a>Welcome: ${fn},${ln}</a></li>
					<li><a href="index.htm" class="btn btn-danger">
					<span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
				</ul>
			</div>
		</div>
		
<c:forEach items="${orders}" var="order">
<div class="control-inline" style="box-shadow: 10px 10px 5px #888888;border:2px solid;border-radius:25px;">
	<div class="field-wrap">
	<br>
	<h4>Total Price: ${order.price}&nbsp;&nbsp;&nbsp;Order Status: ${order.status}
	&nbsp;&nbsp;&nbsp;Order Time: ${order.time}</h4>
	Customer Name: ${order.fn}, ${order.ln} &nbsp;&nbsp;&nbsp;Address: ${order.address}&nbsp;&nbsp;&nbsp; Phone: ${order.phone}<br>
	Memo to Merchant: ${order.memo}<br><br>
	Payment Card: ${order.cardNum}<br>
	Card CCV: ${order.ccv}<br>
	Card ExpireDate: ${order.expireDate}<br>
	
	</div>

	<table class="table table-striped table-hover table-bordered">
		<c:forEach items="${order.products}" var="product">
			<tr>

				<td><img  style="width:50%"  alt="image" src="<c:url value="${product.filepath}"/>" /></td>
				<td class="success">${product.name}</td>
				<td class="info">${product.detail}</td>
				<td class="info">${product.category}</td>
				<td class="warning">${product.num}</td>
				<td class="success">${product.price}USD</td>
			</tr>
		</c:forEach>
	</table>

	&nbsp;&nbsp;&nbsp;
	<a href="deleteOrder/${order.id}.htm" class="btn btn-danger" onclick="return confirm('are you sure to delete order?')">
	<span class="glyphicon glyphicon-remove"></span> Delete Order</a>

	</div>
	</c:forEach>
</body>
</html>