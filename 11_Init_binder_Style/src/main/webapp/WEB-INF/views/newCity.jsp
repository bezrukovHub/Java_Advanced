<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="city" action="saveCity" method="post">
	
	<form:input path="name" placeholder="city name"/>
	
	<form:select path="country" items="${countries}" itemLabel="name" itemValue="id" >
	</form:select>
	<button>save city</button>

</form:form>



</body>
</html>