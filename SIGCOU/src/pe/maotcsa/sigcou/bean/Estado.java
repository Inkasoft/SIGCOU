package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Estados database table.
 * 
 */
@Entity
@Table(name="Estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EstadoId")
	private int estadoId;

	@Column(name="EstadoDetalle")
	private String estadoDetalle;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="estado")
	private List<Historial> historiales;

	public Estado() {
	}

	public int getEstadoId() {
		return this.estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public String getEstadoDetalle() {
		return this.estadoDetalle;
	}

	public void setEstadoDetalle(String estadoDetalle) {
		this.estadoDetalle = estadoDetalle;
	}

	public List<Historial> getHistoriales() {
		return this.historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}

	public Historial addHistoriale(Historial historiale) {
		getHistoriales().add(historiale);
		historiale.setEstado(this);

		return historiale;
	}

	public Historial removeHistoriale(Historial historiale) {
		getHistoriales().remove(historiale);
		historiale.setEstado(null);

		return historiale;
	}

}