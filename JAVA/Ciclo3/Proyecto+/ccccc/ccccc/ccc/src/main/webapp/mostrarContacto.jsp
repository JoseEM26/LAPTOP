<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Contacto</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/mostrarVuelo.css">
</head>

<body>
	<div class="container contact-form">
		<div class="contact-image">
			<img src="/" alt="contact_image" onerror="this.src='https://i.ytimg.com/vi/tBkF0hqNV6E/maxresdefault.jpg'" />
		</div>
		<form method="post" action="mostrarContacto?id=${contacto.idContacto}">
			<h3>Actualizar Contacto</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label>Nombre</label>
						<input type="text" name="nombre" class="form-control" value="${contacto.nombreContacto}" required />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label>Email</label>
						<input type="email" name="email" class="form-control" value="${contacto.emailContacto}" required />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label>Teléfono</label>
						<input type="tel" name="telefono" class="form-control" value="${contacto.numeroContacto}" required />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label>Mensaje</label>
						<textarea name="mensaje" class="form-control" rows="4" required>${contacto.mensajeContacto}</textarea>
					</div>
				</div>

				

				<div class="col-md-12 text-center">
					<input class="btn btn-secondary" type="submit" value="Actualizar">
					<button type="button" class="btn btn-outline-secondary" onclick="history.back()">Volver</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
