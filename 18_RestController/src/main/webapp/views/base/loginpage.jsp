<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--<link rel="stylesheet" href="/css/login.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">--%>


${fail}

<div id="login">
    <form:form action="loginprocesing" method="post">
        <span class="fontawesome-user"></span>
        <input name="username" type="text" id="user" placeholder="Username">

        <span class="fontawesome-lock"></span>
        <input name="password" type="password" id="pass" placeholder="Password">

        <input type="submit" id="login" value="Login">

    </form:form>
</div>


<script>

    document.getElementById('login').onclick = function () {


        if(document.getElementById('user').value == ''){


            console.log("empty field");


        }


    }


</script>


