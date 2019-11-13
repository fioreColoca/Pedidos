package Restaurante2;

/*import java.util.LinkedList;*/
import java.util.TreeSet;


public class Restaurante {
	public Restaurante() {
	} // NO FUNCIONA
	/*LinkedList<Producto> productos = new LinkedList<Producto>();*/
	
	TreeSet <Producto> productos = new TreeSet <Producto>();
	// NO HACE FALTA NINGUN METODO Q DISTINGA LOS NUMEROS DE IDENTIFICACION PARA Q HAYA REPETIDOS
	//PORQ LO HACE EL MISMO TREESET
	// ESTA ORDENADO PARA FACILITAR EL INGRESO DEL PRODUCTO YA QUE SE TIENE QUE INGRESAR ID

	/*
	 * public Set<Producto> getProductosSet() { return productosSet; } //NO FUNCIONA
	 */

	private String nombre2;
	private Integer cuit2;
	

	public Restaurante(String nombre2, int cuit2) {
		this.nombre2 = nombre2;
		this.cuit2 = cuit2;
	}
	//MUESTRA TODA LA ARRAY 
	public Boolean mostrarCarta() {
		Integer contador=0;
		for (Producto P : productos) {
			if (productos == null) {
				return false;
			}
			System.out.println(P.hashCode() + " -- " + P.toString());
		}
		return false;

	}
}
