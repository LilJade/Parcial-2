<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Consulta</title>
	<link rel="stylesheet" href="estilos.css">
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
	<div class="contentFrm">
		<form class="frmSrv" action="servletControl">
			<label class="rotulo">ID: </label>
			<input class="control" type="text" name="id" value="<%= id%>">
			<label class="rotulo">NOMBRE: </label>
			<input class="control"  type="text" name="nombre" value="<%= name%>">
			<label class="rotulo">APELLIDO: </label>
			<input class="control"  type="text" name="apellido" value="<%= lastName%>">
			<input class="btn" type="submit" value="ACTUALIZAR" name="btn" style="background-color: #0779e4">
			<a href="index.jsp" class="btn" style="background-color: #fcbf1e">Cancelar</a>
		</form>
		<form class="frmSrv" action="servletLogin" method="post">
			<input class="btn"  type="submit" value="Cerrar Sesion" name="btnClose" style="background-color: #c70039">
		</form>
	</div>
</body>
</html>