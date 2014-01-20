/**
 * 
 */

var app = app || {};

var HojaRutaCollection = Backbone.Collection.extend({
	url: app.webRoot + 'api/hoja_ruta',
	model: HojaRuta
});