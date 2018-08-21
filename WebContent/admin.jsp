<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin page</title>
</head>
<style>
.logoutLblPos{
position:absolute;
right:10px;

background-color:orange;
color:#fff;
top:200px;
}
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
<center>
<h2>This is Admin page</h2>
</center>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
String UserName=(String)session.getAttribute("UserName");
out.print(UserName);
if(UserName==null)
{
	response.sendRedirect("admin_login.jsp");
}

%>
<h3>
 <center>
  ${msg}<br><br>
 ${added}<br><br>
 ${status}
 </center>
</h3>

<form align="right" name="form1" action="/magazine/adminLogoutServlet" method="post">
<label class="logoutLblPos"><input type="submit" name="submit" value="logout"/>
</label>
</form><br>

<form action="/magazine/add_article.jsp" >
<Button class="button">Add Article</button><br><br>
</form><br><br>

<form action="/magazine/articleViewServlet" >
<Button class="button">View Article</button><br><br>
</form><br><br>


<form action="/magazine/changepwdform.jsp" >
<Button class="button">Change Password </button><br><br>
</form><br><br>

<form action="/magazine/viewStudentServlet" >
<Button class="button">View Student List</button><br><br>
</form><br><br>

<form action="/magazine/ViewFeed" method="get">
<Button class="button">View Feedbacks</button><br><br>
</form><br><br>

<form action="/magazine/add_moderator.jsp">
<Button class="button">Add Moderator</button><br><br>
</form><br><br>

<form action="/magazine/ViewModerators">
<Button class="button">View Moderator</button><br><br>
</form><br><br>

</body>
</html>