<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h2 style="text-align:center;color:blue">Article Information</h2>

<table style="margin-left:325px;length:60%;width:60%;height:40%;">
<tr style="color:blue;background-color:lightgrey;">
<th style="width:10%">Id</th>
<th>ArticleName</th><th>ArticleType</th><th>CategoryType</th>
<th>ArticleName</th><th>PostDate</th><td>File</td><th>DeleteFile</th>
</tr>

<c:forEach items="${result}" var="ar">
<tr style="background-color:#FFF0F5;text-align:center;">
<td>${ar.id}</td>
<td>${ar.artname}</td><td>${ar.arttype}</td><td>${ar.cattype}</td>
<td>${ar.catname}</td><td>${ar.postdate}</td>
<td><a href="/magazine/DisplayFileServlet?id=${ar.getId()}">download</a></td>
<td><a href="/magazine/DeleteServlet?id=${ar.getId()}">delete</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>