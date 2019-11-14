package Restaurante;

import java.util.Iterator;
import java.util.LinkedList;

public class Restaurante {

	private String nombre2;
	private Integer cuit2;

	public Restaurante(String nombre2, int cuit2) {
		this.nombre2=nombre2;
		this.cuit2=cuit2;
	}
	LinkedList<Producto> productos = new LinkedList<Producto>();

	public Boolean agregarProductor(Producto P, Administrador A, Sistema S, String email, String password) throws SistemaExceptionNoEncuentraUsuario {
		if (S.loguearUsuario(email, password)) {
			if (!productos.contains(P)) {
				this.productos.add(P);
				return true;
			}
			return false;
		}
		return false;
	}

	public Boolean eliminarProducto(Integer IdProducto, Administrador a) {
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
		}
	}


