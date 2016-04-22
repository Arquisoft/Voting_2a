package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.model.Recuento;
import es.uniovi.asw.rest.RecuentoPieRest;
import es.uniovi.asw.service.RecuentoService;

@RestController
public class RecuentoEstadisticasController {

	@Autowired
	private RecuentoService recuentoService;

	private static final Logger LOG = LoggerFactory.getLogger(RecuentoEstadisticasController.class);

	@RequestMapping("/recuento/pie")
	public List<RecuentoPieRest> verEstadisticas(Long idEleccion) {
		LOG.info("verEstadisticas page access");

		List<RecuentoPieRest> recuento = new ArrayList<RecuentoPieRest>();

		try {
			RecuentoPieRest rec = null;
			for (Recuento r : this.recuentoService.publicarRecuento(idEleccion)) {
				rec = new RecuentoPieRest(r.getOpcion(), r.getTotal() + "");
				recuento.add(rec);
			}
		} catch (Exception e) {
			LOG.error("Error al recuperar recuento " + e);
		}

		return recuento;
	}

}
