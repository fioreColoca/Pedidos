package Restaurante;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres {
		Integer option = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
		
// <----------MENU ---------- >
		do {
			System.out.println("Ingrese '1' si es administrador o '2' si es cliente");
			option = teclado.nextInt();
			if (option != 1 || option != 2) {
				salir = true;
			}

			switch (option) {
			case 1:

				Boolean salirAdministrador = false;
				Integer opcionAdministrador = null;
				do {

					System.out.println(
							"Seleccionaste administrador, Ingrese '1'  registrarse,'2' abrir sesión,'3' salir");
					opcionAdministrador = teclado.nextInt();
					if (opcionAdministrador != 1 || opcionAdministrador != 2) {
						salirAdministrador = true;
					}
					switch (opcionAdministrador) {

					case 1:
						Boolean error = false;
						String nombre;
						String apellido;
						String email;
						String password;
						Integer id;
						// *HACER CLASE PARA QUE VERIFIQUE SI ESTAN BIEN O NO LO INGRESADO //

						System.out.println("Selecciono para registrarse");
						do {
							System.out.println("Ingrese su nombre");
							nombre = teclado.next();
							if (sistema.soloLetras(nombre) == true) {
								String nombreConfirmado = nombre;
								System.out.println("Ingrese su apellido");
								apellido = teclado.next();
								if (sistema.soloLetras(apellido) == true) {
									String apellidoConfrimado = apellido;
								} else {
									error = true;
								}
							} else {
								error = true;
							}

						} while (error = false);

						System.out.println("Ingrese su apellido");
						apellido = teclado.next();
						System.out.println("Ingrese su email");
						email = teclado.next();
						System.out.println("Ingrese su password");
						password = teclado.next();
						System.out.println("Ingrese su DNI, sólo números");
						id = teclado.nextInt();

						Administrador a1 = new Administrador(id, nombre, apellido, email, password);

						// VERIFICAR PASSWORD ESTA MAL DENTRODE USUARIO

					}

					break;
				} while (salirAdministrador = true);
				break;

			case 2:
				Integer opcionCliente = null;
				System.out.println("Seleccionaste cliente, Ingrese '1'  registrarse,'2' abrir sesión , '3' salir");
				option = teclado.nextInt();

				break;
			}

		} while (salir = true);

	}

}
