package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.GuiaDespacho;

public interface IGuiaDespachoDao extends JpaRepository<GuiaDespacho, Integer> {

}
