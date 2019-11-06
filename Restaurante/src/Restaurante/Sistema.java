package Restaurante;


import java.util.Iterator;
import java.util.LinkedList;

public class Sistema {
	private String nombreDeSistema;

	public Sistema(String nombreDeSistema) {
		this.nombreDeSistema = nombreDeSistema;
	}

	LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	LinkedList<Usuario> usuariosLogueados = new LinkedList<Usuario>();

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
				Usuario usuario = usuarios.get(i);
				this.usuariosLogueados.add(usuario);
				return true;
			}
		}
		return false;
	}

	public Boolean cerrarSesiondeUsuario(Usuario usuario) {
		Iterator<Usuario> it = usuariosLogueados.iterator();

		while (it.hasNext()) {

			Usuario usuarioAuxiliar = it.next();
			if (usuarioAuxiliar.equals(usuario)) {
				usuariosLogueados.remove(usuario);
				return true;
			}
		}
		return false;

	}

	public Boolean buscarUsuarioLogueado(Integer Id) {
		for (Usuario usuarios : usuariosLogueados) {
			if (usuarios.getId().equals(Id))
				return true;
		}
		return false;
	}

	public Boolean buscarUsuario(Integer Id) {
		for (Usuario usuarios : usuarios) {
			if (usuarios.getId().equals(Id))
				return true;
		}
		return false;
	}

	public Boolean EliminarUsuario(Integer Id) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

			Usuario usuario = it.next();
			if (usuario.getId().equals(Id)) {
				usuarios.remove(usuario);
				return true;
			}
		}
		return false;

	}

}
