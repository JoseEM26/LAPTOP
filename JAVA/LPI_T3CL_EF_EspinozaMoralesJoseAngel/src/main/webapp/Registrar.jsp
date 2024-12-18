<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h1>Registrar</h1>
		
		
		<form class="row g-3" method="post" action="registrar">
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Nombre del Proyecto</label> <input
				placeholder="nombre" name="nombre" type="text" class="form-control" id="inputEmail4">
			</div>
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Tipo Proyecto</label> 
                <select class="form-control" name="tipo">
					<option selected>Choose...</option>
					<c:forEach var="x" items="${cmb }">
					<option value="${x.id_tipo }">${x.des_tipo_proy }</option>
					</c:forEach>
                </select>
			</div>
			<div class="col-12">
				<label for="inputAddress" class="form-label">Presupuesto</label> <input
					type="number" class="form-control" id="inputAddress"
					placeholder="00.00" name="presupuesto">
			</div>
			<div class="col-12">
				<label for="inputAddress2" class="form-label">Fecha de Inicio 2</label> <input
					type="date" class="form-control" id="inputAddress2" name="fecha"
					placeholder="">
			</div>
			<div class="col-md-6">
				<label for="inputCity" class="form-label">Duracion</label> <input name="duracion"
					type="number" class="form-control" id="inputCity">
		
			<div class="col-12">
				<button type="submit" class="btn btn-secondary"> registrar</button>
			</div>
		</form>
		${mensaje }
	</div>
</body>
</html>