<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Ciberfarma</title>
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- CSS Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<div class="container">
		<header>
			
		</header>

		<main>
			<div>${mensaje }</div>
			<%-- condicional si no hay productos --%>
			<c:if test="${cantArticulos == 0 }">
				<div style="text-align: center;">
					<h1>Carro de compra</h1>
					<img alt="" src="img/productos/vacio.png">
					<p>
						Su carrito de compras está vacío, pulse <a href="catalogo">aquí</a>
						para empezar a comprar
					</p>
				</div>
			</c:if>
			
			<%-- condicional si hay productos --%>
			<c:if test="${cantArticulos > 0 }">
				<div class="row">
					<div class="col-8">
						<h1>Carrito de compra</h1>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Código</th>
									<th scope="col">Producto</th>
									<th scope="col">Cantidad</th>
									<th scope="col">Precio</th>
									<th scope="col">Sub total</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${carro }" var="d">
									<tr>
										<th scope="row">${d.idprod }</th>
										<td>${d.nomprod }</td>
										<td>${d.cantidad }</td>
										<td>${d.preciovta }</td>
										<td>${d.importe }</td>
										<td><a href="eliminar?cod=${d.idprod }"
											class="btn btn-outline-warning">Eliminar <i
												class="fas fa-trash"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br> 
						<a href="catalogo" class="btn btn-primary">Continuar comprando <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
					</div>
					<div class="col-4">
						<h1>Resumen de pedido</h1>
						<hr>
						<div class="mb-3 row">
							<label for="inputCod" class="col">Total artículos:</label> 
							<label for="inputCod" class="col">(${cantArticulos })</label>
						</div>
						<div class="mb-3 row">
							<label for="inputCod" class="col">Total importe:</label> 
							<label for="inputCod" class="col">S/. ${subTotalVenta }</label>
						</div>
						<form action="pagar" method="post">
							<button class="btn btn-primary">
								Procesar compra <i class="fas fa-credit-card"></i>
							</button>
						</form>
					</div>
				</div>
			</c:if>
				



		</main>
		<footer> </footer>
	</div>
</body>
</html>
