package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Envio;

public interface IEnvioDao extends JpaRepository<Envio, Integer> {

}
