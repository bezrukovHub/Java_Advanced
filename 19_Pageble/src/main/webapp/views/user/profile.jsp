<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,400,300,600,700,800'
      rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/css/profile.css">


<div class="portfoliocard">
    <div class="coverphoto"></div>
    <div class="profile_picture">
        <img src="${user.pathImage}" alt="" width="110px" height="110px" style="border-radius: 50%">
    </div>
    <div class="left_col">
        <div class="followers">
            <%--<div class="follow_count">18,541</div>
            Followers--%>
        </div>
        <div class="following">
            <%--<div class="follow_count">181</div>
            Following--%>
        </div>
    </div>
    <div class="right_col">
        <h2 class="name">${user.name}</h2>
        <h3 class="location">San Francisco, CA</h3>
        <ul class="contact_information">
            <%--<li class="mail">${user.email}</li>--%>
            <li class="phone">${user.phone}</li>
            <li class="resume"><a href="updateProfile">update profile</a></li>
        </ul>
    </div>
</div>
</body>


<c:forEach var="book" items="${user.books}">
    ${book.title} ${book.pages}
    <br>
</c:forEach>