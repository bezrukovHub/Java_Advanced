<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">


	<form:form modelAttribute="user" action="saveUser" method="post">
		<div id="form-main">
			<div id="form-div">
				<form class="form" id="form1">

					<p class="name">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="Name">${usernameException}</label>
						</div>
						<form:input path="name" type="text"
							class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
							placeholder="Name" id="name"/>
					</p>

					<p class="email">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="Name">${emailException}</label>
						</div>
						<form:input path="email" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="password">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="Name">${passwordException}</label>
						</div>
						<form:input path="password" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="password" />
					</p>

					<p class="phone">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="Name">${phoneException}</label>
						</div>
						<form:input path="phone" type="text"
							class="validate[required,custom[password]] feedback-input"
							id="email" placeholder="phone" />
					</p>

					<div class="submit">
						<input type="submit" value="SEND" id="button-blue" />
						<div class="ease"></div>
					</div>
					
				</form>
			</div>
	</form:form>
