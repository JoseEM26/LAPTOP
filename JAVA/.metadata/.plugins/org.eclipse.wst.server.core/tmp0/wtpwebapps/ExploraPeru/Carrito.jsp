<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.20.0/js/mdb.min.js"
	integrity="sha512-XFd1m0eHgU1F05yOmuzEklFHtiacLVbtdBufAyZwFR0zfcq7vc6iJuxerGPyVFOXlPGgM8Uhem9gwzMI8SJ5uw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<style>
@media ( min-width : 1025px) {
	.h-custom {
		height: 100vh !important;
	}
}
</style>
<body>
	<section class="h-100 h-custom" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card">
						<div class="card-body p-4">

							<div class="row">

								<div class="col-lg-7">
									<h5 class="mb-3">
										<a href="vuelos" class="text-body"><i
											class="fas fa-long-arrow-alt-left me-2"></i>Continuar
											Comprando</a>
									</h5>
									<hr>



									<div
										class="d-flex justify-content-between align-items-center mb-4">
										<div>
											<p class="mb-1">Carrito compras:</p>
											<p class="mb-0">
												Tu tienes <strong>${canViajes }</strong> boletos de viajes
											</p>
										</div>
										<div>
											<p class="mb-0">
												<span class="text-muted">Sort by:</span> <a href="#!"
													class="text-body">price <i
													class="fas fa-angle-down mt-1"></i></a>
											</p>
										</div>
									</div>

									<fmt:setLocale value="es-PE" />

									<c:forEach var="x" items="${carro }">


										<div class="card mb-3 mb-lg-0">
											<div class="card-body">
												<div class="d-flex justify-content-between">
													<div class="d-flex flex-row align-items-center">
														<div>
															<img src="${x.urlImg }" class="img-fluid rounded-3"
																alt="Shopping item" style="width: 110px; height: 70px">
														</div>
														<div class="ms-3">
															<h5>${x.nombreViaje }</h5>
															<p class="small mb-0">Fecha: ${x.fechaSalida }</p>
														</div>
													</div>
													<div class="d-flex flex-row align-items-center">
														<div style="width: 50px;">
															<h5 class="fw-normal mb-0">${x.cantidad}</h5>
														</div>
														<div style="width: 80px;">
															<h5 class="mb-0">
																<fmt:formatNumber value="${x.precio}" type="currency"></fmt:formatNumber>
															</h5>
														</div>
														<a href="EliminarCarro?id=${x.idViaje }"
															style="color: #cecece; margin-left: 10px"
															class="btn btn-outline-secondary"> Eliminar</a>
													</div>
												</div>
											</div>
										</div>


									</c:forEach>
									<fmt:setLocale value="es-PE" />
								</div>
								<div class="col-lg-5">
									<div class="card bg-primary text-white rounded-3">
										<div class="card-body">

											<c:if test="${u != null }">
												<div
													class="d-flex justify-content-between align-items-center mb-4">
													<h5 class="mb-0">Card details</h5>
													<img
														src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
														class="img-fluid rounded-3" style="width: 45px;"
														alt="Avatar">
												</div>

												<p class="small mb-2">Card type</p>
												<a href="#!" type="submit" class="text-white"><i
													class="fab fa-cc-mastercard fa-2x me-2"></i></a>
												<a href="#!" type="submit" class="text-white"><i
													class="fab fa-cc-visa fa-2x me-2"></i></a>
												<a href="#!" type="submit" class="text-white"><i
													class="fab fa-cc-amex fa-2x me-2"></i></a>
												<a href="#!" type="submit" class="text-white"><i
													class="fab fa-cc-paypal fa-2x"></i></a>

												<form class="mt-4" method="post" action="verificarTar">
													<div data-mdb-input-init
														class="form-outline form-white mb-4">
														<select class="form-control form-control-lg" name="cmb">
															<option value="">Selecionar......</option>
															<c:forEach var="x" items="${cmb}">
																<option value="${x.idTipo }">${x.nombreTipo }</option>
															</c:forEach>
														</select> <label class="form-label" for="typeName">Tipo de
															Tarjeta</label>
													</div>

													<div data-mdb-input-init
														class="form-outline form-white mb-4">
														<input type="int" id="typeText" max="numero"
															class="form-control form-control-lg" name="numero"
															placeholder="1234 5678 9012 345" minlength="16"
															maxlength="16" /> <label class="form-label"
															for="typeText">Numero de Tarjeta</label>
													</div>

													<div class="row mb-4">
														<div class="col-md-6">
															<div data-mdb-input-init class="form-outline form-white">
																<input type="date" id="typeExp" name="fecha"
																	class="form-control form-control-lg" /> <label
																	class="form-label" for="typeExp">Fecha
																	Expiracion</label>
															</div>
														</div>
														<div class="col-md-6">
															<div data-mdb-input-init class="form-outline form-white">
																<input type="password" id="typeText" name="cvv"
																	class="form-control form-control-lg"
																	placeholder="&#9679;&#9679;&#9679;" size="1"
																	minlength="3" maxlength="3" /> <label
																	class="form-label" for="typeText">CVV</label>
															</div>
														</div>
													</div>
													<hr class="my-4">

													<div class="d-flex justify-content-between">
														<p class="mb-2">Cantidad :</p>
														<p class="mb-2">${canViajes }</p>
													</div>

													<div class="d-flex justify-content-between">
														<p class="mb-2">SubTotal:</p>
														<p class="mb-2">
															<fmt:formatNumber value="${subTotalViaje }"
																type="currency"></fmt:formatNumber>
														</p>
													</div>

													<button type="submit">
														<strong>Comprar</strong>
													</button>



												</form>
											</c:if>
											<c:if test="${u == null }">
												<div class="container mt-5">
													<h2 class="text-center">Inicia Sesion :</h2>
													<p>Inicia sesion primero para que puedas hacer cualquier compra</p>
													<form action="Login" method="post">
														<div class="mb-3">
															<label for="nombreUsuario" class="form-label">Email</label>
															<input type="text" class="form-control"
																id="nombreUsuario" name="email"
																placeholder="Ingrese su nombre de usuario" required>
														</div>
														<div class="mb-3">
															<label for="contraseña" class="form-label">Contraseña</label>
															<input type="password" class="form-control"
																id="contraseña" name="contrasena"
																placeholder="Ingrese su contraseña" required>
														</div>
														<button  type="submit" class="btn btn-light w-100">Iniciar
															Sesión</button>
														<h6 style="text-align: center; "><a style="color: white;" href="Index.jsp">Crear Cuenta</a></h6>
													</form>
												</div>
											</c:if>
										</div>

									</div>

								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	${mensaje }

</body>
</html>