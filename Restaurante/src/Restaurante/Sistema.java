package Restaurante;

import java.util.Iterator;
import java.util.LinkedList;


public class Sistema {
	private String nombreDeSistema;

	public Sistema(String nombre) {
		this.nombreDeSistema = nombre;
	}

	LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

	public Boolean crearNuevoUsuario(Usuario usuario) {
		if (!usuarios.contains(usuario)) { // Se Asegura que no este la cuenta agregada anteriormente..
			for (Usuario usuarios : usuarios) { // NombreClase,NombreOBJ:NombreList
				if (usuarios.getEmail().equals(usuario.getEmail()))
					return false;
			}
			this.usuarios.add(usuario);
			return true;
		}
		return false;
	}
	
	public Boolean loguearUsuario(String email, String password) {

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}


	/*public Boolean buscarUsuario(String email, String password) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

			Usuario usuario = it.next();
			if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}*/ 
	
	public Boolean buscarUsuario(String email,String password) {
		for (Usuario usuarios:usuarios) {
			if (usuarios.getEmail().contentEquals(email) && usuarios.getPassword().contentEquals(password))
				return true;
		} return false;
	}
	

	public Boolean EliminarUsuario(String email, String password) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

			Usuario usuario = it.next();
			if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
				usuarios.remove(usuario);
				return true;
			}
		}
		return false;

	}
}
