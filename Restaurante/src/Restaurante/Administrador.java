package Restaurante;

public class Administrador extends Usuario {

	String tipoDeAdm;
	
	public Administrador (String nombre, String apellido, String email, String password,String tipoDeAdm) {
		super( nombre, apellido, email, password);
		this.tipoDeAdm=tipoDeAdm;
	}

}
