<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Director</title>
</head>
<body>
<h2>New Director</h2>
<mvc:form modelAttribute="director" action="updateDirector.mvc">
	<table>
	    <tr>
	        <td><mvc:label path="firstName">First Name: </mvc:label></td>
	        <td><mvc:input path="firstName" value="${firstName}"/></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="lastName">Last Name: </mvc:label></td>
	        <td><mvc:input path="lastName" value="${lastName}" /></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="address">Address: </mvc:label></td>
	        <td><mvc:input path="address" value="${address}" /></td>
	    </tr>
	    <tr>
	        <td><label>Gender: </label></td>
	         <td><mvc:select path="gender" items="${genders}" /></td>
<!--          <td>	
	        	<select name="gender">			
		        	<c:forEach items="${genders}" var="currentitem">
						<option value="${currentitem.gender}" ${director.gender == currentitem.gender ? "selected":""}>${currentitem.gender}</option>
					</c:forEach>
				</select>
			</td>
			-->
	    </tr>
        <tr>
	        <td colspan="2">
                <input type="submit" value="Submit" />
	        </td>
	    </tr>
	</table>  
</mvc:form>
<a href = "viewDirectors.mvc">View all Directors</a><br />
<a href = "index.jsp">Home</a>
</body>
</html>