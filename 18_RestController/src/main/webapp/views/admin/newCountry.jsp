<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<link rel="stylesheet" href="/css/country.css">

<script src="/js/jquery-3.1.1.min.js"></script>




<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />


<div class="wrapper" style="text-align: center">
    <header>
        <div id="error"></div>
        <input type="text" id="nameCountry" placeholder="name of country">
        <button id="save">save</button>
    </header>
    <div class="all">

    </div>
</div>




<script src="/js/country.js"></script>
