<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<header>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-primary shadow-sm mb-5">
		<div class="container">
			<a class="navbar-brand text-white fw-bold" href="index.jsp">Horóscopo
				Chino</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto">
					<c:if test="${not empty sessionScope.userObj}">
						<li class="nav-item"><span class="nav-link text-white">👤
								${userObj.nombre}</span></li>
					</c:if>
					<c:if test="${empty sessionScope.userObj}">
						<li class="nav-item"><a class="nav-link text-white"
							href="login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="registro.jsp">Registro</a></li>
					</c:if>
				</ul>
				<ul class="navbar-nav">
					<c:if test="${not empty sessionScope.userObj}">
						<li class="nav-item"><a
							class="btn btn-light btn-sm text-primary"
							href="${pageContext.request.contextPath}/logout">Cerrar
								sesión</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
</header>
