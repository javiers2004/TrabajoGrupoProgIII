	import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame implements KeyListener{
	protected boolean teclaw;
	protected boolean teclaa;
	protected boolean teclas;
	protected boolean teclad;

	protected boolean isTeclaw() {
		return teclaw;
	}
	protected void setTeclaw(boolean teclaw) {
		this.teclaw = teclaw;
	}
	protected boolean isTeclaa() {
		return teclaa;
	}
	protected void setTeclaa(boolean teclaa) {
		this.teclaa = teclaa;
	}
	protected boolean isTeclas() {
		return teclas;
	}
	protected void setTeclas(boolean teclas) {
		this.teclas = teclas;
	}
	protected boolean isTeclad() {
		return teclad;
	}
	protected void setTeclad(boolean teclad) {
		this.teclad = teclad;
	}
	
	public VentanaMapa(Jugador player){	
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 
     public void keyPressedW(KeyEvent e) {
         if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
             this.setTeclaw(true);
         }
     }

     
     public void keyReleasedW(KeyEvent e) {
         if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
        	 this.setTeclaw(false);
         }
     }

	 public void keyPressedA(KeyEvent e) {
         if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
             this.setTeclaa(true);
         }
     }

     
     public void keyReleasedA(KeyEvent e) {
         if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
        	 this.setTeclaa(false);
         }
     }
	 public void keyPressedS(KeyEvent e) {
         if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
             this.setTeclas(true);
         }
     }

     
     public void keyReleasedS(KeyEvent e) {
         if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
        	 this.setTeclas(false);
         }
     }
     
	 public void keyPressedD(KeyEvent e) {
         if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
             this.setTeclad(true);
         }
     }

     
     public void keyReleasedD(KeyEvent e) {
         if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
        	 this.setTeclad(false);
         }
     }
     
}
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	
}