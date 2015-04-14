<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
   <tiles:putAttribute name="body">
		<div style="margin: 30px 10px 0;">
			<div class="title">
				<h3><spring:message code="registrationForm" /></h3>
			</div>
			<div class="section">
				<form:form method="post" action="/users/insert" modelAttribute="user">
					<ul>
						<li class="huge">
							<form:label path="firstName"><strong><spring:message code="firstName" /></strong></form:label> 
							<form:input path="firstName" name="firstName" />
						</li>
						<li class="huge">
							<form:label path="lastName"><strong><spring:message code="lastName" /></strong>
							</form:label> <form:input path="lastName" name="lastName" />
						</li>
						<li class="huge">
							<form:label path="gender"><strong><spring:message code="gender" /></strong>
							</form:label> <form:radiobuttons path="gender" items="${map.genderList}" />
						</li>
						<li class="huge">
							<form:label path="city"><strong><spring:message code="city" /></strong>
							</form:label> <form:select path="city" items="${map.cityList}" />
						</li>
						<input type="submit" value="Save" />
						
					</ul>
				</form:form>
			</div>
			<a href="list">Click Here to See User List</a>
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>