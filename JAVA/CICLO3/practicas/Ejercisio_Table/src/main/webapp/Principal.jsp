<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRINCIPAL</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
<h1>Ejercisio de formulario y tabla Trabajadores</h1>

<form action="SvTrabajadores" method="post">
   <label>Nombre:</label>
   <input type="text" name="nombre" placeholder="nombre de trabajdor"  maxlength="20">
   <br>
   <label>Apellido:</label>
   <input type="text" name="apellido" placeholder="apellido de trabajdor" maxlength="20">
   <br>
   <label>edad:</label>
   <input type="number" name="edad" placeholder="edad de trabajdor"  min="0" max="100">
   <br>
   <button type="submit">Enviar</button>
</form>
   ${mensaje }

<form action="SvTrabajadores" method="get">
  <button type="submit">To see </button>
</form>

</body>

 
</html>