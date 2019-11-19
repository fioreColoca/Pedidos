package Restaurante;

import java.util.Iterator;
import java.util.LinkedList;

public class Cliente extends Usuario {

		public Cliente(String Id, String nombre, String apellido, String email, String password) {
			super(Id, nombre, apellido, email, password);
		}

		LinkedList<Producto> PedidosHistorial = new LinkedList<Producto>();
		public Object out;
		
		public Boolean pedirProducto(Integer idProducto,Pedido p1 ,Restaurante R ) throws ExceptionProductoInexistente {
			for (Producto p : R.productos) {
				if (p.getIdProducto().equals(idProducto)) {
					this.PedidosHistorial.add(p);
					p1.pedirProducto(idProducto,R);
					return true;
				}
			}
			throw new ExceptionProductoInexistente();
		}
		
		public Integer pedirCuenta(Pedido p1,Restaurante R) {
			return p1.pedirCuenta(R) ;
			
		}
		
		public void pagar(Pedido pedido) {
			 pedido.pagar();
		}
		
		public void mostrarPedido(Pedido pedido) {
			 pedido.mostrarPedido() ;
			
		}
		
		public void eliminarPedidoCompleto(Pedido pedido) {
			pedido.eliminarPedido();
		}
		
		public void verHistorial() {
			for (Producto P : PedidosHistorial) {
				System.out.println(P.hashCode() + "-------" + P.toString());
			}
		}
		
		public Boolean  eliminarProducto (Pedido pedido,Integer idProducto) throws ExceptionProductoInexistente {
			return pedido.eliminarProducto(idProducto);
		}
		
		 public EstadoPedido verEstado (Pedido pedido) {
			 return pedido.getEstado();
		 }
		
		
	}