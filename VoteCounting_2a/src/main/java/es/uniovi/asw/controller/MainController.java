package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.model.Recuento;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.rest.RecuentoRest;
import es.uniovi.asw.rest.VotoRest;
import es.uniovi.asw.service.RecuentoService;
import es.uniovi.asw.service.VotoService;

//@RestController
@Controller
public class MainController {

	@Autowired
	private VotoService votoService;

	@Autowired
	private RecuentoService recuentoService;

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public ModelAndView landing() {
		LOG.info("Landing page access");
		return new ModelAndView("landing");
	}

	@RequestMapping("/online")
	public ModelAndView verResultadosOnline(Long idEleccion) {
		LOG.info("verResultadosOnline page access");
		List<VotoRest> votos = new ArrayList<VotoRest>();

		try {
			List<Voto> votosModel = this.votoService.obtenerVotos(idEleccion);

			if (votosModel != null && votosModel.size() > 0) {
				VotoRest voto = null;
				for (Voto v : votosModel) {
					voto = new VotoRest(v.getIdEleccion(), v.getIdColegio(), v.getOpcion(), v.isOnline());
					votos.add(voto);
				}
			}
		} catch (Exception e) {
			LOG.error("Error al recuperar votos " + e);
			return new ModelAndView("error", "error", "Error al recuperar votos " + e);
		}

		return new ModelAndView("online", "votos", votos);
	}

	@RequestMapping("/recuento")
	public ModelAndView realizarRecuento(Long idEleccion) {
		LOG.info("realizarRecuento page access");
		try {
			this.votoService.realizarRecuento(idEleccion);
		} catch (Exception e) {
			LOG.error("Error al realizar recuento " + e);
			return new ModelAndView("error", "error", "Error al realizar recuento " + e);
		}
		return new ModelAndView("recuento");
	}

	@RequestMapping("/estadisticas")
	public ModelAndView verEstadisticas(Long idEleccion) {
		LOG.info("verEstadisticas page access");

		List<RecuentoRest> recuento = new ArrayList<RecuentoRest>();

		try {

			RecuentoRest rec = null;
			for (Recuento r : this.recuentoService.publicarRecuento(idEleccion)) {
				rec = new RecuentoRest(r.getIdEleccion(), r.getOpcion(), r.getTotal());
				recuento.add(rec);
			}
		} catch (Exception e) {
			LOG.error("Error al recuperar recuento " + e);
			return new ModelAndView("error", "error", "Error al recuperar recuento " + e);
		}

		return new ModelAndView("estadisticas", "recuento", recuento);
	}

}