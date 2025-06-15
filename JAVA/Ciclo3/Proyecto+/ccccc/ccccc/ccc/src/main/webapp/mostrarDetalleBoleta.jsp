<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Detalle Boleta</title>
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
			<img src="https://as2.ftcdn.net/v2/jpg/00/82/31/47/1000_F_82314794_keVT6Wt8KmJLa6jMjUikFtCdBCPUD33n.jpg" alt="contact_image"
				onerror="this.src='https://i.ytimg.com/vi/tBkF0hqNV6E/maxresdefault.jpg'" />
		</div>
		<!-- El formulario ahora actualizará los detalles de la boleta -->
		<form method="post"
			action="mostrarDetBoleta?numBol=${detalle.num_bol}&idDestino=${detalle.id_destino}">
			<h3>Actualizar Detalle Boleta</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="idDestino">NumBoleta</label> <input type="text"
							name="numBol" id="idDestino" class="form-control"
							value="${detalle.num_bol}" />
					</div>
				</div>
				<div class="col-md-12"><label for="idDestino">Destino</label> 
					<select class="form-control">
						<c:forEach var="x" items="${cmb }">
							<option value="${x.idDestino }"  <c:if test="${x.idDestino == detalle.id_destino }">selected</c:if> >${x.destino }</option>

						</c:forEach>
					</select>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label for="cantidad">Cantidad</label> <input type="number"
							name="cantidad" id="cantidad" class="form-control"
							value="${detalle.cantidad}" required />
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label for="precio">Precio</label> <input type="number"
							name="precio" id="precio" class="form-control"
							value="${detalle.preciovta}" required />
					</div>
				</div>

				<div class="col-md-12 text-center">
					<input class="btn btn-secondary" type="submit" value="Actualizar">
					<button type="button" class="btn btn-outline-secondary"
						onclick="history.back()">Volver</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
