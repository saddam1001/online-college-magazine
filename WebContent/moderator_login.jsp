<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login form design</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%@ include file="nav.html" %>

<h2>This is moderator login page</h2>

<div class="loginbox">
<img src="I\Avtar.png" class="Avtar">
<h1>Login Here</h1>

<form action="/magazine/ModeratorLogin" method="post">
<p>Email</p>
<input type="text" name="email" placeholder="Enter Email">
<p>Password</p>
<input type="Password" name="password" placeholder="Enter Password">
<input type="submit" name="" value="Login">


</form>

</div>

</body>
</html>