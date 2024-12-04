<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<style>
body {
	background: linear-gradient(135deg, #fbc2eb, #a6c1ee);
	min-height: 100vh;
	display: flex;
}
</style>
<head>
<meta charset="UTF-8">
<title>Tu animal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>

	<div
		class="container full-height d-flex justify-content-center align-items-center ">
		<div class="text-center m-3">
			<h3 class="mt-3 fw-bold text-primary">Conoce a tu animal del
				horóscopo chino</h3>
			<div class="m-3">
				<h4 class="text-Dark">
					Tu animal es: <strong> ${userObj.animal}</strong>
				</h4>
			</div>

			<c:if test="${userObj.animal == 'Rata'}">
			</c:if>

			<c:if test="${userObj.animal == 'Buey'}">
			</c:if>

			<c:if test="${userObj.animal == 'Tigre'}">
			</c:if>

			<c:if test="${userObj.animal == 'Conejo'}">
			</c:if>

			<c:if test="${userObj.animal == 'Dragón'}">
			</c:if>

			<c:if test="${userObj.animal == 'Serpiente'}">
			</c:if>

			<c:if test="${userObj.animal == 'Caballo'}">
			</c:if>

			<c:if test="${userObj.animal == 'Cabra'}">
			</c:if>

			<c:if test="${userObj.animal == 'Mono'}">
			</c:if>

			<c:if test="${userObj.animal == 'Gallo'}">
			</c:if>

			<c:if test="${userObj.animal == 'Perro'}">
			</c:if>

			<c:if test="${userObj.animal == 'Cerdo'}">
			</c:if>

			<c:if test="${userObj.animal == null}">
				<p>Usted no tiene animal</p>
			</c:if>
			<a class="btn btn-primary" href="index.jsp" role="button">Atras</a>
		</div>
	</div>

	<%@ include file="extra/footer.jsp"%>
</body>
</html>