package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Trabajadores database table.
 * 
 */
@Entity
@Table(name="Trabajadores")
@NamedQuery(name="Trabajador.findAll", query="SELECT t FROM Trabajador t")
public class Trabajador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TrabajadorId")
	private int trabajadorId;

	@Column(name="Rol")
	private int rol;

	@Column(name="TrabajadorApellido")
	private String trabajadorApellido;

	@Column(name="TrabajadorNombre")
	private String trabajadorNombre;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="trabajadore")
	private List<Login> logins;

	public Trabajador() {
	}

	public int getTrabajadorId() {
		return this.trabajadorId;
	}

	public void setTrabajadorId(int trabajadorId) {
		this.trabajadorId = trabajadorId;
	}

	public int getRol() {
		return this.rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getTrabajadorApellido() {
		return this.trabajadorApellido;
	}

	public void setTrabajadorApellido(String trabajadorApellido) {
		this.trabajadorApellido = trabajadorApellido;
	}

	public String getTrabajadorNombre() {
		return this.trabajadorNombre;
	}

	public void setTrabajadorNombre(String trabajadorNombre) {
		this.trabajadorNombre = trabajadorNombre;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setTrabajadore(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setTrabajadore(null);

		return login;
	}

}