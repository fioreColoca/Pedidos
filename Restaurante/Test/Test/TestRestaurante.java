package Test;

import org.junit.Test;

import Restaurante2.Administrador;
import Restaurante2.AdministradorExceptionAgregarProducto;
import Restaurante2.Categoria;
import Restaurante2.Cliente;
import Restaurante2.Producto;
import Restaurante2.Restaurante;
import Restaurante2.Sistema;
import Restaurante2.SistemaExceptionNoCreaUsuario;
import Restaurante2.SistemaExceptionNoEncuentraUsuario;

public class TestRestaurante {
		// 1 mostrar carta
		@Test
		public void mostrarCarta() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
			Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema();
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 5);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", "123456");
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			r1.mostrarCarta();
		}

}
