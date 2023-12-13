import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemigos {
		int x, y;
		int health;
		JLabel label;
		protected ArrayList<ImageIcon> derecha;
		protected ArrayList<ImageIcon> izquierda;
		protected ArrayList<ImageIcon> ataquenemigo = new ArrayList<ImageIcon>();
		protected ArrayList<ImageIcon> muerte = new ArrayList<ImageIcon>();
		int daño;
		int experiencia;
		int anchoventana;
		int altoventana;
		boolean vivo = true;
		protected ArrayList<ImageIcon> arrayenuso;
		int contadorsprite;
		int screenWidth =  Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight =  Toolkit.getDefaultToolkit().getScreenSize().height;

		protected int getExperiencia() {
			return experiencia;
		}
		protected void setExperiencia(int experiencia) {
			this.experiencia = experiencia;
		}
		protected ArrayList<ImageIcon> getMuerte() {
			return muerte;
		}
		protected void setMuerte(ArrayList<ImageIcon> muerte) {
			this.muerte = muerte;
		}
		protected int getDaño() {
			return daño;
		}
		protected void setDaño(int daño) {
			this.daño = daño;
		}
		protected boolean isVivo() {
			return vivo;
		}
		protected void setVivo(boolean vivo) {
			this.vivo = vivo;
		}
		protected int getAnchoventana() {
			return anchoventana;
		}
		protected void setAnchoventana(int anchoventana) {
			this.anchoventana = anchoventana;
		}
		protected int getAltoventana() {
			return altoventana;
		}
		protected void setAltoventana(int altoventana) {
			this.altoventana = altoventana;
		}
		protected ArrayList<ImageIcon> getArrayenuso() {
			return arrayenuso;
		}
		protected void setArrayenuso(ArrayList<ImageIcon> arrayenuso) {
			this.arrayenuso = arrayenuso;
		}
		
		
		protected int getContadorsprite() {
			return contadorsprite;
		}
		protected void setContadorsprite(int contadorsprite) {
			this.contadorsprite = contadorsprite;
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
					arrayenuso = derecha;
				}
					x--;
				}
	        }
	        if (this.y > player.getPosy() + altoventana/2) {
	        	Color color = new Color(mapacolisiones.getRGB(this.getX()/3   , this.getY()/3 ));
	        	int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				if (red > 220 && green > 220 && blue > 220 ) {
					y--;
				}
	        }
	        	        
		}
		public JLabel getLabel() {
			return label;
		}
		public void setLabel(JLabel label) {
			this.label = label;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getHealth() {
			return health;
		}
		public void setHealth(int health) {
			this.health = health;
		}
		public ArrayList<ImageIcon> getDerecha() {
			return derecha;
		}
		public void setDerecha(ArrayList<ImageIcon> derecha) {
			this.derecha = derecha;
		}
		public ArrayList<ImageIcon> getIzquierda() {
			return izquierda;
		}
		public void setIzquierda(ArrayList<ImageIcon> izquierda) {
			this.izquierda = izquierda;
		}
		public ArrayList<ImageIcon> getAtaquenemigo() {
			return ataquenemigo;
		}
		public void setAtaquenemigo(ArrayList<ImageIcon> ataquenemigo) {
			this.ataquenemigo = ataquenemigo;
		}
		
		public int distancia(Jugador jug) {
			return (int) Math.sqrt(Math.pow(jug.getPosx() - (this.getX()-768), 2) + Math.pow(jug.getPosy()- (this.getY()-417), 2)); 
				
		}
		
}
