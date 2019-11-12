package Restaurante2;

import java.util.Iterator;
import java.util.LinkedList;

public class Cliente extends Usuario {

	public Cliente(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}

	LinkedList<Producto> PedidosHistorial = new LinkedList<Producto>();
	LinkedList<Producto> Pedido = new LinkedList<Producto>();

	public Boolean pedirProducto(Integer idProducto, Restaurante R) {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(idProducto)) {
				this.Pedido.add(p);
				this.PedidosHistorial.add(p);
				return true;
			}

		}
		return false;
	}

	public Double pedirCuenta(Restaurante R) {
		Double acumuladorPrecio = 0.0;
		for (Producto p : Pedido) {
			if (Pedido == null) {
			} else {
				acumuladorPrecio += p.getPrecio();

			}

		}
		return acumuladorPrecio;
	}

	/*public void pagar(Restaurante R,  Integer numeroDePedido) { //NO FUNCIONA
		Iterator<Producto> it = Pedido.iterator();

		while (it.hasNext()) {

			Producto producto = it.next();
			if (producto.equals(Pedido.getNumeroDePedido)) {
			}Pedido.remove();
		}
	}NO SE COMO HACERLO*/

	public Boolean eliminarPedido(Integer IdProducto) {
		for (Producto P : Pedido) {
			if (Pedido == null) {
				return false;
			} else {
				Pedido.remove(P);
				return true;
			}
		}
		return false;
	}

	public void mostrarPedido() {
		for (Producto P : Pedido) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());
		}
	}

}
