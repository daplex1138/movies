<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<title>Edit Movie</title>
</head>
<body>
<div class="container-fluid">
<h2>Edit Movie</h2>
<div class="row">
<div class="col-sm-6">
<mvc:form modelAttribute="movie" action="updateMovie.mvc" method="POST">
	<div class="form-group">
	        <mvc:label path="id">Movie ID:</mvc:label>
	        <mvc:input path="id" value="${id}" class="form-control"/>
 	    </div>
	    <div class="form-group">
	        <mvc:label path="title">Title:</mvc:label>
	        <mvc:input path="title" value="${title}" class="form-control"/>
	    </div>
	    <div class="form-group">
	        <mvc:label path="year">Year:</mvc:label>
	        <mvc:input path="year" value="${year}" class="form-control" />
	    </div>
	    <div class="form-group">
	        <mvc:label path="rating">Rating:</mvc:label>
	        <mvc:select path="rating" items="${ratings}" class="form-control"/>
	    </div>
	     <div class="form-group">
	        <mvc:label path="genre">Genre:</mvc:label>
	        <mvc:select path="genre" items="${genres}" class="form-control"/>
	    </div>
	   <div class="form-group"> 
	        <mvc:label path="duration">Duration:</mvc:label>
	        <mvc:input path="duration" value="${duration}"  class="form-control"/>
	    </div>
	     <div class="form-group">
	        <mvc:label path="director">Director:</mvc:label>
	        <mvc:select name="director" path="director" items="${allDirectors}" itemLabel="fullName" itemValue = "id" class="form-control"/>
	    </div>
        <div class="form-group">
	       
                <input type="submit" value="Submit" class="btn btn-primary" />
	      </div>  
	    
	</table>  
</mvc:form>
<a href = "viewMovies.mvc">View all Movies</a><br />
<a href = "index.jsp">Home</a>
</div>
</div>
</div>
</body>
</html>