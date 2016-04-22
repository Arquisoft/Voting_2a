package es.uniovi.asw.model;

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
public class UserInfoTest {

	UserInfo user = new UserInfo();
	UserInfo user1 = new UserInfo();

	@Test
	public void createUser() throws Exception {
		user = new UserInfo(null, "1");
		assertFalse(user.emailCorrecto(user.getEmail()));
		assertTrue(user.getPassword().equals("1"));
		assertTrue(user.getCodigoMesa() == 0);
		assertTrue(user.getNif() == null);
		assertTrue(user.getNombre() == null);

		user1 = new UserInfo("adrian@gmail.com", null);
		assertFalse(user1.passwordCorrecta(user1.getPassword()));
		assertTrue(user1.getEmail().equals("adrian@gmail.com"));
		assertFalse(user1.getCodigoMesa() == -1);
		assertTrue(user.getNif() == null);
		assertTrue(user.getNombre() == null);

	}

	@Test
	public void updateUser() throws Exception {
		user.setEmail("@.com");
		assertFalse(user.emailCorrecto(user.getEmail()));
		user.setEmail("a@");
		assertFalse(user.emailCorrecto(user.getEmail()));
		user.setEmail("a@a.com");
		assertTrue(user.emailCorrecto(user.getEmail()));
		assertTrue(user.getPassword()==null);
		user.setPassword("123456");
		assertTrue(user.passwordCorrecta(user.getPassword()));
		user.setEmail("");
		assertFalse(user.getEmail().equals(""));
		user.setNif("");
		assertFalse(user.nifCorrecto(user.getNif()));

		user1.setCodigoMesa(2);
		assertTrue(user1.getCodigoMesa() == 2);
		user1.setCodigoMesa(0);
		assertFalse(user1.getCodigoMesa() == 0);
		user1.setNombre("Daniel");
		assertTrue(user1.getNombre().equals("Daniel"));
		user1.setNombre(null);
		assertFalse(user1.getNombre().equals(null));

		user1.setNif(null);
		assertFalse(user1.nifCorrecto(user1.getNif()));
		user1.setNif("1234567");
		assertFalse(user1.nifCorrecto(user1.getNif()));
		user1.setNif("123456789");
		assertFalse(user1.nifCorrecto(user1.getNif()));
		user1.setNif("77777777A");
		assertTrue(user1.nifCorrecto(user1.getNif()));
		assertFalse(!user1.nifCorrecto(user1.getNif()));
	}

	@Test
	public void deleteUser() throws Exception {
		assertTrue(user != null);
		assertTrue(user1 != null);
		user = null;
		user1 = null;
		assertTrue(user == null);
		assertTrue(user1 == null);
	}

}
