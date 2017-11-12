<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>


	<c:forEach var="user" items="${users}">
		<div style="background-color: aqua">
			${user.name} ${user.email} <a href="deleteUser/${user.id}">delete</a>
		</div>
		<br>
	</c:forEach>



	<form:form modelAttribute="user" action="saveUser" method="post">
		<div id="form-main">
			<div id="form-div">
				<form class="form" id="form1">

					<p class="name">
						<form:input path="name" type="text"
							class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
							placeholder="Name" id="name" />
					</p>

					<p class="email">
						<form:input path="email" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="password">
						<form:input path="password" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="phone">
						<form:input path="phone" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>


					<div class="submit">
						<input type="submit" value="SEND" id="button-blue" />
						<div class="ease"></div>
					</div>
				</form>
			</div>
	</form:form>
</body>
</html>