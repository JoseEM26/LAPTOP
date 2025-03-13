<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Explora Perú</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons -->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Tinos:wght@400;700&family=DM+Sans:wght@400;500;700&display=swap"
	rel="stylesheet" />
<!-- Core CSS (includes Bootstrap) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<!-- CSS --> 
<link href="css/prev.css" rel="stylesheet" />
<link href="css/login_styles.css" rel="stylesheet" />

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<!-- Background Video -->
	<video class="bg-video" playsinline="playsinline" autoplay="autoplay"
		muted="muted" loop="loop">
		<source src="mp4/bg_p.mp4" type="video/mp4" />
	</video>

	<!-- Masthead -->
	<div class="masthead">
		<div class="masthead-content text-white">
			<div class="container-fluid px-4 px-lg-0">
				<h1 class="fst-italic lh-1 mb-4">Explora Perú - La Aventura
					Comienza</h1>
				<p class="mb-5">Desde las majestuosas cumbres de los Andes hasta
					los misterios de la Amazonía, podrás descubrir y planificar
					aventuras inolvidables. Inicia sesión para conocer nuestras ofertas
					exclusivas y tours personalizados.</p>

				<!-- Boton de Modal -->
				<button class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#loginModal">Iniciar Sesión</button>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="container">

						<!-- Panel que contiene login y registro -->
						<div class="panel-wrapper">

							<!-- Panel de Iniciar Sesión -->
							<div class="login-panel">
								<div class="login-form">
									<h2>Iniciar Sesión</h2>
									<div class="social-login">
										<button class="btn-google">
											<img src="img/iconos/g_icon.png">
										</button>
										<button class="btn-facebook">
											<img src="img/iconos/f_icon.png">
										</button>
									</div>
									<p>o ingresa tu correo y contraseña</p>

									<!-- Inicio formulario -->
									<form action="Login" method="post">
										<input type="email" placeholder="Correo" id="correoLogin"
											name="email" required> 
										<input type="password"
											placeholder="Contraseña" id="contrasenaLogin"
											name="contrasena" required>
										<button type="submit" class="btn-login">Ingresar</button>
										<%-- <div>${mensaje }${requestScope.mensaje }</div> --%>
									</form>

									<!-- Fin formulario -->

									<br> <a href="#" class="forgot-password">Olvidé mi
										contraseña</a>
								</div>
								<div class="login-info">
									<h2>Hola, Explorador!</h2>
									<p>Registrate para utilizar todas las funciones del sitio
										web</p>
									<button class="btn-switch" id="goToRegister">Registrarse</button>
								</div>
							</div>

							<!-- Panel de Registro -->
							<div class="register-panel">
								<div class="register-info">
									<h2>Bienvenido, Explorador!</h2>
									<p>Ingresa tus datos para utilizar todas las funciones del
										sitio web</p>
									<button class="btn-switch" id="goToLogin">Iniciar
										Sesión</button>
								</div>
								<div class="register-form">
									<h2>Crear Cuenta</h2>
									<div class="social-login">
										<button class="btn-google">
											<img src="img/iconos/g_icon.png">
										</button>
										<button class="btn-facebook">
											<img src="img/iconos/f_icon.png">
										</button>
									</div>
									<p>o usa tu correo para registrarte</p>

									<!-- Inicio Formulario -->
									<form action="registro" method="post">
										<input type="text" placeholder="Nombre" id="nombre"
											name="nombre" required> <input type="email"
											placeholder="Correo" id="correo" name="correo" required>
										<input type="password" placeholder="Contraseña" id="clave"
											name="clave" required> <input type="tel"
											placeholder="Número de Teléfono" id="telefono"
											name="telefono" required pattern="[0-9]{9}"> <input
											type="date" id="fecha-nacimiento" name="cumple"
											placeholder="Fecha de Nacimiento" required>
											<input type="text" name="img" placeholder="Perfil imagen en Url" >
										<button type="submit" class="btn-register">Registrarse</button>
									
									</form>
									<!-- Fin formulario -->
								</div>
							</div>
							
	<div>${mensaje } </div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- JS -->
	<script src="js/script.js"></script>
</body>
</html>
