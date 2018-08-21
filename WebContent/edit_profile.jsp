<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=password], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=number], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;

}

input[type=email] {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

input[type=file] {
    color: red;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;


}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.bean.StudentBean"%>
<body>
<%
	String email=request.getParameter("email");
	StudentBean student=StudentDAO.viewProfile(email);
%>

<form action="/magazine/EditStudent" method="post"
	 enctype="multipart/form-data">
<input type="hidden" name="id" value="<%=student.getId() %>">



<label for="name">Name</label><input type="text" name="name" value="<%=student.getName() %>"><br>
<label for="email">Email</label><input type="email" name="email" value="<%=student.getEmail() %>"><br>
<label for="password">Password</label><input type="password" name="pwd" value="<%=student.getPassword() %>"><br>
<label for="mobile">Mobile</label><input type="number" name="number" value="<%=student.getMobile() %>"><br>
<label for="dob">DOB</label><input type="text" name="dob" value="<%=student.getDob() %>"><br>
<label for="image">image</label><input type="file" name="image" value="<%=student.getBlob() %>"><br>

<input type="submit" value="Update">
</form>
</body>
