package Restaurante;

import java.util.Iterator;
import java.util.LinkedList;

public class Restaurante {

	private String nombre;
	private Integer cuit;
	
	public Restaurante (String nombre,Integer cuit) {
		this.nombre=nombre;
		this.cuit=cuit;
		
	}
	LinkedList<Producto> productos = new LinkedList<Producto>();

	public Boolean agregarproductor (Producto P, Administrador A, Sistema S,String email,String  password ) {
		if (S.loguearUsuario(email, password)) {
		if (!productos.contains(P)) {
			this.productos.add(P);
			return true;
		}
			return false;
		}return false;
	}
	
	public Boolean eliminarProducto (Integer IdProducto , Administrador a) {
		Iterator<Producto> it = productos.iterator();

		while (it.hasNext()) {// devuelve true si tiene otro elemento y entra hasta que sea false

			Producto producto = it.next();
			if (producto.getIdProducto().equals(IdProducto)) {
				productos.remove(it);
				return true;
			}
		}
		return false;
		
	}
	
	public Boolean buscarProducto(Integer id) {
		for (Producto p:productos) {
			if (p.getIdProducto().equals(id))
				return true;
		} return false;
	}
	
	public Boolean moficarPrecio(Double nuevoPrecio , Integer id) {
		for (Producto p:productos) {
			if (p.getIdProducto().equals(id))
				p.setPrecio(nuevoPrecio);
				return true;
		} return false;
	}
	
}
