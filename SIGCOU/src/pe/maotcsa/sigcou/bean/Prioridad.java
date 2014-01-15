package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Prioridades database table.
 * 
 */
@Entity
@Table(name="Prioridades")
@NamedQuery(name="Prioridad.findAll", query="SELECT p FROM Prioridad p")
public class Prioridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PrioridadId")
	private int prioridadId;

	@Column(name="PrioridadDescripcion")
	private String prioridadDescripcion;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="prioridade")
	private List<Envio> envios;

	public Prioridad() {
	}

	public int getPrioridadId() {
		return this.prioridadId;
	}

	public void setPrioridadId(int prioridadId) {
		this.prioridadId = prioridadId;
	}

	public String getPrioridadDescripcion() {
		return this.prioridadDescripcion;
	}

	public void setPrioridadDescripcion(String prioridadDescripcion) {
		this.prioridadDescripcion = prioridadDescripcion;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setPrioridade(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setPrioridade(null);

		return envio;
	}

}