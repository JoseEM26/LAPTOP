<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Detalles del Vuelo</title>
  <style>
    /* Estilos generales */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .card {
      background: #fff;
      width: 700px; /* Más ancho */
      border-radius: 12px;
      box-shadow: 0px 6px 20px rgba(0, 0, 0, 0.3);
      overflow: hidden;
      position: relative; /* Para posicionar la X */
      transition: transform 0.3s ease-in-out;
    }
    .card:hover {
      transform: scale(1.03);
    }
    .close-btn {
      position: absolute;
      top: 15px;
      right: 15px;
      background-color: #ff4d4d;
      color: #fff;
      font-size: 20px;
      font-weight: bold;
      border: none;
      border-radius: 50%;
      width: 35px;
      height: 35px;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
      transition: background 0.3s ease;
    }
    .close-btn:hover {
      background-color: #cc0000;
    }
    .card img {
      width: 100%;
      height: 350px;
      object-fit: cover;
    }
    .card-content {
      padding: 25px 35px;
    }
    .card-content h2 {
      margin: 0 0 10px 0;
      font-size: 32px;
      color: #333;
    }
    .card-content p {
      margin: 10px 0;
      color: #555;
      font-size: 18px;
    }
    .price {
      font-size: 24px;
      font-weight: bold;
      color: #1e88e5;
      margin: 15px 0;
    }
    .availability {
      font-size: 18px;
      color: #28a745;
      font-weight: bold;
      margin-top: 10px;
    }
    .buy-now {
      background: #007bff;
      color: #fff;
      text-align: center;
      padding: 15px;
      text-decoration: none;
      font-size: 20px;
      font-weight: bold;
      display: block;
      border-radius: 6px;
      margin-top: 25px;
      transition: background 0.3s;
    }
    .buy-now:hover {
      background: #0056b3;
    }
    .footer {
      text-align: center;
      font-size: 14px;
      color: #888;
      margin-top: 15px;
      padding-bottom: 10px;
    }
  </style>
</head>
<body>
  <!-- Tarjeta de Vuelo -->
  <div class="card">
    <!-- Botón para cerrar -->
    <button class="close-btn" onclick="window.history.back();">&times;</button>
    
    <!-- Imagen dinámica del vuelo -->
    <form action="reservar" method="post">
    
    <img src="${vuelo.imagenUrl}" alt="Destino: ${vuelo.lugar}">
    <fmt:setLocale value="es-PE"/>

    <!-- Contenido del vuelo -->
    <div class="card-content">
      <h2>Destino: ${vuelo.lugar}</h2>
      <p><strong>ID Vuelo:</strong> ${vuelo.idVuelo}</p>
      <p><strong>Fecha de Salida:</strong> ${vuelo.fechaSalida}</p>
      <p><strong>Fecha de Llegada:</strong> ${vuelo.fechaLlegada}</p>
      <p class="price">Precio: 
        <fmt:formatNumber type="currency" value="${vuelo.precio}"></fmt:formatNumber>
      </p>
      <p class="availability">Plazas Disponibles: ${vuelo.plazasDisponibles}</p>
      <label><strong>Cantidad Boletos  :</strong></label> 
      <input name="cantidad" type="number" max="3" min="1" value="1" >

      <!-- Botón Reservar -->
      <button type="submit" class="buy-now">RESERVAR AHORA</button>
    
    </form>
    </div>

    <!-- Pie de página -->
    <p class="footer">Consulta términos y condiciones.</p>
  </div>
</body>
</html>
