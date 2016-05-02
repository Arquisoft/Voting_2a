package es.uniovi.asw.rest;

import java.io.Serializable;

public class RecuentoRest implements Serializable {

	private static final long serialVersionUID = 2202030848123918214L;
	private String eleccion;
	private String opcion;
	private Long total;

	public RecuentoRest() {

	}

	public RecuentoRest(Long eleccion, String opcion, Long total) {
		super();
		this.eleccion = eleccion + "";
		this.opcion = opcion;
		this.total = total;
	}

	public String getEleccion() {
		return eleccion;
	}

	public void setEleccion(String eleccion) {
		if(eleccion != null && !eleccion.isEmpty())
		   this.eleccion = eleccion;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		if(opcion != null && !opcion.isEmpty())
		   this.opcion = opcion;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		if(total != null && total >= 0)
		   this.total = total;
	}

}
