import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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
		int anchoventana;
		int altoventana;
		boolean vivo = true;
		
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
		public Enemigos() {
			super();
			this.x = 0;
			this.y = 0;
			this.health = 100;
			this.label = new JLabel();
			this.label.setBounds(x,y,64,50);
			this.label.setBackground(Color.red);
			this.label.setOpaque(true);
			
			derecha = new ArrayList<ImageIcon>();
			ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-0.png");
			ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
			ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-1.png");
			ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
			ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-2.png.");
			ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
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
			ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-0.png");
			ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-1.png");
			ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-1.png");
			ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ataquenemigo.add(imagen9);
			ImageIcon icono10 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-1.png");
			ImageIcon image10 = new ImageIcon(icono10.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ataquenemigo.add(image10);
			ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-1.png");
			ImageIcon imagen11 = new ImageIcon(icono11.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
			ataquenemigo.add(imagen11);
			ataquenemigo.add(imagen7);
			ataquenemigo.add(imagen8);
			this.ataquenemigo = ataquenemigo;	
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setAnchoventana(screenSize.width);
			this.setAltoventana(screenSize.height);
			
			this.derecha = derecha;
			this.izquierda = izquierda;
			this.ataquenemigo = ataquenemigo;
		}
		public void moveToPlayer(Jugador player) {
			//mover hacia el jugador cuando entra en x rango
			if (this.x < player.getPosx()+ anchoventana/2) x++;
	        if (this.y < player.getPosy() + altoventana/2) y++;
	        if (this.x > player.getPosx() + anchoventana/2) x--;
	        if (this.y > player.getPosy() + altoventana/2) y--;
	        
	        
	        
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
