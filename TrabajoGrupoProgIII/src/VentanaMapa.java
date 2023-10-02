	import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame{
	protected JPanel panelfondo;
	protected JLabel spritelbl;
	protected ImageICon[] spritesmov;
	protected int cspriteindex;
	

	public VentanaMapa(Jugador player){	
		super();
		this.setLayout(null);
		ImageIcon icon = new ImageIcon("mapajuego2.png");
		ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(13000,13000,Image.SCALE_SMOOTH));
		Image i2 = imagen.getImage();
		BufferedImage imagenparadibujar = new BufferedImage(i2.getHeight(null), i2.getWidth(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = imagenparadibujar.createGraphics();
		g2d.drawImage(i2, 0, 0, null);
        g2d.dispose();
        ImageIcon imagenfinal = new ImageIcon(imagenparadibujar);
        JLabel labelmapa = new JLabel(imagenfinal);
        labelmapa.setLocation(0-player.getPosx(), 0-player.getPosy());
        labelmapa.setSize(13000,13000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(labelmapa);
        
        
        //sprites
        sprites = new ImageIcon[4];
        sprites[0] = new ImageIcon();
        sprites[1] = new ImageIcon();
        sprites[2] = new ImageIcon("");
        sprites[3] = new ImageIcon("");
        
        cspriteindex = 0;
        spritelbl= new JLabel(sprites[csproteindex]);
        spritelbl.setHorizontalAlignment(JLabel.CENTER);
        spritelbl.setVerticalAlignment(JLabel.CENTER);
        
        this.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		keypress(e.getKeyCode());
        	}
        });
        this.setFocusable(true);
        this.add(spritelbl);
        
        
        
        this.setVisible(true);
        
        
        
        
	}
protected void keypress(int keycode) {
	switch(keycode{
		case KeyEvent.VK_W:
			cspriteindex= 0;
			break;
		case KeyEvent.VK_D:
			cspriteindex= 1;
			break;
		case KeyEvent.VK_S:
			cspriteindex= 2;
			break;
		case KeyEvent.VK_A:
			cspriteindex= 3;
			break;
			
	}
	spritelbl.setIcon(sprites[cspriteindex]);
	
}
	
}
