<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="text" id="nameCity">
<select  id="idCountry">
    <c:forEach var="book" items="${countries}">
        <option value="${book.id}">${book.name}</option>
    </c:forEach>
</select>

<button id="saveCity">save city</button>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />


<script src="/js/city.js"></script>