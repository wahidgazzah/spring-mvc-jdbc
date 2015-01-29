<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>dihaw - Spring MVC JDBC</title>
		
		<link href="<c:url value="/static/css/style.css" />" rel="stylesheet"> </link> 
		<script type="text/javascript" src="<c:url value="/static/js/script.js" />"></script>
	</head>
	<body>
		<div class="container" style="border: #C1C1C1 solid 1px; border-radius:10px; margin: 30px auto;">
			<!-- Header -->
			<tiles:insertAttribute name="header" />
			<!-- Menu Page -->
			
			<tiles:insertAttribute name="menu" />
			
			<!-- Main Page -->
			<div class="main">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Footer Page -->
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>