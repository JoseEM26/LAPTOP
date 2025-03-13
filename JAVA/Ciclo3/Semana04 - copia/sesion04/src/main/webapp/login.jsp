<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceso - Ciberfarma</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<div class="container">
		<h1>Acceso al Sistema</h1>
		<form action="login" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Usuario</label> 
				<input type="email" name="usuario"   class="form-control"
					id="exampleInputEmail1">
				
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input name="clave" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			
			<div>
				${mensaje }
				${requestScope.mensaje }
			</div>
			
		</form>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>