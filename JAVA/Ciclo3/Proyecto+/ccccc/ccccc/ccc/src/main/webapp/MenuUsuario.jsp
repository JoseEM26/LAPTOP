<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Menu</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="Estilos/Index.css" rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>




</head>
<body id="page-top">
	<!-- header-bg -->
	<!-- Navigation-->
	<jsp:include page="fragmetos/Nav.jsp"></jsp:include>

	<!-- Masthead-->
	<jsp:include page="fragmetos/header.jsp"></jsp:include>


	<!-- Services-->
	<jsp:include page="fragmetos/Servicios.jsp"></jsp:include>


	<!-- Portfolio Grid-->
	<jsp:include page="fragmetos/portafolio.jsp"></jsp:include>

	<!-- About-->
	<jsp:include page="fragmetos/Carrusel.jsp"></jsp:include>

	<!-- Team-->
	<jsp:include page="fragmetos/comentario.jsp"></jsp:include>

	<!-- Clients-->
	<jsp:include page="fragmetos/contactos.jsp"></jsp:include>

	<!-- Contact-->
	<jsp:include page="fragmetos/formComent.jsp"></jsp:include>

	<!-- Footer-->
	<jsp:include page="fragmetos/footer.jsp"></jsp:include>

	<!-- Portfolio Modals-->
	<!-- Portfolio item 1 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Santuario Histórico de Machu
									Picchu</h2>
								<p class="item-intro text-muted">Cuzco</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/1.webp" alt="..." />
								<p>Es el mayor atractivo turístico del Perú y la máxima
									expresión de la arquitectura prehispánica en Sudamérica.
									Construida a finales del siglo XV por órdenes del inca
									Pachacutec, Machu Picchu es una ciudadela imponente, enclavada
									en una montaña de la selva alta. Considerada como una de las
									Siete Maravillas del Mundo Moderno, la “montaña vieja” (ese es
									su nombre en español) no solo es arqueología. La naturaleza
									aquí es prodigiosa y alberga una interesante diversidad de
									especies de flora y fauna. Estas le dan vida y hermosean un
									santuario boscoso a 2430 m s.n.m.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 2 horas</li>
									<li><strong>Costo:</strong> S/.550</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio item 2 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Complejo Arqueológico Chan Chan</h2>
								<p class="item-intro text-muted">a 5 kilómetros de Trujillo
								</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/2.webp" alt="..." />
								<p>Una ciudad de barro con 9 templos amurallados con
									representaciones zoomorfas. Una urbe costera de 20 km² de
									extensión que, en su apogeo, albergó hasta 100 000 personas.
									Una obra arquitectónica que fue el centro del poder de los
									chimú (700 a 1400 d. C.), una civilización prehispánica del
									norte del Perú. Chan Chan (Sol Sol en español) es una evidencia
									arqueológica de que el desarrollo en el antiguo Perú, no se
									limita a la zona andina ni a la avanzada organización social,
									militar y agrícola del imperio incaico.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 2 horas</li>
									<li><strong>Costo:</strong> S/.550</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio item 3 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Islas Ballestas</h2>
								<p class="item-intro text-muted">Pisco</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/3.webp" alt="..." />
								<p>El Perú no solo es pampas y cordilleras. Su costa
									desértica es el refugio de diversas especies de la fauna
									marina. Eso es lo que descubrirás en Ballesta, un conjunto de
									pequeñas islas frente a la península de Paracas (provincia de
									Pisco, región Ica). Tu aventura en el Pacífico peruano
									comenzará en el muelle artesanal El Chaco, donde zarpan las
									embarcaciones hacía Ballestas, donde avistarás —siempre desde
									el mar— colonias de lobos marinos y nutrias, además de
									pingüinos de Humboldt, pelícanos, cormoranes de patas rojas,
									zarcillos y piqueros, entre otras aves.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 1 horas</li>
									<li><strong>Costo:</strong> S/.250</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio item 4 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Reserva Nacional Titicaca</h2>
								<p class="item-intro text-muted">Puno</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/4.webp" alt="..." />
								<p>Un lugar legendario con islas tejidas con totora, con
									playas que parecen extraídas del Caribe y comunidades
									organizadas para recibir a los turistas. Todo eso y mucho más
									en el lago Titicaca que en sus 8300 km² de extensión
									compartidos por Perú y Bolivia, alberga 530 especies acuáticas
									de flora y fauna.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 4 horas</li>
									<li><strong>Costo:</strong> S/.150</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio item 5 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Líneas y geoglifos de Nazca</h2>
								<p class="item-intro text-muted">Ica</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/5.webp" alt="..." />
								<p>Uno de los mayores misterios arqueológicos del planeta se
									encuentra en el Perú. Diversas teorías —terrenales, cósmicas y
									hasta interplanetarias— tratan de explicar el origen de las
									líneas de Nazca, cuyos geoglifos representan seres
									antropomorfos, zoomorfos y fitomorfos, además de figuras
									geométricas trazadas en el siglo V a. C. en una pampa de 500
									km². Reconocidas como Patrimonio Cultural de la Humanidad por
									la Unesco en 1994, las enigmáticas líneas elaboradas por los
									hombres de la cultura nazca, solo se ven a plenitud desde el
									aire. Esta peculiaridad genera diversas interpretaciones
									científicas y místicas que generan un aura de misteriosa.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 2 horas</li>
									<li><strong>Costo:</strong> S/.150</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio item 6 modal popup-->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-bs-dismiss="modal">
					<img src="assets/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project details-->
								<h2 class="text-uppercase">Centro Histórico de Lima</h2>
								<p class="item-intro text-muted">Lima</p>
								<img class="img-fluid d-block mx-auto"
									src="assets/img/portfolio/6.webp" alt="..." />
								<p>Es un error turístico pensar que Lima es solo un lugar de
									paso. Fundada el 18 de enero de 1535 por el español Francisco
									Pizarro, la capital peruana conserva en su Centro Histórico,
									iglesias, casonas y conventos que son auténticas maravillas de
									la arquitectura colonial. Declarado Patrimonio Cultural de la
									Humidad por la Unesco en 1991, las calles de la vieja Lima te
									conducirán a espacios urbanos monumentales, como la plaza de
									Armas, la Catedral, el convento de San Francisco, el Palacio de
									Gobierno, el jirón de La Unión, entre otros lugares que te
									transportarán en el tiempo.</p>
								<ul class="list-inline">
									<li><strong>Tiempo de viaje:</strong> 30 minutos</li>
									<li><strong>Costo:</strong> S/.50</li>
								</ul>
								<button class="btn btn-primary btn-xl text-uppercase"
									data-bs-dismiss="modal" type="button">
									<i class="fas fa-xmark me-1"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
${mensaje }
</body>

</html>
