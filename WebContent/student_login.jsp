<title>student login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<body>
	
	<%@ include file="nav.html" %>
<h2>Student Login Page</h2>
<div class="loginbox">
<img src="I\Avtar.png" class="Avtar">
<h1>Login Here</h1>

<form action="/magazine/LoginProcessServlet" method="post">
<p>Email</p>
<input type="text" name="email" placeholder="Enter Email">
<p>Password</p>
<input type="Password" name="password" placeholder="Enter Password">
<input type="submit" name="" value="Login">
<a href="student_register.jsp">You don't have an account?</a>

</form>
</div>
</body>
