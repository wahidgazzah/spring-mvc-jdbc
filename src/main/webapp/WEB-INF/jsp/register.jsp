<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add User</title>
</head>
<link href="<c:url value="/static/css/myCss.css" />" rel="stylesheet">
<body>
	<center>
		  <br /> <b> Registration Form </b> <br />
		<div>
			<form:form method="post" action="/insert" modelAttribute="user">
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:radiobuttons path="gender"
								items="${map.genderList}" /></td>
					</tr>
					<tr>
						<td>City :</td>
						<td><form:select path="city" items="${map.cityList}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
					<tr>
						
						<td colspan="2"><a href="getList">Click Here to See User List</a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
</body>
</html>