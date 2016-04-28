package es.uniovi.asw;

import java.io.IOException;

import java.util.List;

import es.uniovi.asw.Parser.GenerarCarta;
import es.uniovi.asw.Parser.LeerExcel;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;


/**
 * Clase que lanza la aplicacion
 */
public class LoadUsers {

	public static void main(String[] args) {
		
		String nombreFichero=args[0];
		
		LeerExcel fichero = new LeerExcel();
		
		try {
			
			List<Usuario> listaUsuarios=fichero.leerFichero("./src/test/resources/"+nombreFichero);
			Factories.service.createUsuarioService().generarUsuarios(listaUsuarios);

			GenerarCarta gc = new GenerarCarta(listaUsuarios);
			
			gc.crearCarta();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
