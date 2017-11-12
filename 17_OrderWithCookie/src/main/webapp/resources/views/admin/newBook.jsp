<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



	<c:forEach var="book" items="${books}">
		<div style="background-color: grey">
			${book.title} ${book.pages} <a
				href="deleteBook/${book.id}">delete</a>
		</div>
		<br>
	</c:forEach>

	<form:form modelAttribute="book" action="saveBook" method="post">
		<form:input path="title" placeholder="title" />
		<input name="pages" type="number" />
		<input name="date" type="date">

		<form:select path="country" items="${countriesDTOs}" itemLabel="name"
			itemValue="id">
		</form:select>

		<form:select path="author" items="${authorsDTOs}" itemLabel="surname"
			itemValue="id">
		</form:select>

		<button>save book</button>
	</form:form>
