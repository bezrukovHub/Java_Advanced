<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



	

	<form:form action="./saveBook?${_csrf.parameterName}=${_csrf.token}"
			   method="post" enctype="multipart/form-data">

		<input name="title" placeholder="title" />
		<input name="pages" type="number" />
		<input name="date" type="date">

		<input name="image" type="file">

		<button>save book</button>
	</form:form>
