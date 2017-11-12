<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 

${user.name} ${user.email} ${user.phone}
<br>

<br>

<c:forEach var="book" items="${user.books}">
	${book.title} ${book.pages}
<br>
</c:forEach> 