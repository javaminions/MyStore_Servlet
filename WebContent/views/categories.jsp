<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="styles/categories.css">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	console.log("category");
	var urlParams = new URLSearchParams(window.location.search);
	var category = urlParams.get("filterCategory");
	if(category != null && category != ""){
	 	filterSelection(category);
	} else {
	       var categoryFromSession = '${filteredCategory}';
	       console.log(categoryFromSession + " is last visited category");
	       filterSelection(categoryFromSession);
	}
});
</script>
<body>

	<div class="top">
		<img alt="Costco Logo" src="images/logo.png"
			style="width: 20%; height: auto;">
	</div>
	
		<h2 style="text-align: center">Products</h2>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark bg-white">
		<form class="form-inline" action="/action_page.php">
			<div class="wrap">
			  		<a href="index.jsp" class="homeButton"><i class="fas fa-home"></i></a>
				</div>
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<div class="wrap">
			  		<a href="#" class="button2">Search</a>
				</div>
				<div class="wrap">
					<a href="CartServlet?action=showall" class="cart"><i class="fas fa-shopping-cart"></i><span class='badge badge-warning' id='lblCartCount'>${cartCount}</span></a>
					</div>
		</form>
	</nav>
	</div>
	<br>
	
	<div id="myBtnContainer">
		<button class="btn active" onclick="filterSelection('all')">
			Show all</button>
		<button class="btn" onclick="filterSelection('apparel')">
			Apparel</button>
		<button class="btn" onclick="filterSelection('accessories')">
			Accessories</button>
		<button class="btn" onclick="filterSelection('sports')">
			Sports Equipment</button>
		<button class="btn" onclick="filterSelection('outdoors')">
			Outdoors</button>
		<button class="btn" onclick="filterSelection('groceries')">
			Groceries</button>
		<button class="btn" onclick="filterSelection('clearance')">
			Clearance</button>
	</div>
	<div class="container">
	   <c:forEach var="product" items="${products}">
		<c:choose>
		    <c:when test="${product.inventory=='0'}">
				<c:set var = "stock" scope = "session" value = "Out of stock"/>
				<c:set var = "theColor" scope = "session" value = "color: red !important;"/>
				<c:set var = "disableButton" scope = "session" value = "disabled"/>
		    </c:when>    
		    <c:otherwise>
				<c:set var = "stock" scope = "session" value = "Available"/>
				<c:set var = "theColor" scope = "session" value = ""/>
				<c:set var = "disableButton" scope = "session" value = ""/>
		    </c:otherwise>
		</c:choose>
	  
	   <div class="filterDiv ${product.category}">
			<div class="card" style="width: 18rem;">
			  <a href="WishList.html" class="card-link text-danger d-flex justify-content-end" style="padding: 10px 10px 0 0;">
					       	 <i class="fas fa-heart"></i>
        			 		</a>
				<img class="card-img-top"
					src="${product.img}"
					alt="Vans">			
				<div class="card-body">
					<h4 class="card-title">${product.name}</h4>
					<h6 class="card-subtitle mb-2 text-muted" style="${theColor}">Status: ${stock}</h6>
					<p class="card-text">${product.description}</p>
					<div class="options d-flex flex-fill">
						<select class="custom-select mr-1">
							<option selected>Color</option>
							<option value="1">Green</option>
							<option value="2">Blue</option>
							<option value="3">Red</option>
						</select> <select class="custom-select ml-1">
							<option selected>Size</option>
							<option value="1">41</option>
							<option value="2">42</option>
							<option value="3">43</option>
						</select>
					</div>
					<div class="buy d-flex justify-content-between align-items-center">
						<div class="price text-success">
							<h5 class="mt-4">${product.getPriceCurrencyFormat()}</h5>
						</div>
		
						<a href="CartServlet?action=addtocart&amp;prodcode=${product.code}" class="btn btn-danger mt-3 cartButton ${disableButton}"><i
							class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
			</div>
		</div>
	   </c:forEach>
	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="scripts/categories.js"></script>
	<script src="scripts/cart.js"></script>
</body>
</html>