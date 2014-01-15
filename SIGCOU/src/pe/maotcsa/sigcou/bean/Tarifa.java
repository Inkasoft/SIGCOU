package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Tarifas database table.
 * 
 */
@Entity
@Table(name="Tarifas")
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TarifaId")
	private int tarifaId;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="tarifa")
	private List<Envio> envios;

	public Tarifa() {
	}

	public int getTarifaId() {
		return this.tarifaId;
	}

	public void setTarifaId(int tarifaId) {
		this.tarifaId = tarifaId;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setTarifa(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setTarifa(null);

		return envio;
	}

}