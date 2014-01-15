package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ManifiestoDespacho database table.
 * 
 */
@Entity
@NamedQuery(name="ManifiestoDespacho.findAll", query="SELECT m FROM ManifiestoDespacho m")
public class ManifiestoDespacho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ManifiestoDespachoId")
	private int manifiestoDespachoId;

	@Column(name="Consignatario")
	private String consignatario;

	@Column(name="Destino")
	private String destino;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ManifiestoDespachosFecha")
	private Date manifiestoDespachosFecha;

	//bi-directional many-to-one association to Contenido
	@OneToMany(mappedBy="manifiestoDespacho")
	private List<Contenido> contenidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ClienteId")
	private Cliente cliente;

	public ManifiestoDespacho() {
	}

	public int getManifiestoDespachoId() {
		return this.manifiestoDespachoId;
	}

	public void setManifiestoDespachoId(int manifiestoDespachoId) {
		this.manifiestoDespachoId = manifiestoDespachoId;
	}

	public String getConsignatario() {
		return this.consignatario;
	}

	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getManifiestoDespachosFecha() {
		return this.manifiestoDespachosFecha;
	}

	public void setManifiestoDespachosFecha(Date manifiestoDespachosFecha) {
		this.manifiestoDespachosFecha = manifiestoDespachosFecha;
	}

	public List<Contenido> getContenidos() {
		return this.contenidos;
	}

	public void setContenidos(List<Contenido> contenidos) {
		this.contenidos = contenidos;
	}

	public Contenido addContenido(Contenido contenido) {
		getContenidos().add(contenido);
		contenido.setManifiestoDespacho(this);

		return contenido;
	}

	public Contenido removeContenido(Contenido contenido) {
		getContenidos().remove(contenido);
		contenido.setManifiestoDespacho(null);

		return contenido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}