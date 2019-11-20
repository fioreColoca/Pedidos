package Restaurante;

public class ClienteExceptionNoPedidos extends Exception {

	public ClienteExceptionNoPedidos() {
		super("no hay pagas pendientes ");
	}

}
