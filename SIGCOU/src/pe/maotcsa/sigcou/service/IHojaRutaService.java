package pe.maotcsa.sigcou.service;

import java.util.List;

import pe.maotcsa.sigcou.bean.HojaRuta;

public interface IHojaRutaService {

	public List<HojaRuta> searchHojaRuta (String query, Integer page);
	//public Paginator paginateSearchHojaRuta (String query, Integer page);
	public HojaRuta getById (Integer id);

}
