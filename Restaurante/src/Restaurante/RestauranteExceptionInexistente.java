package Restaurante2;

public class RestauranteExceptionInexistente extends Exception {

	public RestauranteExceptionInexistente() {
		super("El Restaurante no existe");
	}
}
