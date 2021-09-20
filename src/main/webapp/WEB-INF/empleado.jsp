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
			<br>
			<label for="proyecto">Seleccione un Proyecto:</label>
			<select name="proyecto">
				<c:forEach var="proyecto" items="${lista_proyectos}" >
					<option value="<c:out value="${proyecto.id}" />"> <c:out value="${proyecto.nombre}" /> </option>
				</c:forEach>
			</select>
			<br>
			<label for="categorias">Seleccione Categorias:</label>
			<select name="categorias" multiple>
				<c:forEach var="categoria" items="${lista_categorias}" >
					<option value="<c:out value="${categoria.id}" />"> <c:out value="${categoria.nombre}" /> </option>
				</c:forEach>
			</select>
			<br>
			<input type="submit" value="Crear Empleado">
		</form:form>
		<br>
		<hr>
		<h1>Lista Empleados</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
					<th>Profesion</th>
					<th>Cargo</th>
					<th>Proyecto</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="empleado" items="${lista_empleados}" >
				<tr>
					<td><c:out value="${empleado.id}" /> </td>
					<td><c:out value="${empleado.rut}" /> </td>
					<td><c:out value="${empleado.nombre}" /> </td>
					<td><c:out value="${empleado.apellido}" /> </td>
					<td><c:out value="${empleado.edad}" /> </td>
					<td><c:out value="${empleado.profesion}" /> </td>
					<td><c:out value="${empleado.cargo}" /> </td>
					<td><c:out value="${empleado.proyecto.nombre}" /> </td>
					<td></td>
					<td>
						<a href="/empleado/actualizar/${empleado.id}">Editar</a>
						
						<form action="/empleado/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${empleado.id}" />" >
							<input type="submit" value="Eliminar">
						</form>
				
						<form action="/empleado/eliminar2/${empleado.id}" method="POST">
							<input type="hidden" name="_method" value="delete" >
							<input type="submit" value="Eliminar">
						</form>

					</td>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>