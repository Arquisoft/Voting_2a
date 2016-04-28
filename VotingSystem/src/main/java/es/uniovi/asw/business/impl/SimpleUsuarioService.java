package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.UsuarioService;
import es.uniovi.asw.business.impl.classes.FindUsuario;
import es.uniovi.asw.business.impl.classes.FindUsuarioPorId;
import es.uniovi.asw.business.impl.classes.GuardarUsuarios;
import es.uniovi.asw.business.impl.classes.ListadoUsuarios;
import es.uniovi.asw.business.impl.classes.PuedeVotar;
import es.uniovi.asw.business.impl.classes.SaveUser;
import es.uniovi.asw.model.Usuario;

public class SimpleUsuarioService implements UsuarioService {

	
	public Usuario findByNif(String nif) {

		return new FindUsuario().findByNif(nif);
		
	}

	
	public boolean saveUser(Usuario usuario) {
		
		return new SaveUser().saveUser(usuario);

	}

	
	public boolean puedeVotar(Usuario usuario) {

		return new PuedeVotar().puedeVotar(usuario);
		
	}
	
	
	public List<Usuario> listaUsuarios() {

		return new ListadoUsuarios().listadoUsuarios();
		
	}

	
	public Usuario findById(int id) {
		
		return new FindUsuarioPorId().findById(id);
		
	}

	@Override
	public void generarUsuarios(List<Usuario> listaUsers) {
		
		new GuardarUsuarios(listaUsers).guardar();
		
	}

}
