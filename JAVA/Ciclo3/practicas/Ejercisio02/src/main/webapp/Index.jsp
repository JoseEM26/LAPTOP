<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de Formulario</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="container">
	<h1>Mantenimiento de Trabajador</h1>
	<form class="row g-3" action="trabajadorServelt" method="post">
		<div class="col-12">
			<label for="inputAddress" class="form-label">DNI</label> <input
				name="dni" placeholder="Escribir DNI" type="number"
				class="form-control" id="inputAddress">
		</div>
		<div class="col-md-6">
			<label for="inputEmail4" class="form-label">Nombre</label> <input
				name="nombre" placeholder="Escribe Nombre" type="text"
				class="form-control" id="inputEmail4">
		</div>
		<div class="col-md-6">
			<label for="inputPassword4" class="form-label">Apellido</label> <input
				name="apellido" placeholder="Escribe Apellido" type="text"
				class="form-control" id="inputPassword4">
		</div>
		<div class="col-12">
			<label for="inputAddress" class="form-label">Edad</label> <input
				name="edad" placeholder="Escribir edad" type="number"
				class="form-control" id="inputAddress">
		</div>
		<div class="col-12">
			<label for="inputAddress2" class="form-label"> Direccion</label> <input
				name="direccion" placeholder="Escribe Direccion" type="text"
				class="form-control" id="inputAddress2">
		</div>
		<div class="col-md-6">
			<label for="inputCity" class="form-label">fechaNacimiento</label> <input
				name="fecha" placeholder="" type="date" class="form-control"
				id="inputCity">
		</div>
		<div class="col-12">
			<button name="boton" type="submit" value="registrar"
				class="btn btn-danger">Registrar</button>
			<button name="boton" type="submit" value="eliminar"
				class="btn btn-primary">Eliminar</button>
			<button type="submit" name="boton" value="editar"
				class="btn btn-primary">Editar</button>
			<button type="submit" name="boton" value="listar"
				class="btn btn-danger">Listar</button>
		</div>
			${mensaje}
		
	</form>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>