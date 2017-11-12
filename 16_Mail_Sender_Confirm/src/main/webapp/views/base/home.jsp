<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
	<a href="some">some</a>
	
	
<sec:authentication property="name" />

<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration">registration</a>
	<br>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="profile">profile</a>
</sec:authorize>

<br>
<br>
<br>


<c:forEach var="book" items="${books}">
		${book.title} ${book.pages} 
			<sec:authorize access="isAuthenticated()">
				<a href="buyBook/${book.id}">buy</a>
			</sec:authorize>
	<br>
</c:forEach>
