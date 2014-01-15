package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Historial;

public interface IHistorialDao extends JpaRepository<Historial, Integer> {

}
