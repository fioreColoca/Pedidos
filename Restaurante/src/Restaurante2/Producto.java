package Restaurante2;

public class Producto implements  Comparable<Producto> {
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

	@Override
	public String toString() {
		return "Producto [categoria=" + categoria + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", idProducto=" + idProducto + "]";
	}	
	//identificacion unica
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Producto other = (Producto) obj;
		if (categoria != other.categoria)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
	//ORDENA EL LISTADO SEGUN EL ID,NO PUEDE HABER ID REPETIDOS
	@Override
	public int compareTo(Producto idPedido){
		return this.idProducto.compareTo(idPedido.getIdProducto());
	}

	
	
}
