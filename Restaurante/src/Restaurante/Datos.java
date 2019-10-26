package Restaurante;

public class Datos {
	
	private String localidad;
	private String calle;
	private Integer numero;
	private Integer codigoPostal;
	private Integer dni;
	
	public Datos (String localidad, String calle, Integer numero, Integer codigoPostal, Integer dni) {
		this.localidad=localidad;
		this.calle=calle;
		this.numero=numero;
		this.codigoPostal=codigoPostal;
		this.dni=dni;
	}
}
