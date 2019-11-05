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
	
	/*
	String  b;
	public void ayuda (String hola) throws SistemException {
		if (hola=="a") {
			 b = "b";
		}
		throw new SistemException ();
	}*/
	
	public Boolean loguearUsuario(String email, String password) {

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean buscarUsuario(String email) {
		for (Usuario usuarios:usuarios) {
			if (usuarios.getEmail().contentEquals(email))
				return true;
		} return false;
	}
	

	public Boolean EliminarUsuario(String email,String contraseña) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

			Usuario usuario = it.next();
			if (usuario.getEmail().equals(email) && usuario.getPassword().equals(contraseña)) {
				usuarios.remove(usuario);
				return true;
			}
		}
		return false;

	}
	public Boolean validarPassword(Usuario usuario) {

		if (usuario.getPassword().length() >= 8) {
			for (int i = 0; i < usuario.getPassword().length(); i++) {
				if (Character.isDigit(usuario.getPassword().charAt(i)) == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	LinkedList<Producto> productos = new LinkedList<Producto>();
	
	
}
