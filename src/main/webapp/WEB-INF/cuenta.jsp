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
		<h1>Nueva Cuenta de Empleado</h1>

		
		<form action="/cuenta/insertar" method="post">
			<label for="codigo">Código:</label>
			<input type="text" name="codigo">
			<br>
			<label for="estado">Estado:</label>
			<input type="text" name="estado">
			<br>
			<label for="empleados">Seleccione un Empleado:</label>
			<select name="empleados">
				<c:forEach var="empleado" items="${lista_empleados}" >
					<option value="<c:out value="${empleado.id}" />"> <c:out value="${empleado.nombre}" /> <c:out value="${empleado.apellido}" /></option>
				</c:forEach>
			</select>
			<br>
			<input type="submit" value="Crear Cuenta">
		</form>
	</div>
</body>
</html>