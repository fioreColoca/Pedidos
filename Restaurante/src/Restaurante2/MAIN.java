package Restaurante2;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres {
		Integer optcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
// <----------MENU ---------- >
		do {
			System.out.println("Ingrese '1' si es administrador o '2' si es cliente");
			optcion = teclado.nextInt();
			if (optcion != 1 || optcion != 2) {
				salir = true;
			}

			switch (optcion) {
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
						String password;
						String id;
						String email;
						String nombreConfirmado = null;
						String apellidoConfirmado = null;
						String emailConfirmado = null;
						String passwordConfirmado = null;
						String idConfirmado = null;
						// *HACER CLASE PARA QUE VERIFIQUE SI ESTAN BIEN O NO LO INGRESADO //

						System.out.println("Selecciono para registrarse");

						do {
							System.out.println("Ingrese su nombre");
							nombre = teclado.next();
							try {
								if (sistema.soloLetras(nombre) == true) {
									nombreConfirmado = nombre;
									do {
										System.out.println("Ingrese su apellido");
										apellido = teclado.next();

										try {
											if (sistema.soloLetras(apellido) == true) {
												apellidoConfirmado = apellido;
												do {
													System.out.println("Ingrese su email");
													email = teclado.next();
													try {
														if (sistema.verificarEmail(email) == true) {
															emailConfirmado = email;
														do {
															System.out.println("Ingrese su contraseña");
															password = teclado.next();
															try {
																if (sistema.validarPassword(password)) {
																	passwordConfirmado = password;
																	do {
																		System.out.println("Ingrese su dni");
																		id= teclado.next();
																		try {
																			if (sistema.soloNumeros(id)) {
																				idConfirmado=id;
																			}
																			} catch (ExceptionNumero e) {
																		System.out.println(e.getMessage());																		}
																	
																	} while (error != true); // FALTA ALGO PARA QUE LO CORTE
																}
															} catch (UsuarioExceptionPasswordIncorrecta e) {
																System.out.println(e.getMessage());
															}
													
															} while (error != true);
														}

													} catch (ExceptionEmail e) {
														System.out.println(e.getMessage());
													}
													
												} while (error != true);

											}

										} catch (MainExceptionSoloCaracteres e) {
											System.out.println(e.getMessage());
										}
									} while (error != true);
								}
							
							} catch (MainExceptionSoloCaracteres e) {
								System.out.println(e.getMessage());
							}

						} while (error != true);

				

						Administrador a1 = new Administrador(idConfirmado, nombreConfirmado, apellidoConfirmado, emailConfirmado,
								passwordConfirmado);

						// VERIFICAR PASSWORD ESTA MAL DENTRODE USUARIO

					}

					break;
				} while (salirAdministrador = true);
				break;

			case 2:
				Integer opcionCliente = null;
				System.out.println("Seleccionaste cliente, Ingrese '1'  registrarse,'2' abrir sesión , '3' salir");
				optcion = teclado.nextInt();

				break;
			}

		} while (salir = true);

	}

}