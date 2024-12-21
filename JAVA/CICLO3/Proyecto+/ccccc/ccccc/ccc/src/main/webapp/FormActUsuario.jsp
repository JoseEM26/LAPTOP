<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Estilos/boostrap.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="Estilos/FormActUsuario.css"><script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
	<jsp:include page="fragmetos/Nav.jsp"></jsp:include>
<body>
	<div class="registration-form">
		<form action="ActualizarUsuario" method="post">
			<div class="form-icon"
				style="display: flex; justify-content: center; align-items: center; width: 120px; height: 120px; background-color: white; border-radius: 50%; padding: 5px;">
				<img alt="Error al encontrar img" src="${u.img}" onerror="this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png'"
					style="width: 100px; height: 100px; border-radius: 50%; object-fit: cover;">
			</div>

			<div class="form-group">
				<label>Nombre Usuario:</label> <input type="text" name="nombre"
					class="form-control item" id="username" value="${u.nombreUsuario }"
					placeholder="Nombre Usuario">
			</div>
			<div class="form-group">
				<label>Email:</label> <input type="text" class="form-control item" name="email"
					id="password" value="${u.email }" placeholder="Correo Electronico">
			</div>
			<div class="form-group">
				<label>Contraseña:</label> <input type="password" name="contrasena"
					class="form-control item" id="email" value="${u.contraseña }"
					placeholder="Antigua Contraseña">
			</div>

			<div class="form-group">
				<label>Fecha Nacimiento:</label> <input type="date" name="fecha"
					class="form-control item" id="birth-date"
					value="${u.fechaCumpleaños }" placeholder="Fecha Nacimiento">
			</div>
			<div class="form-group">
				<label>Telefono:</label> <input type="number" name="telefono"
					class="form-control item" id="birth-date"
					value="${u.telefono }" placeholder="999-999-999">
			</div>
			<div class="form-group">
				<label>Url Imagen:</label> <input type="text" name="img"
					class="form-control item" id="birth-date" value="${u.img }"
					placeholder="Url Imagen">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-block create-account">Actualizar</button>
			</div>
		</form>
		<div class="social-media">
			<h5>Siguenos en nuestras redes sociales</h5>
			<div class="social-icons">
				<a href="#"><i class="icon-social-facebook" title="Facebook"></i></a>
				<a href="#"><i class="icon-social-google" title="Google"></i></a> <a
					href="#"><i class="icon-social-twitter" title="Twitter"></i></a>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="assets/js/script.js"></script>
	








	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>