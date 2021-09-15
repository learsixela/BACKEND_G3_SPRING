<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleado</title>
</head>
<body>
	<div>
		<form:form action="/empleado/modificar" method="post" modelAttribute="empleado">
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="edad">edad:</form:label>
			<form:input type="text" path="edad"/><br>
			
			<form:label path="profesion">profesion:</form:label>
			<form:input type="text" path="profesion"/><br>
			
			<form:label path="cargo">cargo:</form:label>
			<form:input type="text" path="cargo"/><br>
			
			<input type="submit" value="Modificar Empleado">
		</form:form>
		
	</div>
</body>
</html>