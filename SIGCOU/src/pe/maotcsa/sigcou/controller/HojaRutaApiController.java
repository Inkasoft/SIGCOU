package pe.maotcsa.sigcou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.maotcsa.sigcou.bean.HojaRuta;
import pe.maotcsa.sigcou.model.IHojaRutaDao;
import pe.maotcsa.sigcou.service.IHojaRutaService;

@Controller
@RequestMapping("/api/hoja_ruta")
public class HojaRutaApiController {
	@Autowired
	IHojaRutaService iHojaRutaService;

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	@ResponseBody
	public List<HojaRuta> listAllHojaRuta (@RequestParam(defaultValue="") String query, 
											@RequestParam(defaultValue="0") Integer page) {
		List<HojaRuta> hojaRutas = iHojaRutaService.searchHojaRuta(query, page);
		return hojaRutas;
	}

	@RequestMapping(value={"/{id}"}, method=RequestMethod.GET)
	@ResponseBody
	public HojaRuta getById (@PathVariable Integer id) {
		return iHojaRutaService.getById(id);
	}

	@RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
	@ResponseBody
	public HojaRuta updateHojaRuta (@PathVariable Integer id) {
		return iHojaRutaService.getById(id);
	}

	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	@ResponseBody
	public HojaRuta create (@RequestBody HojaRuta hojaRuta) {
		HojaRuta lHojaRuta = hojaRuta;
		return lHojaRuta;
	}
}
