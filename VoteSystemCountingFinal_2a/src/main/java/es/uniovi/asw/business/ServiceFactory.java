package es.uniovi.asw.business;

import es.uniovi.asw.writeReport.Log;

public interface ServiceFactory {
	
	CircunscripcionService createCircunscripcionService();
	ColegioElectoralService createColegioElectoralService();
	ComunidadAutonomaService createComunidadAutonomaService();
	OpcionService createOpcionService();
	UsuarioService createUsuarioService();
	VotacionService createVotacionService();
	VotadoService createVotadoService();
	VotoService createVotoService();
	PrecargaDeDatosService precargaDeDatosService();
	Log createLog();
}
