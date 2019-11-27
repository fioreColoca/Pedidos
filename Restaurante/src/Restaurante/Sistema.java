package Restaurante2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;

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

	LinkedList<Restaurante> restaurantes = new LinkedList<Restaurante>();
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
			} 	throw new SistemaExceptionNoEncuentraUsuario();

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
			}
			return true;
		}
		return false;
	}

	// BUSCAR USUARIOS ONLINE
	public Boolean buscarUsuarioLogueado(String string) throws SistemaExceptionNoEncuentraUsuario {
		for (Usuario usuarioLogueado : usuariosLogueados) {
			if (usuarioLogueado.getId().equals(string))
				return true;
		}
		throw new SistemaExceptionNoEncuentraUsuario();
	}

	// BUSCAR USUARIOS
	public Boolean buscarUsuarioNoLogueado(String string) throws SistemaExceptionNoEncuentraUsuario {
		for (Usuario usuarioIngresado1 : usuarios) {
			if (usuarioIngresado1.getId().equals(string)) {
				return true;
			}
			throw new SistemaExceptionNoEncuentraUsuario();
		}
		throw new SistemaExceptionNoEncuentraUsuario();
	}

	// ELIMINAR USUARIO

	public Boolean EliminarUsuario(String Id, String password) throws SistemaExceptionNoEliminaUsuario {
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

	public Boolean Eliminar(String Id, String password) throws SistemaExceptionNoEliminaUsuario {
		if (usuarios.contains(usuarioLogueado)) {
			if (usuarioLogueado.getPassword() == password && usuarioLogueado.getId() == Id) {
				usuarios.remove(usuarioLogueado);
				return true;
			}
		}
		throw new SistemaExceptionNoEliminaUsuario();
	}

	// BUSCAR EL RESTAURANTE

	public Boolean buscarRestaurante(String nombre) throws RestauranteExceptionInexistente {
		for (Restaurante restaurante1 : restaurantes) {
			restaurante1.getNombre2().equals(nombre);
			return true;
		}
		throw new RestauranteExceptionInexistente();
	}

	// AGREGAR EL RESTAURANTE

	public Boolean agregarRestaurante(Restaurante r) throws RestauranteExceptionNoLoCrea {
		if (!restaurantes.contains(r)) {
			this.restaurantes.add(r);
			return true;
		}
		throw new RestauranteExceptionNoLoCrea();

	}

	// VALIDAR PASSWORD

	public Boolean validarPassword(String password) throws UsuarioExceptionPasswordIncorrecta {

		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i)) == true) {
					return true;
				}
				throw new UsuarioExceptionPasswordIncorrecta();
			}
		}
		throw new UsuarioExceptionPasswordIncorrecta();
	}

	// VERIFICA QUE TENGA SOLO LETRAS

	public Boolean soloLetras(String nombre) throws MainExceptionSoloCaracteres {
		for (int i = 0; i < nombre.length(); i++) {
			char caracter = nombre.toUpperCase().charAt(i);
			int valorASCII = (int) caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				throw new MainExceptionSoloCaracteres();
		}
		return true;

	}

	// VERIFICA QUE TENGA SOLO NUMEROS

	public Boolean soloNumeros(String numero) throws ExceptionNumero {
		for (int i = 0; i < numero.length(); i++) {
			char caracter = numero.toUpperCase().charAt(i);
			int valorASCII = (int) caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return true;
		}
		throw new ExceptionNumero();

	}

	Pattern pattern = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	// VERIFICACION DE EMAIL

	public Boolean verificarEmail(String email) throws ExceptionEmail {
		java.util.regex.Matcher mather = pattern.matcher(email);
		if (mather.find() == true) {
			return true;
		} else {
			throw new ExceptionEmail();
		}
	}
	// VERIFICACION CATEGORIAS

}
