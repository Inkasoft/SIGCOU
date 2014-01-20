package pe.maotcsa.sigcou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pe.maotcsa.sigcou.bean.HojaRuta;
import pe.maotcsa.sigcou.model.IHojaRutaDao;
import pe.maotcsa.sigcou.service.IHojaRutaService;

@Service
public class HojaRutaServiceImpl implements IHojaRutaService {
	@Autowired
	IHojaRutaDao iHojaRutaDao;

	@Override
	public List<HojaRuta> searchHojaRuta(String query, Integer page) {
		//List<HojaRuta> hojaRutas = iHojaRutaDao.findAll();
		/*
		PageRequest pageRequest = new PageRequest(page, 2);
		Page<HojaRuta> pageResults = iHojaRutaDao.findAll(pageRequest);
		return pageResults.getContent();
		*/
		return iHojaRutaDao.findAllForDisplay(query);
		//return iHojaRutaDao.findAll();
	}

	/*
	@Override
	public Paginator paginateSearchHojaRuta(String query, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	@Override
	public HojaRuta getById(Integer id) {
		return iHojaRutaDao.findOne(id);
	}

}
