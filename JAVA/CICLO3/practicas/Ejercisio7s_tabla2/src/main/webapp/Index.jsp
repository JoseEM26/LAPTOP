<%@page import="java.util.ArrayList"%>
<%@page import="com.Persona.Controller.model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Personas</h1>


	<div>${lista}</div>
	<c:forEach var="persona" items="${lista}">
		<div>${persona.nombre}${persona.apellido}</div>

	</c:forEach>
	
</body>
</html>