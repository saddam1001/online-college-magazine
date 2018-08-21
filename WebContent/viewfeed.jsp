<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>feedbacks</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h1 style="text-align:center">Here admin can view Feedbacks</h1>
<h1 style="color:blue;margin-left:600px">Feedback Details</h1>
<table style="margin-left:325px;length:60%;width:60%;height:80%">
<tr style="color:blue;background-color:lightgrey">
<th style="width:10%">Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Feed</th>
</tr>
<c:forEach items="${feeds}" var="fb">
<tr style="background-color:#FFF0F5;text-align:center">
<td>${fb.id}</td><td>${fb.fname}</td><td>${fb.lname}</td><td>${fb.email}</td>
<td>${fb.feed}</td>
</tr>
</c:forEach>
</table>
</body>
</html>