<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Directors</title>
</head>
<body>
	<a href="newDirector.mvc">Add a new Director</a><br />
	<a href="index.jsp">Home</a>
	<hr style="text-align: left; margin-left: 0; width: 25%">
	<c:forEach items="${allDirectors}" var="item">
		<table>
			<tr>
				<td>ID: </td>
				<td>${item.id}</td>
		
			<tr>
				<td>Name: </td>
				<td>${item.fullName}</td>
			</tr>
			<tr>
				<td>Address: </td>
				<td>${item.address}</td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td>${item.gender}</td>
			</tr>
			
		</table>
		<br />
		<form action="deleteDirectorResult.mvc" method="POST">
			<input name="directorId" type="hidden" value="${item.id}">
			<input type="submit" value="DELETE">
		</form>
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
	<a href="newDirector.mvc">Add a new Director</a><br />
	<a href="index.jsp">Home</a>
	
</body>
</html>