package pe.maotcsa.sigcou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.maotcsa.sigcou.bean.Receptor;

public interface IReceptorDao extends JpaRepository<Receptor, Integer> {

}
