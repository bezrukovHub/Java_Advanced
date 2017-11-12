<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/newCountry.css">
</head>
<body>

<c:forEach var="country" items="${countries}">
	${country.name}
	<br>
</c:forEach>

<%-- <form:form modelAttribute="country" action="newCountry" method="post">
	<form:input path="name" placeholder="country name"/>
	<button>save country</button>
</form:form> --%>

<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new country</h2>

  <form:form modelAttribute="country" action="newCountry" method="post" class="login-container">
    <p><form:input path="name" type="text" placeholder="name country"/></p>
    <p><input type="submit" value="Log in"></p>
  </form:form>
</div>


</body>
</html>