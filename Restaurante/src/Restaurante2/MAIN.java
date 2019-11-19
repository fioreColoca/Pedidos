package Restaurante2;

import java.util.Scanner;

public class MAIN {

	private static final Restaurante r1 = null;
	private static final Administrador a1 = null;

	public static void main(String[] args) throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres,
			SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario, RestauranteExceptionNoLoCrea,
			RestauranteExceptionInexistente, ExceptionNumero, AdministradorExceptionNoModificaPrecio {
		String optcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
		// <----------MENU ---------- >

		do {
			// PREGUNTA SI ES ADMINISTRADOR O CLIENTE
			System.out.println("BIENVENIDO");
			System.out.println("Ingrese la opcion '0' si es administrador o la opcion '1' si es cliente");
			optcion = teclado.next();

			if (optcion != "0" || optcion != "1") {
				salir = true;
			}

			// SWITCH DEL ADMINISTRADOR PARA CREAR SU RESTAURANTE O LOGUEARSE

			switch (optcion) {

			case "0":

				Boolean salirAdministrador = false;
				String opcionAdministrador = null;
				boolean ingresoTerminado2;
				do {
					// DO WHILE DE CREAR RESTAURANTE O INGRESAR A UN RESATURANTE
					System.out.println(
							"Usted ha seleccionado administrador, Ingrese la opcion'1' si desea crear su restaurante, la opcion '2' ingresar a su restaurante, la opcion '3' para salir");
					opcionAdministrador = teclado.next();

					if (opcionAdministrador != "1" || opcionAdministrador != "2") {
						salirAdministrador = true;
					}

					// SWITCH PARA CREAR EL RESTAURANTE O LOGUEARSE //<<------------------
					// RESTAURANTE ----------------->>
					switch (opcionAdministrador) {

					// CREAR RESTAURANTE
					case "1": {
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
					}

					case "2":

						String nombreResto;
						boolean ingresoTerminado5;

						do {
							boolean ingresoTerminado4 = false;

							do {
								System.out.println("Ingrese el nombre de su restaurante");
								nombreResto = teclado.next();

								try {

									if (sistema.buscarRestaurante(nombreResto)) {
										System.out.println(
												"Usted ha entrado a su restaurante exitosamente , Ingrese la opcion '1' para registrarse, la opcion '2'  para  iniciar sesión , la opcion '3' para salir");
										opcionAdministrador = teclado.next();

										if (opcionAdministrador != "1" || opcionAdministrador != "2"
												|| opcionAdministrador == "3") {
											salirAdministrador = true;
										}

										// SWITCH DEL ADMINISTRADOR

										switch (opcionAdministrador) {

										// REGISTRO DEL ADMINISTRADOR
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
											Boolean finalizado = false;

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
																				if (sistema.verificarEmail(
																						email) == true) {
																					emailConfirmado = email;
																					do {
																						System.out.println(
																								"Ingrese su contraseña");
																						password = teclado.next();
																						try {
																							if (sistema.validarPassword(
																									password) == true) {
																								passwordConfirmado = password;
																								do {
																									System.out.println(
																											"Ingrese su dni");
																									id = teclado.next();
																									try {
																										if (sistema
																												.soloNumeros(
																														id) == true) {
																											idConfirmado = id;

																											do {
																												System.out
																														.println(
																																"verificacion..");

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
																														System.out
																																.println(
																																		"te registraste correctamente"); // SE
																																											// CREA
																														// ADMINISTRADOR
																														ingresoTerminado2 = false;
																														error = true;
																														break;

																													}
																												} catch (SistemaExceptionNoCreaUsuario e) {
																													System.out
																															.println(
																																	e.getMessage());
																													ingresoTerminado = false;
																												}

																											} while (error != true);
																										}
																									} catch (ExceptionNumero e) {
																										System.out
																												.println(
																														e.getMessage());
																									}

																								} while (error != true);
																							}
																						} catch (UsuarioExceptionPasswordIncorrecta e) {
																							System.out.println(
																									e.getMessage());
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

										// INICIO DE SESION ADMINISTRADOR

										case "2": {

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
																"Ingrese '1'-> para agregar productos '2'-> para eliminar '3'-> Buscar producto '4'->Modificar precio , '5'-> CERRAR SESION , '6' -> eliminar cuenta");
														opcionAdministrador2 = teclado.next();

														if (opcionAdministrador2 != "1" || opcionAdministrador2 != "2"
																|| opcionAdministrador2 != "3") {
															salirMenuAdm = true;
														}

														// SWITCH DE ADMINISTRADOR PARA REALIZAR ACCIONES

														switch (opcionAdministrador2) {
														// <------------------------------ AGREGAR PRODUCTOS
														// ------------------------------>
														case "1":

															Boolean error1 = false;
															Categoria categoria = null;
															String descripcion = null;
															String descripcionConfirmado = null;
															Integer precioConfirmado = null;
															Integer idConfirmada = null;
															Integer precio = null;
															Integer id = null;
															String opcion = null;
															boolean errorAdm2 = false;

															do {

																System.out.println(
																		"Seleccionaste 1- 'agregar productos'");

																do {
																	System.out.println(
																			"Ingrese categoria '1'PIZZAS , '2' EMPANADAS , '3' PASTAS , '4' POSTRES ");
																	opcion = teclado.next();
																	if (opcionAdministrador2 != "1"
																			|| opcionAdministrador2 != "2"
																			|| opcionAdministrador2 != "3"
																			|| opcionAdministrador2 != "4") {
																		errorAdm2 = true;
																	} else {

																		/*
											* <----------- SWTICH CON LAS CATEGORIAS  ELEGIDAS-------------->
																		 */
																		switch (opcion) {
																		case "1":
																			categoria = categoria.PIZZAS;
																			break;
																		case "2":
																			categoria = categoria.EMPANADAS;
																			break;

																		case "3":
																			categoria = categoria.PASTAS;
																			break;

																		case "4":
																			categoria = categoria.POSTRES;
																			break;

																		}
																	}

																	do {
																		System.out.println("Ingrese descripcion");
																		descripcion = teclado.next();
																		try {
																			if (sistema
																					.soloLetras(descripcion) == true) {
																				descripcionConfirmado = descripcion;
																			}
																			do {
																				System.out.println(
																						"Ingrese precio '000.00' ");
																				precio = teclado.nextInt();
																				precioConfirmado = precio;
																				System.out.println(
																						"Ingrese id sólo números ");
																				id = teclado.nextInt();
																				idConfirmada = id;
																				try {
																					Producto p1 = new Producto(
																							categoria,
																							descripcionConfirmado,
																							precioConfirmado,
																							idConfirmada);
																					if (a1.agregarProductos(p1,
																							r1) == true) {
																						System.out.println(
																								"Ha creado su restaurante Exitosamente");
																					}

																				} catch (AdministradorExceptionAgregarProducto e) {
																					System.out.println(e.getMessage());
																				}

																			} while (error1 != true);

																		} catch (MainExceptionSoloCaracteres e) {
																			System.out.println(e.getMessage());
																		}

																	} while (error1 != true);

																} while (errorAdm2 != true);
															} while (errorAdm2 != true);

															break;
															
							// <---------------------------- ELIMINAR PRODUCTO	 ------------------------------------>
														case "2":
															error1 = true;
															Integer idEliminar = null;
															do {
																System.out.println(
																		"Seleccionaste 2- para eliminar productos");
																System.out.println(
																		"Ingrese id (sólo numeros) del producto a eliminar");
																idEliminar = teclado.nextInt();
																try {
																	if (a1.eliminarProducto(idEliminar, r1) == true) {
																		System.out.println("Eliminacion exitosa");
																	}

																} catch (AdministradorExceptionEliminarProducto e) {
																	System.out.println(e.getMessage());
																}

															} while (error1 != true);
															break;
															
							// <---------------------------- BRUSCAR PRODUCTO  ------------------------------------>

														case "3":
															error1 = true;
															Integer buscarProducto = null;
															do {
																System.out.println(
																		"Seleccionaste 3- para buscar productos");
																System.out.println(
																		"Ingrese id (slo numeros) para buscar el producto");
																buscarProducto = teclado.nextInt();
																try {
																	if (a1.buscarProducto(buscarProducto,r1) == true ) {
																		System.out.println(a1.buscarProductoDevuelve(buscarProducto,r1));
																	}

																} catch (AdministradorExceptionProductoNoEncontrado e) {
																	System.out.println(e.getMessage());
																}

															} while (error1 != true);
															break;

							// <---------------------------- MODIFICAR PRECIO  ------------------------------------>

														case "4":
															error1 = true;
															Integer buscarProducto2 = null;
															Double  precioModificar = null;
															do {
																System.out
																.println("Seleccionaste 4- para modificar precio");
																System.out.println(
																		"Ingrese id (slo numeros) para el producto que quiere modificar su precio");
																buscarProducto2 = teclado.nextInt();
																System.out.println(
																		"Ingrese 0000.00 del precio que quiera modificar");
																precioModificar = teclado.nextDouble();

																try {
																	if (a1.buscarProducto(buscarProducto2,r1) == true   ) {
																		 a1.modificarPrecio(precioModificar,buscarProducto2,r1);
																	System.out.println(a1.buscarProductoDevuelve(buscarProducto2,r1));
																	
																	}

																} catch (AdministradorExceptionProductoNoEncontrado e) {
																	System.out.println(e.getMessage());
																}

															} while (error1 != true);
															break;
							// <--------------------CERRAR SESION-----------------)							
															
														case "5" : 
															System.out.println(" cerrando sesion... ");
															sistema.cerrarSesiondeUsuario();
															
															
														break ;
														
							// <--------------------ELIMINAR CUENTA----------------)							

														case "6" : 
															String password3 = null;
															String passwordConfirmado2 = null;
															String id2 = null;
															System.out.println("Eliminar cuenta");
															error1=true;
															do {
	
																	System.out.println(
																			"Ingrese su contraseña");
																	password3 = teclado.next();
																	try {
																		if (sistema.validarPassword(
																				password3) == true) {
																			passwordConfirmado2 = password2;
																		}
																			do {
																				System.out.println("Ingrese su documento");
																				id2 = teclado.next();
																				try {
																					if (sistema.Eliminar(passwordConfirmado2,id2)== true) {
																						System.out
																								.println("Cuenta eliminada");
																						}
																					} catch (SistemaExceptionNoEliminaUsuario e) {
																						System.out.println(e.getMessage());
																					}

																				} while (error1 != true);
																				
																			} catch (UsuarioExceptionPasswordIncorrecta e) {
																				System.out.println(e.getMessage());
																			}

																
															}while (error1 != true);
															
															
														break;
															
															
							// <----------------------    TERMINA SWITCH DE ADM ------------------------------------->						
														}

													} while (salirMenuAdm = true);

												} catch (SistemaExceptionNoEncuentraUsuario e) {
													System.out.println(e.getMessage());
												}

											} while (iniciarSesion != true);

											break;
										}

										case "3": {
											break;
										}

										}
										while (salirAdministrador = true)
											;
										break;
									}

								} catch (RestauranteExceptionInexistente e) {
									System.out.println(e.getMessage());
								}
							} while (ingresoTerminado4 != true);
						} while (ingresoTerminado5 = true);
						break;

					}
				} while (ingresoTerminado2 = true);
				// PARA LOGUEARSE AL RESTAURANTE

				
				
				
				
				// <<----------------------------- CLIENTE ---------------------------->>
			case "1":

				String opcionCliente = null;

				System.out.println(
						"Seleccionaste cliente, Ingrese la opcion '1' para registrarse, la opcion '2'  para  iniciar sesión , la opcion '3' para salir");
				opcionCliente = teclado.next();

				break;
			}

		} while (salir = true);

	}
}
