package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.OpcionService;
import es.uniovi.asw.business.impl.classes.FindOpcion;
import es.uniovi.asw.business.impl.classes.SaveOpc;
import es.uniovi.asw.business.impl.classes.ListadoOpciones;
import es.uniovi.asw.model.Opcion;

public class SimpleOpcionService implements OpcionService {

	@Override
	public Opcion findById(Long idOpcion) {

		return new FindOpcion().findById(idOpcion);
		
	}

	@Override
	public List<Opcion> listadoOpciones(Long idVotacion) {

		return new ListadoOpciones().listadoVotacion(idVotacion);
		
	}

	@Override
	public boolean save(Opcion op) {
		
		return new SaveOpc().save(op);
		
	}

}
