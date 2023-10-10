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
<<<<<<< HEAD
						if (ven1.isTeclaw() == true) {	
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 3/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosy(jug1.getPosy() - 3);
								ven1.actualizarVentana(jug1);
							}	
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() - 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
							}
							
							
							
							
							
						}	
						if (ven1.isTeclaa() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 3/3 + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosx(jug1.getPosx() - 3);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() - 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
							}
							
						}
						if (ven1.isTeclas() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 +  screenWidth/6, jug1.getPosy()/3+ 3/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosy(jug1.getPosy() + 3);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() + 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
							}
						}
						if (ven1.isTeclad() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3+ 3/3 + + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosx(jug1.getPosx() + 3);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() + 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
							}
						}
=======
						ven1.sistemamovimiento(jug1, screenWidth, screenHeight, mapacolisiones);
						//PAUSA DE 5 ms
>>>>>>> branch 'master' of https://github.com/javiers2004/TrabajoGrupoProgIII
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
<<<<<<< HEAD
		//hilomovimiento.start();
		VentanaInicio v1 = new VentanaInicio();
=======
>>>>>>> branch 'master' of https://github.com/javiers2004/TrabajoGrupoProgIII

	}
}
