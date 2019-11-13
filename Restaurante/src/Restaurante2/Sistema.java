package Restaurante2;


import java.util.Iterator;
import java.util.LinkedList;

public class Sistema {
	
	public static Sistema instance ;
	
	Usuario usuarioLogueado;
	
	public Sistema() {}

	public static Sistema getInstance() {
		if (instance  == null) {
			instance  = new Sistema();
		}
		
		return instance;
	}
	LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	LinkedList<Usuario> usuariosLogueados = new LinkedList<Usuario>();
	
//REGISTRAR
	public Boolean crearNuevoUsuario(Usuario usuario) {
		if (!usuarios.contains(usuario)) { // Se Asegura que no este la cuenta agregada anteriormente..
			for (Usuario usuarios : usuarios) { // NombreClase,NombreOBJ:NombreList
				if (usuarios.getEmail().equals(usuario.getEmail()))
					 return false;	}
			this.usuarios.add(usuario);
			return true;
		} return false;
		 
	}

//ABRIR SESION
	
	public Boolean loguearUsuario(String email, String password) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getPassword().equals(password)) {
				Usuario usuario = usuarios.get(i);
				this.usuariosLogueados.add(usuario);
				usuarioLogueado = usuario;
				return true;
			}
		} return false;
	}

//CERRAR SESION
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
//BUSCAR USUARIOS ONLINE
	public Boolean buscarUsuarioLogueado(Integer Id,Usuario usuarioBuscado) {
		for (Usuario  usuarioLogueado  : usuariosLogueados) {
		for (Usuario usuarios : usuariosLogueados) {
			
			if (usuarios.getId().equals(Id))
				return true;
		}
		return false;
		}return false;
	}
	
//BUSCAR USUARIOS ONLINE/OFFLINE
	public Boolean buscarUsuario(Integer Id,Usuario usuarioIngresado) {
		for (Usuario  usuarioLogueado  : usuariosLogueados) {
		for (Usuario  usuarioIngresado1  : usuariosLogueados) {
			if  (usuarioIngresado1.equals(usuarioIngresado)) {
		for (Usuario usuarios : usuarios) {
			if (usuarios.getId().equals(Id))
				return true;
		}
				return false;
			} return false;
		}return  false;
		} return false;
	}
//ELIMINAR USUARIO 

	// NUEVO ELIMINAR , YA QUE ESTE S�LO ELIMINA AL USUARIO LOGUEADO
	
	public Boolean Eliminar (Integer Id,String password) {
		if (usuarios.contains(usuarioLogueado)) {
			if(usuarioLogueado.getPassword()==password && usuarioLogueado.getId()==Id) {
			usuarios.remove(usuarioLogueado);
			return true;
			}
		}return false;
	}
	

	
}
