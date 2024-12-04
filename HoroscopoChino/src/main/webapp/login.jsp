<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%
    if (session.getAttribute("userObj") != null) {
        response.sendRedirect("index.jsp");
        return; 
    }
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    response.setHeader("Pragma", "no-cache"); 
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="es">
<style>
body {
	background: linear-gradient(135deg, #fbc2eb, #a6c1ee);
	min-height: 100vh;
	display: flex;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Iniciar Sesión - Horóscopo Chino</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script>
		function showAlert(message) {
	        if (message) {
	            alert(message);
	        }
	    }
	</script>
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>
	<div class="container d-flex justify-content-center align-items-center">
		<div class="text-center">
			<h1 class="fw-bold text-primary">Iniciar Sesión</h1>
			<form action="${pageContext.request.contextPath}/login"
				class="row g-3 needs-validation" method="post" novalidate>
				<div class="col-12">
					<label for="validationCustom01" class="form-label text-primary">Username</label>
					<input type="text" class="form-control" id="validationCustom01"
						name="username" required>
				</div>
				<div class="col-12">
					<label for="validationCustom02" class="form-label text-primary">Contraseña</label>
					<input type="password" class="form-control" id="validationCustom02"
						name="password" required>
				</div>
				<div class="col-12">
					<button class="btn btn-primary" type="submit">Ingresar</button>
				</div>
			</form>
			<br>
			<c:if test="${not empty error}">
				<div class="alert alert-danger m-2">${error}</div>
			</c:if>
			<div>
				<p>
					Si necesitas una cuenta puede registrarse <a href="registro.jsp">aquí</a>
				</p>
			</div>
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
		
		showAlert("${successMessage}");
	</script>
</body>
</html>
