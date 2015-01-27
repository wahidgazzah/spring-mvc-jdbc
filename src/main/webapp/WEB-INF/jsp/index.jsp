<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> 

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<div style="margin:30px 10px 0;">
			<div class="title">
				<h3>About this project</h3>
			</div>
			<p>	
				This project developed By <a href="http://blog.dihaw.com" target="_blank">Wahid Gazzah</a> 
				within the <a href="http://team.dihaw.com" target="_blank">dihaw team</a>  group to be used during the Spring MVC & JDBC Training. 
				The source code is available on <a href="https://github.com/wahidgazzah/spring-mvc-jdbc" target="_blank">Github</a>.
			</p>
		
			<div class="title">
				<h3>Import the Git project using STS IDE</h3>
			</div>
			<ul>
				<li>Go to the File menu and choose Import.</li>
				<li>Surf in the Import menu to Git and select Projects from Git.</li>
				<li>Choose URI at this point...</li>
				<li>To run the project, use "clean compile install" cmd.</li>
				<li>Go to http://localhost:port/spring-mvc-jdbc/</li>
			</ul>

		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>