package Restaurante2;

public class SistemaExceptionNoEliminaUsuario extends Exception{
	
	public SistemaExceptionNoEliminaUsuario() {
		super("No se pudo eliminar el usuario");
	}

}