/**
 * 
 */

var app = app || {};
var HojaRutaBuscarView = Backbone.View.extend({
	initialize: function () {
		this.collection = new HojaRutaCollection ();
	},
	events: {
		'submit .busca_hr_form': 'go_to_search'
	},
	go_to_search: function (evt) {
		evt.preventDefault();
		try {
			var query = this.$el.find('input[name=q]').val();
			if (query == '')
				app.router.navigate('buscar', {trigger: true});
			else
				app.router.navigate('buscar/'+encodeURIComponent(query), {trigger: true});
		} catch(e) {}
	},
	do_search: function (data) {
		console.log(data);
		var me = this;
		this.data = _.extend({}, {page: 1, query: ''}, data);
		this.collection.fetch({
			'data': me.data,
			'success': function () {
				me.render();
			}
		});
	},
	template: _.template($('#buscar_hoja_ruta').html()),
	render: function () {
		var me = this;
		me.$el.html(me.template({
			'hoja_rutas': me.collection.toJSON(),
			'data': me.data
		}));
		me.$el.find('input[name=q]').focus();
		return this;
	}
});