package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Tarifa;

public interface ITarifaDao extends JpaRepository<Tarifa, Integer> {

}
