package pe.maotcsa.sigcou.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.maotcsa.sigcou.bean.UsuarioTest;
import pe.maotcsa.sigcou.service.IUsuarioService;

@Controller
public class AutenticacionController {

	@Autowired
	IUsuarioService usuarioService;
	
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> autenticar(UsuarioTest usuario, HttpSession ses) {
		
		UsuarioTest sesion = usuarioService.autentificar(usuario);
		
		if(sesion==null){
			System.out.println("Usuario o password incorrecto");
		}else{
			System.out.println("Usuario correcto");
		}
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		
		return response;
	}
	
}
