package Restaurante2;

import java.util.Iterator;
import java.util.LinkedList;

public class Administrador extends Usuario {

	public Administrador(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}
	 //Lo puse aca asi son metodos q hace solo el administrador//
	

	public Boolean agregarProductos(Producto P, Restaurante nombreRestaurante) {
			if (!nombreRestaurante.productos.contains(P)) {
				nombreRestaurante.productos.add(P);
				return true;
			}
		return false;
	}
	//Otra manera de hacerlo//
	public void agregarProductosSet(Producto P, Restaurante nombreRestaurante) {
		nombreRestaurante.productos.add(P);
	}

	//Eliminar//

	public Boolean eliminarProducto(Integer IdProducto, Restaurante R) {
		Iterator<Producto> it = R.productos.iterator();

		while (it.hasNext()) {
			Producto producto = it.next();
			if (producto.getIdProducto().equals(IdProducto)) {
				R.productos.remove(producto);
				return true;
			}return false;
			}return false;
		}
	
	public Boolean buscarProducto(Integer id,Restaurante R) {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id))
				return true;
		}
		return false;
	}
	
	
	/*public Boolean eliminarProducto(Integer IdProducto, Administrador a) {
		Iterator<Producto> it = productos.iterator();

		while (it.hasNext()) {
			Producto producto = it.next();
			if (producto.getIdProducto().equals(IdProducto)) {
				productos.remove(producto);
				return true;
			}
		}
		return false;

	}
	

	public Boolean buscarProducto(Integer id) {
		for (Producto p : productos) {
			if (p.getIdProducto().equals(id))
				return true;
		}
		return false;
	}

	public Boolean modificarPrecio(Double nuevoPrecio, Integer id) {
		for (Producto p : productos) {
			if (p.getIdProducto().equals(id))
				p.setPrecio(nuevoPrecio);
			return true;
		}
		return false;
	}
	
	public int mostrarCarta() { //NI IDEA SI ESTA BIEN
			return productos.size();
		}*/
}
