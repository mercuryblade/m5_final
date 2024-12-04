<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<style>
body {
	background: linear-gradient(135deg, #fbc2eb, #a6c1ee);
	min-height: 100vh;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="bg-light text-dark">
	<%@ include file="extra/navbar.jsp"%>
	<div class="container d-flex justify-content-center align-items-center"
		style="min-height: 100vh;">
		<div class="bg-white p-5 rounded shadow"
			style="width: 100%; max-width: 500px;">
			<h1 class="text-center mb-4 text-primary">Editar Datos</h1>
			<c:if test="${not empty error}">
				<div class="alert alert-danger text-center" role="alert">
					${error}</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/edit" method="post"
				class="needs-validation" novalidate>
				<!-- Campo oculto para el ID del usuario -->
				<input type="hidden" name="id" value="${u.id}">

				<div class="mb-3">
					<label for="nombre" class="form-label fw-bold">Nombre:</label> <input
						type="text" id="nombre" name="nombre" class="form-control"
						value="${u.nombre}" required>
				</div>

				<div class="mb-3">
					<label for="username" class="form-label fw-bold">Username:</label>
					<input type="text" id="username" name="username"
						class="form-control" value="${u.user}" required>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label fw-bold">Email:</label> <input
						type="email" id="email" name="email" class="form-control"
						value="${u.email}" required>
				</div>

				<div class="mb-3">
					<label for="fecha_nacimiento" class="form-label fw-bold">Fecha
						de Nacimiento:</label> <input type="date" id="fecha_nacimiento"
						name="fecha_nacimiento" class="form-control"
						value="${u.fecha_nacimiento}" required>
				</div>

				<div class="mb-3">
					<label for="password" class="form-label fw-bold">Password:</label>
					<input type="password" id="password" name="password"
						class="form-control" value="${u.pass}" required>
				</div>

				<!-- Botones -->
				<div class="d-flex justify-content-between">
					<button type="submit" class="btn btn-primary">Actualizar</button>
					<a href="index.jsp" class="btn btn-warning">Atrás</a>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="extra/footer.jsp"%>
	<script>
        (() => {
            'use strict'
            const forms = document.querySelectorAll('.needs-validation')
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
        })()
    </script>
</body>
</html>
