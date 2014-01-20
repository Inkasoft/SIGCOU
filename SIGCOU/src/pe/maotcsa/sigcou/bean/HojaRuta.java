package pe.maotcsa.sigcou.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HojaRutas database table.
 * 
 */
@Entity
@Table(name="HojaRutas")
@NamedQuery(name="HojaRuta.findAll", query="SELECT h FROM HojaRuta h")
public class HojaRuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HojaRutaId")
	private Integer hojaRutaId;

	@Column(name="EnvioEntregado")
	private Integer envioEntregado;

	@Column(name="EnvioRezagado")
	private Integer envioRezagado;

	@Column(name="EnvioTotal")
	private Integer envioTotal;

	//@Temporal(TemporalType.DATE)
	@Column(name="HojaRutaFecha")
	private Date hojaRutaFecha;

	//bi-directional many-to-one association to DetalleHojaRuta
	@JsonIgnore
	@OneToMany(mappedBy="hojaRuta")
	private List<DetalleHojaRuta> detalleHojaRutas;

	//bi-directional many-to-one association to Mensajero
	@ManyToOne
	@JoinColumn(name="MensajeroId")
	private Mensajero mensajero;

	//bi-directional many-to-one association to Ruta
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="RutaId")
	private Ruta ruta;

	public HojaRuta() {
	}

	public Integer getHojaRutaId() {
		return this.hojaRutaId;
	}

	public void setHojaRutaId(Integer hojaRutaId) {
		this.hojaRutaId = hojaRutaId;
	}

	public Integer getEnvioEntregado() {
		return this.envioEntregado;
	}

	public void setEnvioEntregado(Integer envioEntregado) {
		this.envioEntregado = envioEntregado;
	}

	public Integer getEnvioRezagado() {
		return this.envioRezagado;
	}

	public void setEnvioRezagado(Integer envioRezagado) {
		this.envioRezagado = envioRezagado;
	}

	public Integer getEnvioTotal() {
		return this.envioTotal;
	}

	public void setEnvioTotal(Integer envioTotal) {
		this.envioTotal = envioTotal;
	}

	public Date getHojaRutaFecha() {
		return this.hojaRutaFecha;
	}

	public void setHojaRutaFecha(Date hojaRutaFecha) {
		this.hojaRutaFecha = hojaRutaFecha;
	}

	public List<DetalleHojaRuta> getDetalleHojaRutas() {
		return this.detalleHojaRutas;
	}

	public void setDetalleHojaRutas(List<DetalleHojaRuta> detalleHojaRutas) {
		this.detalleHojaRutas = detalleHojaRutas;
	}

	public DetalleHojaRuta addDetalleHojaRuta(DetalleHojaRuta detalleHojaRuta) {
		getDetalleHojaRutas().add(detalleHojaRuta);
		detalleHojaRuta.setHojaRuta(this);

		return detalleHojaRuta;
	}

	public DetalleHojaRuta removeDetalleHojaRuta(DetalleHojaRuta detalleHojaRuta) {
		getDetalleHojaRutas().remove(detalleHojaRuta);
		detalleHojaRuta.setHojaRuta(null);

		return detalleHojaRuta;
	}

	public Mensajero getMensajero() {
		return this.mensajero;
	}

	public void setMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}