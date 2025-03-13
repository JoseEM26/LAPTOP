<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Vuelos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="Estilos/Index.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<!-- Cabecera y Navegación -->
	<jsp:include page="fragmetos/Nav.jsp"></jsp:include>

	<!-- Masthead -->
	<jsp:include page="fragmetos/header.jsp"></jsp:include>

	<!-- Filtro de Búsqueda de Vuelos -->
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-4">
				<h3>Filtro de Vuelos</h3>
				<form class="row g-3" action="vuelos" method="post">
					<div class="col-12">
						<label for="inputDestino" class="form-label">Destino</label> <select
							name="destino" id="inputDestino" class="form-select">
							<option value="0" selected>Seleccione...</option>
							<c:forEach var="destino" items="${lstDestinos}">
								<option value="${destino.idDestino}">${destino.destino}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-12">
						<button name="btnFiltro" value="lstVuelos" type="submit"
							class="btn btn-primary">Aplicar Filtro</button>
					</div>
				</form>
			</div>

			<div class="col-md-8">
				<h3>Vuelos Disponibles</h3>

				<!-- Tarjetas de Vuelos -->
				<div class="row">
					<fmt:setLocale value="es-PE" />
					<c:forEach items="${lstVuelos}" var="vuelo">
						<div class="col-md-4 mb-4">
							<div class="card">
								<!-- Mostrar la imagen del vuelo -->
								<img src="${vuelo.imagenUrl}" class="card-img-top" onerror="this.src='https://i.ytimg.com/vi/tBkF0hqNV6E/maxresdefault.jpg'"
									alt="Imagen de vuelo" style="height: 200px; object-fit: cover;">
								<div class="card-body">
									<h5 class="card-title">${vuelo.fechaSalida}-
										${vuelo.fechaLlegada}</h5>

									<!-- Mostrar el destino y lugar -->
									<c:forEach items="${lstDestinos}" var="destino">
										<c:if test="${destino.idDestino == vuelo.idDestino}">
											<p class="card-text">${destino.destino}</p>
											<p class="card-text text-muted">${vuelo.lugar}</p>
										</c:if>
									</c:forEach>

									<p class="card-text" style="color: red; font-weight: bold;">
										<fmt:formatNumber value="${vuelo.precio }" type="currency"></fmt:formatNumber>
									</p>
									<a href="VerVuelo?id=${vuelo.idVuelo}"
										class="btn btn-outline-primary">Ver Detalles</a>
								</div>
							</div>
						</div>
					</c:forEach>
				<%-- </div>

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
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lstVuelos}" var="vuelo">
							<tr>
								<!-- Mostrar la imagen en la tabla -->
								<td><img src="${vuelo.imagenUrl}" alt="Imagen de vuelo"
									style="width: 50px; height: 50px; object-fit: cover;" /></td>
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
								<td><a href="verVuelo?id=${vuelo.idVuelo}"
									class="btn btn-outline-primary">Ver Detalles</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
 --%>		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="fragmetos/footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>

</html>
