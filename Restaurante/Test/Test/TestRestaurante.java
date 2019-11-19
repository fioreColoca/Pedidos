package Test;

import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.AdministradorExceptionAgregarProducto;
import Restaurante.Categoria;
import Restaurante.Cliente;
import Restaurante.Producto;
import Restaurante.Restaurante;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;

public class TestRestaurante {
	// 1 mostrar carta
	@Test
	public void mostrarCarta() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		r1.mostrarCarta();
	}

}
