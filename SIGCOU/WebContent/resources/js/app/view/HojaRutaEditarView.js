/**
 * 
 */

var app = app || {};

var HojaRutaEditarView = Backbone.View.extend({
	template: _.template($('#editar_formulario').html()),
	render: function () {
		var me = this;
		console.log(me.model);
		if (me.model == null) {
			throw {
				name: 'NO_ITEM_SELECTED',
				mensaje: 'No hay ningún elemento a modificar!'
			};
		}
		this.$el.html(this.template(me.model.toJSON()));
		return this;
	}
});