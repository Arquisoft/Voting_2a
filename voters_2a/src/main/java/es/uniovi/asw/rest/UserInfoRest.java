package es.uniovi.asw.rest;

import java.io.Serializable;

public class UserInfoRest implements Serializable {

	private static final long serialVersionUID = 2202030848123918214L;
	private String name;
	private String nif;
	private String email;
	private int pollingStationCode;

	public UserInfoRest() {

	}

	public UserInfoRest(String name, String nif, String email, int pollingStationCode) {
		super();
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.pollingStationCode = pollingStationCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(int pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

}
