<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mantenimiento - Detalle Boleta</title>
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
				<div class="col">
					<fmt:setLocale value="es-PE" />
					<!-- Tabla de Detalle Boletas -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">N°Boleta</th>
								<th scope="col">Id Viaje</th>
								<th scope="col">Cantidad</th>
								<th scope="col">Precio</th>
								<th scope="col">Acciones</th>
							
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstDetBoletas}" var="detalle">
								<tr>
									<td>${detalle.num_bol}</td>
									<td>${detalle.id_destino}</td>
									<td>${detalle.cantidad}</td>
									<td>${detalle.preciovta}</td>
									<td>
										<div class="d-flex">
											<a href="mostrarDetBoleta?numBol=${detalle.num_bol}&idDestino=${detalle.id_destino}"
												class="btn btn-outline-primary me-2">Editar</a> 
											<!-- Enlace para eliminar detalle de la boleta, pasando numBol y idDestino -->
											<a href="EliminarDetalleBoleta?numBol=${detalle.num_bol}&idDestino=${detalle.id_destino}"
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
