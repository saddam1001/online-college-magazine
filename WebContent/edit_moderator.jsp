<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<center>
<text>
<h3>Moderator Update Page</h3>
<form action="/magazine/UpdateModerator" method="post">
<div class="container">
<input type="hidden" name="id" value="${mb.id}">

<label><b>Email</b></label><br><input type="text" name="email" value="${mb.email}"><br>
<label><b>Password</b></label><br><input type="text" name="password" value="${mb.password}"><br>
<button type="submit" value="update">Update</button><br>
</div>

</form>
</center>
</body>