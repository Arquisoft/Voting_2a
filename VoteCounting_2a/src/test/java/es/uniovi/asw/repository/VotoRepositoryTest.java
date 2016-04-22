package es.uniovi.asw.repository;

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
import es.uniovi.asw.model.Voto;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class VotoRepositoryTest {

	@Autowired
	private VotoRepository voto;

	private Long id;

	private Long idEleccion;

	@Test
	public void testFindAll() {

		assertTrue(voto.findAll() != null);

	}

	@Test
	public <S extends Voto> void testSaveS() {

		Voto v = null;
		TestCase.assertNull(v);
		v = new Voto();
		v.setIdColegio(new Long(1));
		v.setIdEleccion(new Long(1));
		v.setOpcion("No");
		int temp = this.voto.findAll().size();
		v = this.voto.save(v);
		TestCase.assertTrue(this.voto.findAll().contains(v));
		TestCase.assertTrue(temp < this.voto.findAll().size());
		TestCase.assertNotNull(v);

	}

	@Test
	public void testFindOne() {

		if (id == null)
			TestCase.assertNull(voto.findOne(-1L));
		else
			TestCase.assertNotNull(voto.findOne(id));

	}

	@Test
	public void testExists() {

		if (id == null)
			assertFalse(voto.exists(-1L));
		else
			assertTrue(voto.exists(id));

	}

	@Test
	public void testFindByIdEleccion() {

		if (idEleccion == null)
			assertFalse(voto.findByIdEleccion(idEleccion) == null);
		else
			assertFalse(voto.findByIdEleccion(idEleccion) == null);

	}

}
