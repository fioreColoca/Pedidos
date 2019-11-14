package Restaurante;

public class SistemaExceptionNoEncuentraUsuario extends Exception {

	public SistemaExceptionNoEncuentraUsuario() {
		super("No se encontró el usuario");
	}

}
