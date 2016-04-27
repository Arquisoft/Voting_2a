
package es.uniovi.asw.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.model.Recuento;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.repository.VotoRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })

public class VotoServiceTest {

	@Autowired
	private VotoRepository votos;

	@Autowired
	private VotoService vS;

	private Long eleccionId = (long) 1;

	@Test
	public void testObtenerVotos() {

		if (eleccionId == null)
			throw new IllegalArgumentException("eleccionId no puede ser nulo");
		else
			TestCase.assertNotNull(votos.findByIdEleccion(eleccionId));

	}

	@Test
	public void testRealizarRecuento() {

		if (votos.findByIdEleccion(eleccionId) == null)
			TestCase.assertNull(votos.findByIdEleccion(new Long(1)));

		if (eleccionId == null)
			throw new IllegalArgumentException("eleccionId no puede ser nulo");

		Map<String, Long> recuento = new HashMap<String, Long>();

		Recuento r = null;
		Iterator<Entry<String, Long>> it = recuento.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, Long> e = it.next();
			r = new Recuento();
			r.setIdEleccion(eleccionId);
			r.setOpcion(e.getKey());
			r.setTotal(e.getValue());
		}

		TestCase.assertNotNull(it);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerVotosIdNuloTest() {

		Long id = null;
		Voto v = null;
		TestCase.assertNull(v);
		v = new Voto();
		v.setIdColegio(new Long(1));
		v.setIdEleccion(new Long(1));
		v.setOpcion("No");
		int temp = this.votos.findAll().size();
		v = this.votos.save(v);

		TestCase.assertTrue(this.votos.findAll().contains(v));
		TestCase.assertTrue(temp < this.votos.findAll().size());

		TestCase.assertTrue(v != null);
		TestCase.assertTrue(vS != null);
		vS.obtenerVotos(id);

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
		int temp = this.votos.findAll().size();
		v = this.votos.save(v);

		TestCase.assertTrue(this.votos.findAll().contains(v));
		TestCase.assertTrue(temp < this.votos.findAll().size());

		TestCase.assertTrue(v != null);
		TestCase.assertTrue(vS != null);
		vS.realizarRecuento(id);

	}

}
