package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Envios database table.
 * 
 */
@Entity
@Table(name="Envios")
@NamedQuery(name="Envio.findAll", query="SELECT e FROM Envio e")
public class Envio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EnvioId")
	private int envioId;

	@Column(name="Bulto")
	private int bulto;

	@Column(name="EnvioDireccion")
	private String envioDireccion;

	@Temporal(TemporalType.DATE)
	@Column(name="FechaRecepcion")
	private Date fechaRecepcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FechaRegistro")
	private Date fechaRegistro;

	@Column(name="Latitud")
	private String latitud;

	@Column(name="Longitud")
	private String longitud;

	private String numEnvio;

	@Column(name="OficinaOrigen")
	private String oficinaOrigen;

	@Column(name="Peso")
	private float peso;

	@Column(name="PrecioKg")
	private float precioKg;

	@Column(name="PrecioTotal")
	private float precioTotal;

	@Column(name="Zona")
	private String zona;

	//bi-directional many-to-one association to DetalleHojaRuta
	@OneToMany(mappedBy="envio")
	private List<DetalleHojaRuta> detalleHojaRutas;

	//bi-directional many-to-one association to Prioridad
	@ManyToOne
	@JoinColumn(name="PrioridadId")
	private Prioridad prioridade;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ClienteId")
	private Cliente cliente;

	//bi-directional many-to-one association to Destinatario
	@ManyToOne
	@JoinColumn(name="DestinatarioId")
	private Destinatario destinatario;

	//bi-directional many-to-one association to Receptor
	@ManyToOne
	@JoinColumn(name="ReceptorId")
	private Receptor receptore;

	//bi-directional many-to-one association to GuiaDespacho
	@ManyToOne
	@JoinColumn(name="GuiaDespachoId")
	private GuiaDespacho guiaDespacho;

	//bi-directional many-to-one association to Tarifa
	@ManyToOne
	@JoinColumn(name="TarifaId")
	private Tarifa tarifa;

	//bi-directional many-to-one association to TipoServicio
	@ManyToOne
	@JoinColumn(name="TipoServicioId")
	private TipoServicio tipoServicio;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="UbigeoId")
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Via
	@ManyToOne
	@JoinColumn(name="ViaId")
	private Via via;

	//bi-directional many-to-one association to Contenido
	@ManyToOne
	@JoinColumn(name="ContenidoId")
	private Contenido contenido;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="envio")
	private List<Historial> historiales;

	public Envio() {
	}

	public int getEnvioId() {
		return this.envioId;
	}

	public void setEnvioId(int envioId) {
		this.envioId = envioId;
	}

	public int getBulto() {
		return this.bulto;
	}

	public void setBulto(int bulto) {
		this.bulto = bulto;
	}

	public String getEnvioDireccion() {
		return this.envioDireccion;
	}

	public void setEnvioDireccion(String envioDireccion) {
		this.envioDireccion = envioDireccion;
	}

	public Date getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNumEnvio() {
		return this.numEnvio;
	}

	public void setNumEnvio(String numEnvio) {
		this.numEnvio = numEnvio;
	}

	public String getOficinaOrigen() {
		return this.oficinaOrigen;
	}

	public void setOficinaOrigen(String oficinaOrigen) {
		this.oficinaOrigen = oficinaOrigen;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPrecioKg() {
		return this.precioKg;
	}

	public void setPrecioKg(float precioKg) {
		this.precioKg = precioKg;
	}

	public float getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<DetalleHojaRuta> getDetalleHojaRutas() {
		return this.detalleHojaRutas;
	}

	public void setDetalleHojaRutas(List<DetalleHojaRuta> detalleHojaRutas) {
		this.detalleHojaRutas = detalleHojaRutas;
	}

	public DetalleHojaRuta addDetalleHojaRuta(DetalleHojaRuta detalleHojaRuta) {
		getDetalleHojaRutas().add(detalleHojaRuta);
		detalleHojaRuta.setEnvio(this);

		return detalleHojaRuta;
	}

	public DetalleHojaRuta removeDetalleHojaRuta(DetalleHojaRuta detalleHojaRuta) {
		getDetalleHojaRutas().remove(detalleHojaRuta);
		detalleHojaRuta.setEnvio(null);

		return detalleHojaRuta;
	}

	public Prioridad getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(Prioridad prioridade) {
		this.prioridade = prioridade;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinatario getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public Receptor getReceptore() {
		return this.receptore;
	}

	public void setReceptore(Receptor receptore) {
		this.receptore = receptore;
	}

	public GuiaDespacho getGuiaDespacho() {
		return this.guiaDespacho;
	}

	public void setGuiaDespacho(GuiaDespacho guiaDespacho) {
		this.guiaDespacho = guiaDespacho;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	public Via getVia() {
		return this.via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public List<Historial> getHistoriales() {
		return this.historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}

	public Historial addHistoriale(Historial historiale) {
		getHistoriales().add(historiale);
		historiale.setEnvio(this);

		return historiale;
	}

	public Historial removeHistoriale(Historial historiale) {
		getHistoriales().remove(historiale);
		historiale.setEnvio(null);

		return historiale;
	}

}