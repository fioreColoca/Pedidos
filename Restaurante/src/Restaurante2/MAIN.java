package Restaurante2;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		Integer optcion = null;
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = new Sistema();
		Boolean salir = false;
// <----------MENU ---------- >
		do {
			System.out.println("Ingrese '1' si es administrador o '2' si es cliente");
			optcion = teclado.nextInt();
			if (optcion != 1 || optcion != 2) {
				salir = true;
			}

			switch (optcion) {
			case 1 : 
				
				Boolean salirAdministrador=false;
				Integer opcionAdministrador=null;
				do {
					
				System.out.println("Seleccionaste administrador, Ingrese '1'  registrarse,'2' abrir sesión,'3' salir");
				opcionAdministrador = teclado.nextInt();
					if (opcionAdministrador!=1 || opcionAdministrador!=2 ) {
						salirAdministrador=true;
					}
				switch (opcionAdministrador) {	
				
				case 1:
					String nombre;
					String apellido;
					String email;
					String password;
					Integer id;
					String nombreConfirmado;
					String apellidoConfirmado;
					String emailConfirmado;
					String passwordConfirmado;
					Integer idConfirmado;
					
					System.out.println("Selecciono para registrarse");
					System.out.println("Ingrese su nombre");
					nombre = teclado.next();
					System.out.println("Ingrese su apellido");
					apellido = teclado.next();
					System.out.println("Ingrese su email");
					email = teclado.next();
					System.out.println("Ingrese su password");
					password = teclado.next();
					System.out.println("Ingrese su DNI, sólo números");
					id = teclado.nextInt();

					
					Administrador a1 = new Administrador(id, nombre, apellido, email, password);

					


				
				
				
				}
				

				break;}
				while (salirAdministrador=true);
				break;
				
			case 2 :
				Integer opcionCliente=null;
				System.out.println("Seleccionaste cliente, Ingrese '1'  registrarse,'2' abrir sesión , '3' salir" );
				optcion = teclado.nextInt();

				break;
			}

		} while (salir = true);

	}

}
