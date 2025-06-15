<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet" integrity="sha512-mXN1mJ0L9Cdy8yA7ukrCekjULczTvdRS19WBWgB7c8H0q9VsCcb2Yk8Z8+S65D9iFLnHQ5cxlvKhFgFtmgUPag==" crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>
<body>
	<div class="container">
		<br> <br> ${lista }
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NOMBRE</th>
					<th scope="col">APELLIDO</th>
					<th scope="col">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${lista }">
					<tr>
						<td>${x.id }</td>
						<td>${x.nombre }</td>
						<td>${x.apellido }</td>
						<td>
    <a href="#" class="btn btn-outline-warning">
        Editar 
    </a>
</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<i class="bi bi-plus"></i>
	</div>
	<a href="IndexServlt">Link</a>
</body>
</html>