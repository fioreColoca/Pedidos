package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador2;
import Restaurante.Cliente2;
import Restaurante.Mozo;
import Restaurante.Sistema;
import Restaurante.Usuario;

public class TestRestaurante {
	//1
	@Test
	public void registrarUsuarioValido() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//2
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
	//3
	@Test 
	public void registrarUsuarioNoValido2() {
		Sistema sistema = new Sistema("Serena cafeteria");
		Usuario usuario1 = new Usuario("djaskd", "daskd", "mm.com", "123qwer4");
		sistema.crearNuevoUsuario(usuario1);
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}                           
	//4
	@Test
	public void passwordAceptada() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.validarPassword(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	//5
	@Test
	public void passwordNegado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123");
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.validarPassword(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//6
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
	//7
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
	//8
	@Test
	public void buscarUsuario() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario("macarena123@.com");
		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	//9
	@Test
	public void buscarUsuarioNoEncontrado() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("asddsa@gmail.com");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//10
	@Test
	public void eliminarUsuarioEncontrado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario("hjaksdhjak.com","123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//11
	@Test
	public void eliminarUsuarioNoEncontrado() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario("hjaksdhjakf.com","123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//12
	@Test
	public void verificarEliminacionDeUsuario() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak.com", "123qwer4");
		sistema.EliminarUsuario("hjaksdhjak.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak.com");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//13
	@Test
	public void verificarNoEliminacionDeUsuarioo() {
		Usuario usuario1 = new Usuario("djaskd", "daskd", "hjaksdhjak12.com", "123qwer4");
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("hjaksdhjak12.com", "123qwer4");
		sistema.EliminarUsuario("hjaksdhjajfklsdk.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario("hjaksdhjak12.com");
		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	//14
	@Test
	public void crearCliente() {
		Cliente2 cliente = new Cliente2("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",4);
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(cliente);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//15
	@Test
	public void crearMozo() {
		Mozo mozo = new Mozo("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",true);
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(mozo);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//16
	@Test
	public void crearAdministrador() {
		Administrador2 adm = new Administrador2("djaskd", "daskd", "hjaksdhjak.com", "123qwer4","Dueño");
		Sistema sistema = new Sistema("Serena cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(adm);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//17
	@Test
	public void probarLlamarMozo() {
		Cliente2 cliente = new Cliente2("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",4);
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(cliente);
		Mozo mozo = new Mozo("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",true);
		sistema.crearNuevoUsuario(mozo);
		mozo.llamarMozo(cliente);
		Boolean valorEsperado = true;
		Boolean valorObtenido = mozo.getConOtroCliente();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//18
	@Test
	public void cancelarLlamadoMozo() {
		Cliente2 cliente = new Cliente2("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",4);
		Sistema sistema = new Sistema("Serena cafeteria");
		sistema.crearNuevoUsuario(cliente);
		Mozo mozo = new Mozo("djaskd", "daskd", "hjaksdhjak.com", "123qwer4",true);
		sistema.crearNuevoUsuario(mozo);
		mozo.llamarMozo(cliente);
		mozo.candelarLLamado(cliente);
		Boolean valorEsperado = false;
		Boolean valorObtenido = mozo.getConOtroCliente();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

}
