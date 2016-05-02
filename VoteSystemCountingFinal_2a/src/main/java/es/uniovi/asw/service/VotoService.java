package es.uniovi.asw.service;

import java.util.List;

import es.uniovi.asw.model.VotoInfo;

public interface VotoService {

	List<VotoInfo> obtenerVotos(Long eleccionId);

	void realizarRecuento(Long eleccionId);

}
