<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    <div style="margin: 30px 10px 0;">
		<div class="title">
			<h3>User List</h3>
		</div>
			<center>
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
						<td class="edit"><a href="edit?id=${user.userId}">Edit</a></td>
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
								<a id="deleteAction" href="delete?id=" class="btn">Yse</a>
								<a href="#" class="btn" onclick="closeDetails()">Cancel</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
    </tiles:putAttribute>
</tiles:insertDefinition>
