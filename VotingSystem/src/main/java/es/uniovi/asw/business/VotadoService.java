package es.uniovi.asw.business;

import es.uniovi.asw.model.Votado;

public interface VotadoService {

	boolean votado(Votado votado);

	boolean haVotado(Long idUser, Long idVotacion);
	
}
