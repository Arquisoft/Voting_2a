package es.uniovi.asw.rest;

import java.io.Serializable;

public class RecuentoPieRest implements Serializable {

	private static final long serialVersionUID = 220245687893918214L;
	private String value;
	private String label;

	public RecuentoPieRest() {

	}

	public RecuentoPieRest(String label, String value) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if(value != null && !value.isEmpty())
		   this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if(label != null && !label.isEmpty())
		   this.label = label;
	}

}
