<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegistroEspinoza</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>
<body>
	<jsp:include page="fragmentos/nav.jsp"></jsp:include>
	<div class="container">
		<h1>Mantenimiento</h1>


		<form class="row g-3" method="post" action="editar?id=${p.cod_proyecto }">
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Nombre del
					Proyecto</label> <input value="${p.nom_proyecto }" placeholder="nombre"
					name="nombre" type="text" class="form-control" id="inputEmail4">
			</div>
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Tipo Proyecto</label>
				<select class="form-control" name="tipo">
					<option value="0" disabled>Choose...</option>
					<c:forEach var="x" items="${cmb}">
						<option value="${x.id_tipo}"
							${x.id_tipo == p.id_tipo ? 'selected' : ''}>${x.des_tipo_proy}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-12">
				<label for="inputAddress" class="form-label">Presupuesto</label> <input
					type="number" class="form-control" id="inputAddress"
					value="${p.presupuesto }" placeholder="00.00" name="presupuesto">
			</div>
			<div class="col-12">
				<label for="inputAddress2" class="form-label">Fecha de
					Inicio 2</label> <input value="${p.fecha_inicio }" type="date"
					class="form-control" id="inputAddress2" name="fecha" placeholder="">
			</div>
			<div class="col-md-6">
				<label for="inputCity" class="form-label">Duracion</label> <input
					name="duracion" value="${p.duracion }" type="number"
					class="form-control" id="inputCity">

				<div class="col-12">
					<button type="submit" class="btn btn-primary">Actualizar</button>
					<a href="eliminar?id=${p.cod_proyecto }" class="btn btn-danger">Eliminar</a>
				</div>
		</form>
		${mensaje }
	</div>
</body>
</html>