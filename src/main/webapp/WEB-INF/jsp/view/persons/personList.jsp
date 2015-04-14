<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<div style="margin: 30px 10px 0;">
			<div class="title">
				<h3>List of Persons</h3>
			</div>
			<center>
				<table style="width: 90%" class="reference">
					<tbody>
						<tr>
							<th>Sr. No.</th>
							<th>Name</th>
							<th>Age</th>
							<th>Email</th>
						</tr>
						
						<c:forEach var="person" items="${persons}" varStatus="loopCounter">
							<tr>
								<td><c:out value="${loopCounter.count}" /></td>
								<td><c:out value="${person.name}" /></td>
								<td><c:out value="${person.age}" /></td>
								<td><c:out value="${person.email}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>