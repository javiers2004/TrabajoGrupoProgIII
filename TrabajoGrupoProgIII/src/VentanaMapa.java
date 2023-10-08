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
	public JLabel map;

	
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
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
	    this.addKeyListener(this);
	    // Establecer el foco en el JFrame para recibir eventos de teclado
	    this.setFocusable(true);
	    this.requestFocusInWindow();
        
        ImageIcon icon = new ImageIcon("src/MAPADEFINITIVO.png");
        ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(10000,10000,Image.SCALE_SMOOTH));
        Image i2 = imagen.getImage();
        BufferedImage imagenparadibujar = new BufferedImage(i2.getHeight(null), i2.getWidth(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagenparadibujar.createGraphics();
        g2d.drawImage(i2, 0, 0, null);
        g2d.dispose();
        ImageIcon imagenfinal = new ImageIcon(imagenparadibujar);
        
        map = new JLabel(imagenfinal);
        this.add(map);
        map.setBounds(-player.getPosx(), -player.getPosy(), 10000, 10000);
        map.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
        char keyChar = Character.toUpperCase(e.getKeyChar());  // Convertir a mayúsculas
        // Verificar qué tecla se presionó y establecer la correspondiente variable booleana
        	if (keyChar == 'W') {
        		teclaw = true;
        	} else if (keyChar == 'A') {
        		teclaa = true;
        	} else if (keyChar == 'S') {
        		teclas = true;
        	} else if (keyChar == 'D') {
        		teclad = true;
        	}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		 char keyChar = Character.toUpperCase(e.getKeyChar());  // Convertir a mayúsculas

	        // Verificar qué tecla se soltó y establecer la correspondiente variable booleana
	        if (keyChar == 'W') {
	            teclaw = false;
	        } else if (keyChar == 'A') {
	            teclaa = false;
	        } else if (keyChar == 'S') {
	            teclas = false;
	        } else if (keyChar == 'D') {
	            teclad = false;
	        } 
	}
	public void actualizarVentana(Jugador player) {
		map.setLocation(-player.getPosx(), -player.getPosy());
		map.setVisible(true);

	}
}