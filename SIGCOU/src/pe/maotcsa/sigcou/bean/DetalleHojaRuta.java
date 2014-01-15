package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DetalleHojaRutas database table.
 * 
 */
@Entity
@Table(name="DetalleHojaRutas")
@NamedQuery(name="DetalleHojaRuta.findAll", query="SELECT d FROM DetalleHojaRuta d")
public class DetalleHojaRuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetalleHojaRuta;

	@Column(name="DetalleHojaRutaObservacion")
	private String detalleHojaRutaObservacion;

	//bi-directional many-to-one association to Envio
	@ManyToOne
	@JoinColumn(name="EnvioId")
	private Envio envio;

	//bi-directional many-to-one association to HojaRuta
	@ManyToOne
	@JoinColumn(name="HojaRutaId")
	private HojaRuta hojaRuta;

	public DetalleHojaRuta() {
	}

	public int getIdDetalleHojaRuta() {
		return this.idDetalleHojaRuta;
	}

	public void setIdDetalleHojaRuta(int idDetalleHojaRuta) {
		this.idDetalleHojaRuta = idDetalleHojaRuta;
	}

	public String getDetalleHojaRutaObservacion() {
		return this.detalleHojaRutaObservacion;
	}

	public void setDetalleHojaRutaObservacion(String detalleHojaRutaObservacion) {
		this.detalleHojaRutaObservacion = detalleHojaRutaObservacion;
	}

	public Envio getEnvio() {
		return this.envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public HojaRuta getHojaRuta() {
		return this.hojaRuta;
	}

	public void setHojaRuta(HojaRuta hojaRuta) {
		this.hojaRuta = hojaRuta;
	}

}