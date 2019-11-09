package Restaurante;

import java.util.Iterator;

public class Administrador extends Usuario {

	public Administrador(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}
	public Boolean agregarProductos(Producto P, Restaurante nombreRestaurante) {
		if (!nombreRestaurante.productos.contains(P)) {
			nombreRestaurante.productos.add(P);
			return true;
		}
		return false;
	}
	// Otra manera de hacerlo//
	/*
	 * public void agregarProductosSet(Producto P, Restaurante nombreRestaurante) {
	 * nombreRestaurante.productos.add(P); }
	 */

	// Eliminar//

	public Boolean eliminarProducto(Integer IdProducto, Restaurante R) {
		Iterator<Producto> it = R.productos.iterator();

		while (it.hasNext()) {
			Producto producto = it.next();
			if (producto.getIdProducto().equals(IdProducto)) {
				R.productos.remove(producto);
				return true;
			}
		}
		return false;
	}

	public Boolean buscarProducto(Integer id, Restaurante R) {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id))
				return true;
		}
		return false;
	}

	public Boolean modificarPrecio(Double nuevoPrecio, Integer id, Restaurante R) {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id))
				if (nuevoPrecio < 3000 && nuevoPrecio > 0) {
					p.setPrecio(nuevoPrecio);
					return true;
				}
			return false;
		}
		return false;
	}

	public void finalizarPedido(Pedido p) {
		p.setEstado(EstadoPedido.FINALIZADO);
	}

	public void pedidoEnProceso(Pedido p) {
		p.setEstado(EstadoPedido.PROCESANDO);
	}// DUDANDO COMO METER ESTO EN EL MAIN

	public void mostrarListadoPedidosPendientes(Restaurante r1) {
		for (Producto P : r1.productos) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());

		}
	}

}
