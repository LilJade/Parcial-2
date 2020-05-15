<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Parcial 2</title>
	<link rel="stylesheet" href="estilos.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#cargar').click(function(event){
				var btn = $('#cargar').val();
				$.post('servletControl', {
				
				}, function(respose){
					let datos = JSON.parse(respose);
					var tbDatos = document.getElementById('tablaDatos');
					for(let item of datos){
						tbDatos.innerHTML += `
							<tr>
								<td>${item.apellido}</td>
								<td>${item.nombre}</td>
								<td>${item.id}</td>
								<td>
									<a href="editar.jsp?id=${item.id}&name=${item.nombre}&lastName=${item.apellido}" class="btn btn-warning">Editar</a>
									<a href="servletControl?btn=ELIMINAR&id=${item.id}" class="btn btn-danger">Eliminar</a>
								</td>
							</tr>
						`
					}
				});
			});
		});
	</script>
	<header class="head">
			<a class="floatBtn right" href="logIn.jsp">Iniciar Sesion</a>
			<input type="submit" class="floatBtn left" name="btn" value="Cargar Datos" id="cargar">
		<h1>PARCIAL 2</h1>
	</header>
	<div class="content">
		<table class="table table-dark" id="tablaDatos">
			<thead>
				<th>Apellido</th>
				<th>Nombre</th>
				<th>Id</th>
				<th>OPCIONES</th>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>
	<footer>
		<h4>Developer By LilJade</h4>
	</footer>
</body>
</html>
