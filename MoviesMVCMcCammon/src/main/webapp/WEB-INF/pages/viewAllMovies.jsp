<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<html>
<head>
<%@include file="head.jsp" %>
<title>All Movies</title>
</head>
<body>
<div class="container-fluid">
<h2>All Movies</h2>
<div class="row">
<div class="col-sm-6">
	<a href="newMovie.mvc">Add a new Movie</a><br />
	<a href="index.jsp">Home</a>
	<hr style="text-align: left; margin-left: 0; width: 25%">
	<c:forEach items="${allMovies}" var="item">
	<div class="card">
	<div class="card-body">
		<table>
			<tr>
				<td>ID: </td>
				<td>${item.id}</td>
			</tr>
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
		<div class="form-group">
		<form action="deleteMovieResult.mvc" method="POST">
			<input name="movieId" type="hidden" value="${item.id}" class="btn btn-primary">
			<input type="submit" value="DELETE" class="btn btn-primary">
		</form>
		</div>
		<div class="form-group">
		<form action="editMovieResult.mvc" method="POST">
			<input name="movieId" type="hidden" value="${item.id}"class="btn btn-primary">
			<input type="submit" value="Edit" class="btn btn-primary">
		</form>
		</div>
		</div>
		</div>
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
	<a href="newMovie.mvc">Add a new Movie</a><br />
	<a href="index.jsp">Home</a>
		</div>
	</div>
</body>
</html>