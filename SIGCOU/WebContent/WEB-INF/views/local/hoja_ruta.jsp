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
			<ul id="left_nav_menu" class="nav nav-pills nav-stacked">
				<li class="active"><a href="#buscar">Inicio</a></li>
				<li><a href="#nuevo">Nuevo</a></li>
				<li><a href="#editar">Editar</a></li>
			</ul>
		</div>
		<div class="col-sm-10" id="hoja_de_trabajo" style="background: white;">
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

<!-- Plantillas -->

<script type="text/template" id="nuevo_formulario">
<div class="row">
	<div class="col-md-12">
		<h2>Hoja de ruta <small><span class="glyphicon glyphicon-plus"></span> Nueva</small></h2>
		<form class="form-horizontal" role="form" id="nuevo_form">
			<div class="form-group">
				<label for="mensajero_nombres" class="col-sm-2 control-label">Mensajero</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="mensajero_nombres" placeholder="Mensajero" />
				</div>
			</div>
			<div class="form-group">
				<label for="fecha_asignacion" class="col-sm-2 control-label">Fc. de asignación</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="fecha_asignacion" placeholder="dd/mm/yyyy" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-right">
					<button class="btn btn-success btn-sm" type="submit">Guardar</button>
				</div>
			</div>
		</form>
	</div>
</div>
</script>

<script type="text/template" id="editar_formulario">
<div class="row">
	<div class="col-md-12">
		<h2>Hoja de ruta <small><span class="glyphicon glyphicon-pencil"></span> Editar</small></h2>
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="mensajero_nombres" class="col-sm-2 control-label">Mensajero</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="mensajero_nombres" placeholder="Mensajero" value="{{=mensajero.mensajeroNombre+' '+mensajero.mensajeroApellido}}" />
				</div>
			</div>
			<div class="form-group">
				<label for="fecha_asignacion" class="col-sm-2 control-label">Fc. de asignación</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="fecha_asignacion" placeholder="dd/mm/yyyy" value="{{=(new Date(hojaRutaFecha)).toString('dd/MM/yyyy')}}" />
				</div>
			</div>
		</form>
	</div>
</div>
</script>

<script type="text/template" id="buscar_hoja_ruta">
<div class="row">
	<div class="col-md-12">
		<h2>Hoja de ruta <small><span class="glyphicon glyphicon-align-justify"></span> Lista</small></h2>
		<form role="form" class="busca_hr_form">
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-8">
					<div class="input-group">
						<input type="text" name="q" class="form-control input-sm" placeholder="Consulta..." value="{{=data.query}}" />
						<span class="input-group-btn">
							<button class="btn btn-default btn-sm btn_do_search" type="submit"><span class="glyphicon glyphicon-search"></span></button>
						</span>
					</div>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Fecha</th>
							<th>Mensajero</th>
							<th></th>
						</tr>
					</thead>
						{{ if (hoja_rutas.length == 0) { }}
							<tr class="warning"><td colspan="4" class="text-center">No se han encontrado Hojas de Ruta</td></tr>
						{{ } }}
						{{ _.each(hoja_rutas, function (val, key)  { }}
						<tr class="{{=(val.envioEntregado == 1 ? 'success' : '')}}">
							<td>{{=val.hojaRutaId}}</td>
							<td>{{=(new Date(val.hojaRutaFecha)).toString('dd/MM/yyyy')}}</td>
							<td>{{=val.mensajero.mensajeroNombre+' '+val.mensajero.mensajeroApellido}}</td>
							<td>
								<a href="#editar/{{=val.hojaRutaId}}" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a>
							</td>
						</tr>
						{{ }); }}
					<thead>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</script>

<script>
_.templateSettings = {
	    interpolate: /{{\=(.+?)}}/gim,
	    evaluate: /{{(.+?)}}/gim,
	    escape: /{{\-(.+?)}}/gim
	};
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/HojaRuta.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/HojaRutaCollection.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/HojaRutaNuevoView.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/HojaRutaBuscarView.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/HojaRutaEditarView.js"></script>

<script type="text/javascript">
$(function () {
	var workspace = Backbone.Router.extend({
		initialize: function () {
			var hoja_trabajo = $('#hoja_de_trabajo');
			this.hojaRutaNuevoView = new HojaRutaNuevoView({
				el: hoja_trabajo
			});
			this.hojaRutaBuscarView = new HojaRutaBuscarView({
				el: hoja_trabajo
			});
			this.hojaRutaEditarView = new HojaRutaEditarView({
				el: hoja_trabajo,
				model: {}
			});
		},
		routes: {
			'nuevo': 'nuevo',
			'': 'buscar',
			'buscar': 'buscar',
			'buscar/:query': 'buscar',
			'editar': 'editar',
			'editar/:idHojaRuta': 'editar'
		},
		nuevo: function () {
			this.hojaRutaNuevoView.render();
			$('#left_nav_menu li').removeClass('active');
			$('#left_nav_menu li a[href=#nuevo]').parent().addClass('active');
		},
		buscar: function (query) {
			if (typeof query == 'undefined')
				query = '';
			this.hojaRutaBuscarView.do_search({
				'query': query
			});
			$('#left_nav_menu li').removeClass('active');
			$('#left_nav_menu li a[href=#buscar]').parent().addClass('active');
		},
		editar: function (idHojaRuta) {
			if (!idHojaRuta) {
				this.navigate('buscar', {trigger: true, replace: true});
				return;
			}
			var me = this;
			
			this.hojaRutaEditarView.model = me.hojaRutaBuscarView.collection.get(idHojaRuta);
			if (this.hojaRutaEditarView.model == null) {
				
				me.hojaRutaBuscarView.collection.create({'hojaRutaId': idHojaRuta},{
					success: function () {
						me.hojaRutaEditarView.model = me.hojaRutaBuscarView.collection.get(idHojaRuta);
						me.hojaRutaEditarView.render();
					}
				});
			}else{
				this.hojaRutaEditarView.render();
			}
			$('#left_nav_menu li').removeClass('active');
			$('#left_nav_menu li a[href=#editar]').parent().addClass('active');
		}
	});
	app.router = new workspace();
	Backbone.history.start();
});
</script>

</body>
</html>