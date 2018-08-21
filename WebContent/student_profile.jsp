
<body>
<jsp:useBean id="profile" class="com.bean.StudentBean" scope="request"/>
<h2 style="color:red;text-align:center">Student Profile</h2>
<table style="margin-left:325px;length:50%;width:50%;height:25%;">
<tr style="color:blue;background-color:lightgrey;">
<th>Name</th><th>Email</th><th>Password</th>
<th>Mobile</th><th>DateOfBirth</th><th>Image</th><th>Edit_Profile</th>
</tr>


<tr style="background-color:#FFF0F5;text-align:center;">
<td><jsp:getProperty name="profile" property="name"/></td>
<td><jsp:getProperty name="profile" property="email"/></td>
<td><jsp:getProperty name="profile" property="password"/></td>
<td><jsp:getProperty name="profile" property="mobile"/></td>
<td><jsp:getProperty name="profile" property="dob"/></td>
<td><jsp:getProperty name="profile" property="blob"/></td>
<td><a href="edit_profile.jsp?email=<jsp:getProperty name="profile" property="email"/>">edit</a></td>
</tr>

</table>
</body>
