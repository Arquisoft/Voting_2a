package es.uniovi.asw.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.persistence.Jdbc;

public class OpcionTest {

	 @Before
	  public  void reset(){
		 
		 try {
			Jdbc.reset();
		} catch (InstantiationException | IllegalAccessException |
				ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 
	  }
	
	@Test
	public void test() {
		
		Opcion o= new Opcion((long)1, (long)1, "AlbertRivera");
		
		assertEquals("1", Long.toString(o.getId()));
		o.setId((long)2);
		assertEquals("2", Long.toString(o.getId()));
		
		assertEquals("1", Long.toString(o.getIdVotacion()));
		o.setIdVotacion((long)2);
		assertEquals("2", Long.toString(o.getIdVotacion()));
		
		assertEquals("AlbertRivera", o.getDescripcion());
		o.setDescripcion("Rajoy");
		assertEquals("Rajoy", o.getDescripcion());
		
		Opcion a= new Opcion();
		a.setIdVotacion((long)1);
		a.setDescripcion("PP");
		
		boolean guardado= Factories.service.createOpcionService().save(a);
		boolean guardadoDoble= Factories.service.createOpcionService().save(a);
		assertEquals(true,guardado);
		assertFalse(guardadoDoble);
		
		Opcion b= new Opcion();
		b.setIdVotacion((long)1);
		b.setDescripcion("PSOE");
		
		guardado= Factories.service.createOpcionService().save(b);
		
		assertEquals(true,guardado);
		
		Opcion aux=Factories.service.createOpcionService().findById((long)1);
		
		assertEquals("PP",aux.getDescripcion());
		
		
		assertEquals(2,Factories.service.createOpcionService().listadoOpciones((long)1).size());
		assertEquals(null,Factories.service.createOpcionService().findById((long)1232525235));
		assertEquals(null,Factories.service.createOpcionService().findById(null));
		assertEquals(null,Factories.service.createOpcionService().listadoOpciones(null));
	}

}
