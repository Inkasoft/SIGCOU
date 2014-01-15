package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Estado;

public interface IEstadoDao extends JpaRepository<Estado, Integer> {

}
