package pe.maotcsa.sigcou.service;

import java.util.List;

import pe.maotcsa.sigcou.bean.Mensajero;

public interface IMensajeroService {
	
	public List<Mensajero> listAll ();
	
	public List<Mensajero> searchMensajerosByFullname (String fullName);

}
