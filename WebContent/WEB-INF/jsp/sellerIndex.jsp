<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>this is seller's end</title>
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

	<div class="container">
		<div class="page-header">
		<div class="row">
			<div class="span6">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">This is seller's page</a></li>
					<li><a>Welcome: ${fn},${ln}</a></li>
					<li><a href="index.htm" class="btn btn-danger">
					<span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
				</ul>
			</div>
		</div>
		<br /><br /><br />

		<h3>
		<a  href="checkProduct.htm"> Product Management</a>
		</h3>
		 <br />
		<h3>
			<a href="sellerOrder.htm"> Order Management</a>
		</h3>


	</div>