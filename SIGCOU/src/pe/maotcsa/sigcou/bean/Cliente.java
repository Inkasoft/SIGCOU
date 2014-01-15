package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Clientes database table.
 * 
 */
@Entity
@Table(name="Clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClienteId")
	private int clienteId;

	@Column(name="ClienteApellido")
	private String clienteApellido;

	@Column(name="ClienteNombre")
	private String clienteNombre;

	@Column(name="ClienteNumeroDocumento")
	private String clienteNumeroDocumento;

	@Column(name="ClienteTelefono")
	private String clienteTelefono;

	@Column(name="ClienteTipoDocumento")
	private String clienteTipoDocumento;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="Email")
	private String email;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="cliente")
	private List<Envio> envios;

	//bi-directional many-to-one association to ManifiestoDespacho
	@OneToMany(mappedBy="cliente")
	private List<ManifiestoDespacho> manifiestoDespachos;

	public Cliente() {
	}

	public int getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteApellido() {
		return this.clienteApellido;
	}

	public void setClienteApellido(String clienteApellido) {
		this.clienteApellido = clienteApellido;
	}

	public String getClienteNombre() {
		return this.clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public String getClienteNumeroDocumento() {
		return this.clienteNumeroDocumento;
	}

	public void setClienteNumeroDocumento(String clienteNumeroDocumento) {
		this.clienteNumeroDocumento = clienteNumeroDocumento;
	}

	public String getClienteTelefono() {
		return this.clienteTelefono;
	}

	public void setClienteTelefono(String clienteTelefono) {
		this.clienteTelefono = clienteTelefono;
	}

	public String getClienteTipoDocumento() {
		return this.clienteTipoDocumento;
	}

	public void setClienteTipoDocumento(String clienteTipoDocumento) {
		this.clienteTipoDocumento = clienteTipoDocumento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setCliente(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setCliente(null);

		return envio;
	}

	public List<ManifiestoDespacho> getManifiestoDespachos() {
		return this.manifiestoDespachos;
	}

	public void setManifiestoDespachos(List<ManifiestoDespacho> manifiestoDespachos) {
		this.manifiestoDespachos = manifiestoDespachos;
	}

	public ManifiestoDespacho addManifiestoDespacho(ManifiestoDespacho manifiestoDespacho) {
		getManifiestoDespachos().add(manifiestoDespacho);
		manifiestoDespacho.setCliente(this);

		return manifiestoDespacho;
	}

	public ManifiestoDespacho removeManifiestoDespacho(ManifiestoDespacho manifiestoDespacho) {
		getManifiestoDespachos().remove(manifiestoDespacho);
		manifiestoDespacho.setCliente(null);

		return manifiestoDespacho;
	}

}