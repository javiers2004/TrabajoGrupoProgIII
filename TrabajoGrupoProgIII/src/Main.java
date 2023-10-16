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
		Thread hiloteclas = new Thread() {
			public void run() {
				try {
		            //File image = new File("https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/src/MAPABLANCO.png");
		            //BufferedImage imageFile = ImageIO.read(image);
					//File imageFile = new File("src/MAPABLANCO.png");
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int screenWidth = screenSize.width;
			        int screenHeight = screenSize.height;
					BufferedImage mapacolisiones = ImageIO.read(new URL("https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/src/MAPABLANCO.png"));
		            Dimension dimension = ven1.getSize();
		            int width = dimension.width;
		            int height = dimension.height;
					while(true) {
						if (ven1.isTeclaw() == true) {	
							Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 3/3 + screenHeight/6));
							int red = color.getRed();
							int green = color.getGreen();
							int blue = color.getBlue();
							if (red > 200 && green > 200 && blue > 200 ) {
								jug1.setPosy(jug1.getPosy() - 3);
								ven1.actualizarVentana(jug1);
								ven1.lblplayer.setBackground(Color.red);
							}	
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() - 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
								ven1.lblplayer.setBackground(Color.BLACK);
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
								ven1.lblplayer.setBackground(Color.red);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() - 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
								ven1.lblplayer.setBackground(Color.BLACK);
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
								ven1.lblplayer.setBackground(Color.red);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosy(jug1.getPosy() + 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
								ven1.lblplayer.setBackground(Color.BLACK);
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
								ven1.lblplayer.setBackground(Color.red);
							}
							if (red == 255 && green == 0 && blue == 0) {
								jug1.setPosx(jug1.getPosx() + 3);
								ven1.actualizarVentana(jug1);
								//quitar opacidad
								ven1.lblplayer.setBackground(Color.BLACK);
							}
						}
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
		Thread hilomovimiento = new Thread() {
			public void run() {
				while(true) {
					ven1.actualizarVentana(jug1);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
			}
		};

		hiloteclas.start();
		//hilomovimiento.start();
		VentanaInicio v1 = new VentanaInicio();

	}
}
