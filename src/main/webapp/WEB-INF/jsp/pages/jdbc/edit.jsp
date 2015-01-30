<%@ taglib prefix="form"uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div style="margin: 30px 10px 0;">
			<div class="title">
				<h3><spring:message code="edit.user" /></h3>
			</div>
			<div class="section">
				<form:form method="post" action="/jdbc/do-edit" modelAttribute="user">
					<div class="user">
						<ul>
							<li class="huge">
								<form:label path="firstName"><strong><spring:message code="firstName" /></strong></form:label> 
								<form:input path="firstName" name="firstName" />
								<form:errors path="firstName" element="label" cssClass="error"/>
							</li>
							<li class="huge">
								<form:label path="lastName"><strong><spring:message code="lastName" /></strong>
								</form:label> <form:input path="lastName" name="lastName" />
								<form:errors path="lastName" element="label" cssClass="error"/>
							</li>
							<li class="huge">
								<form:label path="gender"><strong><spring:message code="gender" /></strong></form:label>
								<spring:bind path="gender">
									<c:forEach items='${genderList}' var='genderName'>
										<c:choose>
											<c:when test="${genderName eq user.gender}">
												<input type="radio" name="gender" value="${genderName}"
													checked="checked">${genderName}
											</c:when>
											<c:otherwise>
												<input type="radio" name="gender" value="${genderName}">${genderName}
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</spring:bind>
							</li>
							<li class="huge">
								<form:label path="city"><strong><spring:message code="city" /></strong></form:label>
								<spring:bind path="city">
									<select name="city">
										<c:forEach items='${cityList}' var='cityName'>
											<c:choose>
												<c:when test="${cityName eq user.city}">
													<option value="${cityName}" selected="true">${cityName}</option>
												</c:when>
												<c:otherwise>
													<option value="${cityName}">${cityName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</spring:bind>
							</li>
						</ul>
					</div>
					<ul>
						<li class="huge-btn">
							<button type="submit" name="submit"><spring:message code="save" /></button>
							<a href="users/pages/${currentIndex}" class="btn"><spring:message code="cancel" /></a>
						</li>
					</ul>
					<form:hidden path="userId" value="${user.userId}" />
				</form:form>
			</div>
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>