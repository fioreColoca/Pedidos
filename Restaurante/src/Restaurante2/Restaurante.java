package Restaurante2;

import java.util.LinkedList;


public class Restaurante {
	public Restaurante() {
	} // NO FUNCIONA

	LinkedList<Producto> productos = new LinkedList<Producto>();

	/*
	 * public Set<Producto> getProductosSet() { return productosSet; } //NO FUNCIONA
	 */

	private String nombre2;
	private Integer cuit2;

	public Restaurante(String nombre2, int cuit2) {
		this.nombre2 = nombre2;
		this.cuit2 = cuit2;
	}

	public Boolean mostrarCarta() {
		for (Producto P : productos) {
			if (productos == null) {
				return false;
			}
			System.out.println(P.hashCode() +"-------"+ P.toString());
		}
		return false;

	}// ESTA MAL LO TENGO Q CAMBIAR
}
