package es.uniovi.asw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class RecuentoRepositoryTest {

	@Autowired
	private RecuentoRepository recuento;

	private Long id;
	private Long idEleccion;

	@Test
	public void testFindAll() {

		TestCase.assertNotNull(recuento.findAll());

	}

	@Test
	public void testFindOne() {

		if (id == null)
			assertTrue(recuento.findOne(-1L) == null);
		else
			assertFalse(recuento.findOne(id) == null);

	}

	@Test
	public void testExists() {

		if (id == null)
			assertFalse(recuento.exists(-1L));
		else
			assertTrue(recuento.exists(id));

	}

	@Test
	public void testCount() {

		assertEquals(recuento.count(), 0);
		assertFalse(recuento.count() < 0);
		assertFalse(recuento.count() > 0);

	}

	@Test
	public void testFindByIdEleccion() {

		if (idEleccion == null)
			TestCase.assertNotNull(recuento.findByIdEleccion(-1L));
		else
			TestCase.assertNotNull(recuento.findByIdEleccion(idEleccion));
	}

}
