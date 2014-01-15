package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Historiales database table.
 * 
 */
@Entity
@Table(name="Historiales")
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HistorialId")
	private int historialId;

	@Temporal(TemporalType.DATE)
	@Column(name="HistorialFecha")
	private Date historialFecha;

	//bi-directional many-to-one association to Envio
	@ManyToOne
	@JoinColumn(name="EnvioId")
	private Envio envio;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="EstadoId")
	private Estado estado;

	public Historial() {
	}

	public int getHistorialId() {
		return this.historialId;
	}

	public void setHistorialId(int historialId) {
		this.historialId = historialId;
	}

	public Date getHistorialFecha() {
		return this.historialFecha;
	}

	public void setHistorialFecha(Date historialFecha) {
		this.historialFecha = historialFecha;
	}

	public Envio getEnvio() {
		return this.envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}