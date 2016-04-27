package es.uniovi.asw.controller;

import static org.junit.Assert.assertFalse;

public class RecuentoEstadisticasControllerTest {

	private RecuentoEstadisticasController r = new RecuentoEstadisticasController();

	public void testRecuentoEstadisticas() {
		r.verEstadisticas(null); // Lanza excepción

		assertFalse(r.verEstadisticas(new Long(1)) == null);

	}

}
