<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register With Us</title>
<link rel="stylesheet" href="../styles/register.css" type="text/css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<h1>Don't have an account?</h1>
<h2>Register with us!</h2>


<br><br><br>

<div id="registration">
<form action="../IndexHandler" method="post">
    <input type="hidden" name="action" value="register">        
    <label class="pad_top">Email:</label>
    <input type="email" name="email"><br>
    <label class="pad_top">Name:</label>
    <input type="text" name="name"><br>
    <label class="pad_top">Username:</label>
    <input type="text" name="userName"><br> 
    <label class="pad_top">Password:</label>
    <input type="password" name="password">  <br>     
    <label>&nbsp;</label><br>
    <input type="submit" value="Register" class="margin_left">
</form>
</div>


<jsp:include page="Footer.html"/>
</body>
</html>