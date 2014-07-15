<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/static/css/myCss.css" />" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
	<center>
	 <br /> <b> Edit User </b><br /> 
		<div>
			<form:form method="post" action="/update" modelAttribute="user">
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName"
								value="${map.user.firstName}" />
						</td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" value="${map.user.lastName}" />
						</td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><spring:bind path="gender">
								<c:forEach items='${map.genderList}' var='genderName'>
									<c:choose>
										<c:when test="${genderName eq map.user.gender}">
											<input type="radio" name="gender" value="${genderName}"
												checked="checked">${genderName}
										</c:when>
										<c:otherwise>
											<input type="radio" name="gender" value="${genderName}">${genderName}
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</spring:bind>
						</td>
					</tr>
					<tr>

						<td>City :</td>
						<td><spring:bind path="city">
								<select name="city">
									<c:forEach items='${map.cityList}' var='cityName'>
										<c:choose>
											<c:when test="${cityName eq map.user.city}">
												<option value="${cityName}" selected="true">${cityName}</option>
											</c:when>
											<c:otherwise>
												<option value="${cityName}">${cityName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</spring:bind></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" />
						</td>
					</tr>
				</table>
				<form:hidden path="userId" value="${map.user.userId}" />

			</form:form>
		</div>
	</center>
</body>
</html>