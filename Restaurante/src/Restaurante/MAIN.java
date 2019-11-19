package Restaurante;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) throws UsuarioExceptionPasswordIncorrecta, MainExceptionSoloCaracteres,
			SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario, RestauranteExceptionNoLoCrea,
			RestauranteExceptionInexistente, AdministradorExceptionNoModificaPrecio {

		String opcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Restaurante r1 = new Restaurante(" ", " ");
		Cliente c1 = new Cliente(null, "", "", "", "");
		Administrador a1 = new Administrador(null, "", "", "", "");
		Producto p1 = new Producto(null, "", null, null);
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
						
						Administrador usuario;
						if(usuario instanceof Administrador) {
						
						String opcionADM;
						
						do {
						
							// MENU DE ADMINISTRADOR
							System.out.println("¿Que desea hacer?");

							System.out.println("0 -> Crear Restaurante");
							System.out.println("1 -> Agregar Productos");
							System.out.println("2 -> Eliminar Producto");
							System.out.println("3 -> Buscar Producto");
							System.out.println("4 -> Modificar Precio del Producto");
							System.out.println("5 -> Cerrar Sesion");
							System.out.println("6 -> Eliminar Cuenta");
							System.out.println("7 -> Menu Principal");
							opcionADM = teclado.next();

							if (opcionADM != "1" || opcionADM != "2" || opcionADM != "3" || opcionADM != "4"
									|| opcionADM != "5" || opcionADM != "6") {
								salir = true;
							}

							// DEL MENU DEL ADM
							switch (opcionADM) {

							case "0":
								
								String nombre1;
								String cuit1;

								System.out.println("Usted ha seleccionado Crear Restaurante");
								Boolean error1;
								do {
									String nombreConfirmado = null;
									String cuitConfirmado = null;

									System.out.println("Ingrese el nombre de su Restaurante");
									nombre1 = teclado.next();

									try {

										if (sistema.soloLetras(nombre1) == true) {
											nombreConfirmado = nombre1;
										}

										System.out.println("Ingrese el cuit de su Restaurante");
										cuit1 = teclado.next();

										try {

											if (sistema.soloNumeros(cuit1) == true) {
												cuitConfirmado = cuit1;
											}

											try {
												System.out.println("VERIFICANDO..");

												r1.setNombre2(nombreConfirmado);
												r1.setCuit2(cuitConfirmado);

												if (r1.getNombre2().equals(nombreConfirmado)
														&& r1.getCuit2().equals(cuitConfirmado)
														&& sistema.agregarRestaurante(r1) == true) {
													System.out.println("Ha creado su Restaurante exitosamente");
													error1 = true;
													
												}

											} catch (RestauranteExceptionNoLoCrea e) {
												System.out.println(e.getMessage());
											}
										} catch (ExceptionNumero e) {
											System.out.println(e.getMessage());
										}

									} catch (MainExceptionSoloCaracteres e) {
										System.out.println(e.getMessage());
									}

								} while (error1 = true);
								break;

							case "1":

								String opcionADM1 = null;
								Categoria categoria = null;
								String descripcion = null;
								String descripcionConfirmado = null;
								Integer precioConfirmado = null;
								Integer idConfirmada = null;
								Integer precio;
								Integer id1 = null;
								Boolean errorProd = false;

								System.out.println("Seleccionaste 1- 'Agregar Productos'");

								do {
									System.out
											.println("Por favor, ingrese la categoria a la que agregara el producto: ");

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
									System.out.println("12 -> Salir");

									opcionADM1 = teclado.next();

									if (opcionADM1 != "1" || opcionADM1 != "2" || opcionADM1 != "3" || opcionADM1 != "4"
											|| opcionADM1 != "5" || opcionADM1 != "6" || opcionADM1 != "7"
											|| opcionADM1 != "8" || opcionADM1 != "9" || opcionADM1 != "10"
											|| opcionADM1 != "11") {
										salir = true;
									}

									else {
										// <----------- SWTICH CON LAS CATEGORIAS ELEGIDAS-------------->
										switch (opcionADM1) {
										case "1":
											categoria = Categoria.PIZZAS;
											break;
										case "2":
											categoria = Categoria.EMPANADAS;
											break;

										case "3":
											categoria = Categoria.PASTAS;
											break;

										case "4":
											categoria = Categoria.POSTRES;
											break;

										case "5":
											categoria = Categoria.BEBIDAS;
											break;
										case "6":
											categoria = Categoria.VINOS;
											break;
										case "7":
											categoria = Categoria.ENSALADAS;
											break;

										case "8":
											categoria = Categoria.ENTRADAS;
											break;

										case "9":
											categoria = Categoria.MILANESAS;
											break;

										case "10":
											categoria = Categoria.GUARNICIONES;
											break;

										case "11":
											categoria = Categoria.PARRILLA;
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
													p1.setPrecioId(idConfirmada);
													p1.setDescripcion(descripcionConfirmado);
													p1.setPrecio(precioConfirmado);

													if (p1.getPrecio().equals(precioConfirmado)
															&& p1.getCategoria().equals(categoria)
															&& p1.getDescripcion().equals(descripcionConfirmado)
															&& p1.getPrecio().equals(precioConfirmado)
															&& a1.agregarProductos(p1, r1) == true) {
														System.out.println("Ha creado su producto Exitosamente");
													}

												} catch (AdministradorExceptionAgregarProducto e) {
													System.out.println(e.getMessage());
												}

											} while (errorProd != true);

										} catch (MainExceptionSoloCaracteres e) {
											System.out.println(e.getMessage());
										}

									} while (errorProd != true);

								} while (salir = true);

								// <------------------- ELIMINAR PRODUCTO------------------------>

							case "2":

								errorProd = true;
								Integer idEliminar = null;
								do {
									System.out.println("Seleccionaste 2- Eliminar P");

									System.out.println("Ingrese id (solo numeros) del producto a eliminar");
									idEliminar = teclado.nextInt();

									try {
										if (a1.eliminarProducto(idEliminar, r1) == true) {
											System.out.println("Eliminacion exitosa");
										}

									} catch (AdministradorExceptionEliminarProducto e) {
										System.out.println(e.getMessage());
									}

								} while (errorProd != true);
								break;

							// <---------------------- BUSCAR PRODUCTO------------------------->

							case "3":

								errorProd = true;

								Integer buscarProducto = null;
								do {
									System.out.println("Seleccionaste 3- Buscar producto");
									System.out.println("Ingrese id (solo numeros) para buscar el producto");
									buscarProducto = teclado.nextInt();
									try {
										if (a1.buscarProducto(buscarProducto, r1) == true) {
											System.out.println(a1.buscarProductoDevuelve(buscarProducto, r1));
										}

									} catch (AdministradorExceptionProductoNoEncontrado e) {
										System.out.println(e.getMessage());
									}

								} while (errorProd != true);
								break;

							// <---------------------------- MODIFICAR PRECIO--------------------------->

							case "4":
								errorProd = true;
								Integer buscarProducto2 = null;
								Integer precioModificar = null;
								do {
									System.out.println("Seleccionaste 4- Modificar Precio del Producto");
									System.out.println(
											"Ingrese id (solo numeros) para el producto que quiere modificar su precio");
									buscarProducto2 = teclado.nextInt();
									System.out.println("Ingrese 0000.00 del precio que quiera modificar");
									precioModificar = (int) teclado.nextDouble();

									try {
										if (a1.buscarProducto(buscarProducto2, r1) == true) {
											a1.modificarPrecio(precioModificar, buscarProducto2, r1);
											System.out.println(a1.buscarProductoDevuelve(buscarProducto2, r1));

										}

									} catch (AdministradorExceptionProductoNoEncontrado e) {
										System.out.println(e.getMessage());
									}

								} while (errorProd != true);
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
								errorProd = true;
								do {

									System.out.println("Ingrese su contraseña");
									password3 = teclado.next();
									try {
										if (sistema.validarPassword(password3) == true) {
											passwordConfirmado2 = password3;
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

										} while (errorProd != true);

									} catch (UsuarioExceptionPasswordIncorrecta e) {
										System.out.println(e.getMessage());
									}

								} while (errorProd != true);
								break;

							case "7":
								errorProd = true;
								break;

							}// CIERRA SWITCH ADM ACCIONES
						
						}while (salir = true);
						
						}else { Cliente usuario1;
						if (usuario1 instanceof Cliente) {
							String opcionCliente1 = null;
							String opcionCliente11 = null;
							Boolean salirMenuClie = false;
							Boolean errorClie = true;

							do {
								System.out.println("Por favor, indique que desea hacer: ");

								System.out.println("1 -> Pedir");
								System.out.println("2 -> Agregar un Producto al Pedido");
								System.out.println("3 -> Eliminar un Producto del Pedido");
								System.out.println("4 -> Ver Estado del Pedido");
								System.out.println("5 -> Pedir Cuenta");
								System.out.println("6 -> Eliminar Pedido");
								System.out.println("7 -> Ver Mi Historial de Pedidos");
								System.out.println("8 -> Cerrar Sesion");
								System.out.println("9 -> Eliminar Cuenta");
								System.out.println("10 -> Salir");
								opcionCliente1 = teclado.next();

								if (opcionCliente1 != "1" || opcionCliente1 != "2" || opcionCliente1 != "3") {
									salirMenuClie = true;
								}

								switch (opcionCliente1) {
								// <-------------------HACER PEDIDO-------------------->

								// <----------------------MOSTRAR PRODUCTOS----------------->
								case "4":
									r1.mostrarCarta();
									// <----------------------PEDIR CUENTA----------------->
								case "5":
									 System.out.println("Su cuenta es de" + c1.pedirCuenta(p1, r1));
									break;
								// <---------------------- ELIMINAR PEDIDO COMPLETO----------------->
								case "6":
									 c1.eliminarPedidoCompleto(p1);
									System.out.println("su pedido fue eliminado");
									break;
								// <----------------------HISTORIAL----------------->
								case "7":
									System.out.println("mi historial de pedidos es");
									c1.verHistorial();
									break;
								// <--------------- CERRAR SESION --------------------->
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

								case "10":
									salirMenuClie = true;
									break;
								}

								// <----------------------- CIERRE SWTICH ------------------>

							} while (salirMenuClie = true);

						} while (salir = true);

					}
					}catch (SistemaExceptionNoEncuentraUsuario e) { // NO ENCUENTRA USUARIO
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
												a1.setNombre(nombreAdmConfirmado);
												a1.setApellido(apellidoAdmConfirmado);
												a1.setEmail(emailAdmConfirmado);
												a1.setPassword(passwordAdmConfirmado);
												a1.setId(idAdmConfirmado);

												if (a1.getNombre().equals(nombreAdmConfirmado)
														&& a1.getApellido().equals(apellidoAdmConfirmado)
														&& a1.getId().equals(idAdmConfirmado)
														&& a1.getEmail().equals(emailAdmConfirmado)
														&& a1.getPassword().equals(passwordAdmConfirmado)
														&& sistema.crearNuevoUsuario(a1) == true) {

													System.out.println("Te registraste correctamente");

												}
											} catch (SistemaExceptionNoCreaUsuario e) {
												System.out.println(e.getMessage());

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

												c1.setNombre(nombreClieConfirmado);
												c1.setApellido(apellidoClieConfirmado);
												c1.setEmail(emailClieConfirmado);
												c1.setPassword(passwordClieConfirmado);
												c1.setId(idClieConfirmado);

												if (c1.getNombre().equals(nombreClieConfirmado)
														&& c1.getApellido().equals(apellidoClieConfirmado)
														&& c1.getEmail().equals(emailClieConfirmado)
														&& c1.getId().equals(idClieConfirmado)
														&& c1.getPassword().equals(passwordClieConfirmado)
														&& sistema.crearNuevoUsuario(c1) == true) {

													System.out.println("Te registraste correctamente");

												}
											} catch (SistemaExceptionNoCreaUsuario e) {
												System.out.println(e.getMessage());

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
				}

			while (salir = true);

		}while (salir = true);
		
	}
}
