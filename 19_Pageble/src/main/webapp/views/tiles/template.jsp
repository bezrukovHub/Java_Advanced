<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="/css/header.css">
    <script src="/js/jquery-3.1.1.min.js"></script>

    <title>Your Website Title</title>
    <!-- Comment #1: OG Tags -->
    <meta property="og:url"           content="http://www.your-domain.com/your-page.html" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="Your Website Title" />
    <meta property="og:description"   content="Your description" />
    <meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" />

</head>
<body>
<header class="outer page-header">
    <div class="container">

        <a href="/"><img src="/image/library.png" alt=" " class="page-logo pull-left" /></a>

        <nav class="pull-right">

            <ul class="delist menu page-menu">
                <li>
                    <a href="sale">sale</a>
                </li>
                <li>
                    <a href="basket">basket</a>
                </li>
                <sec:authorize access="!isAuthenticated()">
                    <li>
                        <a href="loginpage">login</a>
                    </li>
                    <li>
                        <a href="registration">registration</a>
                    </li>
                </sec:authorize>
                <li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="admin">admin page</a>
                    </sec:authorize>
                </li>
                <li>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="profile">profile</a>
                    </sec:authorize>
                </li>
                <li>
                    <sec:authorize access="isAuthenticated()">

                        <form:form action="logout" method="post">
                            <button>logout</button>
                        </form:form>
                    </sec:authorize>
                </li>

            </ul>

        </nav>


    </div>
</header>
<br>
<br>
<br>
<br>
<br>
<br>


<div>
    <tiles:insertAttribute name="body"/>
</div>
</body>
</html>