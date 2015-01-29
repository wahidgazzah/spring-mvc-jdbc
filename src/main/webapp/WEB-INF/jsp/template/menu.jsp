<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/" var="helloUrl" />
<spring:url value="/msm/index" var="homeUrl" />
<spring:url value="/msm/viewPeson" var="personListUrl"  />
<spring:url value="/jdbc/users/pages/0" var="userListUrl"  />
 
<div class="menu">
	<ul>
		<li>
			<a href="${homeUrl}">About</a>
		</li>
		<li>
			<a href="${helloUrl}">Hello</a>
		</li>
		<li>
			<a href="${personListUrl}">Person List</a>
		</li>
		<li>
			<a href="${userListUrl}">User List</a>
		</li>
	</ul>
</div>
<!-- TO Use Bootsrap
		 <div class="span3">
            <ul class="nav nav-list">

                <li><a href="${helloUrl}"><i class="icon-chevron"></i> Hello</a></li>
                <li><a href="${homeUrl}"><i class="icon-chevron"></i> Home</a></li>
                <li><a href="${personListUrl}"><i class="icon-chevron"></i> Person List</a></li>
                <li><a href="${userListUrl}"><i class="icon-chevron"></i> User List</a></li>

            </ul>
		</div>
	 -->