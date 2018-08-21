<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>moderator page</title>
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
<h2>This is Moderator Page</h2>

<h3>

 Welcome ${msg}<br><br>
</h3>

<form align="right" name="form1" action="/magazine/ModeratorLogout" method="post">
<label class="logoutLblPos"><input type="submit" name="submit" value="logout"/>
</label>
</form><br>


<form action="/magazine/add_article.jsp" >
<Button class="button">Add Article</button><br><br>
</form><br><br>

<form action="/magazine/articleViewServlet" >
<Button class="button">View Article</button><br><br>
</form><br><br>

<form action="/magazine/viewStudentServlet">
<Button class="button">Students List</button><br><br>
</form><br><br>

<form action="/magazine/ViewFeed" method="get">
<Button class="button">Feedback Details</button><br><br>
</form><br><br>

</body>
</html>