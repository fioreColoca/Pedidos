package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.Cliente;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;
import Restaurante.SistemaExceptionNoEliminaUsuario;

public class TestSistema {
	//FALTAN EXCEPTION PONER EN E TRUE O FALSE

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
	public void registrarUsuarioValido() throws SistemaExceptionNoCreaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioNoValido() throws SistemaExceptionNoCreaUsuario {

		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);
		Cliente c2 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c2);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void registrarUsuarioNoValido2() throws SistemaExceptionNoCreaUsuario {

		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void loguearUsuarioNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciz");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void cerrarSesionDeUsuarioValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.cerrarSesiondeUsuario();

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void cerrarSesionDeUsuarioNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.cerrarSesiondeUsuario();

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioLogueadoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123,admin);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioLogueadoNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123,admin);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void buscarUsuarioValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123,admin);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void buscarUsuarioNoEncontrado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(12345678,admin);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioEncontrado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario(123, "123roberto", admin);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void eliminarUsuarioNoEncontrado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario(1235, "123roberto", admin);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarEliminacionDeUsuario() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123, "123roberto", admin);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(123, admin);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void verificarQueNoSeElimineElUsuario() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		Administrador admin = new Administrador(1234, "roberto", "perez", "robetoperez@hotmail.com", "123roberto");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(1234, "123roberto", admin);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123, admin);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

}
