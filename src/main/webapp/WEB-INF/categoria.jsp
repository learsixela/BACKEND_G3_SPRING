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
		<h1>Categorias</h1>


		<form action="/categoria/insertar" method="post">
			<label for="nombre">Nombre:</label> <input type="text" name="nombre">
			<br> <input type="submit" value="Crear Categoria">
		</form>
		<br>
		<hr>
		<h1>Lista de Categorias</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="categoria" items="${lista_categorias}" >
				<tr>
					<td><c:out value="${categoria.id}" /> </td>
					<td><c:out value="${categoria.nombre}" /> </td>
					<td>
						<a href="/categoria/actualizar/${categoria.id}">Editar</a>
						
				
						<form action="/categoria/eliminar/${categoria.id}" method="POST">
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