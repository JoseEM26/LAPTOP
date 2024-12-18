<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	referrerpolicy="no-referrer" />


<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="principal.jsp">Inicio</a></li>
				
				<c:if test="${u != null }">
					<li class="nav-item"><a class="nav-link" href="actuser">Actualizar
						datos</a></li>
				</c:if>
				
				
				<li class="nav-item"><a class="nav-link" href="catalogo">Catálogo</a></li>

				<%-- si el usuario es tipo Admin, mostrará...  --%>
				<c:if test="${u.tipo == 1 }">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Mantenimientos
						</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="crudprod">Productos</a></li>
							<li><a class="dropdown-item" href="#">Categorías</a></li>
							<li><a class="dropdown-item" href="#">Usuarios</a></li>
						</ul>
					</li>
				</c:if>

				<li class="nav-item"><a class="nav-link" href="logout">Cerrar
						sesión</a></li>
				
				<li class="nav-item">
					<a class="nav-link" href="canasta.jsp">
					<i class="fas fa-shopping-cart"></i><sup style="background-color: orange; border-radius: 50% ">${cantArticulos }</sup></a>
				</li>
			</ul>
		</div>
	</div>
</nav>