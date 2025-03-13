<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListadoEspinoza</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>


</head>
<body>
	<jsp:include page="fragmentos/nav.jsp"></jsp:include>
	<div class="container">
		<h1>Listado</h1>
		<div style="text-align: right;">
			<a href="registrar" class="btn btn-primary">Nuevo +</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Nombre</th>
					<th scope="col">Fecha Inicio</th>
					<th scope="col">Presupuesto</th>
					<th scope="col">Editar</th>
				</tr>
			</thead>
			<tbody>
				<fmt:setLocale value="es-PE" />
				<c:forEach var="x" items="${lista}">
					<tr>
						<th scope="row">${x.cod_proyecto }</th>
						<td>${x.nom_proyecto }</td>
						<td>${x.fecha_inicio }</td>
						<td><fmt:formatNumber value="${x.presupuesto}"
								type="currency"></fmt:formatNumber></td>
						<td><a href="editar?id=${x.cod_proyecto }"
							class="btn btn-secondary">editar</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	${mensaje }
</body>
</html>