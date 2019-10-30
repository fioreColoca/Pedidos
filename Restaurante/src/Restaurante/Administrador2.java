package Restaurante;

public class Administrador2 extends Usuario{
	
	String tipoDeAdm;
	
	public Administrador2 (String nombre, String apellido, String email, String password,String tipoDeAdm) {
		super( nombre, apellido, email, password);
		this.tipoDeAdm=tipoDeAdm;
	}
}
