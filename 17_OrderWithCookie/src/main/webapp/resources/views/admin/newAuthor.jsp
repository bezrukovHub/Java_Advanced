
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link rel="stylesheet" href="css/author.css">




	<c:forEach var="author" items="${authors}">
		${author.name} ${author.surname}
		<a href="deleteAuthor/${author.id}">delete author</a>

		<c:forEach var="book" items="${author.books}">
			${book.title}
			<a href="deleteBookFromAuthor/${book.id}">delete book</a>

		</c:forEach>
		<br>
	</c:forEach>


<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new Author</h2>

  <form:form modelAttribute="author" action="saveAuthor" method="post" class="login-container">
    <p><form:input path="name"  type="text" placeholder="author name"/></p>
    <p><form:input path="surname" type="text" placeholder="author surname"/></p>
    <p><input type="submit" value="save author"></p>
  </form:form>
</div>

