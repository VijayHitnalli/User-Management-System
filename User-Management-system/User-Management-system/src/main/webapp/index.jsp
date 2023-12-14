<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome User</h1>
	<a href="add-user.jsp">Add User</a>
	<%
		String message = (String) request.getAttribute("msg");
		if(message!=null){ %>
			<h3><%=message%></h3>
	<%	} %>
	<br>
	<a href="users">View Users</a>

</body>
</html>