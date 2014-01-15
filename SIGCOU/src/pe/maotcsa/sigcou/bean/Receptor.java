package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Receptores database table.
 * 
 */
@Entity
@Table(name="Receptores")
@NamedQuery(name="Receptor.findAll", query="SELECT r FROM Receptor r")
public class Receptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReceptorId")
	private int receptorId;

	@Column(name="Observacion")
	private String observacion;

	@Column(name="Parentesco")
	private String parentesco;

	@Temporal(TemporalType.DATE)
	@Column(name="ReceptorFecha")
	private Date receptorFecha;

	@Column(name="ReceptorNombre")
	private String receptorNombre;

	@Column(name="ReceptorNumeroDocumento")
	private String receptorNumeroDocumento;

	@Column(name="ReceptorTipoDocumento")
	private String receptorTipoDocumento;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="receptore")
	private List<Envio> envios;

	public Receptor() {
	}

	public int getReceptorId() {
		return this.receptorId;
	}

	public void setReceptorId(int receptorId) {
		this.receptorId = receptorId;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Date getReceptorFecha() {
		return this.receptorFecha;
	}

	public void setReceptorFecha(Date receptorFecha) {
		this.receptorFecha = receptorFecha;
	}

	public String getReceptorNombre() {
		return this.receptorNombre;
	}

	public void setReceptorNombre(String receptorNombre) {
		this.receptorNombre = receptorNombre;
	}

	public String getReceptorNumeroDocumento() {
		return this.receptorNumeroDocumento;
	}

	public void setReceptorNumeroDocumento(String receptorNumeroDocumento) {
		this.receptorNumeroDocumento = receptorNumeroDocumento;
	}

	public String getReceptorTipoDocumento() {
		return this.receptorTipoDocumento;
	}

	public void setReceptorTipoDocumento(String receptorTipoDocumento) {
		this.receptorTipoDocumento = receptorTipoDocumento;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setReceptore(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setReceptore(null);

		return envio;
	}

}