package Restaurante;

public class Cliente2 extends Usuario {
		Integer numeroMesa;
		Boolean atendido;
		public Cliente2(String nombre, String apellido, String email, String password,Integer numeroMesa) {
			super( nombre, apellido, email, password);
			this.numeroMesa=numeroMesa;
		}

		public void atenderCliente() {
			atendido=true;
		}
		 public void noAtenderCliente() {
			atendido=false;
		 }
}
