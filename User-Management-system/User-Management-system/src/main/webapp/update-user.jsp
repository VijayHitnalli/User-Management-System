<%@page import="com.jsp.ums.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	User user = (User) request.getAttribute("user");
	%>
	
	<form action="update-user" method="post">
	    <label>UserId which is Updating	</label>
		<input type="text" value="<%= user.getUserId()%>" readonly="readonly" name="userId"> <br>
		<label>Enter the new UserName to update</label>
		<input type="text" value="<%= user.getUsername()%>" name="name"> <br>
		<label>Enter the new Email to update</label>
		<input type="email" value="<%= user.getEmail()%>" name="email"> <br>
		<label>Enter the new Password to  update</label>
		<input type="text" value="<%= user.getPassword()%>" name="pwd"> <br>
		<input type="submit" value="Update">
	</form>

</body>
</html>