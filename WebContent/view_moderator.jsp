<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>moderator list</title>
</head>
<body>
<%@ include file="nav.html" %><br><br>
<center>
<h2 style="text=align:center">Here Admin can view Moderators</h2>
<h1 style="text=align:center">Moderators Details</h1>

<table border="3">
<tr>
<th>Id</th><th>Email</th><th>Password</th><th>Edit</th><th>Delete</th>
</tr>

<c:forEach items="${list}" var="mb">
<tr>
<td>${mb.id}</td><td>${mb.email}</td><td>${mb.password}</td>
<td><a href="/magazine/EditModerator?id=${mb.id}">Edit</a></td>
<td><a href="delete_moderator.jsp?id=${mb.id}">Delete</a></td>
</tr>
</c:forEach>

</table>
</center>
</body>
</html>