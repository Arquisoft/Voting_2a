package es.uniovi.asw.rest;

import java.io.Serializable;

public class LoginRest implements Serializable {

	private static final long serialVersionUID = 5702030848872918214L;
	private String login;
	private String password;

	public LoginRest() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
