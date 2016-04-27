package es.uniovi.asw.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VotoTest {

	private Voto v = new Voto();

	@Test
	public void testIdColegio() {

		v.setIdColegio((long) 2);
		assertTrue(v.getIdColegio().equals((long) 2));
		assertFalse(v.getIdColegio().equals(null));

		v.setIdColegio((long) 0);
		assertFalse(v.getIdColegio().equals((long) 0));
		assertTrue(v.getIdColegio().equals((long) 2));

		v.setIdColegio((long) -10);
		assertFalse(v.getIdColegio().equals((long) -10));
		assertTrue(v.getIdColegio().equals((long) 2));

		v.setIdColegio(null);
		assertFalse(v.getIdColegio().equals(null));
		assertTrue(v.getIdColegio().equals((long) 2));

	}

	@Test
	public void testIdEleccion() {

		v.setIdEleccion((long) 5);
		assertTrue(v.getIdEleccion().equals((long) 5));
		assertFalse(v.getIdEleccion().equals(null));

		v.setIdEleccion((long) 0);
		assertTrue(v.getIdEleccion().equals((long) 5));
		assertFalse(v.getIdEleccion().equals((long) 0));
		assertFalse(v.getIdEleccion().equals(null));

		v.setIdEleccion((long) -20);
		assertFalse(v.getIdEleccion().equals((long) -20));
		assertTrue(v.getIdEleccion().equals((long) 5));

		v.setIdEleccion(null);
		assertTrue(v.getIdEleccion().equals((long) 5));
		assertFalse(v.getIdEleccion().equals((long) -20));
		assertFalse(v.getIdEleccion().equals(null));

	}

	@Test
	public void testOpcion() {

		v.setOpcion("Si");
		assertTrue(v.getOpcion().equals("Si"));

		v.setOpcion(null);
		assertTrue(v.getOpcion().equals("Si"));
		assertFalse(v.getOpcion().equals(null));

		v.setOpcion("No");
		assertTrue(v.getOpcion().equals("No"));
		assertFalse(v.getOpcion().equals("Si"));
		assertFalse(v.getOpcion().equals(null));

		v.setOpcion("");
		assertTrue(v.getOpcion().equals("No"));
		assertFalse(v.getOpcion().equals(""));
		assertFalse(v.getOpcion().equals("Si"));
		assertFalse(v.getOpcion().equals(null));

	}

	@Test
	public void testOnline() {

		v.setOnline(false);
		assertTrue(!v.isOnline());
		assertFalse(v.isOnline());

		v.setOnline(true);
		assertTrue(v.isOnline());
		assertFalse(!v.isOnline());
	}

}
