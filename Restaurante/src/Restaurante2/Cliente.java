package Restaurante2;

import java.util.Iterator;
import java.util.LinkedList;

import Test.ClienteExceptionNoPedidos;

public class Cliente extends Usuario {

	public Cliente(Integer Id, String nombre, String apellido, String email, String password) {
		super(Id, nombre, apellido, email, password);
	}

	LinkedList<Producto> PedidosHistorial = new LinkedList<Producto>();
	LinkedList<Producto> Pedido = new LinkedList<Producto>();

	// DONDE IRIA NOMBRE DE MESA ?????????????????
	public Boolean pedirProducto(Integer idProducto, Restaurante R) throws ExceptionProductoInexistente {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(idProducto)) {
				this.Pedido.add(p);
				this.PedidosHistorial.add(p);
				
				return true;
			}

		}
		throw new ExceptionProductoInexistente(); /* falta meter la array dentro de la array pedidos*/
	}

	public Double pedirCuenta(Restaurante R)  throws ClienteExceptionNoPedidos{
		Double acumuladorPrecio = 0.0;
		for (Producto p : Pedido) {
			if (Pedido == null) {
				throw new 	ClienteExceptionNoPedidos();
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

	public void eliminarPedido()   {
			Pedido.remove();
			
		}
	



	// ????????????????????????????????????

	public void mostrarPedido() {
		for (Producto P : Pedido) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());
		}
	}
	
	public void verHistorial () {
		for (Producto P : PedidosHistorial) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());

		}
	}
	
	
}
