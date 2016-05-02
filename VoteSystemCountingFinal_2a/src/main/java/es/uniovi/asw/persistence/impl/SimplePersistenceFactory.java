package es.uniovi.asw.persistence.impl;

import es.uniovi.asw.persistence.CircunscripcionDao;
import es.uniovi.asw.persistence.ColegioElectoralDao;
import es.uniovi.asw.persistence.ComunidadAutonomaDao;
import es.uniovi.asw.persistence.OpcionDao;
import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.UsuarioDao;
import es.uniovi.asw.persistence.VotacionDao;
import es.uniovi.asw.persistence.VotadoDao;
import es.uniovi.asw.persistence.VotoDao;

/**
 * Implementacion de la factoria que devuelve implementaci??????n de la capa
 * de persistencia con Jdbc 
 * 
 * @author Enrique
 *
 */
public class SimplePersistenceFactory implements PersistenceFactory {
	
	
	public UsuarioDao createUsuarioDao() {
		
		return new UsuarioJdbcDao();
		
	}

	
	public CircunscripcionDao createCircunscripcionDao() {

		return new CircunscripcionJdbcDao();
		
	}

	
	public ColegioElectoralDao createColegioElectoralDao() {

		return new ColegioElectoralJdbcDao();
		
	}

	
	public ComunidadAutonomaDao createComunidadAutonomaDao() {
		
		return new ComunidadAutonomaJdbcDao();
		
	}

	
	public OpcionDao createOpcionDao() {

		return new OpcionJdbcDao();
		
	}

	
	public VotacionDao createVotacionDao() {

		return new VotacionJdbcDao();
		
	}

	
	public VotadoDao createVotadoDao() {

		return new VotadoJdbcDao();
		
	}

	
	public VotoDao createVotoDao() {

		return new VotoJdbcDao();
		
	}

}
