package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.model.UserInfo;
import es.uniovi.asw.rest.LoginRest;
import es.uniovi.asw.rest.UserInfoRest;
import es.uniovi.asw.service.UserService;
import es.uniovi.asw.util.StringUtil;

@RestController
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String landing() {
		return "Voters 2a Service";
	}

	/*
	 * {"login": "email", "password": "password"}
	 */
	@RequestMapping(value = "/GetVoterInfo", method = RequestMethod.POST)
	public @ResponseBody UserInfoRest validar(@RequestBody LoginRest login) {
		if (login == null) {
			throw new ResourceNotFoundException();
		}

		try {
			UserInfo u = new UserInfo(login.getLogin(), login.getPassword());
			UserInfo valido = this.userService.validar(u);

			if (valido != null) {
				return new UserInfoRest(valido.getNombre(), valido.getNif(), valido.getEmail(), valido.getCodigoMesa());
			}

		} catch (Exception e) {
			log.error("Se produjo un error en la llamada a /GetVoterInfo. " + e.getMessage());
			throw new ResourceNotFoundException();
		}

		throw new ResourceNotFoundException();
	}

	/*
	 * {"login": email, "password": password}
	 */
	@RequestMapping(value = "/UpdatePassword", method = RequestMethod.POST)
	public String cambiarClave(@RequestBody LoginRest login) {
		if (login == null) {
			throw new ResourceNotFoundException();
		}

		try {
			UserInfo u = new UserInfo(login.getLogin(), login.getPassword());
			UserInfo valido = this.userService.validar(u);

			if (valido != null) {
				String pass = StringUtil.getCadenaAlfanumAleatoria(8);
				valido.setPassword(pass);
				valido = this.userService.update(valido);
				return "{\"password\": \" " + pass + " \"}";
			}

		} catch (Exception e) {
			log.error("Se produjo un error en la llamada a /UpdatePassword. " + e.getMessage());
			throw new ResourceNotFoundException();
		}

		throw new ResourceNotFoundException();
	}

}
