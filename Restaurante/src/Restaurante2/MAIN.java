package Restaurante2;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args)
			throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario {
		String optcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
// <----------MENU ---------- >
		do {
			System.out.println("Ingrese '1' si es administrador o '2' si es cliente");
			optcion = teclado.next();
			if (optcion !="1" || optcion != "2") {
				salir = true;
			}

			switch (optcion) {
			case "1":

				Boolean salirAdministrador = false;
				String opcionAdministrador = null;
				do {

					System.out.println(
							"Seleccionaste administrador, Ingrese '1'  registrarse,'2' abrir sesión,'3' salir");
					opcionAdministrador = teclado.next();
					if (opcionAdministrador != "1" || opcionAdministrador != "2") {
						salirAdministrador = true;
					}
					switch (opcionAdministrador) {

					case "1": {
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
						Boolean finalizado=false;
						// *HACER CLASE PARA QUE VERIFIQUE SI ESTAN BIEN O NO LO INGRESADO //

						System.out.println("Selecciono para registrarse");

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
																	System.out.println("Ingrese su contraseña");
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

																						do {System.out
																								.println("verificacion..");
																							
																							try {
																								Administrador a1 = new Administrador(idConfirmado, nombreConfirmado, apellidoConfirmado,
																										emailConfirmado, passwordConfirmado);
																								if (sistema.crearNuevoUsuario(a1)==true) {
																									System.out.println("te registraste correctamente");
																									opcionAdministrador="2";
																									error=true;
																									break;

																								}
																							}catch (SistemaExceptionNoCreaUsuario e) {
																								System.out.println(e.getMessage());
																								ingresoTerminado=false;
																							}
																							
																						}while (error!=true);
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

						break;

					}

					// VERIFICAR PASSWORD ESTA MAL DENTRODE USUARIO
					case "2": {
						Boolean iniciarSesion = true;
						String email2;
						String password2;
						Integer opcionCliente = null;
						Boolean salirMenuAdm=false;
						String opcionAdministrador2=null;
						Boolean errorAdm = true;
						do {
							System.out.println("Ingrese email");
							email2 = teclado.next();
							System.out.println("Ingrese password");
							password2 = teclado.next();
							try {sistema.loguearUsuario("email2", "password2");
								do { 
									System.out.println("Ingresaste correctamente");
									System.out.println("Ingrese '1'-> para agregar productos '2'-> para eliminar '3'-> Buscar producto '4'->Modificar precio");
									opcionAdministrador2 = teclado.next();
									if (opcionAdministrador2 != "1" || opcionAdministrador2 != "2" || opcionAdministrador2 != "3" ) {
										salirMenuAdm = true;
									}
									switch (opcionAdministrador2) {
									case "1" : 
										System.out.println("Seleccionaste 1- 'agregar productos'");
										do {
											System.out.println();
										}while (errorAdm !=true);
										break;
									case "2" : 
										System.out.println("Seleccionaste 2- para eliminar productos");
											 
										break;
										
									case "3" : 
										System.out.println("Seleccionaste 3- para buscar productos");
										break;
										
									case "4": 
										System.out.println("Seleccionaste 4- para modificar precio");
									}
									
									
								}while(salirMenuAdm=true);
								
							
							} catch (SistemaExceptionNoEncuentraUsuario e) {
								System.out.println(e.getMessage());
							}
							
							
						} while (iniciarSesion != true);

						break;
					}
					case "3":
						break; 
						
					}

				} while (salirAdministrador = true);
				break;
//<<----------------------------- CLIENTE ----------------->>
			case "2":
				String opcionCliente = null;
				System.out.println("Seleccionaste cliente, Ingrese '1'  registrarse,'2' abrir sesión , '3' salir");
				opcionCliente = teclado.next();
				
				break;
			}

		} while (salir = true);

	}

}
