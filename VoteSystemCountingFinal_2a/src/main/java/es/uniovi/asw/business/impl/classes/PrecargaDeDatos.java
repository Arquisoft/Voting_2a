package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.model.Votacion;

public class PrecargaDeDatos {
	
	public void precarga(){
		//Usuario u = new Usuario(nombre, email, NIF, codColElectoral)
		//Usuario u = new Usuario(nombre, email, NIF, password, codColElectoral, id, login)
		Usuario u1 = new Usuario("Victor", "victor@email.com", "33199844B", 1);
		Usuario u2 = new Usuario("Dario", "dario@email.com", "45407517C", 1);
		Usuario u3 = new Usuario("Adrian", "adrian@email.com", "51849980E", 1);
		Usuario u4 = new Usuario("Daniel", "daniel@email.com", "82694008S", 1);
		Usuario u5 = new Usuario("Eduardo", "eduardo@email.com", "17466225W", 1);
		Usuario u6 = new Usuario("Labra", "labra@email.com", "65320151J", 1);
		
		Factories.service.createUsuarioService().saveUser(u1);
		Factories.service.createUsuarioService().saveUser(u2);
		Factories.service.createUsuarioService().saveUser(u3);
		Factories.service.createUsuarioService().saveUser(u4);
		Factories.service.createUsuarioService().saveUser(u5);
		Factories.service.createUsuarioService().saveUser(u6);
		
		//ColegioElectoral e = new ColegioElectoral(id, idCircunscripcion, idPComAutonoma)
		ColegioElectoral ce= new ColegioElectoral((long)1,(long) 1,(long) 1);
		Factories.service.createColegioElectoralService().save(ce);
		//ComunidadAutonoma ca= new ComunidadAutonoma(id, nombre) 
		ComunidadAutonoma as= new ComunidadAutonoma((long)1, "Asturias");
		Factories.service.createComunidadAutonomaService().save(as);
		//Circunscripcion c = new Circunscripcion(id, nombre)
		Circunscripcion cp = new Circunscripcion((long)1, "Gijon");
		Factories.service.createCircunscripcionService().save(cp);
		
		//Opcion op = new Opcion(id, idVotacion, descripcion)
		Opcion op1 = new Opcion((long)1, (long)2, "PP");
		Opcion op2 = new Opcion((long)2, (long)2, "Ciudadanos");
		Opcion op3 = new Opcion((long)3, (long)2, "Podemos");
		
		Opcion op4 = new Opcion((long)1, (long)1, "Si");
		Opcion op5 = new Opcion((long)2, (long)1, "No");
		
		Factories.service.createOpcionService().save(op1);
		Factories.service.createOpcionService().save(op2);
		Factories.service.createOpcionService().save(op3);
		Factories.service.createOpcionService().save(op4);
		Factories.service.createOpcionService().save(op5);

		
		//Votacion v = new Votacion(id, definicion)
		Votacion v1 = new Votacion((long)1, "Referendum");
		Votacion v2 = new Votacion((long)2, "Elecciones Generales");
		Factories.service.createVotacionService().save(v1);
		Factories.service.createVotacionService().save(v2);
		
		
		
		
		
	}

}
