package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.Cliente;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;
import Restaurante.UsuarioExceptionPasswordIncorrecta;
import Restaurante.SistemaExceptionNoEliminaUsuario;

public class TestSistema {
	// FALTAN EXCEPTION PONER EN E TRUE O FALSE

	// 1 CONTRASEÑA ACEPTADA
	@Test
	public void passwordAceptada() throws UsuarioExceptionPasswordIncorrecta {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		String valorEsperado = "123luciamartinez";
		String valorObtenido = c1.getPassword();

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	// 2 CONTRASEÑA INCORRECTA

	@Test(expected = UsuarioExceptionPasswordIncorrecta.class)
	public void passwordNegado() throws UsuarioExceptionPasswordIncorrecta {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		c1.setPassword("111");

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
	@Test(expected = SistemaExceptionNoCreaUsuario.class)
	public void registrarUsuarioNoValido() throws SistemaExceptionNoCreaUsuario {

		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);
		Cliente c2 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c2);

	}

	// 5 MISMO OBJETO NO PUEDE SER REGISTRADO DOS VECES
	@Test(expected = SistemaExceptionNoCreaUsuario.class)
	public void registrarUsuarioNoValido2() throws SistemaExceptionNoCreaUsuario {

		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);
		sistema.crearNuevoUsuario(c1);
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
	@Test(expected = SistemaExceptionNoEncuentraUsuario.class)
	public void loguearUsuarioNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciz");
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
	@Test(expected = SistemaExceptionNoEncuentraUsuario.class)
	public void cerrarSesionDeUsuarioNoValido()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");
		sistema.cerrarSesiondeUsuario();

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
	@Test(expected = SistemaExceptionNoEncuentraUsuario.class)
	public void buscarUsuarioLogueadoNoValido()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");
		sistema.buscarUsuarioLogueado(144);
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
	@Test(expected = SistemaExceptionNoEncuentraUsuario.class)
	public void buscarUsuarioNoEncontrado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.buscarUsuarioNoLogueado(144);
	}

	// 14 ELIMINAR USUARIO POR COMPLETO
	@Test(expected = SistemaExceptionNoEncuentraUsuario.class)
	public void verificarQueSeElimineUsuario()
			throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoEliminaUsuario {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123, "123luciamartinez");

		sistema.buscarUsuarioNoLogueado(123);

	}

}
