package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Rutas database table.
 * 
 */
@Entity
@Table(name="Rutas")
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RutaId")
	private int rutaId;

	@Column(name="RutaDetalle")
	private String rutaDetalle;

	//bi-directional many-to-one association to HojaRuta
	@OneToMany(mappedBy="ruta")
	private List<HojaRuta> hojaRutas;

	public Ruta() {
	}

	public int getRutaId() {
		return this.rutaId;
	}

	public void setRutaId(int rutaId) {
		this.rutaId = rutaId;
	}

	public String getRutaDetalle() {
		return this.rutaDetalle;
	}

	public void setRutaDetalle(String rutaDetalle) {
		this.rutaDetalle = rutaDetalle;
	}

	public List<HojaRuta> getHojaRutas() {
		return this.hojaRutas;
	}

	public void setHojaRutas(List<HojaRuta> hojaRutas) {
		this.hojaRutas = hojaRutas;
	}

	public HojaRuta addHojaRuta(HojaRuta hojaRuta) {
		getHojaRutas().add(hojaRuta);
		hojaRuta.setRuta(this);

		return hojaRuta;
	}

	public HojaRuta removeHojaRuta(HojaRuta hojaRuta) {
		getHojaRutas().remove(hojaRuta);
		hojaRuta.setRuta(null);

		return hojaRuta;
	}

}