package Restaurante;

public class AdministradorExceptionNoModificaPrecio extends Exception {
	public AdministradorExceptionNoModificaPrecio() {
		super("No se pudo modificar el precio del Producto");
	}

}
