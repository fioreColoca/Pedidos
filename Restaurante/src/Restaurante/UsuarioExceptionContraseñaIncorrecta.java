package Restaurante;

public class UsuarioExceptionContrase�aIncorrecta extends Exception{
	public UsuarioExceptionContrase�aIncorrecta() {
		super("La contrase�a debe cumplir con los requisitos: contener al menos 8 caracteres, el primer caracter sea un digito");
	}

}
