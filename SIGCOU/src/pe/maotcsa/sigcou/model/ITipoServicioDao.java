package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.TipoServicio;

public interface ITipoServicioDao extends JpaRepository<TipoServicio, Integer> {

}
