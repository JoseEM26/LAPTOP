<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String nombre = "Jose";
		request.setAttribute("nombre", nombre);
	%>
	<h1>Bienvenido a la p�gina de ${nombre }</h1>
</body>
</html>