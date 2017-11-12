<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>

<script src="/js/jquery-3.1.1.min.js"></script>


<a href="sale">sale</a>

<a href="basket">basket</a>

<sec:authentication property="name"/>

<sec:authorize access="isAuthenticated()">

    <form:form action="logout" method="post">
        <button>logout</button>
    </form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">

    <a href="loginpage">login</a>
    <a href="registration">registration</a>
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



    <input class="radio" id="radio" type="range" name="book" min="10" max="200" step="10">
   <%-- <input class="radio" id="radio" type="radio" name="book" value="50"> 50<br>
    <input class="radio" id="radio" type="radio" name="book" value="100"> 100<br>
    <input class="radio" id="radio" type="radio" name="book" value="200"> 200<br>--%>

<br>
<button id="get">get books</button>
<br>
<div id="books">
    <c:forEach var="book" items="${books}">
        ${book.title} ${book.pages}<br>
    </c:forEach>
</div>





<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script>


    document.getElementById('get').onclick = function () {


//        console.log(document.getElementById('radio').value);


//        var check = document.querySelectorAll('.radio');
        var check = document.getElementById('radio').value;

        /*var value = '';

        for(var i =0; i < check.length; i++){
            if(check[i].checked){
                value = check[i].value;

            }
        }*/


       $.ajax({

           url: 'sortBooks?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
           contentType: 'application/json; charset=UTF-8',
           dataTypes: 'json',
           method: "POST",
           data : check,
           success : function (res) {

               var allBooks = '';

               for(var i =0; i < res.length; i++){
                   allBooks+=res[i].title+'<br>';
               }

               document.getElementById('books').innerHTML = allBooks;

           }


       })


    }



</script>






