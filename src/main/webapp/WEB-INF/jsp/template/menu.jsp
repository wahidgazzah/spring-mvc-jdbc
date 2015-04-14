<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:url value="/" var="helloUrl" />
<spring:url value="/about" var="aboutUrl" />
<spring:url value="/persons/list" var="personListUrl"  />
<spring:url value="/users/list" var="userListUrl"  />

<div class="menu">

	<ul>
		<li ${fn:contains(pageContext.request.requestURI, 'about') ? 'class="selected"' : ''}>
			<a href="${aboutUrl}"><spring:message code="menu.about" /></a>
		</li>
		<li ${fn:contains(pageContext.request.requestURI, 'hello') ? 'class="selected"' : ''}>
			<a href="${helloUrl}"><spring:message code="menu.hello" /></a>
		</li>
		<li ${fn:contains(pageContext.request.requestURI, 'persons') ? 'class="selected"' : ''}>
			<a href="${personListUrl}"><spring:message code="menu.persons" /></a>
		</li>
		<li ${fn:contains(pageContext.request.requestURI, 'users') ? 'class="selected"' : ''}>
			<a href="${userListUrl}"><spring:message code="menu.users" /></a>
		</li>
	</ul>
</div> 
