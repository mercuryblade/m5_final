<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro - Horóscopo Chino</title>
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

.card {
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	border-radius: 15px;
}

.form-label {
	font-weight: bold;
}

.btn-primary {
	background-color: #ff6f61;
	border: none;
}

.btn-primary:hover {
	background-color: #ff3b2e;
}

a.text-primary:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>
	<div class="container d-flex justify-content-center align-items-center">
		<div class="card p-4 col-12 col-md-8 col-lg-6">
			<div class="text-center mb-4">
				<h1 class="fw-bold text-primary">Formulario de registro</h1>
				<p class="text-muted">Rellene los espacios con los sus datos.</p>
			</div>
			<form action="${pageContext.request.contextPath}/register"
				method="post" class="row g-3 needs-validation" novalidate>
				<div class="col-12">
					<label for="nombre" class="form-label">Nombre:</label> <input
						type="text" class="form-control" id="nombre" name="nombre"
						required>
				</div>
				<div class="col-12">
					<label for="username" class="form-label">Nombre de usuario:</label>
					<input type="text" class="form-control" id="username"
						name="username" required>
				</div>
				<div class="col-12">
					<label for="email" class="form-label">Correo:</label> <input
						type="email" class="form-control" id="email" name="email" required>
				</div>
				<div class="col-md-6">
					<label for="clave" class="form-label">Password:</label> <input
						type="password" class="form-control" id="clave" name="clave"
						required>
				</div>
				<div class="col-md-6">
					<label for="confirmclave" class="form-label">Confirmar
						Password:</label> <input type="password" class="form-control"
						id="confirmclave" name="confirmclave" required>
				</div>
				<div class="col-12">
					<label for="birthdate" class="form-label">Fecha de
						Nacimiento:</label> <input type="date" class="form-control"
						id="fecha_nacimiento" name="fecha_nacimiento" required>
				</div>
				<div class="col-12 text-center">
					<button class="btn btn-primary w-100" type="submit">Registrar</button>
				</div>
			</form>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger mt-3">${errorMessage}</div>
			</c:if>
			<div class="text-center mt-3">
				<p>
					¿Ya tienes una cuenta? <a href="login.jsp" class="text-primary">Inicia
						sesión aquí</a>
				</p>
			</div>
		</div>
	</div>
	<%@ include file="extra/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-IOFZ/p9B5UEBPyECeI9z8CPRFiG9uTsvIoSnGq4YLpFJWMyPcGgSwiYtRtnvFY01"
		crossorigin="anonymous"></script>
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
