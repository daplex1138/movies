<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Movies</title>
</head>
<body>
<h2>All Movies</h2>
	<c:forEach items="${allMovies}" var="item">
		<table>
			<tr>
				<td>Title: </td>
				<td>${item.title}</td>
			</tr>
			<tr>
				<td>Year: </td>
				<td>${item.year}</td>
			</tr>
			<tr>
				<td>Rating: </td>
				<td>${item.rating}</td>
			</tr>
			<tr>
				<td>Genre: </td>
				<td>${item.genre}</td>
			</tr>
			<tr>
				<td>Director: </td>
				<td>${item.director.fullName}</td>
			</tr>
			
		</table>
		<br />
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
	<a href="newMovie.mvc">Add a new Movie</a><br />
	<a href="index.jsp">Home</a>
</body>
</html>