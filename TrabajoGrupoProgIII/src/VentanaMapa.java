	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Imagenes.Dialogo;

public class VentanaMapa extends JFrame implements KeyListener{
	//ATRIBUTOS
	protected JLabel lblcartel;
	private static final int distdetect = 900;
	private static final int ddistdetect = 900;
	protected boolean teclaw;
	protected boolean teclaa;
	protected boolean teclas;
	protected boolean teclad;
	protected boolean teclashift;
	protected int contadorsprites = 0;
	protected int contadorspritesenemigos = 0;
	protected PanelInfoVentanaMapa veninfo;
	public JLabel fondo;
	public JLabel map;
	public JLabel mapcueva;
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
	public JLayeredPane panelfondo;
	protected List<Enemigos> enemigos;
	public JPanel pnlprincipal;
	protected ArrayList<ImageIcon> arraymovimientoenemigos;
	protected ArrayList<ImageIcon> arraymovimientoanteriorenemigos;
	protected BufferedImage mapacolisiones;
	protected ImageIcon imagenfinalcueva;
	protected ImageIcon imagenfinal;
	//GETTERS Y SETTERS
	
	
	
	protected int aumentoprogresivoexp= 0;
	
	
	 
	public JLabel getLblcartel() {
		return lblcartel;
	}
	public void setLblcartel(JLabel lblcartel) {
		this.lblcartel = lblcartel;
	}
	public int getContadorspritesenemigos() {
		return contadorspritesenemigos;
	}
	public void setContadorspritesenemigos(int contadorspritesenemigos) {
		this.contadorspritesenemigos = contadorspritesenemigos;
	}
	public BufferedImage getMapacolisiones() {
		return mapacolisiones;
	}
	public void setMapacolisiones(BufferedImage mapacolisiones) {
		this.mapacolisiones = mapacolisiones;
	}
	public static int getDistdetect() {
		return distdetect;
	}
	public static int getDdistdetect() {
		return ddistdetect;
	}
	public int getContadorsprites() {
		return contadorsprites;
	}
	public void setContadorsprites(int contadorsprites) {
		this.contadorsprites = contadorsprites;
	}
	public JLabel getFondo() {
		return fondo;
	}
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}
	public ArrayList<ImageIcon> getArraymovimientoanterior() {
		return arraymovimientoanterior;
	}
	public void setArraymovimientoanterior(ArrayList<ImageIcon> arraymovimientoanterior) {
		this.arraymovimientoanterior = arraymovimientoanterior;
	}
	public JLabel getLabelatravesar() {
		return labelatravesar;
	}
	public void setLabelatravesar(JLabel labelatravesar) {
		this.labelatravesar = labelatravesar;
	}
	public JLabel getLevelup() {
		return levelup;
	}
	public void setLevelup(JLabel levelup) {
		this.levelup = levelup;
	}
	public boolean isClick() {
		return click;
	}
	public void setClick(boolean click) {
		this.click = click;
	}
	public PanelMinimapa getMinimapa() {
		return minimapa;
	}
	public void setMinimapa(PanelMinimapa minimapa) {
		this.minimapa = minimapa;
	}
	public ArrayList<ImageIcon> getArraymovimientoenemigos() {
		return arraymovimientoenemigos;
	}
	public void setArraymovimientoenemigos(ArrayList<ImageIcon> arraymovimientoenemigos) {
		this.arraymovimientoenemigos = arraymovimientoenemigos;
	}
	public ArrayList<ImageIcon> getArraymovimientoanteriorenemigos() {
		return arraymovimientoanteriorenemigos;
	}
	public void setArraymovimientoanteriorenemigos(ArrayList<ImageIcon> arraymovimientoanteriorenemigos) {
		this.arraymovimientoanteriorenemigos = arraymovimientoanteriorenemigos;
	}
	public JPanel getPnlprincipal() {
		return pnlprincipal;
	}
	public void setPnlprincipal(JPanel pnlprincipal) {
		this.pnlprincipal = pnlprincipal;
	}
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
	
	public JLayeredPane getPanelfondo() {
		return panelfondo;
	}
	public void setPanelfondo(JLayeredPane panelfondo) {
		this.panelfondo = panelfondo;
	}
	
	
	public List<Enemigos> getEnemigos() {
		return enemigos;
	}
	public void setEnemigos(List<Enemigos> enemigos) {
		this.enemigos = enemigos;
	}
	//CONSTRUCTOR
	public VentanaMapa(Jugador player){	
		ImageIcon icono5 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/MAPABLANCO4.png");
		Image image = icono5.getImage();
		BufferedImage mapacolisiones = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		mapacolisiones.createGraphics().drawImage(image, 0, 0, null);
		this.mapacolisiones = mapacolisiones;
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
	    panelfondo = new JLayeredPane();
	    panelfondo.setPreferredSize(new Dimension(8000,8000));
        panelfondo.setBackground(Color.cyan);
        panelfondo.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pnlprincipal= new JPanel();
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
		imagenfinal = new ImageIcon(imagenparadibujar);
		map = new JLabel(imagenfinal);
		
		
		ImageIcon iconcueva = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/MAPACONCUEVAS.png");
		ImageIcon imagencueva = new ImageIcon(iconcueva.getImage().getScaledInstance(12288,12288,Image.SCALE_SMOOTH));
		Image i2cueva = imagencueva.getImage();
		BufferedImage imagenparadibujarcueva = new BufferedImage(i2cueva.getHeight(null), i2cueva.getWidth(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2dcueva = imagenparadibujarcueva.createGraphics();
		g2dcueva.drawImage(i2cueva, 0, 0, null);
		g2dcueva.dispose();
		imagenfinalcueva = new ImageIcon(imagenparadibujarcueva);
		
		
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
		lblplayer.setIcon(this.getArraymovimiento().get(1));
		
		
		//ENEMIGOS Y SPRITES
		enemigos = new ArrayList<>();
		generarEnemigos();
		
//		new Timer(500, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent ae) {
//				actualizarEnemigos();
//			}
//		}).start();
		
		
		
		
		/*JLabel test = new JLabel();
		test.setBounds(100,100, 57,431);
		test.setOpaque(true);
		test.setBackground(Color.red);
		panelfondo.add(test);
		panelfondo.setComponentZOrder(test, 1);*/
		
		
		//GENERAR CARTELES
		
		lblcartel = new JLabel("enemigo", SwingConstants.CENTER);
		lblcartel.setOpaque(true);
		lblcartel.setBackground(new Color(0,0,0,128));
		lblcartel.setForeground(Color.white);
		lblcartel.setFont(new Font("Arial", Font.BOLD, 20));
		lblcartel.setBounds(100,100,60,30);
		lblcartel.setVisible(false);
		panelfondo.add(lblcartel);
		panelfondo.setComponentZOrder(lblcartel, 1);
		
		//generar dialogom -- LISTADOS TODOS LOS DIALOGOS PARA LA HISTORIA
		
		Dialogo d1= new Dialogo("Te has encontrado con un viejo sabio. ¿Qué quieres preguntarle?", Arrays.asList("Sobre la vida", "Sobre la aventura", "Salir"));
		Dialogo d2 = new Dialogo("Encuentras un cofre misterioso. ¿Deseas abrirlo?", Arrays.asList("Abrir", "Ignorar"));
		
		
//		new Timer(10, new ActionListener() { // Este temporizador se ejecutará cada 100 milisegundos.
//		    @Override
//		    public void actionPerformed(ActionEvent ae) {
//		        verificarDialogo(243, 440, d1);
//		       // System.out.println("entra");// Verifica si el jugador está cerca de (243,440) y muestra el diálogo d1.
//		        actualizarEnemigos(); // Sigue actualizando la posición de los enemigos.
//		    }
//		}).start();

	
;
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
                	Hiloataque hiloat = new Hiloataque(lblplayer, VentanaMapa.this, x,0);
                	hiloat.start();
                	try {
						hiloat.join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	Hiloataque hiloat2 = new Hiloataque(lblplayer, VentanaMapa.this, x,1);
                	hiloat2.start();
                	for(Enemigos enem: enemigos) {
                	if(enem.isVivo()) {
                		
                		
                		if(x > anchoventana/2 - anchoventana/10) {	
                			if (enem.distancia(player) < 100 && enem.getX() > player.getPosx()) {
                				enem.setHealth(enem.getHealth()-10);
                				if (enem.getHealth() <= 0) {
                					//enemigos.remove(enem);
                					enem.setArrayenuso(enem.muerte);
                					enem.setVivo(false);
                					player.setExperiencia(player.getExperiencia() + 10);
                				}
                				//System.out.print(enem.getHealth());
                			}
                		}
                		
                		else {	
                			if (enem.distancia(player) < 100 && enem.getX() <= player.getPosx()) {
                				enem.setHealth(enem.getHealth()-10);
                				if (enem.getHealth() <= 0) {
                					//enemigos.remove(enem);
                					enem.setVivo(false);
                					enem.setArrayenuso(enem.muerte);
                					player.setExperiencia(player.getExperiencia() + 10);
                				}
                				//System.out.print(enem.getHealth());
                			}
                		}
                		
                	}	
                		
                	}
                }
            }
        });
		
	}
	
	
	//generar DIALOGO
	
	public void mostrarDialogo(Dialogo dialogo) {
		JLabel lbltxt = new JLabel("<html" + dialogo.getTxt() + "</html");
		lbltxt.setBounds(100, altoventana-100, anchoventana-200, 50);
		lbltxt.setBackground(Color.white);
		lbltxt.setOpaque(true);
		panelfondo.add(lbltxt);
		
		int posy = altoventana-50;
		for(int i = 0; i <dialogo.getOpc().size(); i++) {
			JLabel lblop = new JLabel(dialogo.getOpc().get(i));
			lblop.setBounds(100, posy, anchoventana-200, 30);
			lblop.setBackground(Color.LIGHT_GRAY);
			lblop.setOpaque(true);
			final int a = i;
			lblop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dialogo.setSelec(a);
					//System.out.println("opcion" + dialogo.getOpc().get(a));
					panelfondo.remove(lbltxt);
					panelfondo.remove(lblop);
					panelfondo.repaint();
				}
			});
			panelfondo.add(lblop);
			posy +=35;
			}
		panelfondo.repaint();
	}
	
	public void verificarDialogo(int x, int y, Dialogo d) {
		int jx = player.getPosx();
		int jy = player.getPosy();
		double dis = Math.sqrt(Math.pow(x- jx, 2)+ Math.pow(y-jy, 2));
		//System.out.println("distancia al punto" + dis);
		boolean dialogoMostrado;
		if(dis < ddistdetect) {
			mostrarDialogo(d);
			dialogoMostrado = true;
		}else {
			dialogoMostrado = false;
		}
	}

	private void mostrarCartel(Jugador player, Enemigos enem) {
			//System.out.println(e.distancia(player));
			if(enem.isVivo() == true) {
					//System.out.println("mostrando informacion");
					lblcartel.setText("\u2665 " + enem.getHealth());
					lblcartel.setLocation(enem.getLabel().getX(), enem.getLabel().getY() -50);
					lblcartel.setVisible(true);
					return;		
			}
		//System.out.println("ocultando");
		lblcartel.setVisible(false);
	}
	private boolean areapermitida(int x, int y) {
		int color = this.mapacolisiones.getRGB(x, y);
		Color colorp = new Color(color);
		return colorp.getRed() > 240 && colorp.getGreen() > 240 && colorp.getBlue() >240;
	}

	private void generarEnemigos() {
		Random r = new Random();
		for(int i = 0; i<50; i++) {
			int rx, ry;	
				 rx = r.nextInt(4096) ; 
				 ry = r.nextInt(4096) ;
			while(!areapermitida(rx, ry)) {
				rx = r.nextInt(4096) ; 
				ry = r.nextInt(4096) ;
			}
			Slime e = new Slime();
			e.setX(3*rx );
			e.setY(3*ry );
			enemigos.add(e);
			this.panelfondo.add(e.getLabel());
			this.panelfondo.setComponentZOrder(e.getLabel(),1);	
		}	
		for(int i = 0; i<50; i++) {
			int rx, ry;	
				 rx = r.nextInt(4096) ; 
				 ry = r.nextInt(4096) ;
			while(!areapermitida(rx, ry)) {
				rx = r.nextInt(4096) ; 
				ry = r.nextInt(4096) ;
			}
			Bat e = new Bat();
			e.setX(3*rx );
			e.setY(3*ry );
			enemigos.add(e);
			this.panelfondo.add(e.getLabel());
			this.panelfondo.setComponentZOrder(e.getLabel(),1);	
		}	
		for(int i = 0; i<50; i++) {
			int rx, ry;	
				 rx = r.nextInt(4096) ; 
				 ry = r.nextInt(4096) ;
			while(!areapermitida(rx, ry)) {
				rx = r.nextInt(4096) ; 
				ry = r.nextInt(4096) ;
			}
			Goblin e = new Goblin();
			e.setX(3*rx );
			e.setY(3*ry );
			enemigos.add(e);
			this.panelfondo.add(e.getLabel());
			this.panelfondo.setComponentZOrder(e.getLabel(),1);	
		}
			
	}
	private void actualizarEnemigos() {
		for(Enemigos e: enemigos) {		
			if(e.distancia(player) < 1000 ) {
				//System.out.println(e.getDerecha());
				
				if (e.getContadorsprite() + 1> e.getArrayenuso().size()*20) {
					e.setContadorsprite(0);
				}
				if(e.getContadorsprite() % 20 == 0) {
					e.getLabel().setIcon(e.getArrayenuso().get(e.getContadorsprite()/20));
					e.getLabel().setVisible(true);
				}
				 e.setContadorsprite(e.getContadorsprite()+1);
//				System.out.println("Posicion   " + e.getX() + "  "+ e.getY());
//				System.out.println("Distancia   " + e.distancia(player));
//				System.out.println("Jugador" + player.getPosx() + "   " + player.getPosy());
			}
		}
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
		Enemigos emascercano = enemigos.get(0);
		actualizarEnemigos();
		for(Enemigos e: enemigos) {
			if(e.isVivo() == true) {
				JLabel lblenemigo = e.getLabel();
				int nPx = (int) (e.getX() + -player.getPosx() -anchoventana/20);
				int nPy = (int) (e.getY() + -player.getPosy() -altoventana/12);
				lblenemigo.setLocation(nPx, nPy);
				if (e.distancia(player) > 1000) {
					e.getLabel().setVisible(false);
				}
				else {
					e.moveToPlayer(player, mapacolisiones);
					e.getLabel().setVisible(true);
				}
				if(e.distancia( player) < 100 && e.getContadorsprite() == 20) {
					player.setVidarestante(player.getVidarestante()- e.getDaño());
					e.setArrayenuso(e.getAtaquenemigo());
					
				}
				if(e.distancia(player) < emascercano.distancia(player)) {
					emascercano = e;
				}
				
			}
			else {
				JLabel lblenemigo = e.getLabel();
				int nPx = (int) (e.getX() + -player.getPosx() -anchoventana/20);
				int nPy = (int) (e.getY() + -player.getPosy() -altoventana/12);
				lblenemigo.setLocation(nPx, nPy);
				if (e.distancia(player) > 1000) {
					e.getLabel().setVisible(false);
				}
				else {
					//e.getLabel().setVisible(false);
				}
				
			}
		}
		mostrarCartel(player, emascercano);


		if(teclaw == true || teclaa == true || teclas == true || teclad == true) {
			
			if(this.getArraymovimiento() == null) {
				return;
			}
			if (contadorsprites + 1 > this.getArraymovimiento().size()*10) {
				contadorsprites = 0;
			}
			if(contadorsprites % 10 == 0) {
				lblplayer.setIcon(this.getArraymovimiento().get(contadorsprites/10));
			}
			contadorsprites ++;
			
			
			if (atravesando == true) {
				labelatravesar.setVisible(true);
				lblplayer.setVisible(false);
				map.setIcon(imagenfinalcueva);
				map.setVisible(true);
			}
			//System.out.print(player.getStaminarestante() + "/" + player.getStaminatotal());
			else {
				labelatravesar.setVisible(false);
				lblplayer.setVisible(true);
				map.setIcon(imagenfinal);
				map.setVisible(true);
			}
		
			if(this.getAumentoprogresivoexp() % 100 == 0) {
				player.setExperiencia(player.getExperiencia()+1);			
			}
			this.setAumentoprogresivoexp(this.getAumentoprogresivoexp() + 1);
			this.player = player;
			if (player.getExperiencia() > 200) {
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