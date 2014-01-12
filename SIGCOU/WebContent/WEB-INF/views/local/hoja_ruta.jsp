<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hoja de Ruta</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>
<body>
<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>
	<div class="row">
		<div class="col-sm-2">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#">Inicio</a></li>
				<li><a href="#">Nuevo</a></li>
				<li><a href="#">Editar</a></li>
			</ul>
		</div>
		<div class="col-sm-10">
			<h3>Hojas de ruta</h3>
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
						<table class="table">
							<thead>
								<tr>
									<th>Hola</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Hola</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 
	<h3>Hoja de Ruta</h3>
	<div class="container-fluid">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<div class="col-sm-12" style="text-align: right;">
					<button class="btn btn-default btn-sm" type="reset"><span class="glyphicon glyphicon-plus"></span> Nuevo</button>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Mensajero:</label>
				<div class="col-sm-4">
					<div class="input-group">
						<input class="form-control input-sm" type="text" name="mensajero" />
						<span class="input-group-btn">
							<button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search"></span></button>
						</span>
					</div>
				</div>
				<div class="col-sm-6"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Fecha de Asignación:</label>
				<div class="col-sm-2">
					<div class="input-group">
						<input class="form-control input-sm" type="text" name="fecha_asigna" />
						<span class="input-group-btn">
							<button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
						</span>
					</div>
				</div>
				<div class="col-sm-8"></div>
			</div>
			<div class="form-group">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6">asdf</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="col-md-4 col-md-offset-8">
										<div class="input-group">
											<input class="form-control input-sm" type="text" name="search_query" />
											<span class="input-group-btn">
												<button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search"></span></button>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12" style="text-align: right;">
					<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
				</div>
			</div>
		</form>
	</div>
	-->

<jsp:include page="/WEB-INF/include/footer.jsp"></jsp:include>
</body>
</html>