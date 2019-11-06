package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Cliente;
import Restaurante.Sistema;

public class TestSistema {

	@Test
	public void passwordAceptada() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = c1.validarPassword("123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void passwordNegado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = c1.validarPassword("ñ123lu");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioNoValido() {

		Sistema sistema = new Sistema("La Fragata");
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);
		Cliente c2 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c2);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioNoValido2() {

		Sistema sistema = new Sistema("La Fragata");
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioNoValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciz");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void cerrarSesionDeUsuarioValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.cerrarSesiondeUsuario(c1);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void cerrarSesionDeUsuarioNoValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.cerrarSesiondeUsuario(c1);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioLogueadoValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioLogueadoNoValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void buscarUsuarioNoEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(12345678);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario(123);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioNoEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario(1235);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarEliminacionDeUsuario() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(123);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarQueNoSeElimineElUsuario() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(1234);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

}
