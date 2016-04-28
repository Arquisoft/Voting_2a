package es.uniovi.asw.business.impl;

import es.uniovi.asw.WriteReport.Log;
import es.uniovi.asw.business.CircunscripcionService;
import es.uniovi.asw.business.ColegioElectoralService;
import es.uniovi.asw.business.ComunidadAutonomaService;
import es.uniovi.asw.business.OpcionService;
import es.uniovi.asw.business.PrecargaDeDatosService;
import es.uniovi.asw.business.ServiceFactory;
import es.uniovi.asw.business.UsuarioService;
import es.uniovi.asw.business.VotacionService;
import es.uniovi.asw.business.VotadoService;
import es.uniovi.asw.business.VotoService;

public class SimpleserviceFactory implements ServiceFactory {

	public CircunscripcionService createCircunscripcionService() {

		return new SimpleCircunscripcionService();
		
	}

	
	public ColegioElectoralService createColegioElectoralService() {

		return new SimpleColegioElectoralService();
		
	}

	
	public ComunidadAutonomaService createComunidadAutonomaService() {

		return new SimpleComunidadAutonomaService();
		
	}

	
	public OpcionService createOpcionService() {
		
		return new SimpleOpcionService();
		
	}

	
	public UsuarioService createUsuarioService() {

		return new SimpleUsuarioService();
		
	}

	
	public VotacionService createVotacionService() {

		return new SimpleVotacionService();
		
	}

	
	public VotadoService createVotadoService() {

		return new SimpleVotadoService();
		
	}

	
	public VotoService createVotoService() {

		return new SimpleVotoService();
		
	}

	
	public PrecargaDeDatosService precargaDeDatosService() {
		
		return new SimplePrecargaDeDatosService();
		
	}

	@Override
	public Log createLog() {

		return new Log();
		
	}

}
