package Restaurante;

import java.util.Scanner;

public class MAINMEJORADO {

	public static void main(String[] args)
			throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres, SistemaExceptionNoEncuentraUsuario,
			SistemaExceptionNoCreaUsuario, RestauranteExceptionNoLoCrea, RestauranteExceptionInexistente {
		String opcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
		// <----------MENU ---------- >
		boolean salirAdministrador;
		do {
			// PREGUNTA SI ES ADMINISTRADOR O CLIENTE
			System.out.println("BIENVENIDO");

			System.out.println("Ingrese la opcion '0' si es administrador o la opcion '1' si es cliente");
			opcion = teclado.next();

			if (opcion != "0" || opcion != "1") {
				salir = true;
			}

			// SWITCH DEL ADMINISTRADOR PARA CREAR SU RESTAURANTE O LOGUEARSE

			switch (opcion) {

			case "0":
				Boolean salirAdministrador1 = false;
				String opcionAdministrador = null;
				Boolean ingresoTerminado2 = false;
				
				do {

				do {
					// DO WHILE DE CREAR RESTAURANTE O INGRESAR A UN RESATURANTE
					System.out.println(
							"Usted ha seleccionado administrador, Ingrese la opcion '1' si desea crear su restaurante, la opcion '2' si desea registrarse, la opcion '3' si desea iniciar sesion, la opcion '4' para salir");
					opcionAdministrador = teclado.next();

					if (opcionAdministrador != "1" || opcionAdministrador != "2" || opcionAdministrador != "3") {
						salirAdministrador1 = true;
					}

					// SWITCH PARA CREAR EL RESTAURANTE O LOGUEARSE //<<-----------------
					// RESTAURANTE ----------------->>

					switch (opcionAdministrador) {

					// CREAR RESTAURANTE
					case "1":
						Boolean error1 = false;
						String nombre1;
						String cuit1;

						System.out.println("Usted ha seleccionado Crear Restaurante");

							do {
							
							boolean ingresoTerminado0 = false;

							do {
								System.out.println("Ingrese el nombre de su Restaurante");
								nombre1 = teclado.next();
								try {
									if (sistema.soloLetras(nombre1) == true) {
										String nombreConfirmado = nombre1;

										do {
											System.out.println("Ingrese el cuit de su Restaurante");
											cuit1 = teclado.next();

											try {

												if (sistema.soloNumeros(cuit1) == true) {
													String cuitConfirmado = cuit1;

													do {
														System.out.println("VERIFICANDO..");

														try {
															Restaurante r1 = new Restaurante(nombreConfirmado,
																	cuitConfirmado);

															if (sistema.agregarRestaurante(r1) == true) {
																System.out.println(
																		"Ha creado su restaurante Exitosamente");
																opcionAdministrador = "2";
																error1 = true;
																ingresoTerminado2 = true;
																break;

															}
														} catch (RestauranteExceptionNoLoCrea e) {
															System.out.println(e.getMessage());
															ingresoTerminado0 = false;
														}
													} while (error1 != true);

												}
											} catch (ExceptionNumero e) {
												System.out.println(e.getMessage());
											}
										} while (error1 != true);
									}
								} catch (MainExceptionSoloCaracteres e) {
									System.out.println(e.getMessage());
								}

							} while (error1 != true);

						} while (error1 != true);
						break;

					// REGISTRARSE COMO ADMINISTRADOR
					case "2":
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
						Boolean finalizado = false;

						System.out.println("Usted ha seleccionado para registrarse");

						boolean ingresoTerminado;
						do {
							ingresoTerminado = false;
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
																	System.out.println("Ingrese su contraseņa");
																	password = teclado.next();
																	try {
																		if (sistema.validarPassword(password) == true) {
																			passwordConfirmado = password;
																			do {
																				System.out.println("Ingrese su dni");
																				id = teclado.next();
																				try {
																					if (sistema
																							.soloNumeros(id) == true) {
																						idConfirmado = id;

																						do {
																							System.out.println(
																									"VERIFICACION..");

																							try {
																								Administrador a1 = new Administrador(
																										idConfirmado,
																										nombreConfirmado,
																										apellidoConfirmado,
																										emailConfirmado,
																										passwordConfirmado);
																								if (sistema
																										.crearNuevoUsuario(
																												a1) == true) {
																									System.out.println(
																											"Te registraste correctamente"); // SE
																																				// CREA
																																				// EL
																																				// ADMINISTRADOR
																									opcionAdministrador = "2";
																									error = true;
																									break;

																								}
																							} catch (SistemaExceptionNoCreaUsuario e) {
																								System.out.println(
																										e.getMessage());
																								ingresoTerminado = false;
																							}

																						} while (error != true);
																					}
																				} catch (ExceptionNumero e) {
																					System.out.println(e.getMessage());
																				}

																			} while (error != true);
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

						} while (ingresoTerminado == true);
						salirAdministrador1 = true;
						break;

					// INICIAR SESION EN RESTAURANTE
					case "3":
						Boolean iniciarSesion = true;
						String email2;
						String password2;
						Integer opcionCliente = null;
						Boolean salirMenuAdm = false;
						String opcionAdministrador2 = null;
						Boolean errorAdm = true;

						do {

							System.out.println("Ingrese email");
							email2 = teclado.next();

							System.out.println("Ingrese password");
							password2 = teclado.next();

							try {
								
								sistema.loguearUsuario("email2", "password2");
								do {
									System.out.println("Ingresaste correctamente");

									// <------------------------OPCIONES QUE PUEDE HACER EL ADM -------------------->
									System.out.println(
											"Ingrese la opcion '1'-> para agregar productos, la opcion '2'-> para eliminar, la opcion '3'-> para Buscar producto, la opcion '4'-> para Modificar precio , la opcion '5'-> para Cerrar Sesion , la opcion '6' -> para eliminar cuenta");
									opcionAdministrador2 = teclado.next();

									if (opcionAdministrador2 != "1" || opcionAdministrador2 != "2"
											|| opcionAdministrador2 != "3") {
										salirMenuAdm = true;
									}

									// SWITCH DE ADMINISTRADOR PARA REALIZAR ACCIONES

									switch (opcionAdministrador2) {

									case "1":
										System.out.println("Seleccionaste 1- 'agregar productos'");


										break;
									case "2":
										System.out.println("Seleccionaste 2- para eliminar productos");

										break;

									case "3":
										System.out.println("Seleccionaste 3- para buscar productos");
										break;

									case "4":
										System.out.println("Seleccionaste 4- para modificar precio");
										
										
										
										
									} //CIERRA SWITCH DE ACCIONES

								} while (salirMenuAdm = true); // MENU DE INICIO DE SESION

							} catch (SistemaExceptionNoEncuentraUsuario e) { // NO ENCUENTRA USUARIO
								System.out.println(e.getMessage());
							}
						} while (iniciarSesion != true); //CIERRE DO WHILE DEL CASE 3
						break;

					case "4":
						break;
					} // CIERRA SWITCH DE OPCIONES DE ADMIN D RESTO O LOGUEA

				} while (salirAdministrador1 != true); // TERMINA DO WHILE DE RESTO

			}while(salirAdministrador1 = true); //TERMINA EL OTRO PA QUE VUELVA AL MENU

		} while (salir != true); // SWITCH GENERAL
	} while(salirAdministrador = true); //ADMIN O CLIENTE
	}
}