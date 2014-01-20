package pe.maotcsa.sigcou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.maotcsa.sigcou.bean.Mensajero;
import pe.maotcsa.sigcou.model.IMensajeroDao;
import pe.maotcsa.sigcou.service.IMensajeroService;

@Service
public class MensajeroServiceImpl implements IMensajeroService {
	@Autowired
	IMensajeroDao mensajeroDao;

	@Override
	public List<Mensajero> searchMensajerosByFullname (String fullName) {
		return mensajeroDao.findByNombreCompletoContaining(fullName);
	}

	@Override
	public List<Mensajero> listAll() {
		return mensajeroDao.findAll();
	}

}
