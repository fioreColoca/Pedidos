package Restaurante;

import java.util.Iterator;
import java.util.LinkedList;

public class Sistema {
	public static Sistema instance;

	Usuario usuarioLogueado;

	public Sistema() {
	}

	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}

		return instance;
	}

	LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	LinkedList<Usuario> usuariosLogueados = new LinkedList<Usuario>();

	// REGISTRAR
	public Boolean crearNuevoUsuario(Usuario usuario) throws SistemaExceptionNoCreaUsuario {
		if (!usuarios.contains(usuario)) { // Se Asegura que no este la cuenta agregada anteriormente..
			for (Usuario usuarios : usuarios) {
				if (usuarios.getEmail().equals(usuario.getEmail()))
					throw new SistemaExceptionNoCreaUsuario();
			}
			this.usuarios.add(usuario);
			return true;
		} else
			throw new SistemaExceptionNoCreaUsuario();

	}

	// ABRIR SESION
	public Boolean loguearUsuario(String email, String password) throws SistemaExceptionNoEncuentraUsuario {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getPassword().equals(password)) {
				Usuario usuario = usuarios.get(i);
				this.usuariosLogueados.add(usuario);
				return true;
			}
		}
		throw new SistemaExceptionNoEncuentraUsuario();
	}

	// CERRAR SESION
	public Boolean cerrarSesiondeUsuario() {
		Iterator<Usuario> it = usuariosLogueados.iterator();

		while (it.hasNext()) {

			Usuario usuarioAuxiliar = it.next();
			if (usuarioAuxiliar.equals(usuarioLogueado)) {
				usuariosLogueados.remove(usuarioLogueado);
				return true;
			}
		}
		return false;
	}

	// BUSCAR USUARIOS ONLINE
	public Boolean buscarUsuarioLogueado(Integer Id) throws SistemaExceptionNoEncuentraUsuario {
		for (Usuario usuarioLogueado : usuariosLogueados) {
			if (usuarioLogueado.getId().equals(Id))
				return true;
		}
		throw new SistemaExceptionNoEncuentraUsuario();
	}

	// BUSCAR USUARIOS OFFLINE
	public Boolean buscarUsuarioNoLogueado(Integer Id) throws SistemaExceptionNoEncuentraUsuario {
		for (Usuario usuarioIngresado1 : usuarios) {
			if (usuarioIngresado1.getId().equals(Id)) {
				return true;
			}
			throw new SistemaExceptionNoEncuentraUsuario();
		}
		throw new SistemaExceptionNoEncuentraUsuario();
	}

	// ELIMINAR USUARIO

	public Boolean EliminarUsuario(Integer Id, String password) throws SistemaExceptionNoEliminaUsuario {
		for (Usuario usuarioLogueado : usuariosLogueados) {
			if (usuarioLogueado.getPassword() == password && usuarioLogueado.getId() == Id) {
				Iterator<Usuario> it = usuarios.iterator();

				while (it.hasNext()) {

					Usuario usuario = it.next();
					if (usuario.getId().equals(Id) && usuario.getPassword().equals(password)) {
						usuarios.remove(usuario);
						return true;
					}
				}
			}
			throw new SistemaExceptionNoEliminaUsuario();
		}
		throw new SistemaExceptionNoEliminaUsuario();
	}

	// NUEVO ELIMINAR , YA QUE ESTE SÓLO ELIMINA AL USUARIO LOGUEADO

	public Boolean Eliminar(Integer Id, String password) throws SistemaExceptionNoEliminaUsuario {
		if (usuarios.contains(usuarioLogueado)) {
			if (usuarioLogueado.getPassword() == password && usuarioLogueado.getId() == Id) {
				usuarios.remove(usuarioLogueado);
				return true;
			}
		}
		throw new SistemaExceptionNoEliminaUsuario();
	}

}
