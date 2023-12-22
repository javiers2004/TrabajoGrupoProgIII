import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pajaro extends Enemigos{
	public Pajaro() {
		super();
		this.health = 50;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		this.daño = 1;
		this.experiencia = 5;
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajarowalk0.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajarowalk1.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajarowalk2.png.");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono9 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajarowalk3.png.");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		derecha.add(imagen9);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/leftwalk0.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/leftwalk1.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/leftwalk2.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono14 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/leftwalk3.png");
		ImageIcon imagen14 = new ImageIcon(icono14.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		izquierda.add(imagen14);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajaroatack0.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajaroatack1.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono12 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajaroatack2.png");
		ImageIcon imagen12 = new ImageIcon(icono12.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono13 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajaroatack3.png");
		ImageIcon imagen13 = new ImageIcon(icono13.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);

		ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/pajaro/pajarodeath.png");
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
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3  +1, this.getY()/3 ));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				if(this.distancia(player) > 100) {
					arrayenuso = izquierda;
				}
				x = x+1;
			}
		}
        if (this.y < player.getPosy() + altoventana/2) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3  , this.getY()/3 + 1));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				y = y+1;
			}
        }
        if (this.x > player.getPosx() + anchoventana/2 + 50) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3 -1 , this.getY()/3  ));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
        	if(this.distancia(player) > 100) {
				arrayenuso = derecha;
			}
				x= x-1;
			}
        }
        if (this.y > player.getPosy() + altoventana/2) {
        	Color color = new Color(mapacolisiones.getRGB(this.getX()/3   , this.getY()/3 -1));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red != 255 || green != 0 || blue != 0) {
				y= y-1;
			}
        }
	}
}
