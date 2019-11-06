package Restaurante;

public class Producto {
	private Categoria categoria;
	private String descripcion;
	private Double precio;
	private Integer idProducto;
	
	public Producto (Categoria categoria,String descripcion,Double precio,Integer idProducto) {
		this.categoria=categoria;
		this.descripcion=descripcion;
		this.precio=precio;
		this.idProducto=idProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setProducto(Categoria categoria) {
		this.categoria = categoria;
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
