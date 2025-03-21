<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ciberfarma</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="css/estilos.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
	<div id="contenedor">
		<jsp:include page="fragmento/cabecera.jsp"></jsp:include>
		<jsp:include page="fragmento/menu_nav.jsp"></jsp:include>

		<nav>
			<a href="#">Nosotros</a> <a href="login">Cerrar sesi�n</a>
		</nav>
		<main>
			<aside>
				<h3>Categor�as</h3>
				<a href="#">Pastillas</a> <a href="#">Jarabes</a> <a href="#">Cuidado</a>
			</aside>
			<div class="container bg-white">
				<div class="row">
					<div class="col-md-3">
						<h3>Filtro</h3>
						<form class="row g-3" action="xxxxx" method="post">
						
							<div class="col-12">
								<label for="inputState" class="form-label">Categor�a</label> 
								<select name="categoria" id="inputState" class="form-select">
									<option value="0" selected>Seleccione...</option>
									<c:forEach var="c" items="${lstCategorias }">
										<option value="${c.idcategoria }">${c.descripcion }</option>
									</c:forEach>									
								</select>
							</div>

							<div class="col-12">
								<button name="btnOpcion" value="lst" type="submit"
									class="btn btn-primary">Aplicar Fitro</button>
							</div>
						</form>
					</div>
					<div class="col-md-9">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Nombre</th>
									<th scope="col">Stock</th>
									<th scope="col">Precio</th>
									<th scope="col">Categor�a</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<fmt:setLocale value="es-PE"/>
x								<c:forEach items="${lstProductos }" var="p">
									<tr>
										<%-- <th scope="row">${p.getIdprod() }</th> --%>
										<th scope="row">
										<img alt="foto" src="img/productos/${p.getIdprod() }.png" width="100px"></th>
										<td>${p.descripcion }</td>
										<td>${p.stock }</td>
										<td><fmt:formatNumber value="${p.getPrecio() }" type="currency"></fmt:formatNumber> </td>
										<td>${p.idcategoria }</td>
										<td><a href="#" class="btn btn-outline-primary">
											Editar <i class="fa-regular fa-pen-to-square"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<img src="img/iconos/facebook_icon.png">
			<p>Derechos Reservados. Lima, Per� - 2024</p>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
