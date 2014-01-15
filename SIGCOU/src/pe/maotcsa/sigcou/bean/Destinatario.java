package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Destinatarios database table.
 * 
 */
@Entity
@Table(name="Destinatarios")
@NamedQuery(name="Destinatario.findAll", query="SELECT d FROM Destinatario d")
public class Destinatario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DestinatarioId")
	private int destinatarioId;

	@Column(name="DestinatarioNombre")
	private String destinatarioNombre;

	@Column(name="DestinatarioTelefono")
	private String destinatarioTelefono;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="destinatario")
	private List<Envio> envios;

	public Destinatario() {
	}

	public int getDestinatarioId() {
		return this.destinatarioId;
	}

	public void setDestinatarioId(int destinatarioId) {
		this.destinatarioId = destinatarioId;
	}

	public String getDestinatarioNombre() {
		return this.destinatarioNombre;
	}

	public void setDestinatarioNombre(String destinatarioNombre) {
		this.destinatarioNombre = destinatarioNombre;
	}

	public String getDestinatarioTelefono() {
		return this.destinatarioTelefono;
	}

	public void setDestinatarioTelefono(String destinatarioTelefono) {
		this.destinatarioTelefono = destinatarioTelefono;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setDestinatario(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setDestinatario(null);

		return envio;
	}

}