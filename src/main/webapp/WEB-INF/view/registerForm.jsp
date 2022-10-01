<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="icon"
		  href="${pageContext.request.contextPath}/resources/media/analysis.png">
<meta charset="UTF-8">
<title>tweezer</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/processreg"
			   method="POST" modelAttribute="user">
			   <p>Username</p> 
			   <form:input path="username" />
			   <p>Email</p> 
			   <form:input path="email" />
			   <p>password</p>
			   <form:input type="password" path="password" /> 
			   <input type="submit" value="Submit" />
	</form:form>
</body>
</html>