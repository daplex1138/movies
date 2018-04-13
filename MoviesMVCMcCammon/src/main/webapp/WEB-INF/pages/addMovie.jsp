<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Movie</title>
</head>
<body>
<h2>Add Movie</h2>
<mvc:form modelAttribute="movie" action="newMovieResult.mvc" method="POST">
	<table>
	    <tr>
	        <td><mvc:label path="title">Title</mvc:label></td>
	        <td><mvc:input path="title" /></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="year">Year</mvc:label></td>
	        <td><mvc:input path="year" /></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="rating">Rating</mvc:label></td>
	        <td><mvc:select path="rating" items="${ratings}"/></td>
	    </tr>
	     <tr>
	        <td><mvc:label path="genre">Genre</mvc:label></td>
	        <td><mvc:select path="genre" items="${genres}"/></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="duration">Duration</mvc:label></td>
	        <td><mvc:input path="duration" /></td>
	    </tr>
	     <tr>
	        <td><mvc:label path="director">Director</mvc:label></td>
	        <td><mvc:select name="director" path="director" items="${allDirectors}" itemLabel="fullName" itemValue = "id"/></td>
	    </tr>
        <tr>
	        <td colspan="2">
                <input type="submit" value="Submit" />
	        </td>
	    </tr>
	</table>  
</mvc:form>
<a href = "viewMovies.mvc">View all Movies</a><br />
<a href = "index.jsp">Home</a>
</body>
</html>