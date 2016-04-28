package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.ColegioElectoralService;
import es.uniovi.asw.business.impl.classes.FindColegioElectoral;
import es.uniovi.asw.business.impl.classes.SaveCol;
import es.uniovi.asw.business.impl.classes.UpdateColegioElectoral;
import es.uniovi.asw.model.ColegioElectoral;

public class SimpleColegioElectoralService implements ColegioElectoralService {

	public ColegioElectoral findById(Long idColegioElectoral) {

		return new FindColegioElectoral().findById(idColegioElectoral);
		
	}

	public boolean save(ColegioElectoral col) {

		return new SaveCol().save(col);
		
	}
	
	public boolean update(ColegioElectoral colegioElectoral){
		
		return new UpdateColegioElectoral().updateColegioElectoral(colegioElectoral);
		
	}

}
