package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotoService;
import es.uniovi.asw.business.impl.classes.FindVoto;
import es.uniovi.asw.business.impl.classes.IncrementarVoto;
import es.uniovi.asw.business.impl.classes.SaveVoto;
import es.uniovi.asw.business.impl.classes.UpdateVoto;
import es.uniovi.asw.model.Voto;

public class SimpleVotoService implements VotoService {

	
	public Voto findById(Long idOpcion, Long idColegioElectoral) {
	
		return new FindVoto().findById(idOpcion, idColegioElectoral);
		
	}

	
	public boolean saveVoto(Voto voto) {
		
		return new SaveVoto().guardarVoto(voto);
		
	}

	
	public boolean update(Voto voto) {
	
		return new UpdateVoto().update(voto);
		
	}

	
	public boolean incrementarVoto(Voto voto) {
		
		return new IncrementarVoto().incrementarVoto(voto);
		
	}

}
