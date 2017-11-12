<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
author

<%-- ${authors} --%>

<form action="saveAuthor" method="post">
	<input name="authorName" placeholder="author name">
	<br>
	<input name="authorSurName" placeholder="author surname">
	<br>
	<button>save author</button>
</form>



</body>
</html>