<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
	<h1>Tabla Buses</h1>
	<div class="container">

		<div>
			<form action="tabla" method="post">
				<select name="id">
					<option selected value="0">Open this select menu</option>
					<c:forEach var="x" items="${combo}">
						<option value="${x.id_ruta}">${x.nom_ruta}</option>
					</c:forEach>
				</select> <input type="submit" class="btn btn-secondary" value="Consultar">
			</form>
		</div>



		<table class="table">
			<thead>
				<tr>
					<th scope="col">id_bus</th>
					<th scope="col">nom_choferes</th>
					<th scope="col">Ape_choferes</th>
					<th scope="col">num_choferes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="y">
					<tr>
						<td>${y.id_bus}</td>
						<td>${y.nom_choferes}</td>
						<td>${y.Ape_choferes}</td>
						<td>${y.num_choferes}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>


	</div>



	<a href="tabla">Link tabla</a>


</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>