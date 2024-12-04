<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script>
        function showAlert(error) {
            if (error) {
                alert(error);
            }
        }
        
        showAlert("${error}");
    </script>
</head>
<body>
	<%@ include file="extra/navbar.jsp"%>
	<div class="container d-flex justify-content-center align-items-center">
		<div class="text-center">
			<h1 class="m-2 text-primary">Eliminar Usuario</h1>
			<br>
			<form action="${pageContext.request.contextPath}/delete"
				class="row g-3 needs-validation" method="post" novalidate>
				<input type="hidden" name="id" value="${u.id}">
				<div class="col-12">
					<input type="email" id="email" name="email" class="form-control"
						placeholder="Escriba correo para eliminar @" required />
				</div>
				<div class="col-12">
					<button class="btn btn-primary" type="submit">Eliminar</button>
					<a class="btn btn-primary" href="index.jsp" role="button">Atras</a>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="extra/footer.jsp"%>
	<script>
        (() => {
            'use strict';
            const forms = document.querySelectorAll('.needs-validation');
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        })();

        showAlert("${successMessage}");
    </script>
</body>
</html>
