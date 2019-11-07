package Restaurante2;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


public class Restaurante {
	public Restaurante() {
		this.productosSet  = new TreeSet<>();
	} // NO FUNCIONA
	LinkedList<Producto> productos = new LinkedList<Producto>();
	private Set<Producto> productosSet; // NO FUNCIONA 
	
	public Set<Producto> getProductosSet() {
		return productosSet;
	} //NO FUNCIONA
	
	

	private String nombre2;
	private Integer cuit2;

	public Restaurante(String nombre2, int cuit2) {
		this.nombre2=nombre2;
		this.cuit2=cuit2;
	}
	
}


