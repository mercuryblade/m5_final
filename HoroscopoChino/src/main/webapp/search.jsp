<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Usuarios Registrados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	background: linear-gradient(135deg, #fbc2eb, #a6c1ee);
	min-height: 100vh;
	display: flex;
}

.btn-primary {
	background-color: #4a148c;
	border-color: #4a148c;
}

.btn-primary:hover {
	background-color: #6a1b9a;
	border-color: #6a1b9a;
}

.btn-warning {
	background-color: #fbc02d;
	border-color: #fbc02d;
}

.btn-warning:hover {
	background-color: #f9a825;
	border-color: #f9a825;
}

.table thead {
	background-color: #6a1b9a;
	color: white;
}

.table tbody tr:nth-child(even) {
	background-color: #f3e5f5; /* Morado claro */
}

.table tbody tr:nth-child(odd) {
	background-color: #ede7f6; /* Más claro aún */
}

.table-responsive {
	border: 1px solid #ddd;
	border-radius: 10px;
	overflow: hidden;
}
</style>
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>
	<div class="container text-center">
		<h1 class="mb-4 text-primary">Usuarios Registrados</h1>

		<form action="search" method="get" class="mb-4">
			<div class="input-group w-75 mx-auto">
				<input type="text" name="search" class="form-control"
					placeholder="Username o Correo" />
				<button class="btn btn-secondary" type="submit">Buscar</button>
			</div>
		</form>

		<div class="table-responsive w-100">
			<table class="table table-bordered table-striped text-center">
				<thead>
					<tr>
						<th>Username</th>
						<th>Email</th>
						<th>Año de nacimiento</th>
						<th>Animal</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty usuarios}">
							<c:forEach var="usuario" items="${usuarios}">
								<tr>
									<td>${usuario.user}</td>
									<td>${usuario.email}</td>
									<td>${usuario.animal}</td>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" class="text-center text-muted">No se
									encontraron usuarios</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<a class="btn btn-warning mt-4" href="index.jsp" role="button">Atrás</a>
	</div>
	<%@ include file="extra/footer.jsp"%>
</body>
</html>
