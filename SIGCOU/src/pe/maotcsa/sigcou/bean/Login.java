package pe.maotcsa.sigcou.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LoginId")
	private int loginId;

	@Column(name="Password")
	private String password;

	@Column(name="Usuario")
	private String usuario;

	//bi-directional many-to-one association to Trabajador
	@ManyToOne
	@JoinColumn(name="TrabajadorId")
	private Trabajador trabajadore;

	public Login() {
	}

	public int getLoginId() {
		return this.loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Trabajador getTrabajadore() {
		return this.trabajadore;
	}

	public void setTrabajadore(Trabajador trabajadore) {
		this.trabajadore = trabajadore;
	}

}