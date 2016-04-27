package es.uniovi.asw.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColegioElectoralTest {

	private ColegioElectoral cE = new ColegioElectoral();

	@Test
	public void testNombre() {

		cE.setNombre("Colegio2");
		assertTrue(cE.getNombre().equals("Colegio2"));

		cE.setNombre(null);
		assertFalse(cE.getNombre().equals(null));
		assertTrue(cE.getNombre().equals("Colegio2"));

		cE.setNombre("Colegio8");
		assertTrue(cE.getNombre().equals("Colegio8"));
		assertFalse(cE.getNombre().equals("Colegio2"));
		assertFalse(cE.getNombre().equals(null));

		cE.setNombre("");
		assertFalse(cE.getNombre().equals(""));
		assertTrue(cE.getNombre().equals("Colegio8"));

		cE.setNombre("Colegio10");
		assertTrue(cE.getNombre().equals("Colegio10"));
		assertFalse(cE.getNombre().equals("Colegio8"));
		assertFalse(cE.getNombre().equals(null));

	}

}
