package es.uniovi.asw.service;

import java.util.List;

import es.uniovi.asw.model.Voto;

public interface VotoService {

	List<Voto> obtenerVotos(Long eleccionId);

	void realizarRecuento(Long eleccionId);

}
