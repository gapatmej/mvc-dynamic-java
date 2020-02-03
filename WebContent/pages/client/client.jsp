<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Cliente</title>

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
					<label for="idClient">Id Cliente</label> <input value="${client.idClient}"
						placeholder="Id del Cliente"
						<c:if test="${client.idClient >0}"> <c:out value="readonly='true'" /> </c:if>
						type="text" class="form-control" id="idClient" name="idClient">
				</div>

				<div class="form-group">
					<label for="name">Nombre</label> <input value="${client.name}" required
						placeholder="Nombre del Cliente" type="text" class="form-control"
						id="name" name="name">
				</div>

				<div class="form-group">
					<label for="lastName">Apellido</label> <input value="${client.lastName}"
						placeholder="Apellido del Cliente" type="text"
						class="form-control" id="lastName" name="lastName">
				</div>

				<div class="form-group">
					<label for="age">Edad</label> <input value="${client.age}"
					placeholder="Edad del Cliente"
						type="number" class="form-control" id="age" name="age">
				</div>

				<div class="form-group">
					<label for="dateBirth">Fecha Nacimiento</label> <input value="${client.dateBirth}"
						placeholder="Fecha Nacimiento del Cliente" type="date"
						class="form-control" id="dateBirth" name="dateBirth">
				</div>

				<div class="form-group">
					<label for="email">Email</label> <input value="${client.email}"
						placeholder="Email del Cliente" type="email" class="form-control"
						id="email" name="email">
				</div>

				<c:if test="${client.idClient == 0}">
					<button type="submit" name="action" value="create"
						class="btn btn-primary">Guardar</button>
				</c:if>

				<c:if test="${client.idClient > 0}">
					<button type="submit" name="action" value="update"
						class="btn btn-primary">Actualizar</button>
				</c:if>

			</form>
		</div>
	</div>

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