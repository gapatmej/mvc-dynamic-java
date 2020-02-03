<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="container-fluid">
			<form>
				<div class="form-group">
					<label for="word">Filtro</label> <input placeholder="Ingrese la palabra a buscar"
						type="text" class="form-control" id="word" name="word">
						<button type="submit" name="action" value="search"
						class="btn btn-secondary">Buscar</button>
				</div>
				
			</form>
		</div>
	</div>

	<div class="container">
		<div class="container-fluid">
			<a href="ControllerClient?action=client" class="btn btn-primary">Nuevo</a>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Id Cliente</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Edad</th>
						<th scope="col">Fecha Nacimiento</th>
						<th scope="col">Email</th>
						<th scope="col">Editar</th>
						<th scope="col">Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clients}" var="c">
						<tr>
							<td>${c.idClient}</td>
							<td>${c.name}</td>
							<td>${c.lastName}</td>
							<td>${c.age}</td>
							<td>${c.dateBirth}</td>
							<td>${c.email}</td>
							<td><a
								href="ControllerClient?action=edit&idClient=${c.idClient}"
								class="btn btn-warning">Editar</a></td>
							<td><a
								href="ControllerClient?action=delete&idClient=${c.idClient}"
								class="btn btn-danger">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<c:if test="${message != null}">
		<div class="alert alert-danger" role="alert">${message}</div>
	</c:if>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>