package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Mensajero;

public interface IMensajeroDao extends JpaRepository<Mensajero, Integer> {

}
