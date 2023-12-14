<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add-Employee</title>
</head>
<body>
<form action="users" method="post">
<label>Enter your name</label>
		<input type="text" placeholder="Enter your name:" name="name"/> <br>
		<label>Enter your Email</label>
		<input type="text" placeholder="Enter your email" name="email"> <br>
		<label>Enter your password</label>
		<input type="text" placeholder="Enter your password" name="pwd"> <br>
		<input type="submit" value="Save">
	</form>
</body>
</html>