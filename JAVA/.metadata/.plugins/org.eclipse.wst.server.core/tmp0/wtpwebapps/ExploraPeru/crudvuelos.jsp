<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mantenimiento - Vuelos</title>
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
					<h2>Mantenimiento de Vuelos</h2>
					<form class="row g-3" action="crudvuelos" method="post">
						<div class="col-12">
							<label for="inputIdVuelo" class="form-label">Destino</label> <select
								name="lugar" class="form-control">
								<option selected="selected" value="0">Selecionar......</option>
								<c:forEach var="x" items="${lstDestinos}">
									<option value="${x.idDestino }">${x.destino }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6">
							<label for="inputFechaSalida" class="form-label">Fecha de
								Salida</label> <input name="fechaSalida" type="date"
								class="form-control" id="inputFechaSalida">
						</div>
						<div class="col-md-6">
							<label for="inputFechaLlegada" class="form-label">Fecha
								de Llegada</label> <input name="fechaLlegada" type="date"
								class="form-control" id="inputFechaLlegada">
						</div>
						<div class="col-md-6">
							<label for="inputPrecio" class="form-label">Precio</label> <input
								name="precio" type="number" min="0" step="0.01"
								class="form-control" id="inputPrecio">
						</div>
						<div class="col-md-6">
							<label for="inputPlazasDisponibles" class="form-label">Plazas
								Disponibles</label> <input name="plazasDisponibles" type="number"
								min="0" class="form-control" id="inputPlazasDisponibles">
						</div>
						<div class="col-md-6">
							<label for="inputImagenUrl" class="form-label">Imagen del
								Vuelo</label> <input name="imagenUrl" type="text" class="form-control"
								id="inputImagenUrl" placeholder="URL de la imagen">
						</div>

						<div class="col-12">
							<button name="btnOpcion" value="reg" type="submit"
								class="btn btn-primary">
								<i class="fa-regular fa-floppy-disk"></i> Registrar
							</button>



							${mensaje}
						</div>
					</form>
				</div>
				<div class="col">
					<fmt:setLocale value="es-PE" />
					<!-- Tabla de Vuelos -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Imagen</th>
								<!-- Columna para la imagen -->
								<th scope="col">Destino</th>
								<th scope="col">Fecha de Salida</th>
								<th scope="col">Fecha de Llegada</th>
								<th scope="col">Precio</th>
								<th scope="col">Plazas Disponibles</th>
								<th scope="col">Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstVuelos}" var="vuelo">
								<tr>
									<!-- Mostrar la imagen en la tabla -->
									<td><img src="${vuelo.imagenUrl}" alt="Imagen de vuelo"
										style="width: 50px; height: 50px; object-fit: cover;" /></td>
									<!-- Mostrar el destino correspondiente -->
									<td><c:forEach items="${lstDestinos}" var="destino">
											<c:if test="${destino.idDestino == vuelo.idDestino}">
                            ${destino.destino}
                        </c:if>
										</c:forEach></td>
									<td>${vuelo.fechaSalida}</td>
									<td>${vuelo.fechaLlegada}</td>
									<td><fmt:formatNumber value="${vuelo.precio}"
											type="currency" /></td>
									<td>${vuelo.plazasDisponibles}</td>
									<td>
										<div class="d-flex">
											<a href="mostrarVuelo?id=${vuelo.idVuelo}"
												class="btn btn-outline-primary me-2">Editar</a>
												 <a
												href="eliminarVuelo?id=${vuelo.idVuelo}"
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
