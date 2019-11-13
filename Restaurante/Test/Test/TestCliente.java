package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante2.Administrador;
import Restaurante2.Categoria;
import Restaurante2.Cliente;
import Restaurante2.Producto;
import Restaurante2.Restaurante;
import Restaurante2.Sistema;
import Restaurante2.SistemaException;

public class TestCliente {

	@Test
	public void pedirProducto() throws SistemaException {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = c1.pedirProducto(4, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void pedirProductoInexistente() throws SistemaException {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = c1.pedirProducto(5, r1);
		Boolean valorEsperado = false;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void pedirCuenta() throws SistemaException {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(6, r1);
		Double valorObtenido = c1.pedirCuenta(r1);
		Double valorEsperado = 160.0;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	/*@Test
	public void pedirCuentaoValida() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(6, r1);
		c1.pedirCuenta(r1);
		c1.pagar(r1); //NO FUNCIONA
	}*/

	@Test
	public void mostrarCuenta() throws SistemaException {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(6, r1);
		c1.mostrarPedido();
	}

	@Test
	public void eliminarPedido() throws SistemaException {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
		Restaurante r1 = new Restaurante("Cafeteria", 123456);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(4, r1);
		c1.pedirProducto(6, r1);
		c1.eliminarPedido(4);
		c1.mostrarPedido();
	}
}
