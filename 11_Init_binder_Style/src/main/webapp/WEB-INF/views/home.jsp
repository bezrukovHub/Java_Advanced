<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/links.css">
</head>
<body>

	<div style="display: none;">

		<a href="newAuthor" id="link1">add author</a>
		<br>
		<a href="newBook" id="link2">add book</a>
		<br>
		<a href="newUser" id="link3">add user</a>
		<br>
		<a href="newCountry" id="link4">add country</a>
		<br>
		<a href="newCity" id="link5">add city</a>
		
	</div>

		

	<c:forEach var="book" items="${books}">
		${book.title}
		<br>
	</c:forEach>



<script src="js/links.js"></script>
</body>
</html>
