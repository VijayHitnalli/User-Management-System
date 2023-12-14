<%@page import="com.jsp.ums.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Users list</h1>

	<table border=5px>
		<tr>
			<th>UserId</th>
			<th>UserName</th>
			<th>UserEmail</th>
			<th>UserPassword</th>
			
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		List<User> users = (List<User>) request.getAttribute("users");
		for (User user : users) {
		%>
			<tr>
				<td><%=user.getUserId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getPassword()%></td>
				<td><a href="update-user?userId=<%= user.getUserId()%>">Update</a> </td>
				<td><a href="delete-user?userId=<%= user.getUserId()%>">Delete</a> </td>
			</tr>

		<%
		}
		%>
		
		<%
			String msg = (String)request.getAttribute("msg");
		if(msg!=null){
		%>
		<h3><%= msg %></h3>
		<%} %>
	</table>
</body>
</html>