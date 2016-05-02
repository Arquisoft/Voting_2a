package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;

public class IncrementarVoto {
	
	public boolean incrementarVoto(Voto voto){
		if(voto != null){
			return Factories.persistence.createVotoDao().incrementarVoto(voto);
			
		}
			return false;	
	}

}