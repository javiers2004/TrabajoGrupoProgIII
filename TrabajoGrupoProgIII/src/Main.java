import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		
		Jugador jug1 = new Jugador();
        VentanaMapa ven1 = new VentanaMapa(jug1);
        
        
        // Crear una instancia de VentanaAudio
        VentanaAudio audioPlayer = null;
        try {
        	audioPlayer = new VentanaAudio("acoustic-guitar-loop-f-91bpm-132687.wav");
            audioPlayer.play();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);  // Si hay un error, sal del programa.
        }

        // Crear una instancia de VentanaInicio con las instancias ven1 y audioPlayer.
        VentanaInicio v1 = new VentanaInicio(ven1, audioPlayer);
        ven1.setVeninicio(v1);
        
        Connection con = BD.initBD("project.db");
        BD.crearTablas(con);
		BD.insertarJugador(con, new Jugador("ale11", "2"));
		BD.insertarJugador(con, new Jugador("jose56", "89"));
		BD.closeBD(con);

        
		Thread hiloteclas = new Thread() {
			public void run() {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int screenWidth = screenSize.width;
				int screenHeight = screenSize.height;
				ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/MAPABLANCO2.png");
				Image image = icono2.getImage();
				BufferedImage mapacolisiones = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
				mapacolisiones.createGraphics().drawImage(image, 0, 0, null);
				while(true) {
					
					if(ven1.click == false) {
					
					int velocidadextra = 0;
					if(jug1.getStaminarestante() > 0 && ven1.isTeclashift() == true) {
						velocidadextra = 3;
						jug1.setStaminarestante(jug1.getStaminarestante() - 0.8);
						if(jug1.getStaminarestante() < 0) {
							jug1.setStaminarestante(0);
						}
					}
					if (ven1.isTeclaw() == true) {	
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 30/3 - velocidadextra + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, false);
						}	
						if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, true);
						}	
					}	
					if (ven1.isTeclaa() == true) {
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 42/3 -velocidadextra + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosx(jug1.getPosx() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, false);
						}
						if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosx(jug1.getPosx() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, true);
						}
						
					}
					if (ven1.isTeclas() == true) {
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 +  screenWidth/6 , jug1.getPosy()/3+ 3/3 + velocidadextra + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, false);
						}
						if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, true);
						}
					}
					if (ven1.isTeclad() == true) {
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 12/3 + velocidadextra + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosx(jug1.getPosx() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, false);
						}
						if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosx(jug1.getPosx() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, true);
						}
					}
					if(ven1.isTeclad() == false && ven1.isTeclaa() == false && ven1.isTeclas() == false && ven1.isTeclaw() == false) {
						ven1.actualizarVentana(jug1, false);
					}
					//jug1.setStaminarestante(jug1.getStaminatotal());               PARA EL BONUS DE VELOCIDAD
					ven1.actualizarComponentes(jug1);
					
					if (ven1.isTeclashift() == false && jug1.getStaminarestante()<jug1.getStaminatotal()) {
						jug1.setStaminarestante(jug1.getStaminarestante() + 0.25);
						if(jug1.getStaminarestante() > 100) {
							jug1.setStaminarestante(100);
						}
					}
					
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					}
					else {
						if (ven1.isTeclashift() == false && jug1.getStaminarestante()<jug1.getStaminatotal()) {
							jug1.setStaminarestante(jug1.getStaminarestante() + 0.25);
							if(jug1.getStaminarestante() > 100) {
								jug1.setStaminarestante(100);
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
				
			}	
		};
		hiloteclas.start();
		
		

		
	}
}
