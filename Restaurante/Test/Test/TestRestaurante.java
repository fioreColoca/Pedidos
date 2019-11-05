package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.Cliente;
import Restaurante.Mozo;
import Restaurante.Sistema;
import Restaurante.Usuario;

public class TestRestaurante {
	//1
	@Test
	public void registrarUsuarioValido() {
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//2
	@Test
	public void registrarUsuarioNoValido() {
		Sistema sistema = new Sistema("cafeteria");
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		sistema.crearNuevoUsuario(usuario1);
		Usuario usuario2 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario2);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//3
	@Test 
	public void registrarUsuarioNoValido2() {
		Sistema sistema = new Sistema("cafeteria");
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		sistema.crearNuevoUsuario(usuario1);
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}                           
	//4
	@Test
	public void passwordAceptada() {
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.validarPassword(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	//5
	@Test
	public void passwordNegado() {
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123");
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.validarPassword(usuario1);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//6
	@Test
	public void loguearUsuarioValido() {
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("lauraMartinez@gmail.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("lauraMartinez@gmail.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);  //cambiar para q se use una cuenta a la vez
	}
	//7
	@Test
	public void loguearUsuarioNoValido() {
		Usuario usuario1 = new Usuario("Laura", "Martinez", "lauraMartinez@gmail.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.crearNuevoUsuario(usuario1);
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.loguearUsuario("laurtinez@gmail.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//8
	@Test
	public void buscarUsuario() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
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
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("macarena@gmail.com");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//10
	@Test
	public void eliminarUsuarioEncontrado() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario("macarena123@.com", "123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//11
	@Test
	public void eliminarUsuarioNoEncontrado() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario("macarena@gmail.com","123qwer4");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//12
	@Test
	public void verificarEliminacionDeUsuario() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario( "macarena123@.com", "123qwer4");
		sistema.EliminarUsuario("macarena123@.com", "123qwer4");
		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario("macarena123@.com");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//13
	@Test
	public void verificarNoEliminacionDeUsuarioo() {
		Usuario usuario1 = new Usuario("Macarena", "Rodriguez", "macarena123@.com", "123qwer4");
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(usuario1);
		sistema.loguearUsuario("macarena123@.com", "123qwer4");
		sistema.EliminarUsuario("macarena@.com", "123qwer4");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario("macarena123@.com");
		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	//14
	@Test
	public void crearCliente() {
		Cliente cliente = new Cliente("Macarena", "Rodriguez", "macarena123@.com", "123qwer4",4);
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(cliente);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//15
	@Test
	public void crearMozo() {
		Mozo mozo = new Mozo("Macarena", "Rodriguez", "macarena123@.com", "123qwer4",true);
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(mozo);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//16
	@Test
	public void crearAdministrador() {
		Administrador adm = new Administrador("Macarena", "Rodriguez", "macarena123@.com", "123qwer4","Dueño");
		Sistema sistema = new Sistema("cafeteria");
		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(adm);
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//17
	@Test
	public void probarLlamarMozo() {
		Cliente cliente = new Cliente("Macarena", "Rodriguez", "macarena123@.com", "123qwer4",4);
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(cliente);
		Mozo mozo = new Mozo("Alberto", "Pereyra", "alberto123Mozo@gmail.com", "123qwer4",true);
		sistema.crearNuevoUsuario(mozo);
		mozo.llamarMozo(cliente);
		Boolean valorEsperado = true;
		Boolean valorObtenido = mozo.getConOtroCliente();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//18
	@Test
	public void cancelarLlamadoMozo() {
		Cliente cliente = new Cliente("Macarena", "Rodriguez", "macarena123@.com", "123qwer4",4);
		Sistema sistema = new Sistema("cafeteria");
		sistema.crearNuevoUsuario(cliente);
		Mozo mozo = new Mozo("Alberto", "Pereyra", "alberto123Mozo@gmail.com", "123qwer4",true);
		sistema.crearNuevoUsuario(mozo);
		mozo.llamarMozo(cliente);
		mozo.candelarLLamado(cliente);
		Boolean valorEsperado = false;
		Boolean valorObtenido = mozo.getConOtroCliente();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

}
