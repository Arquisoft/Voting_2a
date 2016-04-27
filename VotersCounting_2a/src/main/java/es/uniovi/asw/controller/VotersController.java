package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.model.UserInfo;
import es.uniovi.asw.service.UserService;
import es.uniovi.asw.util.StringUtil;

@Controller
// @RestController
public class VotersController {
	private static final Logger LOG = LoggerFactory
			.getLogger(VotersController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView landing() {
		LOG.info("Landing page access");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/GetVoterInfo", method = RequestMethod.POST)
	public ModelAndView validar(@RequestParam(name = "u") String u,
			@RequestParam(name = "p") String p) {
		LOG.info("validar usuario page access");

		try {
			UserInfo ui = new UserInfo(u, p);
			UserInfo valido = this.userService.validar(ui);

			if (valido != null) {
				return new ModelAndView("autenticado", "usuario", valido);
			} else {
				return new ModelAndView("error", "error",
						"Usuario y/o Clave no válidos. ");
			}

		} catch (Exception e) {
			LOG.error("Se produjo un error en la llamada a /GetVoterInfo. "
					+ e.getMessage());
			return new ModelAndView("error", "error",
					"Se produjo un error en la llamada a /GetVoterInfo. " + e);
		}
		
	}

	@RequestMapping(value = "/UpdatePassword", method = RequestMethod.GET)
	public ModelAndView cambiarClave(@RequestParam(name = "id") Long id) {

		try {
			UserInfo u = this.userService.get(id);

			if (u != null) {
				String pass = StringUtil.getCadenaAlfanumAleatoria(8);
				u.setPassword(pass);
				u = this.userService.update(u);
				return new ModelAndView("autenticado", "usuario", u);
			}

		} catch (Exception e) {
			LOG.error("Se produjo un error en la llamada a /UpdatePassword. "
					+ e.getMessage());
			return new ModelAndView("error", "error",
					"Se produjo un error en la llamada a /UpdatePassword " + e);
		}

		return new ModelAndView("error", "error",
				"Se produjo un error en la llamada a /UpdatePassword ");
	}

}
