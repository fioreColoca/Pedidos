package Restaurante2;

import java.util.ArrayList;
import java.util.Iterator;


public class Pedido {

	ArrayList<Producto> pedidos = new ArrayList<Producto>();
	
	private Restaurante restaurante;
	private Integer mesa;
	private Integer numeroDePedido;
	private static int ultimo = 0;
    public final int id;
	
	private EstadoPedido estado;

	public Pedido(Integer mesa,Restaurante restaurante) {
		this.id= ultimo++;
		this.mesa = mesa;
		this.restaurante = restaurante;
		this.estado = EstadoPedido.INICIALIZANDO;
	}	

	public Integer getMesa() {
		return mesa;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}
	
	public Integer getNumeroDePedido() {
		return numeroDePedido;
	}

	public void setNumeroDePedido(Integer numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public ArrayList <Producto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Producto> pedidos) {
		this.pedidos = pedidos;
	}

	public void mostrarPedidos() { //NOSE COMO SE HACE 
	}
	
	
	public void agregarProductos() {
		
	}
	
	@Override
	public String toString() {
		return "Pedido [pedidos=" + pedidos + ", restaurante=" + restaurante + ", mesa=" + mesa + ", numeroDePedido="
				+ numeroDePedido + ", estado=" + estado + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		result = prime * result + ((numeroDePedido == null) ? 0 : numeroDePedido.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((restaurante == null) ? 0 : restaurante.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (estado != other.estado)
			return false;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		if (numeroDePedido == null) {
			if (other.numeroDePedido != null)
				return false;
		} else if (!numeroDePedido.equals(other.numeroDePedido))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (restaurante == null) {
			if (other.restaurante != null)
				return false;
		} else if (!restaurante.equals(other.restaurante))
			return false;
		return true;
	}
	public Boolean pedirProducto (Integer id, Restaurante R) {
		for (Producto p : R.productos) {
			if (p.getIdProducto().equals(id)) {
				this.pedidos.add(p);
				return true;
			}
		}
		return false;
	}
	
	public Double pedirCuenta(Restaurante R)  {
		Double acumuladorPrecio = 0.0;
		for (Producto p : pedidos) {
				acumuladorPrecio += p.getPrecio();

			}return acumuladorPrecio;

	}
	
	
	public void eliminarPedido()   {
		pedidos.clear();
	}
	
	public void pagar() { //NO FUNCIONA
		pedidos.clear();
		}
		
	

	public boolean eliminarProducto (Integer idProducto) {
		Iterator<Producto> it = pedidos.iterator();

		while (it.hasNext()) {

			Producto pedido = it.next();
			if (pedido.getIdProducto().equals(idProducto)) {
				pedidos.remove(pedido);
				return true;
			}
		}return false;
	}
	
	
	public void mostrarPedido() {
		for (Producto P : pedidos) {
			if (P == null) {
			}
			System.out.println(P.hashCode() + "-------" + P.toString());
		}
	}
		
	
	
	public void enviarPedido() {
		this.estado = EstadoPedido.ENVIADO;
		
	}
	

}
