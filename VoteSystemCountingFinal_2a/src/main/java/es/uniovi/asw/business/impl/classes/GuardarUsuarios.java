package es.uniovi.asw.business.impl.classes;

import java.util.List;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.UsuarioDao;



/**
 * Clase Para llamar al encargado de guardar los usuarios en la base de datos
 * @author dario
 *
 */
public class GuardarUsuarios {
	
	private List<Usuario> usuarios;

	public GuardarUsuarios(List<Usuario> usuarios) {
		
		this.usuarios = usuarios;
		
	}
	
	public void guardar(){
		
		UsuarioDao dao= Factories.persistence.createUsuarioDao();
		
		for(Usuario user : usuarios){
			
			System.out.println(user.toString());
			dao.save(user);
			
		}
		
	}
	
}
