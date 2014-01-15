package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Ubigeos database table.
 * 
 */
@Entity
@Table(name="Ubigeos")
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UbigeoId")
	private String ubigeoId;

	@Column(name="Departamento")
	private String departamento;

	@Column(name="Distrito")
	private String distrito;

	@Column(name="Provincia")
	private String provincia;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="ubigeo")
	private List<Envio> envios;

	public Ubigeo() {
	}

	public String getUbigeoId() {
		return this.ubigeoId;
	}

	public void setUbigeoId(String ubigeoId) {
		this.ubigeoId = ubigeoId;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setUbigeo(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setUbigeo(null);

		return envio;
	}

}