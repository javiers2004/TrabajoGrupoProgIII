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
	public JLabel map;
	private Color backgroundColor = Color.GREEN;
	protected JLabel lblplayer;

	//GETTERS Y SETTERS
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
	//CONSTRUCTOR
	public VentanaMapa(Jugador player){	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
	    this.addKeyListener(this);
	    
	    
	    // Establecer el foco en el JFrame para recibir eventos de teclado
	    this.setFocusable(true);
	    this.requestFocusInWindow();
	    
	    
	    //AÑADIR EL png DEL MAPA A LA VENTANA
	    JPanel panelfondo = new JPanel();
	    panelfondo.setPreferredSize(new Dimension(800,800));
        panelfondo.setBackground(Color.cyan);  // Color azul claro (RGB) new Color(173, 216, 230)

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
		
	int x = (screenSize.width)/2;
	int y = (screenSize.height)/2;
	int x1 = (screenSize.width)/40;
	
	lblplayer = new JLabel();
	lblplayer.setBackground(Color.red);
	
	
	
	
	lblplayer.setBounds(x, y, x1, x1);
	lblplayer.setOpaque(true);
	panelfondo.add(Box.createRigidArea(new Dimension(0,(800- 200/2))));
	panelfondo.add(lblplayer);
	panelfondo.setComponentZOrder(lblplayer, 0);
	panelfondo.setComponentZOrder(map, 1);
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
		System.out.println(player.getPosy() );
	}
	public void sistemamovimiento(Jugador jug1, int screenWidth , int screenHeight, BufferedImage mapacolisiones) {
		//TECLA W ACTIVADA
		if (this.isTeclaw() == true) {	
			Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 + screenWidth/6  , jug1.getPosy()/3 +  - 3/3 + screenHeight/6));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 200 && green > 200 && blue > 200 ) {
				jug1.setPosy(jug1.getPosy() - 3);
				this.actualizarVentana(jug1);
			}	
			if (red == 255 && green == 0 && blue == 0) {
				jug1.setPosy(jug1.getPosy() - 3);
				this.actualizarVentana(jug1);
				//quitar opacidad
			}
		}	
		//TECLA A ACTIVADA
		if (this.isTeclaa() == true) {
			Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 - 3/3 + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 200 && green > 200 && blue > 200 ) {
				jug1.setPosx(jug1.getPosx() - 3);
				this.actualizarVentana(jug1);
			}
			if (red == 255 && green == 0 && blue == 0) {
				jug1.setPosx(jug1.getPosx() - 3);
				this.actualizarVentana(jug1);
				//quitar opacidad
			}	
		}
		//TECLA S ACTIVADA
		if (this.isTeclas() == true) {
			Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3 +  screenWidth/6, jug1.getPosy()/3+ 3/3 + screenHeight/6));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 200 && green > 200 && blue > 200 ) {
				jug1.setPosy(jug1.getPosy() + 3);
				this.actualizarVentana(jug1);
			}
			if (red == 255 && green == 0 && blue == 0) {
				jug1.setPosy(jug1.getPosy() + 3);
				this.actualizarVentana(jug1);
				//quitar opacidad
			}
		}
		//TECLA D ACTIVADA
		if (this.isTeclad() == true) {
			Color color = new Color(mapacolisiones.getRGB(jug1.getPosx()/3+ 3/3 + + screenWidth/6, jug1.getPosy()/3 + screenHeight/6));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			if (red > 200 && green > 200 && blue > 200 ) {
				jug1.setPosx(jug1.getPosx() + 3);
				this.actualizarVentana(jug1);
			}
			if (red == 255 && green == 0 && blue == 0) {
				jug1.setPosx(jug1.getPosx() + 3);
				this.actualizarVentana(jug1);
				//quitar opacidad
			}
		}

	}
}