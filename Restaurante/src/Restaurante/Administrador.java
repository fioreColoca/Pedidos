package Restaurante;

import java.util.Iterator;

public class Administrador extends Usuario {

	public Administrador(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}

	// AGREGAR PRODUCTO
	public Boolean agregarProductos(Producto P, Restaurante nombreRestaurante) throws AdministradorExceptionAgregarProducto {
		if (!nombreRestaurante.productos.contains(P)) {
			nombreRestaurante.productos.add(P);
			return true;
		}
		throw new AdministradorExceptionAgregarProducto();
	}

	// ELIMINAR PRODUCTO

	public Boolean eliminarProducto(Integer IdProducto, Restaurante R) throws AdministradorExceptionEliminarProducto {
		Iterator<Producto> it = R.productos.iterator();

		while (it.hasNext()) {
			Producto producto = it.next();
			if (producto.getIdProducto().equals(IdProducto)) {
				R.productos.remove(producto);
				return true;
			}
		}
		throw new AdministradorExceptionEliminarProducto();
	}
	
	// BUSCAR PRODUCTO
	
	public Boolean buscarProducto(Integer id, Restaurante R) throws AdministradorExceptionProductoNoEncontrado {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id))
				return true;
		}
		throw new AdministradorExceptionProductoNoEncontrado();
	}

	// MODIFICAR PRECIO DEL PRODUCTO
	
	public Boolean modificarPrecio(Double nuevoPrecio, Integer id, Restaurante R) throws AdministradorExceptionNoModificaPrecio, AdministradorExceptionProductoNoEncontrado {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id)) {
				if (nuevoPrecio < 3000 && nuevoPrecio > 0) {
					p.setPrecio(nuevoPrecio);
					return true;
				}
			throw new AdministradorExceptionNoModificaPrecio();
		}
		throw new AdministradorExceptionProductoNoEncontrado();
	}
		throw new AdministradorExceptionProductoNoEncontrado();
}
	
	// LISTADO DE PEDIDOS PENDIENTES
	
	public void mostrarListadoPedidosPendientes(Restaurante r1) {
		for (Producto P : r1.productos) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());

		}
	}
	
	// VER LISTA DE USUARIOS 
	
	public void mostrarListadoDeUsuarios(Restaurante r1) {
		
		
	}
	
	// VER LISTA DE USUARIOS LOGUEADOS

	// ESTADO DE PEDIDO FINALIZADO
	
	public void finalizarPedido(Pedido p) {
		p.setEstado(EstadoPedido.FINALIZADO);
	}
	
	//ESTADO DE PEDIDO EN PROCESO
	
	public void pedidoEnProceso(Pedido p) {
		p.setEstado(EstadoPedido.PROCESANDO);
	}// DUDANDO COMO METER ESTO EN EL MAIN



}
