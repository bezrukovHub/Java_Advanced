<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<input type="text" id="title">

<button id="save">save</button>


<script>

    $('#save').click(function () {

        var book = {

            title: $('#title').val()

        }


        $.ajax({

            url: 'newBook?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(book),
            success: function (res) {

            }


        })


    })

</script>