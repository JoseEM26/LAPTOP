

<%@page import="com.empleado.servelts.Trabajador"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<table class="table table-bordered border-primary">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Apellido</th>
			<th scope="col">Edad</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<Trabajador> lista = (List) request.getSession().getAttribute("lista");
        int contador =1;
		for (Trabajador x : lista) {
		%>
		<tr>
			<th scope="row"><%=contador %></th>
			<td><%=x.getNombre() %></td>
			<td><%=x.getApellido() %></td>
			<td><%=x.getEdad() %></td>
		</tr>
		<%contador++; %>
		<%
		}
		%>
	</tbody>
</table>