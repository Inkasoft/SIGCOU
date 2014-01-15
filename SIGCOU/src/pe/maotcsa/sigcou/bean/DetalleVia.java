package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DetalleVias database table.
 * 
 */
@Entity
@Table(name="DetalleVias")
@NamedQuery(name="DetalleVia.findAll", query="SELECT d FROM DetalleVia d")
public class DetalleVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DetalleViaId")
	private int detalleViaId;

	@Column(name="Agencia")
	private String agencia;

	@Temporal(TemporalType.DATE)
	@Column(name="FechaEnvio")
	private Date fechaEnvio;

	//bi-directional many-to-one association to Via
	@ManyToOne
	@JoinColumn(name="ViaId")
	private Via via;

	public DetalleVia() {
	}

	public int getDetalleViaId() {
		return this.detalleViaId;
	}

	public void setDetalleViaId(int detalleViaId) {
		this.detalleViaId = detalleViaId;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Via getVia() {
		return this.via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

}