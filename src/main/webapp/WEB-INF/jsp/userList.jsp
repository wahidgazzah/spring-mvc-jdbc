<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<link href="<c:url value="/static/css/myCss.css" />" rel="stylesheet">
<title>user list</title>
 
</head>
<body>
	<center>
		 <br /> <b>User List</b><br />
		<table border="1">
			<tr>
				<td class="heading">User Id</td>
				<td class="heading">First Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Gender</td>
				<td class="heading">City</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td><a href="edit?id=${user.userId}">Edit</a></td>
					<td><a href="delete?id=${user.userId}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="7"><a href="register">Add New User</a></td></tr>
		</table>

	</center>
</body>
</html>