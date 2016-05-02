package es.uniovi.asw.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecuentoRestTest {

	private RecuentoRest rr = new RecuentoRest();
	private RecuentoRest rr1 = new RecuentoRest((long) 2, "No", (long) 50);

	@Test
	public void testEleccion() {

		rr.setEleccion("Eleccion1");
		assertTrue(rr.getEleccion().equals("Eleccion1"));
		assertFalse(rr.getEleccion().equals(null));

		rr.setEleccion(null);
		assertTrue(rr.getEleccion().equals("Eleccion1"));
		assertFalse(rr.getEleccion().equals(null));

		rr.setEleccion("Eleccion7");
		assertTrue(rr.getEleccion().equals("Eleccion7"));
		assertFalse(rr.getEleccion().equals("Eleccion3"));
		assertFalse(rr.getEleccion().equals(null));

		rr.setEleccion("");
		assertFalse(rr.getEleccion().equals(""));
		assertTrue(rr.getEleccion().equals("Eleccion7"));
		assertFalse(rr.getEleccion().equals("Eleccion3"));
		assertFalse(rr.getEleccion().equals(null));

	}

	@Test
	public void testOpcion() {

		rr.setOpcion("Si");
		assertTrue(rr.getOpcion().equals("Si"));
		assertFalse(rr.getOpcion().equals(null));

		rr.setOpcion(null);
		assertTrue(rr.getOpcion().equals("Si"));
		assertFalse(rr.getOpcion().equals(null));

		rr.setOpcion("No");
		assertTrue(rr.getOpcion().equals("No"));
		assertFalse(rr.getOpcion().equals("Ns/Nc"));
		assertFalse(rr.getOpcion().equals(null));

		rr.setOpcion("");
		assertFalse(rr.getOpcion().equals(""));
		assertTrue(rr.getOpcion().equals("No"));
		assertFalse(rr.getOpcion().equals("Ns/Nc"));
		assertFalse(rr.getOpcion().equals(null));

	}

	@Test
	public void testTotal() {

		rr.setTotal((long) 40);
		assertTrue(rr.getTotal().equals((long) 40));
		assertFalse(rr.getTotal().equals(null));

		rr.setTotal((long) 0);
		assertTrue(rr.getTotal().equals((long) 0));
		assertFalse(rr.getTotal().equals(null));

		rr.setTotal((long) -3);
		assertTrue(rr.getTotal().equals((long) 0));
		assertFalse(rr.getTotal().equals((long) -3));

		rr.setTotal(null);
		assertTrue(rr.getTotal().equals((long) 0));
		assertFalse(rr.getTotal().equals(null));

	}

	@Test
	public void testConstructor() {

		assertTrue(rr1.getEleccion().equals("2"));
		assertFalse(rr1.getEleccion().equals("1"));
		assertFalse(rr1.getEleccion().equals(null));
		assertFalse(rr1.getEleccion().equals(""));

		assertTrue(rr1.getOpcion().equals("No"));
		assertFalse(rr1.getOpcion().equals("Si"));
		assertFalse(rr1.getOpcion().equals(null));
		assertFalse(rr1.getOpcion().equals(""));

		assertTrue(rr1.getTotal().equals((long) 50));
		assertFalse(rr1.getTotal().equals((long) 100));
		assertFalse(rr1.getTotal().equals(null));

	}

}
