<!DOCTYPE html>
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
</head>

<body>
	<div id="contenedor">
		<jsp:include page="fragmento/cabecera.jsp"></jsp:include>
		<jsp:include page="fragmento/menu_nav.jsp"></jsp:include>

		<nav>
			<a href="#">Nosotros</a>
			<a href="login">Cerrar sesión</a>
		</nav>
		<main>
			<aside>
				<h3>Categorís</h3>
				<a href="#">Pastillas</a> <a href="#">Jarabes</a> <a href="#">Cuidado</a>
			</aside>
			<section>
				<figure>
					<img src="img/productos/vacio.png">
					<figcaption>Categoría 1</figcaption>
				</figure>
				<figure>
					<img src="img/productos/vacio.png">
					<figcaption>Categoría 1</figcaption>
				</figure>
				<figure>
					<img src="img/productos/vacio.png">
					<figcaption>Categoría 1</figcaption>
				</figure>
			</section>
			<aside></aside>
		</main>
		<footer>
			<img src="img/iconos/facebook_icon.png">
			<p>Derechos Reservados. Lima, Perú - 2024</p>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
