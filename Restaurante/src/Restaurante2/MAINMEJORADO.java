package Restaurante2;

import java.util.Scanner;

public class MAINMEJORADO {

	private static final Cliente c1 = null;
	private static final Pedido  p1 = null;
	private static Restaurante r1;

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

			System.out.println("Por favor, indique si es : ");
			System.out.println("0 -> Administrador");
			System.out.println("1 -> Cliente");
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
						System.out.println("Usted ha seleccionado Administrador");
						System.out.println("1 -> Crear Restaurante");
						System.out.println("2 -> Registrarse");
						System.out.println("3 -> Iniciar Sesion");
						System.out.println("4 -> Salir");
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

							System.out.println("Usted ha seleccionado Registrarse");

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

										System.out.println("1 -> Agregar Productos");
										System.out.println("2 -> Eliminar Producto");
										System.out.println("3 -> Buscar Producto");
										System.out.println("4 -> Modificar Precio del Producto");
										System.out.println("5 -> Cerrar Sesion");
										System.out.println("6 -> Eliminar Cuenta");
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

											System.out.println("Seleccionaste 1- 'Agregar Productos'");

											do {
												System.out.println(
														"Por favor, ingrese la categoria a la que agregara el producto: ");
												System.out.println("1 -> PIZZAS");
												System.out.println("2 -> EMPANADAS");
												System.out.println("3 -> PASTAS");
												System.out.println("4 -> POSTRES");
												System.out.println("5 -> BEBIDAS");
												System.out.println("6 -> VINOS");
												System.out.println("7 -> ENSALADAS");
												System.out.println("8 -> ENTRADAS");
												System.out.println("9 -> MILANESAS");
												System.out.println("10 -> GUARNICIONES");
												System.out.println("11 -> PARRILLA");

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

													case "5":
														categoria = categoria.BEBIDAS;
														break;
													case "6":
														categoria = categoria.VINOS;
														break;
													case "7":
														categoria = categoria.ENSALADAS;
														break;

													case "8":
														categoria = categoria.ENTRADAS;
														break;

													case "9":
														categoria = categoria.MILANESAS;
														break;

													case "10":
														categoria = categoria.GUARNICIONES;
														break;

													case "11":
														categoria = categoria.PARRILLA;
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
												System.out.println("Seleccionaste 2- Eliminar P");
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
												System.out.println("Seleccionaste 3- Buscar producto");
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
											Integer  precioModificar = null;
											do {
												System.out.println("Seleccionaste 4- Modificar Precio del Producto");
												System.out.println(
														"Ingrese id (slo numeros) para el producto que quiere modificar su precio");
												buscarProducto2 = teclado.nextInt();
												System.out.println("Ingrese 0000.00 del precio que quiera modificar");
												precioModificar = teclado.nextInt();

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

				// <----------------CLIENTE---------------------->
			case "1":

				Boolean salirCliente = false;
				String opcionCliente = null;
				Boolean ingresoCliente = false;
				String resto = null;

				do {

					do {
						/*
						 * System.out.
						 * println("Bienvenido, usted ha seleccionado cliente, por favor ingrese en que restaurante se encuentra"
						 * ); resto = teclado.next(); try { if(sistema.buscarRestaurante(resto)) { }
						 */
						System.out.println("1 -> Registrarse");
						System.out.println("2 -> Iniciar Sesion");
						System.out.println("3 -> Salir");
						opcionCliente = teclado.next();

						if (opcionCliente != "1" || opcionCliente != "2") {
							salirCliente = true;
						}

						switch (opcionCliente) {

						// SE REGISTRA EL CLIENTE

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

							System.out.println("Usted ha seleccionado Registrarse");

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

						// SE LOGUEA EL USUARIO

						case "2":
							Boolean iniciarSesion = true;
							String email1;
							String password1;
							String opcionCliente1 = null;
							Boolean salirMenuClie = false;
							String opcionCliente11 = null;
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

										System.out.println("Por favor, indique que desea hacer: ");
										System.out.println("1 -> Pedir");
										System.out.println("2 -> Agregar un Producto al Pedido");
										System.out.println("3 -> Eliminar un Producto del Pedido");
										System.out.println("4 -> Mostrar carta");
										System.out.println("5 -> Pedir Cuenta");
										System.out.println("6 -> Eliminar Pedido");
										System.out.println("7 -> Ver Mi Historial de Pedidos");
										System.out.println("8 -> Cerrar Sesion");
										System.out.println("9 -> Eliminar Cuenta");
										opcionCliente1 = teclado.next();

										if (opcionCliente1 != "1" || opcionCliente1 != "2" || opcionCliente1 != "3" || 
											opcionCliente1 != "4" || opcionCliente1 != "5" || opcionCliente1 != "6" ||
											opcionCliente1 != "7" || opcionCliente1 != "8" || opcionCliente1 != "9") {
											salirMenuClie = true;
											
										}
										
										switch (opcionCliente1) {
										  //<----------------------MOSTRAR PRODUCTOS----------------->
										case "4":
											r1.mostrarCarta();
								        //<----------------------PEDIR CUENTA----------------->
										case "5":
											System.out.println("Su cuenta es de"+ c1.pedirCuenta(p1,r1));
											break;
							           //<---------------------- ELIMINAR PEDIDO COMPLETO----------------->
										case "6":
											c1.eliminarPedidoCompleto(p1);
											System.out.println("su pedido fue eliminado");
											break;
						        		//<----------------------HISTORIAL----------------->
										case "7": 
											System.out.println("mi historial de pedidos es");
											c1.verHistorial();
											break;
										// <---------------  CERRAR SESION --------------------->
										case "8":
											System.out.println(" cerrando sesion... ");
											sistema.cerrarSesiondeUsuario();
											break;

										// <--------------------ELIMINAR CUENTA----------------)

										case "9":
											String password4 = null;
											String passwordConfirmado3 = null;
											String id3 = null;
											System.out.println("Eliminar cuenta");
											Boolean error10 = true;
											do {

												System.out.println("Ingrese su contraseña");
												password4 = teclado.next();
												try {
													if (sistema.validarPassword(password4) == true) {
														passwordConfirmado3 = password4;
													}
													do {
														System.out.println("Ingrese su documento");
														id3 = teclado.next();
														try {
															if (sistema.Eliminar(passwordConfirmado3, id3) == true) {
																System.out.println("Cuenta eliminada");
															}
														} catch (SistemaExceptionNoEliminaUsuario e) {
															System.out.println(e.getMessage());
														}

													} while (error10 != true);

												} catch (UsuarioExceptionPasswordIncorrecta e) {
													System.out.println(e.getMessage());
												}

											} while (error10 != true);
											break;
											
										//	<----------------------- CIERRE SWTICH ------------------>
										}
										
										

									} while (salirMenuClie = true);

								} catch (SistemaExceptionNoEncuentraUsuario e) {
									System.out.println(e.getMessage());
								}

							} while (errorClie != true);

						}

						/*
						 * }catch(RestauranteExceptionInexistente e) {
						 * System.out.println(e.getMessage()); }
						 */

					} while (salirCliente != true);
				} while (salirCliente = true); // TERMINA DO GENERAL

			}
			while (salir != true)
				; // SWITCH GENERAL

		} while (salirAdministrador = true); // ADMIN O CLIENTE
	}
}