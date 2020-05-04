<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="styles/CartStyle.css">
</head>
<body>
	<h2>Shopping Cart</h2>
	<br>
	<div class="Cart">

		<c:forEach items="${cart.lineItem}" var="item">
			<div class="item">
				<div class="item-image">
					<img src="images/visor.jpg" alt="">
				</div>
				<div class="item-info">
					<span class="item-details" id="item-brand">Costco</span> <span
						class="item-details" id="item-name">${item.Product.name}</span>
				</div>
				<div class="item-quantity">
					<button type="button" name="-">-</button>
					<span class="item-quantity-int">${item.quantity}</span>
					<button type="button" name="+">+</button>
				</div>
				<div class="item-price">${item.total}</div>
			</div>
		</c:forEach>

		<div class="item">
			<div class="item-image">
				<img src="images/visor.jpg" alt="">
			</div>
			<div class="item-info">
				<span class="item-details" id="item-brand">Costco</span> <span
					class="item-details" id="item-name">Visor</span> <span
					class="item-details" id="item-color">Black</span>
			</div>
			<div class="item-quantity">
				<button type="button" name="-">-</button>
				<span class="item-quantity-int">1</span>
				<button type="button" name="+">+</button>
			</div>
			<div class="item-price">$19.99</div>
		</div>

		<div class="item">
			<div class="item-image">
				<img src="images/ball.jpg" alt="">
			</div>
			<div class="item-info">
				<span class="item-details" id="item-brand">Costco</span> <span
					class="item-details" id="item-name">Soccer Ball</span> <span
					class="item-details" id="item-color">White and Blue</span>
			</div>
			<div class="item-quantity">
				<button type="button" name="-">-</button>
				<span class="item-quantity-int">1</span>
				<button type="button" name="+">+</button>
			</div>
			<div class="item-price">$79.99</div>
		</div>

		<div class="total">
			<div class="total-items">
				<span>Total Items: </span> <span id="total-items">2</span>
			</div>
			<div class="total-cost">
				<span>Total:</span> <span id="total-cost">$99.98</span>
			</div>
		</div>
		<div class="checkout">
			<button type="button" name="button">Checkout</button>
		</div>
	</div>
</body>
</html>
