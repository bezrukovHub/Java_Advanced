<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.12.2016
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update profile</title>
</head>
<body>

<form:form action="updateProfile" method="post">
    <input type="text" name="name" value="${user.name}">
    <input type="text" name="email" value="${user.email}">
    <input type="text" name="phone" value="${user.phone}">
    <input type="text" name="password">
    <button>save updates</button>
</form:form>


</body>
</html>
