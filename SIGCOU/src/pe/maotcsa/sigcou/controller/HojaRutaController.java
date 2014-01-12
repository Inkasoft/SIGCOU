package pe.maotcsa.sigcou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/local/**")
public class HojaRutaController {

	
	@RequestMapping(value = {"/hoja_ruta.form"}, method = RequestMethod.GET)
	public String hoja_ruta() {
		return "local/hoja_ruta";
	}
}
