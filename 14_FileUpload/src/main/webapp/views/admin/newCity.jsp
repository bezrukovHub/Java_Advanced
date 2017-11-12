<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    

<form:form modelAttribute="city" action="saveCity" method="post">
	
	<form:input path="name" placeholder="city name"/>
	
	<form:select path="country" items="${countries}" itemLabel="name" itemValue="id" >
	</form:select>
	<button>save city</button>

</form:form>
