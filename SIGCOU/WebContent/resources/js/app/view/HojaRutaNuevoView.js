/**
 * 
 */

var app = app || {};

var HojaRutaNuevoView = Backbone.View.extend({
	initialize: function () {
		this.collection = this.collection || new HojaRutaCollection();
		this.tmpHojaRuta = {};
	},
	events: {
		'change #fecha_asignacion': 'fechaActualizada',
		'keyup #fecha_asignacion': 'fechaActualizada',
		'submit #nuevo_form': 'saveNewModel'
	},
	saveNewModel: function (evt) {
		evt.preventDefault();
		console.log(this.tmpHojaRuta);
		this.collection.create(this.tmpHojaRuta);
	},
	fechaActualizada: function (evt) {
		var fecha = Date.parseExact($('#fecha_asignacion').val(), 'dd/MM/yyyy');
		if (fecha == null) {
			return;
		}
		this.tmpHojaRuta.hojaRutaFecha = fecha.getTime();
	},
	template: _.template($('#nuevo_formulario').html()),
	render: function () {
		var me = this;
		this.$el.html(this.template());
		this.$el.find('#mensajero_nombres').typeahead({
			name: 'mensajeros',
			template: _.template('<div class="sugerencia">{{=mensajeroNombre + \' \' + mensajeroApellido}}</div>'),
			remote: {
					url: app.webRoot+'api/mensajero?q=%QUERY&action=searchByFullName',
					filter: function (response) {
						var arr = [];
						_.each(response, function (mensajero) {
							// Add the "value" key for typeahead comparision
							// add the obj to the array so that it appears in
							// the suggs list
							arr.push(_.extend(mensajero, {
								value: mensajero.mensajeroNombre + ' ' + mensajero.mensajeroApellido
							}));
						});
						return arr;
					}
				}
		}).css({ // Fix so the input is correctly visible
			'background': 'white'
		}).on('typeahead:selected', function (object, datum) {
			// Read the event triggered when it's selected
			// and add it to the new HojaRutaModel
			delete datum['value'];
			me.tmpHojaRuta.mensajero = datum;
		});
		return this;
	}
});