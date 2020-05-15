<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Consulta</title>
</head>
<%
	HttpSession seccionPrincipal = (HttpSession) request.getSession();
	String sectionVarUsser = (String) seccionPrincipal.getAttribute("usuario");
	if(sectionVarUsser == null){
		response.sendRedirect("index.jsp");
	}
%>
<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		
		if(id == null){
			id = "";
			name = "";
			lastName = "";
		}
%>
<body>
	<form class="frmSrv" action="servletControl">
		<label>Id: </label>
		<input type="text" name="id" value="<%= id%>">
		<label>Nombre: </label>
		<input type="text" name="nombre" value="<%= name%>">
		<label>Apellido: </label>
		<input type="text" name="apellido" value="<%= lastName%>">
		<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
	</form>
	<form action="servletLogin" method="post">
		<input type="submit" value="Cerrar Sesion" name="btnClose">
	</form>
</body>
</html>