<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><c:out value="${titulo}"></c:out></title>
</head>
<body>
	<div>
		<h1>mi primer jsp</h1>
		<h2><c:out value="${parametro1}"></c:out></h2>
		<h2><c:out value="${parametro2}"></c:out></h2>
		
		<form action="/login" method="post">
			<label for="email">Email:</label>
			<input type="text" name="email">
			<p><c:out value="${errorEmail}" /></p>
			<label for="password">Password:</label>
			<input type="password" name="password">
			<p><c:out value="${errorPassword}" /></p>
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>