package pe.maotcsa.sigcou.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Mensajero;

public interface IMensajeroDao extends JpaRepository<Mensajero, Integer> {
	
	public List<Mensajero> findByNombreCompletoContaining (String nombreCompleto);

}
