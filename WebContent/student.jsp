<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student page</title>
</head>
<style>
.button {
          width:400px;
          height:55px;
          background-color:#B0C4DE;
          border:none;
          color:Red;
          padding: 15px 32px;
          text-align:center;
          text decoration:none;
          
          display:inline-block;
          font-size:16px;
          margin-left:500px;
          margin-right:auto;
          
          margin-bottom:0%;
          cursor: pointer;
          transition-duration: 0.4s;
}
.button1{
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}
 .button:hover { 
         box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}.20.
</style>
<body>


<%@ include file="nav.html" %>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	
    String scope=(String)session.getAttribute("email_id");
	out.print(scope);
	if(scope==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<center><h2><p>This is Student Page</p></h2><br>
<h3>

 ${msg}
</h3>
</center>
<form action="/magazine/LogoutServlet" method="post">
<Button class="button">logout</button><br><br>
</form>

<form action="/magazine/add_article.jsp" >
<Button class="button">Add Article</button><br><br>
</form>

<form action="/magazine/articleViewServlet" >
<Button class="button">View Articles</button><br><br>
</form>

<form action="/magazine/DisplayStudentServlet"  method="post">
<Button class="button">Image</button><br><br>
</form>

<center>${status}</center>
<form action="/magazine/ViewProfile">
<Button class="button">View Profile</button><br><br>
</form>

</body>
</html>