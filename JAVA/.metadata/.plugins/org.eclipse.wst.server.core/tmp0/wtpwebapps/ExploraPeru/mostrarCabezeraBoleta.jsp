<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Cabecera Boleta</title>
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
		</div>
		<form method="post"
			action="mostrarCabeceraBoleta?id=${cabezera.num_bol}">
			<h3>Actualizar Cabecera de Boleta</h3>
			<div class="row">
				<div class="col-md-6">
					<label>CLiente</label> <select class="form-control" name="cliente">
						<c:forEach items="${ssss }" var="x">
							<option value="${x.idUsuario }" <c:if test="${x.idUsuario == cabezera.id_usuario}">selected</c:if>
							>${x.nombreUsuario }</option>
						</c:forEach>
					</select>
				</div>


				<div class="col-md-6">
					<div class="form-group">
						<label>Fecha Emisión</label> <input type="date"
							name="fechaEmision" class="form-control"
							value="${cabezera.fch_bol}" required />
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label>Numero boleta</label> <input type="text" name="direccion"
							class="form-control" value="${cabezera.num_bol}" required />
					</div>
				</div>


				<div class="col-md-12 text-center">
					<button type="button" class="btn btn-outline-secondary"
						onclick="history.back()">Volver</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
