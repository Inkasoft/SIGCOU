package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GuiaDespacho database table.
 * 
 */
@Entity
@NamedQuery(name="GuiaDespacho.findAll", query="SELECT g FROM GuiaDespacho g")
public class GuiaDespacho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GuiaDespachoId")
	private int guiaDespachoId;

	@Column(name="GuiaDespachoDestino")
	private String guiaDespachoDestino;

	@Temporal(TemporalType.DATE)
	@Column(name="GuiaDespachoFecha")
	private Date guiaDespachoFecha;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="guiaDespacho")
	private List<Envio> envios;

	public GuiaDespacho() {
	}

	public int getGuiaDespachoId() {
		return this.guiaDespachoId;
	}

	public void setGuiaDespachoId(int guiaDespachoId) {
		this.guiaDespachoId = guiaDespachoId;
	}

	public String getGuiaDespachoDestino() {
		return this.guiaDespachoDestino;
	}

	public void setGuiaDespachoDestino(String guiaDespachoDestino) {
		this.guiaDespachoDestino = guiaDespachoDestino;
	}

	public Date getGuiaDespachoFecha() {
		return this.guiaDespachoFecha;
	}

	public void setGuiaDespachoFecha(Date guiaDespachoFecha) {
		this.guiaDespachoFecha = guiaDespachoFecha;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setGuiaDespacho(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setGuiaDespacho(null);

		return envio;
	}

}