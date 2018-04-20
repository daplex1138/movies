<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<title>Edit Director</title>
</head>
<body>
<div class="container-fluid">
<h2>Edit Director</h2>
<div class="row">
<div class="col-sm-6">
<mvc:form modelAttribute="director" action="updateDirector.mvc">
<div class="form-group">

	  
	        <mvc:label path="id">ID: </mvc:label>
	        <mvc:input path="id" value="${id}" readonly="readonly" class="form-control"/>
	    
	      </div>
	    <div class="form-group">
	        <mvc:label path="firstName">First Name: </mvc:label>
	        <mvc:input path="firstName" value="${firstName}" class="form-control"/>
	    
	      </div>
	    <div class="form-group">
	        <mvc:label path="lastName">Last Name: </mvc:label>
	        <mvc:input path="lastName" value="${lastName}" class="form-control" />
	    
	      </div>
	    <div class="form-group">
	        <mvc:label path="address">Address: </mvc:label>
	        <mvc:input path="address" value="${address}" class="form-control" />
	    	         
	      </div>
	    <div class="form-group">
	        <mvc:label path="gender">Gender</mvc:label>
	        <mvc:select path="gender" items="${genders}" class="form-control" />
	    
          </div>
	    <div class="form-group">

                <input type="submit" value="Submit" class="btn btn-primary" />
</div>
	    

</mvc:form>
<a href = "viewDirectors.mvc">View all Directors</a><br />
<a href = "index.jsp">Home</a>
</div>
</div>
</div>
</body>
</html>