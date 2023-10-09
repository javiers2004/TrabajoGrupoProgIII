	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame implements KeyListener{
	protected boolean teclaw;
	protected boolean teclaa;
	protected boolean teclas;
	protected boolean teclad;
	public JLabel map;
	private Color backgroundColor = Color.GREEN;

	
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
	    JPanel panelfondo = new JPanel();
	    panelfondo.setBounds(2000, 2000, -400, -400);
        panelfondo.setBackground(new Color(173, 216, 230));  // Color azul claro (RGB)
        this.add(panelfondo);
        JLayeredPane layeredPane = new JLayeredPane();
        this.add(layeredPane, BorderLayout.CENTER);
        layeredPane.add(panelfondo, JLayeredPane.DEFAULT_LAYER);
        String imageUrl = "https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/src/MAPADEFINITIVO.png";
		try {
			ImageIcon icon = new ImageIcon(new ImageIcon(new URL(imageUrl)).getImage());
	        ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(12288,12288,Image.SCALE_SMOOTH));
	        Image i2 = imagen.getImage();
	        BufferedImage imagenparadibujar = new BufferedImage(i2.getHeight(null), i2.getWidth(null), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = imagenparadibujar.createGraphics();
	        g2d.drawImage(i2, 0, 0, null);
	        g2d.dispose();
	        ImageIcon imagenfinal = new ImageIcon(imagenparadibujar);
	        map = new JLabel(imagenfinal);
	        this.add(map);
	        map.setBounds(-player.getPosx(), -player.getPosy(), 12288, 12288);
	        map.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //ImageIcon icon = new ImageIcon("MAPADEFINITIVO.png");

        

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
	public void paint(Graphics g) {
        // Llama al método paint de la superclase para mantener el comportamiento estándar de JFrame
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        // Obtiene el tamaño del JFrame
        int width = getWidth();
        int height = getHeight();

        // Rellena el fondo con el color deseado
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);
    }
}