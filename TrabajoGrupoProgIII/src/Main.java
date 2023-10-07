import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		Jugador jug1 = new Jugador();
		VentanaMapa ven1 = new VentanaMapa(jug1);
		Thread hilo = new Thread() {
			public void run() {
				while(true) {
					if (ven1.isTeclaw() == true) {
						jug1.setPosx(jug1.getPosx() + 10);
					}
					if (ven1.isTeclaa() == true) {
						jug1.setPosx(jug1.getPosy() - 10);
					}
					if (ven1.isTeclas() == true) {
						jug1.setPosx(jug1.getPosx() - 10);
					}
					if (ven1.isTeclad() == true) {
						jug1.setPosx(jug1.getPosy() + 10);
					}
					ven1.actualizarVentana(jug1);
					System.out.println(jug1.getPosy());
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
			}
		};

		hilo.start();

	}
}
