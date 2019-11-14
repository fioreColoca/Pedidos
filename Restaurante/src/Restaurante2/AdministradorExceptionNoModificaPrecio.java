package Restaurante2;

public class AdministradorExceptionNoModificaPrecio extends Exception {
	public AdministradorExceptionNoModificaPrecio() {
		super("No se pudo modificar el precio del Producto");
	}

}
