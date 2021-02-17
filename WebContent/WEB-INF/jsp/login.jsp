<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>

<body>
	<c:if test="${unsafe == true}">
		<script type="text/javascript">alert('Unsafe Request!');</script>
	</c:if>

	<c:if test="${duplicate == true}">
		<script type="text/javascript">alert('Email already exist! Please login');</script>
	</c:if>

	<c:set var="regist" value="${regist}" />
	<c:if test="${regist == true}">
		<script type="text/javascript">alert('Sign Up Successful!');</script>
	</c:if>
	
	<c:set var="log" value="${logfail}" />
	<c:if test="${logfail == true}">
		<script type="text/javascript">alert('User not exist or password incorrect!');</script>
	</c:if>

	<c:if test="${notApproved == true}">
		<script type="text/javascript">alert('You are not approved to login!');</script>
	</c:if>
	
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Sign Up</a></li>
			<li class="tab"><a href="#login">Log In</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">
				<h1 style="color: #e6ffcc">Sign Up for Free</h1>
				<br>
				<form action="signup.htm" method="post">

			
						<div class="field-wrap" >
							<label> Buyer</label> <input class="show" type="radio" name="bOrs" value="buyer" />
						</div>
						
						<div class="field-wrap" >
							<label> Seller</label> <input type="radio" name="bOrs" value=" seller"/>
						</div>

					<br>
					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" required autocomplete="off" name="fn" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" required autocomplete="off" name="ln" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" required autocomplete="off" name="email" />
					</div>

					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" name="pw" />
					</div>



					<button type="submit" class="button button-block">Get Started</button>

				</form>

			</div>

			<div id="login">
				<h1 style="color: #e6ffcc">Welcome Back!</h1>
				<br>
				<form action="login.htm" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" required autocomplete="off"  name="email"/>
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" name="pw" />
					</div>


					<button class="button button-block">Log In</button>

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
	<script src='/js/jquery.min.js'></script>

	<script src="/js/index.js"></script>

</body>
</html>
