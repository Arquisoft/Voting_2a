package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.model.Recuento;
import es.uniovi.asw.model.VotoInfo;
import es.uniovi.asw.rest.RecuentoRest;
import es.uniovi.asw.rest.VotoRest;
import es.uniovi.asw.service.EleccionService;
import es.uniovi.asw.service.RecuentoService;
import es.uniovi.asw.service.VotoService;

//@RestController
@Controller
public class CountingController {

	@Autowired
	private EleccionService eleccionService;
	
	@Autowired
	private VotoService votoService;

	@Autowired
	private RecuentoService recuentoService;

	private static final Logger LOG = LoggerFactory
			.getLogger(CountingController.class);

	@RequestMapping(value = "/online", method = RequestMethod.POST)
	public ModelAndView verResultadosOnline(Long idEleccion) {
		LOG.info("verResultadosOnline page access");
		List<VotoRest> votos = new ArrayList<VotoRest>();

		try {
			List<VotoInfo> votosModel = this.votoService
					.obtenerVotos(idEleccion);

			if (votosModel != null && votosModel.size() > 0) {
				VotoRest voto = null;
				for (VotoInfo v : votosModel) {
					voto = new VotoRest(v.getIdEleccion(), v.getIdColegio(),
							v.getOpcion(), v.isOnline());
					votos.add(voto);
				}
			}
		} catch (Exception e) {
			LOG.error("Error al recuperar votos, no existe dicha idEleccion "
					+ e);
			return new ModelAndView("error", "error",
					"Error al recuperar votos " + e);
		}

		return new ModelAndView("onlineResult", "votos", votos);
	}

	@RequestMapping(value = "/online", method = RequestMethod.GET)
	public ModelAndView verResultadosOnline() {
		LOG.info("verResultadosOnline page access");

		return new ModelAndView("online", "elecciones", eleccionService.getAll());
	}

	@RequestMapping("/recuento")
	public ModelAndView realizarRecuento(Long idEleccion) {
		LOG.info("realizarRecuento page access");
		try {
			this.votoService.realizarRecuento(idEleccion);
		} catch (Exception e) {
			LOG.error("Error al realizar recuento " + e);
			return new ModelAndView("error", "error",
					"Error al realizar recuento " + e);
		}
		return new ModelAndView("recuento");
	}

	@RequestMapping(value = "/estadisticas", method = RequestMethod.POST)
	public ModelAndView verEstadisticas(Long idEleccion) {
		LOG.info("verEstadisticas page access");
		try {
		this.votoService.realizarRecuento(idEleccion);
		}catch (Exception e) {
			LOG.error("Error al recuperar recuento " + e);
			return new ModelAndView("error", "error",
					"No hay votos para realizar el recuento. Consulte este tras realizar alguna votación.");
		}
		List<RecuentoRest> recuento = new ArrayList<RecuentoRest>();

		try {

			RecuentoRest rec = null;
			for (Recuento r : this.recuentoService.publicarRecuento(idEleccion)) {
				rec = new RecuentoRest(r.getIdEleccion(), r.getOpcion(),
						r.getTotal());
				recuento.add(rec);
			}
		} catch (Exception e) {
			LOG.error("Error al recuperar recuento " + e);
			return new ModelAndView("error", "error",
					"Error al recuperar recuento " + e);
		}

		return new ModelAndView("estadisticasResult", "recuento", recuento);
	}

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public ModelAndView verEstadisticas() {
		LOG.info("verResultadosOnline page access");

		return new ModelAndView("estadisticas", "elecciones", eleccionService.getAll());
	}

}