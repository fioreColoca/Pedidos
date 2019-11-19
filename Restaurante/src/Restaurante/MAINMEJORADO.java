package Restaurante;

import java.util.Scanner;

public class MAINMEJORADO {

	public static void main(String[] args) throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres,
			SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario, RestauranteExceptionNoLoCrea,
			RestauranteExceptionInexistente, AdministradorExceptionNoModificaPrecio {
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
																		System.out.println("Ingrese su contraseña");
																		password = teclado.next();
																		try {
																			if (sistema.validarPassword(
																					password) == true) {
																				passwordConfirmado = password;
																				do {
																					System.out
																							.println("Ingrese su dni");
																					id = teclado.next();
																					try {
																						if (sistema.soloNumeros(
																								id) == true) {
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
																										System.out
																												.println(
																														"Te registraste correctamente"); // SE
																																							// CREA
																																							// EL
																																							// ADMINISTRADOR
																										opcionAdministrador = "2";
																										error = true;
																										break;

																									}
																								} catch (SistemaExceptionNoCreaUsuario e) {
																									System.out.println(e
																											.getMessage());
																									ingresoTerminado = false;
																								}

																							} while (error != true);
																						}
																					} catch (ExceptionNumero e) {
																						System.out.println(
																								e.getMessage());
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

									sistema.loguearUsuario(email2, password2);
									do {
										System.out.println("Ingresaste correctamente");

										// <------------------------OPCIONES QUE PUEDE HACER EL ADM
										// -------------------->
										System.out.println(
												"Ingrese la opcion '1'-> para agregar productos, la opcion '2'-> para eliminar, la opcion '3'-> para Buscar producto, la opcion '4'-> para Modificar precio , la opcion '5'-> para Cerrar Sesion , la opcion '6' -> para eliminar cuenta");
										opcionAdministrador2 = teclado.next();

										if (opcionAdministrador2 != "1" || opcionAdministrador2 != "2"
												|| opcionAdministrador2 != "3") {
											salirMenuAdm = true;
										}

										// SWITCH DE ADMINISTRADOR PARA REALIZAR ACCIONES

										Administrador a1 = null;
										Restaurante r1 = null;
										switch (opcionAdministrador2) {

										case "1":

											Boolean error11 = false;
											Categoria categoria = null;
											String descripcion = null;
											String descripcionConfirmado = null;
											Integer precioConfirmado = null;
											Integer idConfirmada = null;
											Integer precio = null;
											Integer id1 = null;
											String opcion1 = null;
											boolean errorAdm2 = false;

											System.out.println("Seleccionaste 1- 'agregar productos'");

											do {
												System.out.println(
														"Ingrese categoria '1'PIZZAS , '2' EMPANADAS , '3' PASTAS , '4' POSTRES ");
												opcion1 = teclado.next();
												if (opcionAdministrador2 != "1" || opcionAdministrador2 != "2"
														|| opcionAdministrador2 != "3" || opcionAdministrador2 != "4") {
													errorAdm2 = true;
												} else {

													/*
													 * <----------- SWTICH CON LAS CATEGORIAS ELEGIDAS-------------->
													 */
													switch (opcion1) {
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
														if (sistema.soloLetras(descripcion) == true) {
															descripcionConfirmado = descripcion;
														}
														do {
															System.out.println("Ingrese precio '000.00' ");
															precio = (int) teclado.nextDouble();
															precioConfirmado = precio;
															System.out.println("Ingrese id sólo números ");
															id1 = teclado.nextInt();
															idConfirmada = id1;
															try {
																Producto p1 = new Producto(categoria,
																		descripcionConfirmado, precioConfirmado,
																		idConfirmada);
																if (a1.agregarProductos(p1, r1) == true) {
																	System.out.println(
																			"Ha creado su producto Exitosamente");
																}

															} catch (AdministradorExceptionAgregarProducto e) {
																System.out.println(e.getMessage());
															}

														} while (error11 != true);

													} catch (MainExceptionSoloCaracteres e) {
														System.out.println(e.getMessage());
													}

												} while (error11 != true);

											} while (errorAdm2 != true);

											// <---------------------------- ELIMINAR PRODUCTO
											// ------------------------------------>
										case "2":
											error1 = true;
											Integer idEliminar = null;
											do {
												System.out.println("Seleccionaste 2- para eliminar productos");
												System.out.println("Ingrese id (sólo numeros) del producto a eliminar");
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

										// <---------------------------- BRUSCAR PRODUCTO
										// ------------------------------------>

										case "3":
											error1 = true;
											Integer buscarProducto = null;
											do {
												System.out.println("Seleccionaste 3- para buscar productos");
												System.out.println("Ingrese id (slo numeros) para buscar el producto");
												buscarProducto = teclado.nextInt();
												try {
													if (a1.buscarProducto(buscarProducto, r1) == true) {
														System.out
																.println(a1.buscarProductoDevuelve(buscarProducto, r1));
													}

												} catch (AdministradorExceptionProductoNoEncontrado e) {
													System.out.println(e.getMessage());
												}

											} while (error1 != true);
											break;

										// <---------------------------- MODIFICAR PRECIO
										// ------------------------------------>

										case "4":
											error1 = true;
											Integer buscarProducto2 = null;
											Double precioModificar = null;
											do {
												System.out.println("Seleccionaste 4- para modificar precio");
												System.out.println(
														"Ingrese id (slo numeros) para el producto que quiere modificar su precio");
												buscarProducto2 = teclado.nextInt();
												System.out.println("Ingrese 0000.00 del precio que quiera modificar");
												precioModificar = teclado.nextDouble();

												try {
													if (a1.buscarProducto(buscarProducto2, r1) == true) {
														a1.modificarPrecio(precioModificar, buscarProducto2, r1);
														System.out.println(
																a1.buscarProductoDevuelve(buscarProducto2, r1));

													}

												} catch (AdministradorExceptionProductoNoEncontrado e) {
													System.out.println(e.getMessage());
												}

											} while (error1 != true);
											break;

										// <--------------------CERRAR SESION---------------------------->

										case "5":
											System.out.println(" cerrando sesion... ");
											sistema.cerrarSesiondeUsuario();
											break;

										// <--------------------ELIMINAR CUENTA----------------)

										case "6":
											String password3 = null;
											String passwordConfirmado2 = null;
											String id2 = null;
											System.out.println("Eliminar cuenta");
											error1 = true;
											do {

												System.out.println("Ingrese su contraseña");
												password3 = teclado.next();
												try {
													if (sistema.validarPassword(password3) == true) {
														passwordConfirmado2 = password2;
													}
													do {
														System.out.println("Ingrese su documento");
														id2 = teclado.next();
														try {
															if (sistema.Eliminar(passwordConfirmado2, id2) == true) {
																System.out.println("Cuenta eliminada");
															}
														} catch (SistemaExceptionNoEliminaUsuario e) {
															System.out.println(e.getMessage());
														}

													} while (error1 != true);

												} catch (UsuarioExceptionPasswordIncorrecta e) {
													System.out.println(e.getMessage());
												}

											} while (error1 != true);
											break;

										} // CIERRA SWITCH DE ACCIONES

									} while (salirMenuAdm = true); // MENU DE INICIO DE SESION

								} catch (SistemaExceptionNoEncuentraUsuario e) { // NO ENCUENTRA USUARIO
									System.out.println(e.getMessage());
								}
							} while (iniciarSesion != true); // CIERRE DO WHILE DEL CASE 3
							break;

						case "4":
							break;
						} // CIERRA SWITCH DE OPCIONES DE ADMIN D RESTO O LOGUEA

					} while (salirAdministrador1 != true); // TERMINA DO WHILE DE RESTO

				} while (salirAdministrador1 = true); // TERMINA EL OTRO PA QUE VUELVA AL MENU
				
				//<----------------CLIENTE---------------------->
			case "1":
				
				Boolean salirCliente = false;
				String opcionCliente = null;
				Boolean ingresoCliente = false;
				String resto = null;

				do {

					do {
						/*System.out.println("Bienvenido, usted ha seleccionado cliente, por favor ingrese en que restaurante se encuentra");
						resto = teclado.next();
						try {
						if(sistema.buscarRestaurante(resto)) {
						}
					*/
						System.out.println(
								"Ingrese la opcion '1' si desea registrarse, la opcion '2' si desea iniciar sesion, la opcion '3' para salir");
						opcionCliente = teclado.next();

						if (opcionCliente != "1" || opcionCliente != "2") {
							salirCliente = true;
						}
						
						switch(opcionCliente) {
						
						//SE REGISTRA EL CLIENTE
						
						case "1":
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
																		System.out.println("Ingrese su contraseña");
																		password = teclado.next();
																		try {
																			if (sistema.validarPassword(
																					password) == true) {
																				passwordConfirmado = password;
																				do {
																					System.out
																							.println("Ingrese su dni");
																					id = teclado.next();
																					try {
																						if (sistema.soloNumeros(
																								id) == true) {
																							idConfirmado = id;

																							do {
																								System.out.println(
																										"VERIFICACION..");

																								try {
																									Cliente c1 = new Cliente(
																											idConfirmado,
																											nombreConfirmado,
																											apellidoConfirmado,
																											emailConfirmado,
																											passwordConfirmado);
																									if (sistema
																											.crearNuevoUsuario(
																													c1) == true) {
																										System.out
																												.println(
																														"Te registraste correctamente"); // SE
																																							// CREA
																																							// EL
																																							// ADMINISTRADOR
																										opcionCliente = "2";
																										error = true;
																										break;

																									}
																								} catch (SistemaExceptionNoCreaUsuario e) {
																									System.out.println(e
																											.getMessage());
																									ingresoTerminado = false;
																								}

																							} while (error != true);
																						}
																					} catch (ExceptionNumero e) {
																						System.out.println(
																								e.getMessage());
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
							salirCliente = true;
							break;
							
						case "2":
							Boolean iniciarSesion = true;
							String email1;
							String password1;
							String opcionCliente1 = null;
							Boolean salirMenuClie = false;
							String opcionCliente11= null;
							Boolean errorClie = true;

							do {

								System.out.println("Ingrese email");
								email1 = teclado.next();

								System.out.println("Ingrese password");
								password1 = teclado.next();

								try {

									sistema.loguearUsuario(email1, password1);
									
									do {
										System.out.println("Ingresaste correctamente");

										// <------------------------OPCIONES QUE PUEDE HACER EL CLIENTE
										// -------------------->
										System.out.println(
												"Ingrese la opcion '1' para hacer un pedido, la opcion '2'-> para Agregar productos, la opcion '3'-> para Eliminar productos, la opcion '4'-> para Eliminar pedido, la opcion '4'-> para Buscar producto , la opcion '5' para pedir cuenta, la opcion '6' -> para Cerrar Sesion, la opcion '7' para Eliminar Cuenta");
										opcionCliente1 = teclado.next();

										if (opcionCliente1 != "1" || opcionCliente1 != "2"
												|| opcionCliente1 != "3") {
											salirMenuClie = true;
										}
										
									}while(salirMenuClie = true);
									
								}catch (SistemaExceptionNoEncuentraUsuario e) {
									System.out.println(e.getMessage());
								}
						
								}while(errorClie!=true);
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						}
				
						
						
						/*}catch(RestauranteExceptionInexistente e) {
							System.out.println(e.getMessage());
						}*/
				
					}while(salirCliente!=true);
				}while(salirCliente=true); //TERMINA DO GENERAL
				
			}while (salir != true); // SWITCH GENERAL
				
		} while (salirAdministrador = true); // ADMIN O CLIENTE
	}
}
