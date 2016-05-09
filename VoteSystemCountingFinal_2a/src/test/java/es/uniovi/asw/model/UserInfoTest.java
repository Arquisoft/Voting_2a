package es.uniovi.asw.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserInfoTest {

	@Test
	public void test() {
		
		UserInfo user = new UserInfo("login", "pass");
		user= new UserInfo("login","");
		assertEquals("login", user.getLogin());
		
		user.setPassword("");
		assertNull(user.getPassword());
		user.setPassword("newPass");
		assertEquals("newPass", user.getPassword());

		
		user.setCodColElectoral(1);
		assertEquals(1, user.getCodColElectoral());

		user.setEmail("uo230766@uniovi.es");
		assertEquals("uo230766@uniovi.es", user.getEmail());

		user.setNIF("53548918L");
		assertEquals("53548918L", user.getNIF());

		user.setLogin("log2");
		assertEquals("log2", user.getLogin());

		user.setNombre("Dario");
		assertEquals("Dario", user.getNombre());

		user.setVotoElectronico(true);
		assertTrue(user.isVotoElectronico());
		user.setVotoElectronico(false);
		assertFalse(user.isVotoElectronico());
		
		assertTrue(user.emailCorrecto("uo230766@uniovi.es"));
		assertFalse(user.emailCorrecto("micorreo"));
		
		assertTrue(user.nifCorrecto("53548918L"));
		assertFalse(user.nifCorrecto("53548925HL"));
		
	}

}
