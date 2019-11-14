package Restaurante;

import java.util.LinkedList;

public class Cliente extends Usuario {

	public Cliente(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}
	
	LinkedList<Producto> HitorialDePedidos = new LinkedList<Producto>();
	LinkedList<Producto> PedidoActual = new LinkedList<Producto>();
	
	public Boolean agregarComida(Producto p, Restaurante r) {
		if(!r.productos.contains(p)) {
			this.PedidoActual.add(p);
			return true;
		}
		
		return false;
	}


}
