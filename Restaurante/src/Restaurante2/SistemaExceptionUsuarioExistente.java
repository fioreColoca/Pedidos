package Restaurante2;

public class SistemaExceptionUsuarioExistente  extends Exception  {
	public SistemaExceptionUsuarioExistente() {
		super("este usuario ya existe");
	}

}


