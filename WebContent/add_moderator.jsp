<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add moderator</title>
</head>
<style>

form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 14px 18px;
    background-color: #f44336;

}

.container {
    padding: 16px;
}

span.psw {
    float: middle;
    padding-top: 15px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: auto;
    }
}

</style>
<body>

<%@ include file="nav.html" %>
<br><br>
<h3><p>Here Admin can Add Moderator</p></h3>
<center>
<form action="/magazine/AddModerator" method="post">
<div class="container">
    <label><b>Email</b></label><br>
    <input type="text" placeholder="Enter Email" name="email" required><br>

    <label><b>Password</b></label><br>
    <input type="text" placeholder="Enter Password" name="password" required><br>
        
    <button type="submit">Add</button><br>
    
  </div>
  
</form>
</center>
</body>
</html>