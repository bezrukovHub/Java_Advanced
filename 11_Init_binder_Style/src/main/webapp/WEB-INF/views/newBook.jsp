<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>

	<c:forEach var="book" items="${books}">
		<div style="background-color: grey">
			${book.title} ${book.pages} ${book.dateofPublic} <a
				href="deleteBook/${book.id}">delete</a>
		</div>
		<br>
	</c:forEach>

	<form:form modelAttribute="book" action="saveBook" method="post">
		<form:input path="title" placeholder="title" />
		<input name="pages" type="number" />
		<input name="date" type="date">

		<form:select path="country" items="${countries}" itemLabel="name"
			itemValue="id">
		</form:select>

		<form:select path="author">
			<c:forEach var="author" items="${authors}">
				<form:option value="${author.id}">${author.surname}</form:option>
			</c:forEach>
		</form:select>

		<button>save book</button>
	</form:form>


</body>
</html>