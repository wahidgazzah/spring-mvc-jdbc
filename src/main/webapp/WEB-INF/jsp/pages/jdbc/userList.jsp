<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:url var="firstUrl" value="/jdbc/users/pages/0" />
<c:url var="lastUrl"  value="/jdbc/users/pages/${totalPages }" />
<c:url var="prevUrl"  value="/jdbc/users/pages/${currentIndex - 1}" />
<c:url var="nextUrl"  value="/jdbc/users/pages/${currentIndex + 1}" />


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    <div style="margin: 30px 10px 0;">
		<div class="title">
			<h3>User List</h3>
		</div>
	<center>	
		<div class="pagination">
		    <ul>
		    
		   <%--      <c:choose> 
		            <c:when test="${currentIndex == 1}">
		                <li class="disabled"><a href="#">&lt;&lt;</a></li>
		                <li class="disabled"><a href="#">&lt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href="${firstUrl}">&lt;&lt;</a></li>
		                <li><a href="${prevUrl}">&lt;</a></li>
		            </c:otherwise>
		        </c:choose>--%>
		        
		        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
		            <c:url var="pageUrl" value="/jdbc/users/pages/${i}" />
		            <c:choose>
		                <c:when test="${i == currentIndex}">
		                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
		                </c:when>
		                <c:otherwise>
		                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		     <%--    <c:choose>
		            <c:when test="${currentIndex == totalPages}">
		                <li class="disabled"><a href="#">&gt;</a></li>
		                <li class="disabled"><a href="#">&gt;&gt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href="${nextUrl}">&gt;</a></li>
		                <li><a href="${lastUrl}">&gt;&gt;</a></li>
		            </c:otherwise>
		        </c:choose>--%>
		    </ul>
		</div>
			
			<table  style="width: 90%" class="reference">
				<tr class="head">
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>City</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.userId}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.gender}</td>
						<td>${user.city}</td>
						<td class="edit"><a href="../../edit?id=${user.userId}">Edit</a></td>
						<td class="delete"><a href="#delete" class="sets" onclick="switchDetails(${user.userId})">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="btn-div">
				<a href="add" class="btn">Add New User</a>
			</div>

		</div>
		
		<div id="device-details" style="display:none">
			<div id="container-details">
				<div id="dialog">
					<div id="openDialog${user.userId}" class="details">
						<div class="details-container">
							<h3>Are You Sure?</h3>
							<div style=" margin: 20px 0 15px;">
								<a id="deleteAction" href="../../delete?id=" class="btn">Yse</a>
								<a href="#" class="btn" onclick="closeDetails()">Cancel</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
    </tiles:putAttribute>
</tiles:insertDefinition>
