package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Ubigeo;

public interface IUbigeoDao extends JpaRepository<Ubigeo, String> {

}
