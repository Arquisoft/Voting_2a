package es.uniovi.asw.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.Jdbc;

public class VotoTest {

	 @Before
	  public void reset(){
		 
		 try {
			Jdbc.reset();
		} catch (InstantiationException | IllegalAccessException |
				ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 
	  }
	
	@Test
	public void test() {
	
		Voto c= new Voto((long)1, (long)1, "PP");
		assertEquals("1", Long.toString(c.getIdColElect()));
		c.setIdColElect((long)2);
		assertEquals("2", Long.toString(c.getIdColElect()));
		
		assertEquals("1", Long.toString(c.getIdOpcion()));
		c.setIdOpcion((long)2);
		assertEquals("2", Long.toString(c.getIdOpcion()));
		
		assertEquals("PP", c.getOpcion());
		c.setOpcion("Podemos");
		assertEquals("Podemos",c.getOpcion());
		
		c=  new Voto();
		c.setIdOpcion((long)1);
		c.setIdColElect((long)1);
		c.setOpcion("PSOE");
		
		boolean guardado=Factories.service.createVotoService().saveVoto(c);
		assertEquals(true,guardado);
		
		Voto aux=Factories.service.createVotoService().findById((long)1, (long)1);
		
		Factories.service.createVotoService().update(c);
		aux = Factories.service.createVotoService().findById((long) 1, (long) 1);

		assertEquals(true, Factories.service.createVotoService().incrementarVoto(aux));
		aux = Factories.service.createVotoService().findById((long) 1, (long) 1);

		//assertEquals(4, (long) aux.getTotVotos());
		assertEquals(null,Factories.service.createVotoService().findById((long)1232525235, null));
		assertEquals(null,Factories.service.createVotoService().findById((long)1232525235,(long)1232525235));
		assertEquals(null,Factories.service.createVotoService().findById(null,(long)1232525235));
		assertEquals(null,Factories.service.createVotoService().findById(null, null));
		assertEquals(false,Factories.service.createVotoService().update(null));
		//
		
		assertEquals(false,Factories.service.createVotoService().saveVoto(null));
		assertEquals(false,Factories.service.createVotoService().incrementarVoto(null));
	}

}
