	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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
	protected int contadorsprites = 0;
	protected PanelInfoVentanaMapa veninfo;
	public JLabel fondo;
	public JLabel map;
	private Color backgroundColor = Color.GREEN;
	protected JLabel lblplayer;
	protected JFrame veninicio;
	protected ArrayList<ImageIcon> arraymovimiento;
	protected ArrayList<ImageIcon> arraymovimientoanterior;
	protected Jugador player;
	protected JLabel labelatravesar;
	protected JLabel levelup;
	protected int anchoventana;
	protected int altoventana;
	protected boolean click = false;
    boolean ataquedisponible = true;
    protected PanelMinimapa minimapa;
    boolean continuar = true;
	
	//GETTERS Y SETTERS
	
	
	
	protected int aumentoprogresivoexp= 0;
	
	protected boolean isContinuar() {
		return continuar;
	}
	protected void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	protected boolean isAtaquedisponible() {
		return ataquedisponible;
	}
	protected void setAtaquedisponible(boolean ataquedisponible) {
		this.ataquedisponible = ataquedisponible;
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
	protected PanelInfoVentanaMapa getVeninfo() {
		return veninfo;
	}
	protected void setVeninfo(PanelInfoVentanaMapa veninfo) {
		this.veninfo = veninfo;
	}
	protected int getAumentoprogresivoexp() {
		return aumentoprogresivoexp;
	}
	protected void setAumentoprogresivoexp(int aumentoprogresivoexp) {
		this.aumentoprogresivoexp = aumentoprogresivoexp;
	}
	protected boolean isTeclaw() {
		return teclaw;
	}
	protected Jugador getPlayer() {
		return player;
	}
	protected void setPlayer(Jugador player) {
		this.player = player;
	}
	protected ArrayList<ImageIcon> getArraymovimiento() {
		return arraymovimiento;
	}
	protected void setArraymovimiento(ArrayList<ImageIcon> arraymovimiento) {
		this.arraymovimiento = arraymovimiento;
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
		//POSICIONAR LABEL DEL JUGADOR
		this.player = player;
		this.setArraymovimiento(player.getDerecha());
		this.setVisible(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setAnchoventana(screenSize.width);
		this.setAltoventana(screenSize.height);
		this.setBounds(0, 0, screenSize.width, screenSize.height);
	    this.addKeyListener(this);
	    //FOCO EN EL JFRAME PARA RECIBIR LOS EVENTOS DEL TECLADO
	    this.setFocusable(true);
	    this.requestFocusInWindow();
	    //AÑADIR EL PANELPRINCIPAL A LA VENTANA
	    JLayeredPane panelfondo = new JLayeredPane();
	    panelfondo.setPreferredSize(new Dimension(8000,8000));
        panelfondo.setBackground(Color.cyan);
        panelfondo.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JPanel pnlprincipal= new JPanel();
        pnlprincipal.setSize(8000,8000);
        pnlprincipal.setLayout(new BoxLayout(pnlprincipal, BoxLayout.PAGE_AXIS));
        //pnlprincipal.add(Box.createRigidArea(new Dimension(0, 0))); 
        pnlprincipal.add(panelfondo);
        this.add(pnlprincipal);
        pnlprincipal.setVisible(true);
        panelfondo.setVisible(true);
        
        //PERSONALIZAR EL FONDO
        ImageIcon iconofondo = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/OIP.jpg");
		ImageIcon imagenfondo = new ImageIcon(iconofondo.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH));
		fondo = new JLabel();
		fondo.setIcon(imagenfondo);
		fondo.setBounds(0, 0, screenSize.width , screenSize.height);
		panelfondo.add(fondo, JLayeredPane.PALETTE_LAYER);
		panelfondo.setComponentZOrder(fondo, 0);
	
		//AÑADIR EL MAPA PRINCIPAL
		ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/MAPADEFINITIVO.png");
		ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(12288,12288,Image.SCALE_SMOOTH));
		Image i2 = imagen.getImage();
		BufferedImage imagenparadibujar = new BufferedImage(i2.getHeight(null), i2.getWidth(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = imagenparadibujar.createGraphics();
		g2d.drawImage(i2, 0, 0, null);
		g2d.dispose();
		ImageIcon imagenfinal = new ImageIcon(imagenparadibujar);
		map = new JLabel(imagenfinal);
		panelfondo.add(map, JLayeredPane.DEFAULT_LAYER);
		map.setBounds(-player.getPosx(), -player.getPosy(), 12288, 12288);
		map.setVisible(true);
		
		//AÑADIR LABEL DEL PLAYER, DEL ATRAVESAR, Y LA VENTANA DE INFORMACIÓN
		int x1 = (screenSize.width)/20;
		int y1 = (screenSize.height)/12;
		int x = (screenSize.width )/2;
		int y = (screenSize.height)/2 - y1;
		lblplayer = new JLabel();
		lblplayer.setOpaque(false);
		//panelfondo.add(Box.createRigidArea(new Dimension(0,0)));
		lblplayer.setBounds(x-x1/2, y, x1 , y1);
		panelfondo.add(lblplayer, JLayeredPane.PALETTE_LAYER);	
		panelfondo.setComponentZOrder(lblplayer, 0);
		panelfondo.setComponentZOrder(map, 1);
		ImageIcon icono2 = new ImageIcon("dcha1.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		lblplayer.setIcon(imagen2);
		veninfo = new PanelInfoVentanaMapa(player);
		veninfo.setLocation(0,0);
		panelfondo.add(veninfo);
		panelfondo.setComponentZOrder(veninfo, 0);
		
		PanelMinimapa minimapa = new PanelMinimapa(imagenfinal);
		minimapa.setLocation(1225,525);
		minimapa.setVisible(true);
		panelfondo.add(minimapa);
		panelfondo.setComponentZOrder(minimapa, 0);
		this.minimapa = minimapa;
		
		labelatravesar = new JLabel();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/imagenatravesar.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH));
		labelatravesar.setIcon(imagen3);
		labelatravesar.setBounds(0, 0, screenSize.width , screenSize.height);
		labelatravesar.setVisible(false);
		panelfondo.add(labelatravesar, JLayeredPane.PALETTE_LAYER);
		panelfondo.setComponentZOrder(labelatravesar, 1);
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/levelup.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		levelup = new JLabel();
		levelup.setIcon(imagen4);
		levelup.setBounds(300, 0, 100 , 100);
		panelfondo.add(levelup, JLayeredPane.PALETTE_LAYER);
		panelfondo.setComponentZOrder(levelup, 1);
		levelup.setVisible(false);
		

	//PERSONALIZAR CURSOR
		BufferedImage cursorImage;
		try {
			cursorImage = ImageIO.read(new File("TrabajoGrupoProgIII/src/Imagenes/sword.png"));
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			map.setCursor(customCursor);
			lblplayer.setCursor(customCursor);
			labelatravesar.setCursor(customCursor);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if(ataquedisponible == true) {
                	click = true;
                	ataquedisponible = false;
                	Hiloataque hiloat = new Hiloataque(lblplayer, VentanaMapa.this, x);
                	hiloat.start();
                }
            }
        });
		
	}

	
	
	//PARA PONER BOOLEANOS A TRUE AL PRESIONAR TECLAS
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
        char keyChar = Character.toUpperCase(e.getKeyChar());  // Convertir a mayúsculas
        // Verificar qué tecla se presionó y establecer la correspondiente variable booleana
        	if (keyChar == 'W') {
        		teclaw = true;
        		this.arraymovimiento = this.arraymovimientoanterior;
        	} else if (keyChar == 'A') {
        		teclaa = true;
        		if (this.getArraymovimiento() != this.getPlayer().getIzquierda()) {
        			//lblplayer.setLocation(lblplayer.getLocation().x - 40, lblplayer.getLocation().y);
    				//player.setPosx(player.getPosx() - 0);
    				//this.actualizarVentana(player);
        		}
        		this.setArraymovimiento(this.getPlayer().getIzquierda());
        		this.arraymovimientoanterior = this.getPlayer().getIzquierda();
        		
        		
        	} else if (keyChar == 'S') {
        		teclas = true;
        		this.arraymovimiento = this.arraymovimientoanterior;

        	} else if (keyChar == 'D') {
        		teclad = true;
        		if (this.getArraymovimiento() != this.getPlayer().getDerecha()) {
        			//lblplayer.setLocation(lblplayer.getLocation().x + 40, lblplayer.getLocation().y);
            		//player.setPosx(player.getPosx() + 15);
    				//this.actualizarVentana(player);
        		}
        		this.setArraymovimiento(this.getPlayer().getDerecha());
        		this.arraymovimientoanterior = this.getPlayer().getDerecha();

        		
        	}
    		if(this.getArraymovimiento() != this.getPlayer().getDerecha() || this.getArraymovimiento() != this.getPlayer().getIzquierda()) {
    			this.setArraymovimiento(arraymovimientoanterior);
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
	public void actualizarVentana(Jugador player, boolean atravesando) {
		map.setLocation(-player.getPosx(), -player.getPosy());
		map.setVisible(true);

		if(teclaw == true || teclaa == true || teclas == true || teclad == true) {
			
			if(this.getArraymovimiento() == null) {
				return;
			}
			if (contadorsprites + 1 > this.getArraymovimiento().size()*5) {
				contadorsprites = 0;
			}
			if(contadorsprites % 5 == 0) {
				lblplayer.setIcon(this.getArraymovimiento().get(contadorsprites/5));
			}
			contadorsprites ++;
			if (atravesando == true) {
				labelatravesar.setVisible(true);
				lblplayer.setVisible(false);
			}
			//System.out.print(player.getStaminarestante() + "/" + player.getStaminatotal());
			else {
				labelatravesar.setVisible(false);
				lblplayer.setVisible(true);
			}
		
			if(this.getAumentoprogresivoexp() % 100 == 0) {
				player.setExperiencia(player.getExperiencia()+1);			
			}
			this.setAumentoprogresivoexp(this.getAumentoprogresivoexp() + 1);
			this.player = player;
			if (player.getExperiencia() > 15) {
				player.setNivel(player.getNivel() + 1);
				player.setExperiencia(0);
				levelup.setVisible(true);
				HiloSubidaNivel hilosubidanivel = new HiloSubidaNivel(veninfo, this, player);
				hilosubidanivel.start();	
				levelup.setVisible(false);
			}
		}
		this.minimapa.actualizarPunto(player);
	}
	public void actualizarComponentes(Jugador player) {
		veninfo.actualizarPanelInfo(player);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}


}