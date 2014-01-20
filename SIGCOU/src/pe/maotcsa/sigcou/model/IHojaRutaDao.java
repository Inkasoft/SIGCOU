package pe.maotcsa.sigcou.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.maotcsa.sigcou.bean.HojaRuta;

public interface IHojaRutaDao extends JpaRepository<HojaRuta, Integer> {
	/*
	public List<HojaRuta> searchPaginated (String query, Integer page);
	public Paginator searcgPaginator (String query, Integer page);
	*/
	
	@Query("SELECT hr from HojaRuta hr LEFT JOIN hr.mensajero m "
			+ "WHERE m.mensajeroNombre || ' ' || m.mensajeroApellido LIKE '%'||:parametro||'%' "
			+ "OR hr.hojaRutaId LIKE '%'||:parametro||'%'"
			+ "ORDER BY hr.hojaRutaId ASC")
	List<HojaRuta> findAllForDisplay (@Param("parametro") String parametro);
}
