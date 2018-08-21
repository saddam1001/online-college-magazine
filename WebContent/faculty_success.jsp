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
		String email=(String)session.getAttribute("UserEmail");
		//out.print(email);
		if(email==null)
		{
			response.sendRedirect("faculty_login.jsp");
		}

	%>
	<h2>Welcome to the faculty Page</h2><br><br>
<h3>
 ${msg} <br><br>
 ${UserEmail}<br><br>
</h3>


<form action="/magazine/add_article.jsp" >
<Button class="button">Add Article</button><br><br>
</form><br><br>

<form action="/magazine/articleViewServlet" >
<Button class="button">View Article</button><br><br>
</form><br><br>

<form action="/magazine/FacultyLogoutServlet" method="post">
<Button class="button">Logout</button><br><br>
</form><br><br>


</body>