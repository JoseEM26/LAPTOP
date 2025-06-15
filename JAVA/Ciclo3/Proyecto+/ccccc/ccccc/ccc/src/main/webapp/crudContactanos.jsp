<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mantenimiento - Contactos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="Estilos/Index.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
</head>

<body>

	<!-- Cabecera y Navegación -->
	<jsp:include page="fragmetos/Nav.jsp"></jsp:include>

	<!-- Masthead -->
	<jsp:include page="fragmetos/header.jsp"></jsp:include>

	<div id="contenedor">
		<div class="container bg-white">
			<div class="row"  style="margin: 50px 20px 0px 30px">
			<%-- 	<div class="col">
					<h2>Mantenimiento de Contactos</h2>
					<form class="row g-3" action="crudcontacto" method="post">
						<div class="col-md-6">
							<label for="inputNombre" class="form-label">Nombre</label> <input
								name="nombre" type="text" class="form-control" id="inputNombre"
								required>
						</div>
						<div class="col-md-6">
							<label for="inputApellido" class="form-label">Apellido</label> <input
								name="apellido" type="text" class="form-control"
								id="inputApellido" required>
						</div>
						<div class="col-md-6">
							<label for="inputEmail" class="form-label">Email</label> <input
								name="email" type="email" class="form-control" id="inputEmail"
								required>
						</div>
						<div class="col-md-6">
							<label for="inputTelefono" class="form-label">Teléfono</label> <input
								name="telefono" type="text" class="form-control"
								id="inputTelefono" required>
						</div>

						<div class="col-12">
							<button name="btnOpcion" value="reg" type="submit"
								class="btn btn-primary">
								<i class="fa-regular fa-floppy-disk"></i> Registrar
							</button>
							${mensaje}
						</div>
					</form>
				</div> --%>
				<div class="col">
					<fmt:setLocale value="es-PE" />
					<!-- Tabla de Contactos -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">N°Contacto</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col">Teléfono</th>
								<th scope="col">mensaje</th>
								<th scope="col">Acciones</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstContactos}" var="contacto">
								<tr>
									<td>${contacto.idContacto}</td>
									<td>${contacto.nombreContacto}</td>
									<td>${contacto.emailContacto}</td>
									<td>${contacto.numeroContacto}</td>
									<td>${contacto.mensajeContacto}</td>

									<td>
										<div class="d-flex">
											<a href="mostrarContacto?id=${contacto.idContacto}"
												class="btn btn-outline-primary me-2">Editar</a> <a
												href="eliminarContacto?id=${contacto.idContacto}"
												class="btn btn-outline-danger">Eliminar</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="fragmetos/footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
