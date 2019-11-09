package Restaurante;

public class Pedido {
	
	private LinkedList<Producto> pedidos = new LinkedList<>();

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

	public LinkedList<Producto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(LinkedList<Producto> pedidos) {
		this.pedidos = pedidos;
	}

	public void mostrarPedidos() { //NOSE COMO SE HACE 
	}

}
