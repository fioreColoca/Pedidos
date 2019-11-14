package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.AdministradorExceptionAgregarProducto;
import Restaurante.AdministradorExceptionEliminarProducto;
import Restaurante.AdministradorExceptionProductoNoEncontrado;
import Restaurante.Categoria;
import Restaurante.Cliente;
import Restaurante.Producto;
import Restaurante.Restaurante;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;

public class TestAdministrador {

	// 1 INGRESAR PRODUCTOS BIEN

	@Test
	public void admAgregarProductos() throws SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 4);
		a1.agregarProductos(p2, r1);

		Boolean valorObtenido = a1.agregarProductos(p1, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
		r1.mostrarCarta();

		System.out.println("-----");

	}

	// 2 INGRESAR PRODUCTOS MAL

	@Test
	public void admNoAgregarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Restaurante Cafeteria = new Restaurante("Cafeteria", 123456);
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 5000.0, 2);
		a1.agregarProductos(p1, Cafeteria);

		Boolean valorObtenido = a1.agregarProductos(p1, Cafeteria);
		Boolean valorEsperado = false;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 3 ELIMINAR PRODUCTOS VALIDO

	@Test
	public void eliminarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionEliminarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = a1.eliminarProducto(4, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 4 NO SE PUEDE ELIMINAR PRODUCTO

	@Test(expected = AdministradorExceptionEliminarProducto.class)
	public void eliminarProductoNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionEliminarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		a1.eliminarProducto(85, r1);

	}

	// 5 ELIMINAR PRODUCTO Y BUSCARLO VALIDO

	@Test(expected = AdministradorExceptionProductoNoEncontrado.class)
	public void eliminarProductosYBuscarlo() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionEliminarProducto,
			AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		a1.eliminarProducto(6, r1);
		a1.buscarProducto(6, r1);
	}

	// 6 BUSCAR PRODUCTOS VALIDO

	@Test
	public void buscarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = a1.buscarProducto(4, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 7 BUSCAR PRODUCTO QUE NO EXISTE

	@Test(expected = AdministradorExceptionProductoNoEncontrado.class)
	public void buscarProductoQueNoExiste() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.buscarProducto(6, r1);

	}

	// 8 MOSTRAR LISTADO DE TODOS LOS PRODUCTOS

	@Test
	public void verListado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		r1.mostrarCarta();

	}

	// 9 MOSTRAR LISTADO DE USUARIOS LOGUEADOS

	@Test
	public void verListadoDeUsuariosLogueados() throws SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		a1.mostrarListadoDeUsuariosLogueados(sistema);
	}

	// 10 MOSTRAR LISTADO USUARIOS

	@Test
	public void verListadoDeUsuarios() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		a1.mostrarListadoDeUsuarios(sistema);
	}

}
