package es.uniovi.asw.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecuentoTest {

	private Recuento rec = new Recuento();

	@Test
	public void testIdEleccion() {

		rec.setIdEleccion((long) 3);
		assertTrue(rec.getIdEleccion().equals((long) 3));
		assertFalse(rec.getIdEleccion().equals(null));

		rec.setIdEleccion((long) 0);
		assertFalse(rec.getIdEleccion().equals((long) 0));
		assertTrue(rec.getIdEleccion().equals((long) 3));

		rec.setIdEleccion((long) -1);
		assertFalse(rec.getIdEleccion().equals((long) -1));
		assertTrue(rec.getIdEleccion().equals((long) 3));

		rec.setIdEleccion(null);
		assertFalse(rec.getIdEleccion().equals(null));
		assertTrue(rec.getIdEleccion().equals((long) 3));

	}

	@Test
	public void testOpcion() {

		rec.setOpcion("No");
		assertTrue(rec.getOpcion().equals("No"));

		rec.setOpcion(null);
		assertFalse(rec.getOpcion().equals(null));
		assertTrue(rec.getOpcion().equals("No"));

		rec.setOpcion("Si");
		assertTrue(rec.getOpcion().equals("Si"));
		assertFalse(rec.getOpcion().equals("No"));
		assertFalse(rec.getOpcion().equals(null));

		rec.setOpcion("");
		assertFalse(rec.getOpcion().equals(""));
		assertTrue(rec.getOpcion().equals("Si"));
		assertFalse(rec.getOpcion().equals("No"));
		assertFalse(rec.getOpcion().equals(null));

	}

	@Test
	public void testTotal() {

		rec.setTotal((long) 60);
		assertTrue(rec.getTotal().equals((long) 60));
		assertFalse(rec.getTotal().equals(null));

		rec.setTotal((long) 0);
		assertTrue(rec.getTotal().equals((long) 0));

		rec.setTotal((long) -5);
		assertFalse(rec.getTotal().equals((long) -5));
		assertTrue(rec.getTotal().equals((long) 0));

		rec.setTotal(null);
		assertFalse(rec.getTotal().equals(null));
		assertTrue(rec.getTotal().equals((long) 0));

	}

}
