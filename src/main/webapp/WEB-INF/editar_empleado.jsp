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
						<br>
			<label for="proyectos">Seleccione un Proyecto:</label>
			<select name="proyecto">
				<c:forEach var="proyecto" items="${lista_proyectos}" >
					<option value="<c:out value="${proyecto.id}" />"> <c:out value="${proyecto.nombre}" /></option>
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
			<input type="submit" value="Modificar Empleado">
		</form:form>
		
	</div>
</body>
</html>