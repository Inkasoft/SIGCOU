package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Contenidos database table.
 * 
 */
@Entity
@Table(name="Contenidos")
@NamedQuery(name="Contenido.findAll", query="SELECT c FROM Contenido c")
public class Contenido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ContenidoId")
	private int contenidoId;

	@Column(name="Cantidad")
	private int cantidad;

	@Column(name="ContenidoDescripcion")
	private String contenidoDescripcion;

	//bi-directional many-to-one association to ManifiestoDespacho
	@ManyToOne
	@JoinColumn(name="ManifiestoDespachoId")
	private ManifiestoDespacho manifiestoDespacho;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="contenido")
	private List<Envio> envios;

	public Contenido() {
	}

	public int getContenidoId() {
		return this.contenidoId;
	}

	public void setContenidoId(int contenidoId) {
		this.contenidoId = contenidoId;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getContenidoDescripcion() {
		return this.contenidoDescripcion;
	}

	public void setContenidoDescripcion(String contenidoDescripcion) {
		this.contenidoDescripcion = contenidoDescripcion;
	}

	public ManifiestoDespacho getManifiestoDespacho() {
		return this.manifiestoDespacho;
	}

	public void setManifiestoDespacho(ManifiestoDespacho manifiestoDespacho) {
		this.manifiestoDespacho = manifiestoDespacho;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setContenido(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setContenido(null);

		return envio;
	}

}