
package es.uniovi.asw.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.controller.exception.NotValidValueException;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.repository.RecuentoRepository;
import es.uniovi.asw.repository.VotoRepository;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class RecuentoServiceTest {
	@Autowired
	RecuentoService recuento;

	@Autowired
	RecuentoRepository repRec;

	@Autowired
	VotoRepository votoRepo;

	Long idEleccion = new Long(1);

	@Test(expected = NotValidValueException.class)
	public void realizarRecuentoNuloTest() {
		Voto v = null;
		TestCase.assertNull(v);
		v = new Voto();
		v.setIdColegio(new Long(1));
		v.setIdEleccion(new Long(1));
		v.setOpcion("No");
		int temp = this.votoRepo.findAll().size();
		v = this.votoRepo.save(v);

		TestCase.assertTrue(this.votoRepo.findAll().contains(v));
		TestCase.assertTrue(temp < this.votoRepo.findAll().size());

		TestCase.assertTrue(v != null);
		TestCase.assertTrue(recuento != null);
		if (recuento != null)
			recuento.publicarRecuento(idEleccion);

	}

	@Test(expected = IllegalArgumentException.class)
	public void realizarRecuentoIdNuloTest() {
		Long id = null;
		Voto v = null;
		TestCase.assertNull(v);
		v = new Voto();
		v.setIdColegio(new Long(1));
		v.setIdEleccion(new Long(1));
		v.setOpcion("Si");
		int temp = this.votoRepo.findAll().size();
		v = this.votoRepo.save(v);

		TestCase.assertTrue(this.votoRepo.findAll().contains(v));
		TestCase.assertTrue(temp < this.votoRepo.findAll().size());

		TestCase.assertTrue(v != null);
		TestCase.assertTrue(recuento != null);
		recuento.publicarRecuento(id);

	}

}
