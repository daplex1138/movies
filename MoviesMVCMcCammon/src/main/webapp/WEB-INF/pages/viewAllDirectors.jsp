<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<%@include file="head.jsp" %>
<title>All Directors</title>
</head>
<body>
<div class="container-fluid">
<h2>All Directors</h2>
<div class="row">
<div class="col-sm-6">
	<a href="newDirector.mvc">Add a new Director</a><br />
	<a href="index.jsp">Home</a>
	<hr style="text-align: left; margin-left: 0; width: 25%">
	<c:forEach items="${allDirectors}" var="item">
	<div class="card">
	<div class="card-body">
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
		<div class="form-group">
		<form action="deleteDirectorResult.mvc" method="POST">
			<input name="directorId" type="hidden" value="${item.id}">
			<input type="submit" value="DELETE" class="btn btn-primary">
		</form>
		</div>
		<div class="form-group">
		<form action="editDirectorResult.mvc" method="POST">
			<input name="directorId" type="hidden" value="${item.id}">
			<input type="submit" value="Edit" class="btn btn-primary">
		</form></div>
		</div>
		</div>
		<br />
	</c:forEach>
		
	<a href="newDirector.mvc">Add a new Director</a><br />
	<a href="index.jsp">Home</a>

	</div>
	</div>
</body>
</html>