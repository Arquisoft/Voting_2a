package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.PrecargaDeDatosService;
import es.uniovi.asw.business.impl.classes.PrecargaDeDatos;

public class SimplePrecargaDeDatosService implements PrecargaDeDatosService {

	public void precargaDeDatos() {
		new PrecargaDeDatos().precarga();
	}


}
