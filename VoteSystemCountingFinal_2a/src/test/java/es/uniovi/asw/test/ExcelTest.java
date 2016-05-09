package es.uniovi.asw.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.LoadUsers;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.parser.GenerarCarta;
import es.uniovi.asw.parser.LeerExcel;
import es.uniovi.asw.persistence.Jdbc;

public class ExcelTest {

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
	public void test() throws IOException {
		LeerExcel le = new LeerExcel();
		List<Usuario> lista = le.leerFichero("./src/main/resources/test");
		assertEquals(13, lista.size());
		GenerarCarta gc = new GenerarCarta(lista);
		gc.crearCarta();
		
		LoadUsers.main(new String[]{"test"});
		
	}
}
