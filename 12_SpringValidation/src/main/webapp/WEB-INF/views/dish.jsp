<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 15.10.16
  Time: 5:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
	<form:form modelAttribute="dish" action="newDish" method="post">
		
		<form:errors path="name"/>
		<form:errors path="recipe"/>
		<form:errors path="story"/>
		
		<form:input path="name"/>
		<form:input path="recipe"/>
		<form:input path="story"/>
		<button>save dish</button>
	 </form:form>


</body>
</html>