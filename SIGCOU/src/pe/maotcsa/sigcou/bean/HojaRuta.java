package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
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
	private int hojaRutaId;

	@Column(name="EnvioEntregado")
	private int envioEntregado;

	@Column(name="EnvioRezagado")
	private int envioRezagado;

	@Column(name="EnvioTotal")
	private int envioTotal;

	@Temporal(TemporalType.DATE)
	@Column(name="HojaRutaFecha")
	private Date hojaRutaFecha;

	//bi-directional many-to-one association to DetalleHojaRuta
	@OneToMany(mappedBy="hojaRuta")
	private List<DetalleHojaRuta> detalleHojaRutas;

	//bi-directional many-to-one association to Mensajero
	@ManyToOne
	@JoinColumn(name="MensajeroId")
	private Mensajero mensajero;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="RutaId")
	private Ruta ruta;

	public HojaRuta() {
	}

	public int getHojaRutaId() {
		return this.hojaRutaId;
	}

	public void setHojaRutaId(int hojaRutaId) {
		this.hojaRutaId = hojaRutaId;
	}

	public int getEnvioEntregado() {
		return this.envioEntregado;
	}

	public void setEnvioEntregado(int envioEntregado) {
		this.envioEntregado = envioEntregado;
	}

	public int getEnvioRezagado() {
		return this.envioRezagado;
	}

	public void setEnvioRezagado(int envioRezagado) {
		this.envioRezagado = envioRezagado;
	}

	public int getEnvioTotal() {
		return this.envioTotal;
	}

	public void setEnvioTotal(int envioTotal) {
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