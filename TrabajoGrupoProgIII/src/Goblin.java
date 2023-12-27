import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Goblin extends Enemigos{
	public Goblin() {
		super();
		this.health = 150;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		this.daño = 5;
		this.experiencia = 12;
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/20.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/21.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/22.png.");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/goblinleft1.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/goblinleft2.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/goblinleft3.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/16.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(80,40, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/17.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(80,40, Image.SCALE_SMOOTH));
		ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/18.png");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(80,40, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);
		ataquenemigo.add(imagen9);
		this.getLabel().setSize(100,100);
		ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/45.png");
		ImageIcon image11 = new ImageIcon(icono11.getImage().getScaledInstance(60,25, Image.SCALE_SMOOTH));
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
			if (red > 220 && green > 220 && blue > 220 ) {
				if(this.distancia(player) > 100) {
					arrayenuso = derecha;
				}
				x++;
			}
		}
        if (this.y < player.getPosy() + altoventana/2) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3  , this.getY()/3 + 1));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 220 && green > 220 && blue > 220 ) {
				y++;
			}
        }
        if (this.x > player.getPosx() + anchoventana/2 + 50) {
			Color color = new Color(mapacolisiones.getRGB(this.getX()/3 -1 , this.getY()/3  ));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 220 && green > 220 && blue > 220 ) {
        	if(this.distancia(player) > 100) {
				arrayenuso = izquierda;
			}
				x--;
			}
        }
        if (this.y > player.getPosy() + altoventana/2) {
        	Color color = new Color(mapacolisiones.getRGB(this.getX()/3   , this.getY()/3 -1));
        	int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 220 && green > 220 && blue > 220 ) {
				y--;
			}
        }
        	        
	}
}
