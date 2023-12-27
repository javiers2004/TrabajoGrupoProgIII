import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Puercoespin extends Enemigos{
	public Puercoespin() {
		super();
		this.health = 100;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		this.daño = 10;
		this.experiencia = 8;
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walk1.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walk2.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walk3.png");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono20 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walk4.png");
		ImageIcon imagen20 = new ImageIcon(icono20.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		derecha.add(imagen20);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walkleft1.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walkleft2.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walkleft3.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono12 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/walkleft4.png");
		ImageIcon imagen12 = new ImageIcon(icono12.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		izquierda.add(imagen12);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/ataque1.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(80,60, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/ataque2.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(80,60, Image.SCALE_SMOOTH));
		ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/ataque3.png");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(80,60, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen9);
		ImageIcon icono10 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/ataque4.png");
		ImageIcon image10 = new ImageIcon(icono10.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(image10);
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);
		ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/puercoespin/muerto.png");
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
		
		if(this.distancia(player) < 100 && this.distancia(player) > 90) {
			this.setContadorsprite(0);
			this.setArrayenuso(this.getAtaquenemigo());
		}
		
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
