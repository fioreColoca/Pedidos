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
	// FALTAN THROWS EXCEPTION

	// REGISTRAR
	public Boolean crearNuevoUsuario(Usuario usuario) throws SistemaException {
		if (!usuarios.contains(usuario)) { // Se Asegura que no este la cuenta agregada anteriormente..
			for (Usuario usuarios : usuarios) { // NombreClase,NombreOBJ:NombreList
				if (usuarios.getEmail().equals(usuario.getEmail()))
					throw new SistemaException();
			}
			this.usuarios.add(usuario);
			return true;
		} else
			throw new SistemaException();

	}

	// ABRIR SESION
	public Boolean loguearUsuario(String email, String password) throws SistemaException1 {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getPassword().equals(password)) {
				Usuario usuario = usuarios.get(i);
				this.usuariosLogueados.add(usuario);
				return true;
			}
		}
		throw new SistemaException1();
	}

	// CERRAR SESION
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

	// BUSCAR USUARIOS ONLINE
	public Boolean buscarUsuarioLogueado(Integer Id, Usuario usuario, Usuario usuarioIngresado)
			throws SistemaException1 {
		for (Usuario usuarioIngresado1 : usuariosLogueados) {
			for (Usuario usuarios : usuariosLogueados) {

				if (usuarios.getId().equals(Id))
					return true;
			}
			throw new SistemaException1();
		}
		throw new SistemaException1();
	}

	// BUSCAR USUARIOS ONLINE/OFFLINE
	public Boolean buscarUsuario(Integer Id, Usuario usuarioIngresado) throws SistemaException1 {
		for (Usuario usuarioIngresado1 : usuariosLogueados) {
			if (usuarioIngresado1.equals(usuarioIngresado)) {
				for (Usuario usuarios : usuarios) {
					if (usuarios.getId().equals(Id))
						return true;
				}
				throw new SistemaException1();
			}
			throw new SistemaException1();
		}
		throw new SistemaException1();
	}
	// ELIMINAR USUARIO

	public Boolean EliminarUsuario(Integer Id, String password, Usuario usuarioIngresado) throws SistemaException2 {
		for (Usuario usuarioIngresado1 : usuariosLogueados) {
			if (usuarioIngresado1.equals(usuarioIngresado)) {

				Iterator<Usuario> it = usuarios.iterator();

				while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

					Usuario usuario = it.next();
					if (usuario.getId().equals(Id) && usuario.getPassword().equals(usuario.getPassword())) {
						usuarios.remove(usuario);
						return true;
					}
				}
			}
			
			throw new SistemaException2();
		}
		throw new SistemaException2();
	}

	// NUEVO ELIMINAR , YA QUE ESTE SÓLO ELIMINA AL USUARIO LOGUEADO

	public Boolean Eliminar(Integer Id, String password, Usuario usuarioIngresado) throws SistemaException2  {
		if (usuarios.contains(usuarioIngresado)) {
			if (usuarioIngresado.getPassword() == password && usuarioIngresado.getId() == Id) {
				usuarios.remove(usuarioIngresado);
				return true;
			}
		}
		throw new SistemaException2();
	}

}
