package pe.maotcsa.sigcou.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Formula;

import java.util.List;


/**
 * The persistent class for the Mensajeros database table.
 * 
 */
@Entity
@Table(name="Mensajeros")
@NamedQuery(name="Mensajero.findAll", query="SELECT m FROM Mensajero m")
public class Mensajero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MensajeroId")
	private int mensajeroId;

	@Column(name="MensajeroApellido")
	private String mensajeroApellido;

	@Column(name="MensajeroDNI")
	private String mensajeroDNI;

	@Column(name="MensajeroNombre")
	private String mensajeroNombre;

	@Column(name="MensajeroTelefono")
	private String mensajeroTelefono;

	//bi-directional many-to-one association to HojaRuta
	@JsonIgnore
	@OneToMany(mappedBy="mensajero")
	private List<HojaRuta> hojaRutas;
	
	@Formula(value="CONCAT(MensajeroNombre , ' ' , MensajeroApellido)")
	private String nombreCompleto;

	public Mensajero() {
	}

	public int getMensajeroId() {
		return this.mensajeroId;
	}

	public void setMensajeroId(int mensajeroId) {
		this.mensajeroId = mensajeroId;
	}

	public String getMensajeroApellido() {
		return this.mensajeroApellido;
	}

	public void setMensajeroApellido(String mensajeroApellido) {
		this.mensajeroApellido = mensajeroApellido;
	}

	public String getMensajeroDNI() {
		return this.mensajeroDNI;
	}

	public void setMensajeroDNI(String mensajeroDNI) {
		this.mensajeroDNI = mensajeroDNI;
	}

	public String getMensajeroNombre() {
		return this.mensajeroNombre;
	}

	public void setMensajeroNombre(String mensajeroNombre) {
		this.mensajeroNombre = mensajeroNombre;
	}

	public String getMensajeroTelefono() {
		return this.mensajeroTelefono;
	}

	public void setMensajeroTelefono(String mensajeroTelefono) {
		this.mensajeroTelefono = mensajeroTelefono;
	}

	public List<HojaRuta> getHojaRutas() {
		return this.hojaRutas;
	}

	public void setHojaRutas(List<HojaRuta> hojaRutas) {
		this.hojaRutas = hojaRutas;
	}

	public HojaRuta addHojaRuta(HojaRuta hojaRuta) {
		getHojaRutas().add(hojaRuta);
		hojaRuta.setMensajero(this);

		return hojaRuta;
	}

	public HojaRuta removeHojaRuta(HojaRuta hojaRuta) {
		getHojaRutas().remove(hojaRuta);
		hojaRuta.setMensajero(null);

		return hojaRuta;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

}