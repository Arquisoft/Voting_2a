package es.uniovi.asw.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class UserInfoRestTest {

	@Test
	public void loginRestTest() throws Exception {
		UserInfoRest r = new UserInfoRest();
		assertTrue(r.getName() == null);
		assertTrue(r.getNif() == null);
		assertTrue(r.getEmail() == null);
		assertTrue(r.getPollingStationCode() == 0);
		r = new UserInfoRest("Jose", "77777777J", "jose@email.com", 33333);
		assertFalse(r.getName() == null);
		assertFalse(r.getNif() == null);
		assertFalse(r.getEmail() == null);
		assertFalse(r.getPollingStationCode() == 0);

	}

}
