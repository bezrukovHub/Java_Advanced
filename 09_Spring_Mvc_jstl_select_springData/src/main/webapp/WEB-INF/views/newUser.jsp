<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- ${users} --%>


<c:forEach var="user" items="${users}">
	<div style="background-color: aqua">	
		${user.username} ${user.email} 
		<a href="deleteUser/${user.id}">delete</a>
	</div>
	<br>
</c:forEach>



<form action="saveUser" method="post">
	<input name="username" placeholder="username">
	<input name="email" type="email" placeholder="email">
	<input name="pass" type="password" placeholder="password">
	<input name="phone" placeholder="phone">
	<button>save user</button>
</form>


</body>
</html>