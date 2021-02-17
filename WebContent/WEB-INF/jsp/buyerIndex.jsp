<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Seller's product</title>
</head>
<body>
<c:set var="addSuccess" value="${addSuccess}" />
	<c:if test="${addSuccess == true}">
		<script type="text/javascript">alert('Added to Cart!');</script>
	</c:if>

	<div class="container">
	
	<%@include file="buyerHeader.jsp" %>
		<div class="row">
		<div class="card-deck">
			<c:forEach items="${products}" var="product">
	 	      
  					<div class="col-lg-4"> 	
						<div class="card" style="width:30rem">
							<img class="aligncenter" height="200" width="200" alt="card" src="<c:url value="${product.filepath}"/>" />

							<div class="card-block">
								<h2 class="card-title">${product.name}</h2>
								<h3 class="card-text">${product.price}USD</h3>
							</div>
							
							<div class="card-footer">
								<c:if test="${product.stock > 0}">
								<a href=" <c:url  value="addCart/${product.id}.htm"/>"
									class="btn btn-info btn-lg">Add To Cart</a> 
								</c:if>
								<c:if test="${product.stock == 0}">
									<a  class="btn btn-light">
									<span class="glyphicon glyphicon-shopping-cart"></span> Out Of Stock</a>
								</c:if>
								<a href=" <c:url  value="viewProduct/${product.id}.htm"/>"
									class="btn btn-info btn-lg">View Detail</a>
 							</div>
						</div>
						</div>
						
			</c:forEach>
			</div>
		</div>
</div>


</body>
</html>
