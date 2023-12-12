import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Caparazon extends Enemigos{
	ArrayList<ImageIcon> escondido = new ArrayList<ImageIcon>();
	
	
	
	
	public Caparazon() {
		super();
		this.health = 300;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		this.daño = 5;
		this.experiencia = 20;
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk1.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk2.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk3.png");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk1.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk2.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/walk3.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/caparazonatack1.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/caparazonatack2.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/caparazonatack3.png");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);
		ataquenemigo.add(imagen9);
		ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/caparazonmuerto.png");
		ImageIcon image11 = new ImageIcon(icono11.getImage().getScaledInstance(60,25, Image.SCALE_SMOOTH));
		muerte.add(image11);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setAnchoventana(screenSize.width);
		this.setAltoventana(screenSize.height);
		this.setArrayenuso(this.getDerecha());
		this.getLabel().setOpaque(false);
		ImageIcon icono12 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/escondido1.png");
		ImageIcon image12 = new ImageIcon(icono12.getImage().getScaledInstance(60,25, Image.SCALE_SMOOTH));
		ImageIcon icono13 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/escondido2.png");
		ImageIcon image13 = new ImageIcon(icono13.getImage().getScaledInstance(60,40, Image.SCALE_SMOOTH));
		ImageIcon icono14 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/escondido3.png");
		ImageIcon image14 = new ImageIcon(icono14.getImage().getScaledInstance(60,25, Image.SCALE_SMOOTH));
		escondido.add(image14);
		escondido.add(image13);
		//escondido.add(image12);
		this.setArrayenuso(escondido);
		this.getLabel().setIcon(escondido.get(0));
	}
	public void moveToPlayer(Jugador player, BufferedImage mapacolisiones) {
		//mover hacia el jugador cuando entra en x rango
		if(this.getHealth() < 300) {
		int value =(int)(Math.random()*3);
		if(value == 1) {
		if (this.x < player.getPosx()+ anchoventana/2 + 50) {
//			Color color = new Color(mapacolisiones.getRGB(player.getPosx()/3 - 12/3  , player.getPosy()/3 ));
//			int red = color.getRed();
//			int green = color.getGreen();
//			int blue = color.getBlue();
//			if (red > 200 && green > 200 && blue > 200 ) {
				if(this.distancia(player) > 100) {
					arrayenuso = derecha;
				}
				x = x+1;
//			}
		}
        if (this.y < player.getPosy() + altoventana/2) {
//			Color color = new Color(mapacolisiones.getRGB(player.getPosx()/3  -10, player.getPosy()/3+ 3/3 ));
//			int red = color.getRed();
//			int green = color.getGreen();
//			int blue = color.getBlue();
//			if (red > 200 && green > 200 && blue > 200 ) {
				y = y+1;
//			}
        }
        if (this.x > player.getPosx() + anchoventana/2 + 50) {
//			Color color = new Color(mapacolisiones.getRGB(player.getPosx()/3 - 42/3 , player.getPosy()/3 ));
//        	int red = color.getRed();
//			int green = color.getGreen();
//			int blue = color.getBlue();
//			if (red > 200 && green > 200 && blue > 200 ) {
        	if(this.distancia(player) > 100) {
				arrayenuso = derecha;
			}
				x = x -1;
//			}
        }
        if (this.y > player.getPosy() + altoventana/2) {
//        	Color color = new Color(mapacolisiones.getRGB(player.getPosx()/3  , player.getPosy()/3 +  - 30/3));
//        	int red = color.getRed();
//			int green = color.getGreen();
//			int blue = color.getBlue();
//			if (red > 200 && green > 200 && blue > 200 ) {
				y = y-1;
//			}
        	}
		}
		}
		else {
			this.setArrayenuso(escondido);
		}
	}
}
