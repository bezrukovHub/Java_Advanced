<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<a href="admin">admin page</a>

	<br>
	<br>
	<br>
	

	<c:forEach var="book" items="${books}">
		${book.title} ${book.pages}
		<br>
	</c:forEach>
