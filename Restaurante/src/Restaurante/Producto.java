package Restaurante;

public class Producto {
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer idProducto;
	
	public Producto (String producto,String descripcion,Double precio,Integer idProducto) {
		this.producto=producto;
		this.descripcion=descripcion;
		this.precio=precio;
		this.idProducto=idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
		
	}
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setPrecio(Integer id) {
		this.idProducto = id;
	}
	
}
