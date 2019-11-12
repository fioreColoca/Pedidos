package Restaurante2;

import java.util.LinkedList;
import java.util.TreeSet;

public class Pedido {

	private TreeSet<Producto> pedidos = new TreeSet<Producto>();

	private Cliente cliente;
	private Restaurante restaurante;
	private Integer numeroDePedido;
	private EstadoPedido estado;

	public Pedido(Cliente cliente, Restaurante restaurante) {
		this.cliente = cliente;
		this.restaurante = restaurante;
		this.estado = EstadoPedido.FINALIZADO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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

	public TreeSet <Producto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(TreeSet<Producto> pedidos) {
		this.pedidos = pedidos;
	}

	public void mostrarPedidos() { //NOSE COMO SE HACE 
	}

}
