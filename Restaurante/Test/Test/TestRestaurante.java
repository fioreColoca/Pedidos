package Test;



import org.junit.Assert;
import org.junit.Test;

import Restaurante.Sistema;
import Restaurante.Usuario;




public class TestRestaurante {
	@Test
	public void registrarUsuarioValido() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioNoValido() {
		Sistema sistema = new Sistema("Serena cafeteria");
		Usuario usuario1 = new Usuario("djaskd", "daskd", "mm.com", "123qwer4");
		sistema.crearNuevoUsuario(usuario1);
		Usuario usuario2 = new Usuario("djaskd", "daskd", "mm.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario2);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test 
	public void registrarUsuarioNoValido2() {
		Sistema sistema = new Sistema("Serena cafeteria");
		Usuario usuario1 = new Usuario("djaskd", "daskd", "mm.com", "123qwer4");
		sistema.crearNuevoUsuario(usuario1);
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}                           

	@Test
	public void passwordAceptada() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = usuario1.validarPassowrd();
		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void passwordNegado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123");
		Boolean valorEsperado = false;
		Boolean valorObtenido = usuario1.validarPassowrd();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioValido() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioNoValido() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.crearNuevoUsuario(usuario1);
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.loguearUsuario("hjaksdhjak.com", "1qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void buscarUsuario() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void buscarUsuarioNoEncontrado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak.com", "1qfefer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioEncontrado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario("hjaksdhjak.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioNoEncontrado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario("hjaksdhjak.com", "1qfefer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarEliminacionDeUsuario() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		sistema.EliminarUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarNoEliminacionDeUsuarioo() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		sistema.EliminarUsuario("hjaksdhjajfklsdk.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);

	}

}
