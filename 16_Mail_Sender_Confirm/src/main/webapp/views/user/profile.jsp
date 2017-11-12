<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


${user.name} ${user.email} ${user.phone}
<br>
<img src="${user.pathImage}" alt="add foto" width="500px" height="500px">
<br>

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <button>save image</button>
</form:form>
<br>

<c:forEach var="book" items="${user.books}">
    ${book.title} ${book.pages}
    <a href="deleteBookFromUser/${book.id}">delete</a>
    <br>
</c:forEach>