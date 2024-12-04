<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
body {
	background: linear-gradient(135deg, #fbc2eb, #a6c1ee);
	min-height: 100vh;
	display: flex;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
	color: white;
	max-width: 300px; /* Cambia este valor según lo necesites */
	margin: 0 auto;
}

.btn-primary:hover {
	background-color: transparent;
	color: #007bff;
	border-color: #007bff;
}

.btn-lg {
	width: 100%; /* Hace que los botones ocupen todo el ancho */
}
</style>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Home</title>
<script>
			function showAlert(message) {
		        if (message) {
		            alert(message);
		        }
		    }
			
			showAlert("${message}");
		</script>
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>
	<main class="container mt-3 text-center">

		<c:if test="${not empty sessionScope.userObj}">
			<h1 class="mt-3 fw-bold text-primary">Bienvenido,
				${userObj.user}</h1>
			<h4 class="m-4 fw-bold text-primary">¿Qué desea hacer?</h4>
			<div class="d-flex flex-column align-items-start">
				<a class="btn btn-primary btn-lg mb-3 fw-bold"
					href="${pageContext.request.contextPath}/animal" role="button">Animal</a>
				<a class="btn btn-primary btn-lg mb-3 fw-bold" href="search?search="
					role="button">Buscar</a> <a
					class="btn btn-primary btn-lg mb-3 fw-bold"
					href="edit?id=${userObj.id}" role="button">Modificar</a> <a
					class="btn btn-primary btn-lg mb-3 fw-bold"
					href="${pageContext.request.contextPath}/delete?id=${userObj.id}"
					role="button">Eliminar</a>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.userObj}">
			<h1 class="fw-bold text-primary">Bienvenido</h1>
			<br>
			<p>
				Por favor <a href="login.jsp">Inicia Sesión</a> o <a
					href="registro.jsp"> Registrate</a>
			</p>
		</c:if>
	</main>
	<%@ include file="extra/footer.jsp"%>
</body>
</html>