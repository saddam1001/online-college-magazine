<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>faculty register </title>
</head>

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

input[type=tel], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=date], select, textarea {
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

<body>

	
	<%@ include file="nav.html" %>
	<h1 style="color:red;margin-left:500px">Faculty Registration</h1>
	<h3 style="color:black;margin-left:500px">Please provide the correct Information</h3>
	<div class="container">
	<form action="FacultyRegServlet" method="post" enctype="multipart/form-data">
			
		<label for="name"> Name</label>
        <input type="text" id="name" name="name" placeholder="Your user name.."><br>

        <label for="email">Email ID</label>
        <input id="email" name="email" type="email" size="64" maxLength="64" required
          placeholder="Your Mail ID.." pattern=".+@gmail.com"
          title="Please provide only a valid email address.."><br>

        <label for="password">Password</label>
        <input type="password" id="password" name="pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"><br>
        
        <label for="text">Branch</label>
        <input type="text" id="branch" name="branch"><br>
        
        
        <label for="mobile">Mobile No.</label>
        <input type="tel" name="number" id="mobile" pattern=".{10,10}" required title="Plz enter 10 digit Mobile no"><br>
   
        <label for="dob">Date of Birth</label>
        <input type="date" name="dob" placeholder="dd-mm-yyyy"  size="64" maxlength="100"><br>
   
        <label for="image">Image :</label>
        <input type="file" id="image" name="image"><br><br>
        
        <input type="submit" value="Register">

	</form>
   </div>	
</body>
</html>