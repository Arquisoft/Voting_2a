package es.uniovi.asw.rest;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;

public class VotoRestTest {

	private VotoRest vr = new VotoRest();
	private VotoRest vr1 = new VotoRest((long) 1, (long) 1, "Si", true);

	@Test
	public void testEleccion() {

		vr.setEleccion("Eleccion1");
		assertTrue(vr.getEleccion().equals("Eleccion1"));
		//assertFalse(vr.getEleccion().equals(null));
		assertNotNull(vr.getEleccion());
		vr.setEleccion(null);
		
		assertTrue(vr.getEleccion().equals("Eleccion1"));
		//assertFalse(vr.getEleccion().equals(null));
		assertNotNull(vr.getEleccion());
		vr.setEleccion("Eleccion7");
		assertTrue(vr.getEleccion().equals("Eleccion7"));
		assertFalse(vr.getEleccion().equals("Eleccion1"));
		//assertFalse(vr.getEleccion().equals(null));
		assertNotNull(vr.getEleccion());
		
		vr.setEleccion("");
		assertFalse(vr.getEleccion().equals(""));
		assertTrue(vr.getEleccion().equals("Eleccion7"));
		assertFalse(vr.getEleccion().equals("Eleccion1"));
		//assertFalse(vr.getEleccion().equals(null));
		assertNotNull(vr.getEleccion());
		
	}

	@Test
	public void testColegioElectoral() {

		vr.setColegioElectoral("Colegio1");
		assertTrue(vr.getColegioElectoral().equals("Colegio1"));
		//assertFalse(vr.getColegioElectoral().equals(null));
		assertNull(vr.getEleccion());
		
		vr.setColegioElectoral(null);
		assertTrue(vr.getColegioElectoral().equals("Colegio1"));
		//assertFalse(vr.getColegioElectoral().equals(null));
		assertNull(vr.getEleccion());
		
		vr.setColegioElectoral("Colegio2");
		assertTrue(vr.getColegioElectoral().equals("Colegio2"));
		assertFalse(vr.getColegioElectoral().equals("Colegio1"));
		//assertFalse(vr.getColegioElectoral().equals(null));
		assertNull(vr.getEleccion());
		
		vr.setColegioElectoral("");
		assertFalse(vr.getColegioElectoral().equals(""));
		assertTrue(vr.getColegioElectoral().equals("Colegio2"));
		assertFalse(vr.getColegioElectoral().equals("Colegio1"));
		//assertFalse(vr.getColegioElectoral().equals(null));
		assertNull(vr.getEleccion());
		
	}

	@Test
	public void testOpcion() {

		vr.setOpcion("No");
		assertTrue(vr.getOpcion().equals("No"));
		//assertFalse(vr.getOpcion().equals(null));
		assertNull(vr.getEleccion());

		vr.setOpcion(null);
		assertTrue(vr.getOpcion().equals("No"));
		//assertFalse(vr.getOpcion().equals(null));
		assertNull(vr.getEleccion());
		
		vr.setOpcion("Si");
		assertTrue(vr.getOpcion().equals("Si"));
		assertFalse(vr.getOpcion().equals("No"));
		//assertFalse(vr.getOpcion().equals(null));
		assertNull(vr.getEleccion());
		
		vr.setOpcion("");
		assertFalse(vr.getOpcion().equals(""));
		assertTrue(vr.getOpcion().equals("Si"));
		assertFalse(vr.getOpcion().equals("No"));
		//assertFalse(vr.getOpcion().equals(null));
		assertNull(vr.getEleccion());
		
	}

	@Test
	public void testOnline() {

		vr.setOnline(true);
		assertTrue(vr.isOnline());
		//assertFalse(!vr.isOnline());
		vr.setOnline(false);
		//assertTrue(!vr.isOnline());
		assertFalse(vr.isOnline());
	}

	@Test
	public void testConstructor() {

		assertTrue(vr1.getEleccion().equals("1"));
		assertFalse(vr1.getEleccion().equals("4"));
		//assertFalse(vr1.getEleccion().equals(null));
		assertNull(vr.getEleccion());
		assertFalse(vr1.getEleccion().equals(""));

		assertTrue(vr1.getColegioElectoral().equals("1"));
		assertFalse(vr1.getColegioElectoral().equals("2"));
		//assertFalse(vr1.getColegioElectoral().equals(null));
		assertNull(vr.getEleccion());
		assertFalse(vr1.getColegioElectoral().equals(""));

		assertTrue(vr1.getOpcion().equals("Si"));
		assertFalse(vr1.getOpcion().equals("No"));
		//assertFalse(vr1.getOpcion().equals(null));
		assertNull(vr.getEleccion());
		assertFalse(vr1.getOpcion().equals(""));

		assertTrue(vr1.isOnline());
		//assertFalse(!vr1.isOnline());

	}

}
