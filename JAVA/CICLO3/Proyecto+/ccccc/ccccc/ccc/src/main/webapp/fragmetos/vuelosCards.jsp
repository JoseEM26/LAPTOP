<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Vuelos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="css/filtro.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<!-- Filtro de Destinos -->
	<div class="filter-container">
		<form action="vuelos" method="POST">
			<div class="filter-section">
				<label for="destino">Selecciona tu destino:</label> <select
					name="destino" id="destino" class="form-control">
					<option value="">Selecciona un destino</option>
					<c:forEach var="destino" items="${lstDestinos}">
						<option value="${destino.idDestino}">${destino.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary mt-3">Filtrar</button>
		</form>
	</div>

	<!-- Cards de vuelos -->
	<div class="container mt-4">
		<div class="row">
			<c:forEach var="vuelo" items="${lstVuelos}">
				<div class="col-md-4">
					<div class="card">
						<img class="card-img-top" src="img/vuelos/${vuelo.idVuelo}.jpg"
							alt="Vuelo">
						<div class="card-body">
							<h5 class="card-title">${vuelo.origen}- ${vuelo.destino}</h5>
							<p class="card-text">Fecha: ${vuelo.fecha}</p>
							<p class="card-text">Hora: ${vuelo.hora}</p>
							<p class="card-text">Precio: S/.${vuelo.precio}</p>
							<a href="detallesVuelo.jsp?id=${vuelo.idVuelo}"
								class="btn btn-primary">Ver Detalles</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Tabla de vuelos -->
	<div class="container mt-4">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Origen</th>
					<th scope="col">Destino</th>
					<th scope="col">Fecha</th>
					<th scope="col">Hora</th>
					<th scope="col">Precio</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vuelo" items="${lstVuelos}">
					<tr>
						<th scope="row">${vuelo.idVuelo}</th>
						<td>${vuelo.origen}</td>
						<td>${vuelo.destino}</td>
						<td>${vuelo.fecha}</td>
						<td>${vuelo.hora}</td>
						<td>S/.${vuelo.precio}</td>
						<td><a href="detallesVuelo.jsp?id=${vuelo.idVuelo}"
							class="btn btn-outline-primary">Ver</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
