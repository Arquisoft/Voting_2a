package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "votantes")
public class UserInfo extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String login;

	@Column(nullable = false)
	private String NIF;

	@Column(name = "CODCOLEGIO", nullable = false)
	private int codColElectoral;

	@Column(name = "VOTOELECTRONICO")
	private boolean votoElectronico;

	public UserInfo(String login, String password) {
		log.info("Creating user " + login + ". password: " + password);
		this.login = login;
		log.error("El email debe tener un valor correcto");
		if (passwordCorrecta(password))
			this.password = password;
		else
			log.error("La constraseña debe tener un valor correcto");
	}

	public UserInfo() {

	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	// public int getCodigoMesa() {
	// return codigo_mesa;
	// }

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		if (emailCorrecto(email))
			this.email = email;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty())
			this.nombre = nombre;
	}

	// public void setNif(String nif) {
	// if (nifCorrecto(nif))
	// this.nif = nif;
	// else
	// log.error("El NIF debe tener un valor correcto");
	// }

	// public void setCodigoMesa(int codigo) {
	// if (codigo > 0)
	// this.codigo_mesa = codigo;
	// else
	// log.error("El código de la mesa debe tener un valor correcto, por encima del valor 0");
	// }

	public void setPassword(String password) {
		if (passwordCorrecta(password))
			this.password = password;
		else
			log.error("La constraseña debe tener un valor correcto");
	}

	public boolean emailCorrecto(String email) {
		if (email != null)
			if (email.contains("@") && !email.startsWith("@")
					&& !email.endsWith("@"))
				return true;
		return false;
	}

	public boolean nifCorrecto(String nif) {
		if (nif != null && !nif.isEmpty())
			if (nif.length() == 9 && Character.isLetter(nif.charAt(8)))
				return true;
		return false;
	}

	public boolean passwordCorrecta(String pass) {
		if (pass != null && !pass.isEmpty())
			return true;
		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public int getCodColElectoral() {
		return codColElectoral;
	}

	public void setCodColElectoral(int codColElectoral) {
		this.codColElectoral = codColElectoral;
	}

	public boolean isVotoElectronico() {
		return votoElectronico;
	}

	public void setVotoElectronico(boolean votoElectronico) {
		this.votoElectronico = votoElectronico;
	}

}
