import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		Thread hilo = new Thread() {
			public void run() {
				Jugador player1 = new Jugador();
				VentanaMapa ven1 = new VentanaMapa(player1);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};	
			hilo.start();
		


=======
		Jugador player1 = new Jugador();
		VentanaMapa ven1 = new VentanaMapa(player1);
		System.out.print(ven1.getWidth());
		
>>>>>>> branch 'master' of https://github.com/javiers2004/TrabajoGrupoProgIII.git
	}
}
