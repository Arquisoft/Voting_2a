package es.uniovi.asw.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserInfoTest {

	@Test
	public void test() {
		
		UserInfo user = new UserInfo("login", "pass");
		assertEquals("login", user.getLogin());
		
		user.setPassword("");
		assertEquals("pass", user.getPassword());
		
		user.setCodColElectoral(1);
		
		user.setEmail("uo230766@uniovi.es");
		
		user.setNIF("53548918L");
		
		user.setLogin("log2");
		
		user.setNombre("Dario");
		
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
