
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<input type="text" id="name">
<input type="text" id="email">
<input type="text" id="phone">
<input type="password" id="password">

<button id="signUp">sign up</button>

<input type="hidden" name="csrf_name"
	   value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
	   value="${_csrf.token}" />

<div id="allUser">asidufjasdo</div>



<script>

	document.getElementById('signUp').onclick = function () {

		var user = {

			name : 	$('#name').val(),
			email : document.getElementById('email').value,
			phone : document.getElementById('phone').value,
			password : document.getElementById('password').value

		}

		$.ajax({

			url: 'saveUser?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
			method: 'POST',
			contentType: 'application/json; charset=UTF-8',
			dataType: 'json',
			data: JSON.stringify(user),
			success : function (res) {

				var all = '';

				for(var i = 0; i < res.length; i++){
					all+= '<div>'+res[i].name+''+res[i].email+''+res[i].phone+'</div><br>';
				}


				document.getElementById('allUser').innerHTML = all;



			}


		})





	}


</script>