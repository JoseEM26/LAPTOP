<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ciberfarma</title>
<!-- CSS only -->
<link href="css/estilos.css" rel="stylesheet">
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- CSS Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	referrerpolicy="no-referrer" />
	<link href="css/estilos.css" rel="stylesheet">
</head>

<body>
	<div id="contenedor">
		<jsp:include page="fragmento/cabecera.jsp"></jsp:include>
		<jsp:include page="fragmento/menu_nav.jsp"></jsp:include>
		<main>
			<aside>
				<h3>Categorías</h3>
				<a href="filtro?categoria=1">Pastillas</a> <a
					href="filtro?categoria=2">Jarabes</a> <a href="filtro?categoria=5">Cuidado</a>
			</aside>
			<section>
				<div class="row">
					<div class="col-4">
						<img alt="" src="img/productos/${p.idprod }.png" width="200px" height="200px">
					</div>
					<div class="col-8">
						<h1></h1>
						<form action="agregar" method="post" class="row g-3">
							<div class="mb-3 row">
								
							</div>
							<div class="mb-3 row">
								<label for="inputCod" class="col">Código:</label>
								<label for="inputCod" class="col">${p.idprod }</label>
							</div>
							<div class="mb-3 row">
								<label for="inputDes" class="col">Descripción:</label>
								<label for="inputDes" class="col">${p.descripcion }</label>
							</div>
							<div class="mb-3 row">
								<label for="inputPre" class="col">Precio:</label>
								<label for="inputPre" class="col">${p.precio }</label>
							</div>
							<div class="mb-3 row">
								<label for="inputCan" class="col">Cantidad:</label>
								<div class="col">
									<input type="number" id="inputCan" name="cantidad" 
										class="form-control" min="1" max="${p.stock }" 
										placeholder="Ingrese cantidad" required="required" 
										value="1">
									<div id="emailHelp" class="form-text">Stock máx. ${p.stock } unidades</div>
								</div>
							</div>
							<div class="col-12">
								<button type="submit" class="btn btn-primary">
									Agregar al carro <i class="fas fa-shopping-cart"></i>
								</button>
							</div>
						</form>

					</div>
				</div>
			</section>
		</main>
		<footer>
			<img src="img/iconos/facebook_icon.png">
			<p>Derechos Reservados. Lima, Perú - 2024</p>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>