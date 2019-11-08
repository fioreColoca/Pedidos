package Restaurante2;

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
			return false;
		}
		return false;
	}

	public Double pedirCuenta(Restaurante R) {
		Double acumuladorPrecio = 0.0;
		for (Producto p : Pedido) {
			if (Pedido == null) {
			} else {
				acumuladorPrecio += p.getPrecio();
				Pedido.remove(p);
			}

		}
		return acumuladorPrecio;
	}
	
	public Boolean eliminarPedido(Integer IdProducto) {
		for (Producto P : Pedido) {
			if (Pedido == null) {
				return false;
			}else {
				Pedido.remove(P);
				return true;
			}
		}return false;
	}
	//NI IDEA:C
	
	
	
	
	
	
	
	

}
