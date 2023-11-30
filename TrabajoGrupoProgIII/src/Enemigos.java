import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemigos {
		int x, y;
		int health;
		JLabel label;
		protected ArrayList<ImageIcon> derecha;
		protected ArrayList<ImageIcon> izquierda;
		protected ArrayList<ImageIcon> ataquenemigo;
		
		public Enemigos() {
			super();
			this.x = 0;
			this.y = 0;
			this.health = 100;
			this.label = new JLabel();
			this.label.setBounds(x,y,30,46);
			this.label.setBackground(Color.red);
			this.label.setOpaque(true);
			
			derecha = new ArrayList<ImageIcon>();
			ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/right0.png");
			ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/right1.png");
			ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/right2.png");
			ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			derecha.add(imagen5);
			derecha.add(imagen);
			derecha.add(imagen2);
			this.derecha = derecha;
			 izquierda = new ArrayList<ImageIcon>();
			ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left0.png");
			ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left1.png");
			ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left2.png");
			ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
			izquierda.add(imagen3);
			izquierda.add(imagen4);
			izquierda.add(imagen6);
			this.izquierda = izquierda;
			ataquenemigo = new ArrayList<ImageIcon>();		
			ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/aright2.png");
			ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/aright1.png");
			ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ataquenemigo.add(imagen7);
			ataquenemigo.add(imagen8);
			this.ataquenemigo = ataquenemigo;	
			
			
			
			this.derecha = derecha;
			this.izquierda = izquierda;
			this.ataquenemigo = ataquenemigo;
		}
		public void moveToPlayer(int playerX, int playerY) {
			//mover hacia el jugador cuando entra en x rango
			if (x < playerX) x++;
	        if (y < playerY) y++;
	        if (x > playerX) x--;
	        if (y > playerY) y--;
	        label.setLocation(x, y);
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
		
		
}
