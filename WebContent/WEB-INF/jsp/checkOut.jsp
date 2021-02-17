<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/normalize.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/normalize.css">
<link rel="stylesheet" href="/css/carousel.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">


<meta charset="ISO-8859-1">
<title>Confirm Your Order</title>
</head>
<body>
<%@include file="buyerHeader.jsp" %>

	<h1>Your Order: </h1>
	<table class="table table-striped table-hover table-bordered">
	<thead>
			<tr class="bg-success">
				<th>Photo</th>
				<th>Item Name</th>
				<th>Detail</th>
				<th>Category</th>
				<th>Num</th>
				<th>Price (each)</th>
			</tr>

		</thead>
		<c:forEach items="${products}" var="product">
			<tr>

				<td><img  style="width:50%"  alt="image" src="<c:url value="${product.filepath}"/>" /></td>
				<td class="success">${product.name}</td>
				<td class="info">${product.detail}</td>
				<td class="info">${product.category}</td>
				<td class="warning">${product.num}</td>
				<td class="success">${product.price}USD</td>
			</tr>
		</c:forEach>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th>Grand Total:</th>
			<th>${total}</th>
			
		</tr>
	</table>

				<form action="postOrder.htm" method="post"  enctype="multipart/form-data">
				<div>
						<div class="field-wrap">
							<label>Phone<span class="req">*</span>
							</label> <input type="tel" required name="phone" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label>Address<span class="req">*</span>
							</label> <input type="text" required name="address" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label>Memo to Merchant
							</label> <input type="text" name="memo" />
						</div>
					</div>
					<h2>Payment: </h2>
					<div class="field-wrap">
						<label>Credit/Debit Card<span class="req">*</span></label> 
						<input type="number" required name="card" maxlength="16" 
						oninput="javascript: if (this.value.length > this.maxlength) this.value = this.value.slice(0, this.maxlength);"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<label>Security Code<span class="req">*</span></label> 
						<input type="number" required name="ccv" maxlength="3"
						oninput="javascript: if (this.value.length > this.maxlength) this.value = this.value.slice(0, this.maxlength);"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<label>Expire Date:<span class="req">*</span></label> 
						<input type="text" required name="expireDate" maxlength="5"
						oninput="javascript: if (this.value.length > this.maxlength) this.value = this.value.slice(0, this.maxlength);"/>
					</div>
		
					<button type="submit" class="glyphicon glyphicon-ok; btn btn-warning btn-large">Complete</button>

				</form>

			</div>
			<script src='/js/jquery.min.js'></script>
			<script src="/js/index.js"></script>
</body>
</html>