package pe.maotcsa.sigcou.service.impl;

import org.springframework.stereotype.Service;

import pe.maotcsa.sigcou.bean.UsuarioTest;
import pe.maotcsa.sigcou.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Override
	public UsuarioTest autentificar(UsuarioTest usuario) {
		
		String nombreUsuario = "Admin";
		String contrasena = "123456";
		
		if(usuario.getUsername().equals(nombreUsuario)&&usuario.getPassword().equals(contrasena)){
			return usuario;
		}else{
			return null;
		}
		
	}

}
