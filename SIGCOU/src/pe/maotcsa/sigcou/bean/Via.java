package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Vias database table.
 * 
 */
@Entity
@Table(name="Vias")
@NamedQuery(name="Via.findAll", query="SELECT v FROM Via v")
public class Via implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ViaId")
	private int viaId;

	@Column(name="ViaDescripcion")
	private String viaDescripcion;

	//bi-directional many-to-one association to DetalleVia
	@OneToMany(mappedBy="via")
	private List<DetalleVia> detalleVias;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="via")
	private List<Envio> envios;

	public Via() {
	}

	public int getViaId() {
		return this.viaId;
	}

	public void setViaId(int viaId) {
		this.viaId = viaId;
	}

	public String getViaDescripcion() {
		return this.viaDescripcion;
	}

	public void setViaDescripcion(String viaDescripcion) {
		this.viaDescripcion = viaDescripcion;
	}

	public List<DetalleVia> getDetalleVias() {
		return this.detalleVias;
	}

	public void setDetalleVias(List<DetalleVia> detalleVias) {
		this.detalleVias = detalleVias;
	}

	public DetalleVia addDetalleVia(DetalleVia detalleVia) {
		getDetalleVias().add(detalleVia);
		detalleVia.setVia(this);

		return detalleVia;
	}

	public DetalleVia removeDetalleVia(DetalleVia detalleVia) {
		getDetalleVias().remove(detalleVia);
		detalleVia.setVia(null);

		return detalleVia;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setVia(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setVia(null);

		return envio;
	}

}