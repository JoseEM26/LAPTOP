<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<br>
	<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">nombre</th>
					<th scope="col">descripcion</th>
					<th scope="col">precio</th>
					<th scope="col">stock</th>
					<th scope="col">categoria</th>
					<th scope="col">Date</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${lista}">
					<tr>
						<th scope="row">${x.id}</th>
						<td>${x.nombre}</td>
						<td>${x.descripcion}</td>
						<td>${x.precio}</td>
						<td>${x.stock}</td>
						<td>${x.categoria}</td>
						<td>${x.fecha_creacion}</td>
						<td><a href="#" class="btn btn-outline-primary"> Editar <i
								class="fa-regular fa-pen-to-square"></i></a></td>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		${lista }
		
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>