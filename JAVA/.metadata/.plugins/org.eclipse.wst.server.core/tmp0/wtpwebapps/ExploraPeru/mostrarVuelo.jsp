<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Vuelo</title>
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
			<img src="${v.imagenUrl }"
				alt="rocket_contact" />
		</div>
		<form method="post" action="mostrarVuelo?id=${v.idVuelo }">
			<h3>Actualiza uno de los Vuelos</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label>Destino</label>
						<select class="form-control" name="destino">
							<c:forEach var="x" items="${lstDestinos}">
								<option value="${x.idDestino}"
									<c:if test="${x.idDestino == v.idDestino}">selected</c:if>>
									${x.destino}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label>Fecha Salida</label>
						<input type="date" name="fechaSalida" class="form-control" value="${v.fechaSalida }" />
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label>Fecha Llegada</label>
						<input type="date" name="fechaLlegada" class="form-control" value="${v.fechaLlegada }" />
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label>Precio</label>
						<input type="number" name="precio" class="form-control" value="${v.precio }" />
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label>Plaza disponibilidad</label>
						<input type="number" name="plazasDisponibles" class="form-control" value="${v.plazasDisponibles }" />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label>Imagen URL</label>
						<input type="text" name="imagenUrl" class="form-control" value="${v.imagenUrl }" />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label>Lugar</label>
						<input type="text" name="lugar" class="form-control" value="${v.lugar }" />
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
