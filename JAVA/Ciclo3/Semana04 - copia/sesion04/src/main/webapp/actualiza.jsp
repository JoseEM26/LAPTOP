<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ciberfarma</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="css/estilos.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
	<div id="contenedor">
		<jsp:include page="fragmento/cabecera.jsp"></jsp:include>
		<jsp:include page="fragmento/menu_nav.jsp"></jsp:include>

		<nav>
			<a href="#">Nosotros</a> <a href="login">Cerrar sesión</a>
		</nav>
		<main>
			<aside>
				<h3>Categorías</h3>
				<a href="#">Pastillas</a> <a href="#">Jarabes</a> <a href="#">Cuidado</a>
			</aside>
			<div class="container bg-white">
				<div class="row">
					<div class="col">
						<h2>Actualiza datos</h2>
						<form class="row g-3" action="actuser" method="post">

							<div class="col-12">
								<label for="inputAddress" class="form-label">Código</label> 
								<input name="codigo" disabled="disabled"
									type="text" class="form-control" value="${u.codigo }"
									id="inputAddress" placeholder="Código">
							</div>
							<div class="col-12">
								<label for="inputAddress2" class="form-label">Nombre</label>
								<input name="nombre" type="text" value="${u.nombre }" 
									 class="form-control"
									id="inputAddress2" placeholder="Nombre" maxlength="15">
							</div>
							<div class="col-md-12">
								<label for="inputEmail4" class="form-label">Apellido</label>
								<input name="apellido" value="${u.apellido }"
									type="text" maxlength="25" class="form-control"
									id="inputEmail4" placeholder="Apellido">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Usuario</label> 
								<input type="email" maxlength="45" name="usuario" value="${u.usuario }"
									class="form-control" id="inputPassword4" disabled="disabled"
									placeholder="Correo">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Clave</label> 
								<input type="text" maxlength="5" name="clave" value="${u.clave }"
									class="form-control" id="inputPassword4" 
									placeholder="Clave">
							</div>

							<div class="col-12">
								<button name="btnOpcion" value="act" type="submit"
									class="btn btn-primary">Actualizar</button>
							</div>
							<div class="col-12">${mensaje }</div>
						</form>
					</div>
					<div class="col">
						
					</div>
				</div>
			</div>
		</main>
		<footer>
			<img src="img/iconos/facebook_icon.png">
			<p>Derechos Reservados. Lima, Perú - 2024</p>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
