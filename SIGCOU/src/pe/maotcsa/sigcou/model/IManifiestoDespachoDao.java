package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.ManifiestoDespacho;

public interface IManifiestoDespachoDao extends
		JpaRepository<ManifiestoDespacho, Integer> {

}
