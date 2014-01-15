package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Contenido;

public interface IContenidoDao extends JpaRepository<Contenido, Integer> {

}
