package Restaurante;

public class UsuarioExceptionContraseñaIncorrecta extends Exception{
	public UsuarioExceptionContraseñaIncorrecta() {
		super("La contraseña debe cumplir con los requisitos: contener al menos 8 caracteres, el primer caracter sea un digito");
	}

}
