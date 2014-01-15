package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Destinatario;

public interface IDestinatarioDao extends JpaRepository<Destinatario, Integer> {

}
