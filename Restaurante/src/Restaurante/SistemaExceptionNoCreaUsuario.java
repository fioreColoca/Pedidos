package Restaurante2;

public class SistemaExceptionNoCreaUsuario extends Exception{

	public SistemaExceptionNoCreaUsuario() {
		super("No se pudo crear el usuario");

	}
}
