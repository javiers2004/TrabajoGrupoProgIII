
public class Main {
	public static void main(String[] args) {
		Jugador player1 = new Jugador();
		VentanaMapa ven1 = new VentanaMapa(player1);
		System.out.print(ven1.getWidth());
	}
}
