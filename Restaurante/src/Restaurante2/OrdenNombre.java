package Restaurante2;

import java.util.Comparator;



public class OrdenNombre implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		if(o1.getCategoria().compareTo(o2.getCategoria())==0) {
		
		}
		return o1.getCategoria().compareTo(o2.getCategoria()) ;
	}
}
//NO FUNCIONA