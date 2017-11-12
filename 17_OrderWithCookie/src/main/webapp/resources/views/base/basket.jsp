<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.12.2016
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>basket</title>
    <link rel="stylesheet" href="/css/popup.css">
    <script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<c:forEach var="book" items="${books}">
    ${book.title} ${book.pages}
    <a href="deleteFromOrder/${book.id}">delete From Cookie</a>
    <div class="popup" onclick="myFunction(${book.id})">get order
        <div class="popuptext" id="myPopup">

            <input type="text" id="titleBook">
            <br>
            <input type="text" id="bookPages">
            <button id="saveUpdate">save update</button>

        </div>
    </div>
    <br>
</c:forEach>

<script src="/js/popup.js"></script>
</body>
</html>
