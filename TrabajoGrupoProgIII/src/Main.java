import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {
	
	public static Inventario inventario;
	public static Productos productos;


	public static void main(String[] args) {
		
		Jugador jug1 = new Jugador();
		//jug1.actualizarDesdeArchivo("partida.txt", jug1);
		
        VentanaMapa ven1 = new VentanaMapa(jug1);
//        inventario = new Inventario();
//        productos = new Productos();
        
        
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
        
//        Connection con = BD.initBD("project.db");
//        BD.crearTablaPartida(con); // Crear la tabla
//        BD.cargarDatosDesdeArchivoYGuardar(con, "partida.txt"); // Luego cargar los datos
//        BD.closeBD(con);
//
//		BD.closeBD(con);

        
		Thread hiloteclas = new Thread() {
			
			public void run() {
				
			
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int screenWidth = screenSize.width;
				int screenHeight = screenSize.height;
				ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/MAPABLANCO4.png");
				Image image = icono2.getImage();
				BufferedImage mapacolisiones = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
				mapacolisiones.createGraphics().drawImage(image, 0, 0, null);
				//entidades
				long startTime = System.currentTimeMillis();
				while(true) {
					System.out.println(ven1.isContinuar());
					if(ven1.isContinuar() == true) {
//					for (Enemigos e1 : entities) {
//						e1.moveToPlayer(jug1.getPosx(), jug1.getPosy());
//					}
						//System.out.println(jug1.getVidarestante());
					if(ven1.click == false) {
					
					int velocidadextra = 0;
					if(jug1.getStaminarestante() > 0 && ven1.isTeclashift() == true) {
						velocidadextra = 4;
						jug1.setStaminarestante(jug1.getStaminarestante() - 0.4);
						if(jug1.getStaminarestante() < 0) {
							jug1.setStaminarestante(0);
						}
					}
					boolean mov = false;
					if (ven1.isTeclaw() == true) {	
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 30/3 - velocidadextra + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, false);
							mov =true;

						}	
						else if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosy(jug1.getPosy() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, true);
							mov =false;
						}	
						else {
							mov = true;
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
							mov =true;

						}
						else if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosx(jug1.getPosx() - 3 - velocidadextra);
							ven1.actualizarVentana(jug1, true);
							mov =false;

						}
						else {
							mov = true;
						}
					}
					if (ven1.isTeclas() == true) {
						Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 +  screenWidth/6 -10, jug1.getPosy()/3+ 3/3 + velocidadextra + screenHeight/6));
						int red = color.getRed();
						int green = color.getGreen();
						int blue = color.getBlue();
						if (red > 200 && green > 200 && blue > 200 ) {
							jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, false);
							mov =true;

						}
						else if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosy(jug1.getPosy() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, true);
							mov =false;

						}
						else {
							mov = true;
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
							mov =true;

						}
						else if (red == 255 && green == 0 && blue == 0) {
							jug1.setPosx(jug1.getPosx() + 3 + velocidadextra);
							ven1.actualizarVentana(jug1, true);
							mov =false;

						}
						else {
							mov = true;
						}

					}
					if(mov == false) {
						ven1.actualizarVentana(jug1, true);
					}
					else {
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
					} catch (InterruptedException ezz) {
						// TODO Auto-generated catch block
						ezz.printStackTrace();
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
						} catch (InterruptedException ez) {
							// TODO Auto-generated catch block
							ez.printStackTrace();
						}
						
					}
					long elapsedTime = System.currentTimeMillis() - startTime;

				    // Ajusta la velocidad según sea necesario
				    if (elapsedTime < 10) {
				        try {
				            Thread.sleep(10 - elapsedTime);
				        } catch (InterruptedException e) {
				            e.printStackTrace();
				        }
				    }

				    startTime = System.currentTimeMillis();
				}					
				}
			}	
		};
		hiloteclas.start();
		
		ven1.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
		            if(jug1.getPosx() > 582 && jug1.getPosx()< 1038 && jug1.getPosy() > 5228 && jug1.getPosy() < 5736) {
		            	VentanaTienda ventanaTienda = new VentanaTienda();
		            	ventanaTienda.setVisible(true);
		            }	
		        }
		    }
		});
		ven1.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
		            
		        	VentanaInventario ventanaInventario = new VentanaInventario();
		            ventanaInventario.setVisible(true);
		        }
		    }
		});

		// Asegúrate de que la ventana puede recibir eventos de teclado
		ven1.setFocusable(true);
		ven1.requestFocusInWindow();
		
		
		

		
	}
}
