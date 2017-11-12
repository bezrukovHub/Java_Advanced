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



	<c:forEach var="author" items="${authors}">
		${author.name} ${author.surname}
		<a href="deleteAuthor/${author.id}">delete author</a>
		
		<c:forEach var="book" items="${author.books}">
			${book.title}
			<a href="deleteBookFromAuthor/${book.id}">delete book</a>
			
		</c:forEach>
		<br>
	</c:forEach>
	






	<form action="saveAuthor" method="post">
		<input name="authorName" placeholder="author name"> 
		<input name="authorSurName" placeholder="author surname"> 
		
		<select name="bookId" multiple="multiple">
		
			<c:forEach var="book" items="${books}">
			
				<option value="${book.id}">${book.title } ${book.pages}</option>
				
			</c:forEach>
			
		
		</select>
		
		
		<button>save author</button>
	</form>



</body>
</html>