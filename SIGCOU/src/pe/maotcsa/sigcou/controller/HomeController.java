package pe.maotcsa.sigcou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/**")
public class HomeController {
	
	@RequestMapping(value = {"/index", "/index.do", "/"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String error() {
		return "error";
	}
}
