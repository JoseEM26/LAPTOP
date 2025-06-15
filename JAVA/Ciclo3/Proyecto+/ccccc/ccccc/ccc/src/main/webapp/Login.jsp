<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login de Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Inicio de Sesión</h2>
		<form action="Login" method="post">
			<div class="mb-3">
				<label for="nombreUsuario" class="form-label">Email</label>
				<input type="text" class="form-control" id="nombreUsuario" name="email" placeholder="Ingrese su nombre de usuario" required>
			</div>
			<div class="mb-3">
				<label for="contraseña" class="form-label">Contraseña</label>
				<input type="password" class="form-control" id="contraseña" name="contrasena" placeholder="Ingrese su contraseña" required>
			</div>
			<button type="submit" class="btn btn-primary w-100">Iniciar Sesión</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
