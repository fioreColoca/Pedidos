package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante2.Cliente;
import Restaurante2.Sistema;

public class TestSistema {
	
	//1 Contraseña aceptada
	@Test
	public void passwordAceptada() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = c1.validarPassword("123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	
	//2 Contraseña incorrecta
	@Test
	public void passwordNegado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = c1.validarPassword("ñ123lu");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//3 registrar Usuario válido
	@Test
	public void registrarUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//4 registrar Usuario no válido, email ya usado
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

	//5 Mismo objeto no puede ser registrado dos veces
	@Test
	public void registrarUsuarioNoValido2() {

		Sistema sistema = new Sistema("La Fragata");
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.crearNuevoUsuario(c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//6 Loguar Usuario Valido
	@Test
	public void loguearUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//7 Loguear Usuario no válido
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

	//8 Cerrar sesion de Usuario valido
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

	//9 Cerrar sesion de Usuario no logueado
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

	//10 Buscar usuario existente y conectado
	@Test
	public void buscarUsuarioLogueadoValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorActual = sistema.buscarUsuarioLogueado(123, c1, c1);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	//11 Buscar usuario no existente y no  conectado
	@Test
	public void buscarUsuarioLogueadoNoValido() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luz");

		Boolean valorEsperado = false;
		Boolean valorActual = sistema.buscarUsuarioLogueado(144, c1,c1);

		Assert.assertEquals(valorEsperado, valorActual);
	}

	//12 Buscar usuario  existente
	@Test
	public void buscarUsuarioValido() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	//12 Buscar usuario no  existente
	@Test
	public void buscarUsuarioNoEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(12345678,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//13 Eliminar Usuario existente
	@Test
	public void eliminarUsuarioEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.EliminarUsuario(123, "123luciamartinez", c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	//13 Eliminar Usuario no existente
	@Test
	public void eliminarUsuarioNoEncontrado() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.EliminarUsuario(1235,"123luciamartinez",c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//13 
	public void verificarEliminacionDeUsuario() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(123, "123luciamartinez", c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void verificarQueNoSeElimineElUsuario() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.EliminarUsuario(1234,"123luciamartinez", c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	
	@Test
	//15 Eliminar usuario sin loguear (no se puede)
	public void verificarQueNoSeElimineUsuarioActualNoLogueado() {
		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Cliente c2 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");

		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.EliminarUsuario(123, "123luciamartinez", c2);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	//Eliminar usuario logueado actualmente
	@Test
	public void verificarEliminacionDeUsuario2() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.Eliminar(123, "123luciamartinez", c1);

		Boolean valorEsperado = false;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	//Eliminar usuario logueado actualmente ingresando mal datos
	@Test
	public void verificarQueNoSeElimineElUsuario2() {

		Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema("La Fragata");
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		sistema.Eliminar(1234,"123luciamartinez", c1);

		Boolean valorEsperado = true;
		Boolean valorObtenido = sistema.buscarUsuario(123,c1);

		Assert.assertEquals(valorEsperado, valorObtenido);

	}
}
