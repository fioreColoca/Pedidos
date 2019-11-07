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
					return true;
				}
			} return false;
		}

	//CERRAR SESION
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
	//BUSCAR USUARIOS ONLINE
		public Boolean buscarUsuarioLogueado(Integer Id,Usuario usuario,Usuario usuarioIngresado) {
			for (Usuario  usuarioIngresado1  : usuariosLogueados) {
			for (Usuario usuarios : usuariosLogueados) {
				
				if (usuarios.getId().equals(Id))
					return true;
			}
			return false;
			}return false;
		}
		
	//BUSCAR USUARIOS ONLINE/OFFLINE
		public Boolean buscarUsuario(Integer Id,Usuario usuarioIngresado) {
			for (Usuario  usuarioIngresado1  : usuariosLogueados) {
				if  (usuarioIngresado1.equals(usuarioIngresado)) {
			for (Usuario usuarios : usuarios) {
				if (usuarios.getId().equals(Id))
					return true;
			}
					return false;
				} return false;
			}return  false;
		}
	//ELIMINAR USUARIO 
		
		public Boolean EliminarUsuario(Integer Id,String password,Usuario usuarioIngresado) {
			for (Usuario  usuarioIngresado1  : usuariosLogueados) {
				if  (usuarioIngresado1.equals(usuarioIngresado)) {
				
			Iterator<Usuario> it = usuarios.iterator();

			while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

				Usuario usuario = it.next();
				if (usuario.getId().equals(Id) && usuario.getPassword().equals(usuario.getPassword())) {
					usuarios.remove(usuario);
					return true;
				}
			} 
			}return false;
			
			}return false;
		}
		

}
