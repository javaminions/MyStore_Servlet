<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Description</title>

<link rel="stylesheet" href="styles/ProductStyle.css">
</head>

<body>
<br><br>
	<h2 class="des">Product Description</h2>
	<br>
	<div>

		<div class="prod-image">
			<img src="${product.img}" height=100px width=100px alt="">
		</div>
		<br>
		<div class="prod-info">
			<span class="prod-details" id="item-brand">${product.name}</span><br>
			<h3><i>Description</i></h3>
			<span class="prod-details" id="item-name">${product.description}</span>
		</div>
		<div>
			<a href="CartServlet?action=addtocart&amp;prodcode=${product.code}"
				class="btn btn-danger mt-3 cartButton ${disableButton}">Add to Cart</a>
		</div>

	</div>


</body>
</html>