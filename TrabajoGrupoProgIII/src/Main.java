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
		Jugador jug1 = new Jugador();
		VentanaMapa ven1 = new VentanaMapa(jug1);
		VentanaInicio v1 = new VentanaInicio(ven1);
		ven1.setVeninicio(v1);
		Thread hiloteclas = new Thread() {
			public void run() {
				try {
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int screenWidth = screenSize.width;
			        int screenHeight = screenSize.height;
					BufferedImage mapacolisiones = ImageIO.read(new URL("https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/src/MAPABLANCO2.png"));
					while(true) {
						int velocidadextra = 0;
						if(jug1.getStaminarestante() != 0 && ven1.isTeclashift() == true) {
							velocidadextra = 2;
							jug1.setStaminarestante(jug1.getStaminarestante() - 1);
						}
						if (ven1.isTeclaw() == true) {	
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 30/3 - velocidadextra + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
								ven1.actualizarVentana(jug1);
							}	
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
								ven1.actualizarVentana(jug1);
							}	
						}	
						if (ven1.isTeclaa() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 42/3 -velocidadextra + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosx(jug1.getPosx() - 3 - velocidadextra);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() - 3 - velocidadextra);
								ven1.actualizarVentana(jug1);
							}
							
						}
						if (ven1.isTeclas() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 +  screenWidth/6 , jug1.getPosy()/3+ 3/3 + velocidadextra + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
								ven1.actualizarVentana(jug1);
							}
						}
						if (ven1.isTeclad() == true) {
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 12/3 + velocidadextra + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosx(jug1.getPosx() + 3 + velocidadextra);
								ven1.actualizarVentana(jug1);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() + 3 + velocidadextra);
								ven1.actualizarVentana(jug1);
							}
						}
						if (ven1.isTeclashift() == false && jug1.getStaminarestante()<jug1.getStaminatotal()) {
							jug1.setStaminarestante(jug1.getStaminarestante() + 0.25);
						}
						System.out.print(jug1.getStaminarestante() + "/" + jug1.getStaminatotal());
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
		hiloteclas.start();
	}
}
