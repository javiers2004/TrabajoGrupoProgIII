import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		
		//CREACIÓN CLASES PRINCIPALES
		Jugador jug1 = new Jugador();
		VentanaMapa ven1 = new VentanaMapa(jug1);
		
		//HILO QUE REGULA EL MOVIMIENTO DEL MAPA EN FUNCIÓN DE LOS BOOLEANOS
		Thread hiloteclas = new Thread() {
			public void run() {
				try {
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int screenWidth = screenSize.width;
			        int screenHeight = screenSize.height;
					BufferedImage mapacolisiones = ImageIO.read(new URL("https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/src/MAPABLANCO.png"));
					while(true) {
						ven1.sistemamovimiento(jug1, screenWidth, screenHeight, mapacolisiones);
						//PAUSA DE 5 ms
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				}
	         catch (IOException e) {
	            e.printStackTrace();
	        }
			}	
		};
		
		//ARRANCA EL HILO
		hiloteclas.start();

	}
}
