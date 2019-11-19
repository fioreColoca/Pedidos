package Restaurante;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args)
			throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres, SistemaExceptionNoEncuentraUsuario,
			SistemaExceptionNoCreaUsuario, RestauranteExceptionNoLoCrea, RestauranteExceptionInexistente {

		String opcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		// Restaurante r1 = new Restaurante(" ", " ");
		// Cliente c1 = new Cliente(null, "", "", "", "");
		// Administrador a1 = new Administrador(null, "", "", "", "");
		Boolean salir = false;

		// <----------MENU ---------- >

		do {

			do {
				System.out.println("Bienvenido");
				System.out.println("1 -> Iniciar Sesion");
				System.out.println("2 -> Registrarse");
				opcion = teclado.next();

				if (opcion != "1" || opcion != "2") {
					salir = true;
				}

				switch (opcion) {

				case "1":

					System.out.println("Usted ha seleccionado: Iniciar Sesion");

					System.out.println("Ingrese email");
					String email = teclado.next();

					System.out.println("Ingrese password");
					String password = teclado.next();

					try {
						System.out.println("VERIFICANDO...");
						sistema.loguearUsuario(email, password);
						System.out.println("Usted ha iniciado sesion correctamente");
						salir = true;

					} catch (SistemaExceptionNoEncuentraUsuario e) { // NO ENCUENTRA USUARIO
						System.out.println(e.getMessage());
					}
					salir = true;
					break;

				case "2":

					System.out.println("Usted ha seleccionado: Registrarse");
					System.out.println("Por favor, Indique:");

					System.out.println("1.1 -> Administrador");
					System.out.println("2.2 -> Cliente");
					String opcionRegistro = teclado.next();

					switch (opcionRegistro) {

					case "1.1":

						String nombreAdm;
						String apellidoAdm;
						String emailAdm;
						String idAdm;
						String passwordAdm;
						Boolean salirAdm;
						String idAdmConfirmado = null;
						String passwordAdmConfirmado = null;
						String apellidoAdmConfirmado = null;
						String emailAdmConfirmado = null;
						String nombreAdmConfirmado = null;

						System.out.println("Ingrese su nombre");
						nombreAdm = teclado.next();

						try {

							if (sistema.soloLetras(nombreAdm) == true) {
								nombreAdmConfirmado = nombreAdm;
							}

							System.out.println("Ingrese su apellido");
							apellidoAdm = teclado.next();

							try {

								if (sistema.soloLetras(apellidoAdm) == true) {
									apellidoAdmConfirmado = apellidoAdm;
								}

								System.out.println("Ingrese su email");
								emailAdm = teclado.next();

								try {

									if (sistema.verificarEmail(emailAdm) == true) {
										emailAdmConfirmado = emailAdm;
									}

									System.out.println("Ingrese su contraseña");
									passwordAdm = teclado.next();

									try {

										if (sistema.validarPassword(passwordAdm) == true) {
											passwordAdmConfirmado = passwordAdm;
										}

										System.out.println("Ingrese su dni");
										idAdm = teclado.next();

										try {

											if (sistema.soloNumeros(idAdm) == true) {
												idAdmConfirmado = idAdm;
											}

											try {
												/*
												 * a1.setNombre(nombreAdm); a1.setApellido(apellidoAdm);
												 * a1.setEmail(emailAdm); a1.setPassword(passwordAdm); a1.setId(idAdm);
												 */

												Administrador a1 = new Administrador(idAdmConfirmado,
														nombreAdmConfirmado, apellidoAdmConfirmado, emailAdmConfirmado,
														passwordAdmConfirmado);

												if (sistema.crearNuevoUsuario(a1) == true) {
													System.out.println("Te registraste correctamente");

												}

											} catch (SistemaExceptionNoCreaUsuario e) {
												System.out.println(e.getMessage());
												salirAdm = false;
											}

										} catch (ExceptionNumero e) {
											System.out.println(e.getMessage());
										}

									} catch (UsuarioExceptionPasswordIncorrecta e) {
										System.out.println(e.getMessage());
									}

								} catch (ExceptionEmail e) {
									System.out.println(e.getMessage());
								}

							} catch (MainExceptionSoloCaracteres e) {
								System.out.println(e.getMessage());
							}

						} catch (MainExceptionSoloCaracteres e) {
							System.out.println(e.getMessage());
						}

						break;

					case "2.2":

						String nombreClie;
						String apellidoClie;
						String emailClie;
						String idClie;
						String passwordClie;
						Boolean salirClie;
						String idClieConfirmado = null;
						String passwordClieConfirmado = null;
						String apellidoClieConfirmado = null;
						String emailClieConfirmado = null;
						String nombreClieConfirmado = null;

						System.out.println("Ingrese su nombre");
						nombreClie = teclado.next();

						try {

							if (sistema.soloLetras(nombreClie) == true) {
								nombreClieConfirmado = nombreClie;
							}

							System.out.println("Ingrese su apellido");
							apellidoClie = teclado.next();

							try {

								if (sistema.soloLetras(apellidoClie) == true) {
									apellidoClieConfirmado = apellidoClie;
								}

								System.out.println("Ingrese su email");
								emailClie = teclado.next();

								try {

									if (sistema.verificarEmail(emailClie) == true) {
										emailClieConfirmado = emailClie;
									}

									System.out.println("Ingrese su contraseña");
									passwordClie = teclado.next();

									try {

										if (sistema.validarPassword(passwordClie) == true) {
											passwordClieConfirmado = passwordClie;
										}

										System.out.println("Ingrese su dni");
										idClie = teclado.next();

										try {

											if (sistema.soloNumeros(idClie) == true) {
												idClieConfirmado = idClie;
											}

											try {
												/*
												 * a1.setNombre(nombreAdm); a1.setApellido(apellidoAdm);
												 * a1.setEmail(emailAdm); a1.setPassword(passwordAdm); a1.setId(idAdm);
												 */

												Cliente a1 = new Cliente(idClieConfirmado, nombreClieConfirmado,
														apellidoClieConfirmado, emailClieConfirmado,
														passwordClieConfirmado);

												if (sistema.crearNuevoUsuario(a1) == true) {
													System.out.println("Te registraste correctamente");

												}

											} catch (SistemaExceptionNoCreaUsuario e) {
												System.out.println(e.getMessage());
												salirClie = false;
											}

										} catch (ExceptionNumero e) {
											System.out.println(e.getMessage());
										}

									} catch (UsuarioExceptionPasswordIncorrecta e) {
										System.out.println(e.getMessage());
									}

								} catch (ExceptionEmail e) {
									System.out.println(e.getMessage());
								}

							} catch (MainExceptionSoloCaracteres e) {
								System.out.println(e.getMessage());
							}

						} catch (MainExceptionSoloCaracteres e) {
							System.out.println(e.getMessage());
						}
						break;

					}
				}

			} while (salir = true);

		} while (salir = true);
	}
}