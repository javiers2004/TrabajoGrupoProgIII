import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bat extends Enemigos{
	public Bat() {
		super();
		this.health = 100;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		this.daño = 1;
		this.experiencia = 5;
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batmove1.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batmove2.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batmove3.png.");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono9 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batmove3.png.");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		derecha.add(imagen9);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/left0.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/left1.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/left2.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batatack1.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batatack2.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);

		ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batdeath.png");
		ImageIcon image11 = new ImageIcon(icono11.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		muerte.add(image11);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setAnchoventana(screenSize.width);
		this.setAltoventana(screenSize.height);
		this.getLabel().setIcon(this.getDerecha().get(0));
		this.setArrayenuso(this.getDerecha());
		this.getLabel().setOpaque(false);
	}
	
	public void moveToPlayer(Jugador player, BufferedImage mapacolisiones) {
		//mover hacia el jugador cuando entra en x rango
		if (this.x < player.getPosx()+ anchoventana/2 + 50) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3  +2, this.getY()/3 ));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				if(this.distancia(player) > 100) {
					arrayenuso = derecha;
				}
				x = x+2;
			}
		}
        if (this.y < player.getPosy() + altoventana/2) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3  , this.getY()/3 + 2));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				y = y+2;
			}
        }
        if (this.x > player.getPosx() + anchoventana/2 + 50) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3 -2 , this.getY()/3  ));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
        	if(this.distancia(player) > 100) {
				arrayenuso = derecha;
			}
				x= x-2;
			}
        }
        if (this.y > player.getPosy() + altoventana/2) {
        	Color color = new Color(mapacolisiones.getRGB(this.getX()/3   , this.getY()/3 -2));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				y= y-2;
			}
        }
        	        
	}
}
