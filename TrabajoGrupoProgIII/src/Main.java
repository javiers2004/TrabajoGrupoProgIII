import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
					File imageFile = new File("src/MAPABLANCO.png");
					BufferedImage mapacolisiones = ImageIO.read(imageFile);
		            Dimension dimension = ven1.getSize();
		            int width = dimension.width;
		            int height = dimension.height;
					while(true) {
						if (ven1.isTeclaw() == true) {	
							//Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()  , jug1.getPosy() +  - 10));
							//int red = color.getRed();
							//int green = color.getGreen();
							//int blue = color.getBlue();
							//if (red > 00 && green > 00 && blue > 00 ) {
								jug1.setPosy(jug1.getPosy() - 2);
								ven1.actualizarVentana(jug1);
							//}	
						}	
						if (ven1.isTeclaa() == true) {
							//Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()- 10, jug1.getPosy()));
							//int red = color.getRed();
							//int green = color.getGreen();
							//int blue = color.getBlue();
							//if (red > 200 && green > 00 && blue > 00 ) {
								jug1.setPosx(jug1.getPosx() - 2);
								ven1.actualizarVentana(jug1);
							//}
						}
						if (ven1.isTeclas() == true) {
							//Color color = new Color(mapacolisiones.getRGB(jug1.getPosx(), jug1.getPosy()+ 10));
							//int red = color.getRed();
							//int green = color.getGreen();
							//int blue = color.getBlue();
							//if (red > 200 && green > 00 && blue > 00 ) {
								jug1.setPosy(jug1.getPosy() + 2);
								ven1.actualizarVentana(jug1);
							//}
						}
						if (ven1.isTeclad() == true) {
							//Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()+ 10, jug1.getPosy()));
							//int red = color.getRed();
							//int green = color.getGreen();
							//int blue = color.getBlue();
							//if (red > 200 && green > 00 && blue > 00 ) {
								jug1.setPosx(jug1.getPosx() + 2);
								ven1.actualizarVentana(jug1);
							//}	
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

	}
}
