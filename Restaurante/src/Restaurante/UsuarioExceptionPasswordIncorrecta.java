package Restaurante;

public class UsuarioExceptionPasswordIncorrecta extends Exception{
	public UsuarioExceptionPasswordIncorrecta() {
		super("La contrase�a debe cumplir con los requisitos: contener al menos 8 caracteres, el primer caracter sea un digito");
	}

}
