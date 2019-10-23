package Restaurante;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private String password;
                        
	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNombe(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean validarPassowrd() {
		if (password.length() > 7) {
			for (int i = 0; i < password.length(); i++) {
				int numero = Character.getNumericValue(password.charAt(i));
				if (Character.isDigit(password.charAt(i))) {
					return true;

				}
			}
		}
		return false;
	}
}
