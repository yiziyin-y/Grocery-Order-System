<!DOCTYPE html>
<html>
<head>
<title>Seller - update a product</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/css/normalize.min.css">
<link rel="stylesheet" href="/css/style.css">

</head>

<body>

			<div class="tab-content">
				<h1>Update ${product.name}</h1>

				<form action="../postUpdateProduct/${product.id}.htm" method="post"  enctype="multipart/form-data">


					<div class="top-row">
						<div class="field-wrap">
							<label>Name<span class="req">*</span>
							</label> <input type="text" value="${product.name}" required autocomplete="off" name="name" />
						</div>

						<div class="field-wrap">
							<label>Detail<span class="req">*</span>
							</label> <input type="text" value="${product.detail}" required autocomplete="off" name="detail" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Price<span class="req">*</span>
						</label> <input type="text" value="${product.price}" required autocomplete="off" name="price" />
					</div>
					
					<div class="field-wrap">
						<label> Category<span class="req">*</span>
						</label> <input type="text" value="${product.category}" required autocomplete="off" name="category" />
					</div>

					<div class="field-wrap">
						<label>Stock<span class="req">*</span>
						</label> <input type="text" value="${product.stock}" required autocomplete="off" name="stock" 
						oninput="value=value.replace(/[^\d]/g,'')" />
					</div>
					
					<div class="field-wrap">
						<label>Image
						</label> <input type="file" name="file"/>
					</div>
	
					<button type="submit" class="button button-block">Post It</button>

				</form>

			</div>

		<!-- tab-content -->

	<!-- /form -->
	<script src='/js/jquery.min.js'></script>

	<script src="/js/index.js"></script>

</body>
</html>
