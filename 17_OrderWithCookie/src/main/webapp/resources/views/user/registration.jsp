<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<script src="/js/jquery-3.1.1.min.js"></script>

<input path="name" type="text"
       placeholder="Name" id="name"/>
<br>
<input path="email" type="text"
       id="email" placeholder="email"/>
<br>
<input path="password" type="text"
       id="password" placeholder="password"/>
<br>

<input id="phone" placeholder="phone"/>
<br>

<label for="user1">registry by user</label>
<input class="role" type="radio" name="role" value="ROLE_USER" id="user1">
<label for="customer">registry by customer</label>
<input class="role" type="radio" name="role" value="ROLE_CUSTOMER" id="customer">

<input type="submit" value="SEND" id="button-blue"/>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script>

    $('#button-blue').click(function () {


        var role = '';

        var roles = document.querySelectorAll('.role');

        for (var i = 0; i < roles.length; i++) {
            if (roles[i].checked) {
                role = roles[i].value;
            }
        }

        console.log(role);

        var user = {

            name: $('#name').val(),
            email: $('#email').val(),
            phone: $('#phone').val(),
            password: $('#password').val(),
            role: role

        }


        $.ajax({

            url: 'saveUser?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(user),
//            success : function (res) {
//
//
//            }

        });


    })


</script>
