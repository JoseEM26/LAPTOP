<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mantenimiento - Boletas</title>
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
	crossorigin="anonymous"></script>
</head>

<body>

	<!-- Cabecera y Navegación -->
	<jsp:include page="fragmetos/Nav.jsp"></jsp:include>

	<!-- Masthead -->
	<jsp:include page="fragmetos/header.jsp"></jsp:include>

	<div id="contenedor">
		<div class="container bg-white">
			<div class="row">
				
				<div class="col">
					<fmt:setLocale value="es-PE" />
					<!-- Tabla de Boletas -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Número de Boleta</th>
								<th scope="col">Fecha</th>
								<th scope="col">Usuario</th>
								<th scope="col">Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstBoletas}" var="boleta">
								<tr>
									<td>${boleta.num_bol}</td>
									<td>${boleta.fch_bol}</td>
									<td>
										<c:forEach items="${lstUsuarios}" var="usuario">
											<c:if test="${usuario.idUsuario == boleta.id_usuario}">
												${usuario.nombreUsuario}
											</c:if>
										</c:forEach>
									</td>
									<td>
										<div class="d-flex">
											<a href="mostrarCabezeraBoleta?numBol=${boleta.num_bol}"
												class="btn btn-outline-primary me-2">MostrarDatos</a>
											
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
