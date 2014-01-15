package pe.maotcsa.sigcou.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.maotcsa.sigcou.bean.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {

	public final static String BUSCAR_POR_FILTROS = "SELECT * from Clientes c WHERE c.ClienteNombre like %:clienteNombre%";
	
	@Query(value=BUSCAR_POR_FILTROS, nativeQuery=true)
	public List<Cliente> buscar(@Param("clienteNombre") String clienteNombre);
	
	public List<Cliente> findByClienteApellido(String clienteApellido);
	
}
