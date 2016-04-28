package es.uniovi.asw.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EleccionTest {

	private Eleccion e = new Eleccion();

	@Test
	public void testNombre() {

		e.setNombre("Eleccion3");
		assertTrue(e.getNombre().equals("Eleccion3"));

		e.setNombre(null);
		assertFalse(e.getNombre().equals(null));
		assertTrue(e.getNombre().equals("Eleccion3"));

		e.setNombre("Eleccion1");
		assertTrue(e.getNombre().equals("Eleccion1"));
		assertFalse(e.getNombre().equals("Eleccion3"));
		assertFalse(e.getNombre().equals(null));

		e.setNombre("");
		assertFalse(e.getNombre().equals(""));
		assertTrue(e.getNombre().equals("Eleccion1"));
		assertFalse(e.getNombre().equals("Eleccion3"));
		assertFalse(e.getNombre().equals(null));

	}

}
