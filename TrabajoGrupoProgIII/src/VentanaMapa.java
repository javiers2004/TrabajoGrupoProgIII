	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame implements KeyListener{
	protected JPanel panelfondo;
	protected JLabel spritelbl;
	protected ImageIcon[] spritesmov;
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
        spritesmov = new ImageIcon[4];
        spritesmov[0] = new ImageIcon("TrabajoGrupoProgIII/TrabajoGrupoProgIII/sprites/guard_sword_up.png");
        spritesmov[1] = new ImageIcon("TrabajoGrupoProgIII/TrabajoGrupoProgIII/sprites/guard_sword_der.png");
        spritesmov[2] = new ImageIcon("TrabajoGrupoProgIII/TrabajoGrupoProgIII/sprites/guard_sword_down.png");
        spritesmov[3] = new ImageIcon("TrabajoGrupoProgIII/TrabajoGrupoProgIII/sprites/guard_sword_izk.png");
        
        cspriteindex = 0;
        spritelbl= new JLabel(spritesmov[cspriteindex]);
        spritelbl.setHorizontalAlignment(JLabel.CENTER);
        spritelbl.setVerticalAlignment(JLabel.CENTER);
        
        this.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		keypress(e.getKeyCode());
        	}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.add(spritelbl);
        
        
        
        this.setVisible(true);
        
        
        
        
	}
protected void keypress(int keycode) {
	switch(keycode){
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
	repaint();
}
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image spriteImage = spritesmov[cspriteindex].getImage();
		int x = (getWidth()- spriteImage.getWidth(null))/2;
		int y = (getHeight()- spriteImage.getHeight(null))/2;
		g.drawImage(spriteImage, x, y,null);
}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
