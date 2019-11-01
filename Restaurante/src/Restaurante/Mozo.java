package Restaurante;

public class Mozo extends Usuario {
	
	Cliente cliente;
	Boolean enServicio=false;
	Boolean conOtroCliente=false;;
	
	public Mozo(String nombre, String apellido, String email, String password,Boolean enServicio) {
		super( nombre, apellido, email, password);
		this.enServicio=enServicio;
	}
	public void llamarMozo(Cliente usuario) {
		if(enServicio==true && conOtroCliente==false){
			conOtroCliente=true;
			cliente=usuario;
		}
	}
	
	public void candelarLLamado (Cliente usuario) {
		if ( cliente.equals(usuario)) {
			cliente=null;
			conOtroCliente=false;
		}
	}
	
	public void fueraDeServicio() {
		enServicio=false;
	}
	public void enServicio() {
		enServicio=true;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Boolean getEnServicio() {
		return enServicio;
	}
	public void setEnServicio(Boolean enServicio) {
		this.enServicio = enServicio;
	}
	public Boolean getConOtroCliente() {
		return conOtroCliente;
	}
	public void setConOtroCliente(Boolean conOtroCliente) {
		this.conOtroCliente = conOtroCliente;
	}
	
	
}
