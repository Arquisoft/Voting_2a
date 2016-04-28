package es.uniovi.asw.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.Parser.GenerarCarta;
import es.uniovi.asw.Parser.LeerExcel;
import es.uniovi.asw.model.Usuario;

public class ExcelTest {

	@Test
	public void test() throws IOException {
		LeerExcel le = new LeerExcel();
		List<Usuario> lista = le.leerFichero("./src/main/resources/test");
		assertEquals(13, lista.size());
		GenerarCarta gc = new GenerarCarta(lista);
		gc.crearCarta();
		
	}
}
