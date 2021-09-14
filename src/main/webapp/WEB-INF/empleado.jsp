<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleado</title>
</head>
<body>
	<div>
		<form:form action="/empleado/crear" method="post" modelAttribute="empleado">
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
			
			<input type="submit" value="Crear Empleado">
		</form:form>
	</div>
</body>
</html>