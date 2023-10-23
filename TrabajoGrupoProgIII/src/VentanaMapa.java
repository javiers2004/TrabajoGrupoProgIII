	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame implements KeyListener{
	//ATRIBUTOS
	protected boolean teclaw;
	protected boolean teclaa;
	protected boolean teclas;
	protected boolean teclad;
	protected boolean teclashift;
	
	public JLabel map;
	private Color backgroundColor = Color.GREEN;
	protected JLabel lblplayer;
	protected JFrame veninicio;

	//GETTERS Y SETTERS
	
	protected boolean isTeclaw() {
		return teclaw;
	}
	protected boolean isTeclashift() {
		return teclashift;
	}
	protected void setTeclashift(boolean teclashift) {
		this.teclashift = teclashift;
	}
	protected JLabel getMap() {
		return map;
	}
	protected void setMap(JLabel map) {
		this.map = map;
	}
	protected Color getBackgroundColor() {
		return backgroundColor;
	}
	protected void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	protected JLabel getLblplayer() {
		return lblplayer;
	}
	protected void setLblplayer(JLabel lblplayer) {
		this.lblplayer = lblplayer;
	}
	protected JFrame getVeninicio() {
		return veninicio;
	}
	protected void setVeninicio(JFrame veninicio) {
		this.veninicio = veninicio;
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
	//CONSTRUCTOR
	public VentanaMapa(Jugador player){	
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	getVeninicio().setVisible(true);  	
            }
        });
		this.setVisible(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
	    this.addKeyListener(this);
	    // Establecer el foco en el JFrame para recibir eventos de teclado
	    this.setFocusable(true);
	    this.requestFocusInWindow();
	    //AÑADIR EL png DEL MAPA A LA VENTANA
	    JPanel panelfondo = new JPanel();
	    panelfondo.setPreferredSize(new Dimension(800,800));
        panelfondo.setBackground(Color.cyan);
        panelfondo.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JPanel pnlprincipal= new JPanel();
        pnlprincipal.setSize(800,800);
        pnlprincipal.setLayout(new BoxLayout(pnlprincipal, BoxLayout.PAGE_AXIS));
        pnlprincipal.add(Box.createRigidArea(new Dimension(0, 0))); 
        pnlprincipal.add(panelfondo);
        this.add(pnlprincipal);
        pnlprincipal.setVisible(true);
        panelfondo.setVisible(true);
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
	        panelfondo.add(map);
	        map.setBounds(-player.getPosx(), -player.getPosy(), 12288, 12288);
	        map.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//label del player
		int x1 = (screenSize.width)/20;
		int y1 = (screenSize.height)/12;
		int x = (screenSize.width )/2 - x1;
		int y = (screenSize.height)/2 - y1;
		lblplayer = new JLabel();

		String imageURL2 = "https://raw.githubusercontent.com/javiers2004/TrabajoGrupoProgIII/master/TrabajoGrupoProgIII/sprites/guard_sword_1%20(1).png";
		try {
			ImageIcon icon = new ImageIcon(new ImageIcon(new URL(imageURL2)).getImage());
			ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(x1,y1,Image.SCALE_SMOOTH));
			Image i2 = imagen.getImage();
			BufferedImage imagenparadibujar = new BufferedImage(i2.getWidth(null),i2.getHeight(null)+ 1000,  BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = imagenparadibujar.createGraphics();
			g2d.drawImage(i2, 0, y, null);
			g2d.dispose();
			ImageIcon imagenfinal = new ImageIcon(imagenparadibujar);
			lblplayer.setIcon(imagenfinal);
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		lblplayer.setOpaque(false);
		panelfondo.add(Box.createRigidArea(new Dimension(0,(800- 200/2))));
		panelfondo.add(lblplayer);
		lblplayer.setBounds(x, y, x1, y1);
		panelfondo.setComponentZOrder(lblplayer, 0);
		panelfondo.setComponentZOrder(map, 1);
	}
	//PARA PONER BOOLEANOS A TRUE AL PRESIONAR TECLAS
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
        	if(e.isShiftDown()) {
        		teclashift = true;
        	}
	}

	//PARA PONER BOOLEANOS A FALSE AL PRESIONAR TECLAS
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
	        if (!e.isShiftDown()) {
	        	teclashift = false;
	        }
	}
	//PARA ACTUALIZAR LA VENTANA CUANDO SE LLAMA DESDE EL MAIN
	public void actualizarVentana(Jugador player) {
		map.setLocation(-player.getPosx(), -player.getPosy());
		map.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}