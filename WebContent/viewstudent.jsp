<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<% response.setContentType("image/gif"); %>

<h2 style="color:blue;margin-left:600px">Student Details</h2>

<% //response.setContentType("html/text"); %>
<table style="margin-left:325px;width:60%;length:60%;height:50%">
<tr style="color:#0000FF;background-color:lightgrey;">
<th style="width:10%">Id</th><th>Name</th><th>Email</th><th>Password</th>
<th>Mobile</th><th>DOB</th><th>Image_variable</th><th>Image</th>
</tr>

<c:forEach items="${student}" var="l">
<tr style="background-color:#FFF0F5;text-align:center">
<td>${l.id}</td><td>${l.name}</td><td>${l.email}</td>
<td>${l.password}</td><td>${l.mobile}</td><td>${l.dob}</td>
<td>${l.blob}</td><td>${l.imageData}</td>
</tr>
</c:forEach>

</table>

</body>
