<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<script src="/js/jquery-3.1.1.min.js"></script>
<div id="error"></div>
<input type="text" id="nameCountry">
<button id="save">save country</button>

<div id="allCountries"></div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/country.js"></script>
