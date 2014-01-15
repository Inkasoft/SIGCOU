package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TipoServicios database table.
 * 
 */
@Entity
@Table(name="TipoServicios")
@NamedQuery(name="TipoServicio.findAll", query="SELECT t FROM TipoServicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TipoServicioId")
	private int tipoServicioId;

	@Column(name="TipoServicioDescripcion")
	private String tipoServicioDescripcion;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="tipoServicio")
	private List<Envio> envios;

	public TipoServicio() {
	}

	public int getTipoServicioId() {
		return this.tipoServicioId;
	}

	public void setTipoServicioId(int tipoServicioId) {
		this.tipoServicioId = tipoServicioId;
	}

	public String getTipoServicioDescripcion() {
		return this.tipoServicioDescripcion;
	}

	public void setTipoServicioDescripcion(String tipoServicioDescripcion) {
		this.tipoServicioDescripcion = tipoServicioDescripcion;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setTipoServicio(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setTipoServicio(null);

		return envio;
	}

}