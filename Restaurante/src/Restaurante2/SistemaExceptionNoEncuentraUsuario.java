package Restaurante2;

public class SistemaExceptionNoEncuentraUsuario extends Exception {

	public SistemaExceptionNoEncuentraUsuario() {
		super("No se encontró el usuario");
	}

}
