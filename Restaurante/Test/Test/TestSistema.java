package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.Cliente;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;
import Restaurante.UsuarioExceptionContraseñaIncorrecta;
import Restaurante.SistemaExceptionNoEliminaUsuario;

public class TestSistema {
	// FALTAN EXCEPTION PONER EN E TRUE O FALSE

	// 1 CONTRASEÑA ACEPTADA
	@Test
	public void passwordAceptada() throws UsuarioExceptionContraseñaIncorrecta {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = c1.validarPassword("123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 2 CONTRASEÑA INCORRECTA
	@Test
	public void passwordNegado() throws UsuarioExceptionContraseñaIncorrecta {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = c1.validarPassword("ñ123lu");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 3 REGISTRAR USUARIO VÁLIDO
	@Test
	public void registrarUsuarioValido() throws SistemaExceptionNoCreaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 4 REGISTRAR USUARIO NO VÁLIDO, EMAIL YA USADO
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

	// 5 MISMO OBJETO NO PUEDE SER REGISTRADO DOS VECES
	@Test
	public void registrarUsuarioNoValido2() throws SistemaExceptionNoCreaUsuario {

		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 6 LOGUEAR USUARIO VALIDO
	@Test
	public void loguearUsuarioValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 7 LOGUEAR USUARIO NO VALIDO
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

	// 8 CERRAR SESIÓN DE USUARIO VÁLIDO
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

	// 9 CERRAR SESIÓN DE USUARIO NO LOGUEADO
	@Test
	public void cerrarSesionDeUsuarioNoValido()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.cerrarSesiondeUsuario();

		Assert.assertEquals(valorEsperado, valorActual);
	}

	// 10 BUSCAR USUARIO LOGUEADO VÁLIDO
	@Test
	public void buscarUsuarioLogueadoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	// 11 BUSCAR USUARIO EXISTENTE Y NO CONECTADO
	@Test
	public void buscarUsuarioLogueadoNoValido()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.buscarUsuarioLogueado(144);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	// 12 BUSCAR USUARIO EXISTENTE
	@Test
	public void buscarUsuarioValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuarioNoLogueado(123);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 13 BUSCAR USUARIO NO EXISTENTE
	@Test
	public void buscarUsuarioNoEncontrado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuarioNoLogueado(144);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 14 ELIMINAR USUARIO POR COMPLETO
	@Test
	public void verificarQueSeElimineUsuario()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123, "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuarioNoLogueado(123);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 15 ELIMINAR USUARIO POR COMPLETO NO VÁLIDO
	@Test
	public void EliminarUsuarioNoValido()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123, "123luciama");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuarioNoLogueado(144);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 16 ELIMINAR USUARIO LOGUEADO ACTUALMENTE
	@Test
	public void verificarEliminacionDeUsuario2()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.Eliminar(123, "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuarioLogueado(123);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	// 17 ELIMINAR USUARIO LOGUEADO ACTUALMENTE INGRESANDO MAL DATOS
	@Test
	public void verificarQueNoSeElimineElUsuario2()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.Eliminar(1234, "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuarioNoLogueado(123);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

}
