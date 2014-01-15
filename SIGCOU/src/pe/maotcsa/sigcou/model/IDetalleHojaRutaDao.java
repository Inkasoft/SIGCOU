package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.DetalleHojaRuta;

public interface IDetalleHojaRutaDao extends
		JpaRepository<DetalleHojaRuta, Integer> {

}
