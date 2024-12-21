<%@page import="com.ExploraPeru.model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="p-3 border-bottom bg-white">
	<div class="container">
		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="MenuUsuario.jsp"
				class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
				<img src="assets/img/logos/PeruExplora.png" width="150px" alt="..." />
			</a>
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
			
				<li><a href="vuelos" class="nav-link px-2 link-dark">Vuelos</a></li>

				<c:if test="${u != null && u.idRol == 2}">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Mantenimientos
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="crudvuelos">Vuelos</a></li>
							<li><a class="dropdown-item" href="crudcontacto">Contactanos</a></li>
							<li><a class="dropdown-item" href="crudCabezera">Cabezera Boleta</a></li>
							<li><a class="dropdown-item" href="DetalleBoleta">Detalle Boleta</a></li>
						</ul></li>
				</c:if>
<%Usuario u=(Usuario) request.getSession().getAttribute("u"); %>
			</ul>

			<div class="dropdown text-end">
				<a href="#"
					class="d-block link-dark text-decoration-none dropdown-toggle"
					data-bs-toggle="dropdown" aria-expanded="false"> <img
					src="${u.img }" alt="mdo" width="32" height="32"
					class="rounded-circle">
				</a>
				<ul class="dropdown-menu text-small">
					<li><a class="dropdown-item" href="#">New project...</a></li>
					<li><a class="dropdown-item" href="#">Settings</a></li>
					<li><a class="dropdown-item" href="PerfilServlt">Profile</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="SingOut">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>
