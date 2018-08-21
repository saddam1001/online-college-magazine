<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add article</title>
</head>
<body>

<%@ include file="nav.html" %>

	<h3 style="color:red;margin-left:600px">ADD ARTICLE</h3>
	
	<form action="AddArticleServlet" method="post" enctype="multipart/form-data">
		<table style="color:blue;margin-left:500px">	
		<tr><td>ArticleName:</td><td><input type="text" name="artname" placeholder="enter article name"></td></tr>
	    <tr><td>ArticleType:</td><td><input type="text" name="arttype" placeholder="enter type of article"></td></tr>
		<tr><td>CategoryType:</td><td><input type="text" name="cattype" placeholder="enter category type"></td></tr>
		<tr><td>CategoryName:</td><td><input type="text" name="catname" placeholder="enter category name"></td></tr>
		<tr><td>PostedDate:</td><td><input type="date" name="postdate" placeholder="dd-mm-yyyy"></td></tr>
		<tr><td>ArticleDesc:</td><td><input type="file" name="artdesc"></td></tr>
        <tr><td>FileType(Extension):</td><td><input type="text" name="extension" placeholder="eg: .txt, .doc..."></td></tr>
		<tr><td></td><td><input type="submit" value="Submit"><input type="reset" value="clear"></td></tr>
		</table>
		
	</form>
	
</body>
</html>