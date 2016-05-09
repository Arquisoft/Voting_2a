package es.uniovi.asw.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EleccionInfoTest {

	@Test
	public void test() {
		
		EleccionInfo elec = new EleccionInfo();
		
		elec.setDefinicion("Referendum");
		
		assertEquals("Referendum",elec.getDefinicion());
		
		
	}

}
