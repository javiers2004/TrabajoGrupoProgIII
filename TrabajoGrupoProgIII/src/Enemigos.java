import java.awt.Color;

import javax.swing.JLabel;

public class Enemigos {
		int x, y;
		int health;
		JLabel label;
		
		public Enemigos(int x, int y) {
			this.x = x;
			this.y = y;
			this.health = 100;
			this.label = new JLabel();
			this.label.setBounds(x,y,10,10);
			this.label.setBackground(Color.red);
			this.label.setOpaque(true);
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
		
		
}
