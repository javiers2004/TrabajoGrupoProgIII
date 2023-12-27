import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;




public class VentanaMapa extends JFrame implements KeyListener{
	//ATRIBUTOS
	private Boss b;
	public JLabel redWall;
	private List<Component> cdialogo = new ArrayList<>();
	public E2 ele;
	public J2 jo;
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
	protected VentanaInicio veninicio;
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
    public boolean continuar = false;
	public JLayeredPane panelfondo;
	protected List<Enemigos> enemigos;
	public JPanel pnlprincipal;
	protected ArrayList<ImageIcon> arraymovimientoenemigos;
	protected ArrayList<ImageIcon> arraymovimientoanteriorenemigos;
	protected BufferedImage mapacolisiones;
	protected ImageIcon imagenfinalcueva;
	protected ImageIcon imagenfinal;
	protected static float fps;
	protected Enemigos e;
	protected int aumentoprogresivoexp= 0;
	protected String nombreplayer;
	//GETTERS Y SETTERS

	protected float getFps() {
		return fps;
	}
	protected String getNombreplayer() {
		return nombreplayer;
	}
	protected void setNombreplayer(String nombreplayer) {
		this.nombreplayer = nombreplayer;
	}
	protected void setFps(float fps) {
		this.fps = fps;
	}
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
	public void setContinuar(boolean continuar) {
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
	protected VentanaInicio getVeninicio() {
		return veninicio;
	}
	protected void setVeninicio(VentanaInicio veninicio) {
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
	
	
   // private VentanaInicio ventanaInicio;

  
	//CONSTRUCTOR
	public VentanaMapa(Jugador player  ){
	    this.player = player;  
		ImageIcon icono5 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/MAPABLANCO4.png");
		Image image = icono5.getImage();
		BufferedImage mapacolisiones = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		mapacolisiones.createGraphics().drawImage(image, 0, 0, null);
		this.mapacolisiones = mapacolisiones;
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        guardarDatosPartida();
		        getVeninicio().setVisible(true);  
		        VentanaMapa.this.setContinuar(false);
		    }

		    
		    //ole
		    
		    
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
        ImageIcon iconofondo = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/OIP.jpg");
		ImageIcon imagenfondo = new ImageIcon(iconofondo.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH));
		fondo = new JLabel();
		fondo.setIcon(imagenfondo);
		fondo.setBounds(0, 0, screenSize.width , screenSize.height);
		panelfondo.add(fondo, JLayeredPane.PALETTE_LAYER);
		panelfondo.setComponentZOrder(fondo, 0);
		//AÑADIR EL MAPA PRINCIPAL
		ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/MAPADEFINITIVO.png");
		ImageIcon imagen = new ImageIcon(icon.getImage().getScaledInstance(12288,12288,Image.SCALE_SMOOTH));
		Image i2 = imagen.getImage();
		BufferedImage imagenparadibujar = new BufferedImage(i2.getHeight(null), i2.getWidth(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = imagenparadibujar.createGraphics();
		g2d.drawImage(i2, 0, 0, null);
		g2d.dispose();
		imagenfinal = new ImageIcon(imagenparadibujar);
		map = new JLabel(imagenfinal);		
		//MAPA DE CUEVAS Y TRONCOS
		ImageIcon iconcueva = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/MAPACONCUEVAS2.png");
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
		//AÑADIR MINIMAPA
		PanelMinimapa minimapa = new PanelMinimapa(imagenfinal);
		minimapa.setLocation(1225,525);
		minimapa.setVisible(true);
		panelfondo.add(minimapa);
		panelfondo.setComponentZOrder(minimapa, 0);
		this.minimapa = minimapa;
		//LABEL DEL CIRCULO AL ATRAVESAR ZONAS
		labelatravesar = new JLabel();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/imagenatravesar.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_SMOOTH));
		labelatravesar.setIcon(imagen3);
		labelatravesar.setBounds(0, 0, screenSize.width , screenSize.height);
		labelatravesar.setVisible(false);
		panelfondo.add(labelatravesar, JLayeredPane.PALETTE_LAYER);
		panelfondo.setComponentZOrder(labelatravesar, 1);
		//LABEL DE AUMENTO DE NIVEL
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
		generarEnemigos2.start();
		generarNpc.start();
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
		drawWall();
		
		jo = new J2();
		 System.out.println("si");
			((Enemigos) jo).getLabel().setVisible(false);
			((Enemigos) VentanaMapa.this.jo).setX(865);
			((Enemigos) VentanaMapa.this.jo).setY(10000);
			VentanaMapa.this.panelfondo.add(((Enemigos) VentanaMapa.this.jo).getLabel());
			VentanaMapa.this.panelfondo.setComponentZOrder(VentanaMapa.this.jo.getLabel(), 3);
			((Enemigos) jo).getLabel().setVisible(true);
		
			
		ele = new E2();
		System.out.println("sisi");
		ele.getLabel().setVisible(false);
		VentanaMapa.this.ele.setX(3380);
		VentanaMapa.this.ele.setY(10200);
		VentanaMapa.this.panelfondo.add(this.ele.getLabel());
		VentanaMapa.this.panelfondo.setComponentZOrder(VentanaMapa.this.ele.getLabel(), 3);
		((Enemigos) ele).getLabel().setVisible(true);
		
		b = new Boss();
		b.getLabel().setVisible(false);
		VentanaMapa.this.b.setX(3385);
		VentanaMapa.this.b.setY(10200);
		VentanaMapa.this.panelfondo.add(this.b.getLabel());
		VentanaMapa.this.panelfondo.setComponentZOrder(VentanaMapa.this.b.getLabel(), 3);
		((Enemigos) b).getLabel().setVisible(true);
		enemigos.add(b);
		
		
		redWall = new JLabel();
			redWall.setOpaque(true);
			this.redWall.setBackground(Color.red);
			this.redWall.setBounds(0, 0, 100, 100);
			this.panelfondo.add(this.redWall);
			this.panelfondo.setComponentZOrder(this.redWall, 3);
			this.redWall.setVisible(false);
			
			
		jo.getLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jo.siguiente();
				mostrarDialogo(jo.actual);
			}
		});
		ele.getLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ele.siguiente();
				mostrarDialogo(ele.actual);
			}
		});
		
		//generar dialogom -- LISTADOS TODOS LOS DIALOGOS PARA LA HISTORIA
		
		Dialogo d1= new Dialogo("Te has encontrado con un viejo sabio. ¿Qué quieres preguntarle?", Arrays.asList("Sobre la vida", "Sobre la aventura", "Salir"));
		Dialogo d2 = new Dialogo("Encuentras un cofre misterioso. ¿Deseas abrirlo?", Arrays.asList("Abrir", "Ignorar"));
		
		Dialogo dialogonpc1 = new Dialogo("Hola aventurero, ¿qué necesitas?", Arrays.asList("Opción 1", "Opción 2", "Salir"));
		/*npc1 = new npc(1122,10122,dialogonpc1);
		//panelfondo.add(npc1.getLabel());
		npc1.getLabel().setLocation(3* npc1.getX()- player.getPosx(), 3*npc1.getY() - player.getPosy() );
		npc1.getLabel().setVisible(true);
		this.panelfondo.add(npc1.getLabel());
		this.panelfondo.setComponentZOrder(npc1.getLabel(), 3);
//		new Timer(10, new ActionListener() { // Este temporizador se ejecutará cada 100 milisegundos.
//		    @Override
//		    public void actionPerformed(ActionEvent ae) {
//		        verificarDialogo(243, 440, d1);
//		       // System.out.println("entra");// Verifica si el jugador está cerca de (243,440) y muestra el diálogo d1.
//		        actualizarEnemigos(); // Sigue actualizando la posición de los enemigos.
//		    }
//		}).start();
		joana = new Joana(player.getPosx()+100, player.getPosy());
		joana.getLabel().setLocation(3* joana.getX() - player.getPosx(),3 * joana.getY() - player.getPosy());
		joana.getLabel().setVisible(true);
        this.panelfondo.add(joana.getLabel());
        this.panelfondo.setComponentZOrder(joana.getLabel(), 3);*/

		
		/*J2 j = new J2();
		enemigos.add(j);
		panelfondo.add(j.getLabel());
		panelfondo.setComponentZOrder(j.getLabel(), 1);
		j.getLabel().setLocation(900, 10000);
		j.getLabel().setVisible(true);*/
		
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
		//PARA EL ATAQUE DE LA ESPADA
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                player.setNumerodegolpes(player.getNumerodegolpes()+1);
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
                			//ATAQUE A LA DERECHA
                			if(x > anchoventana/2) {	
                				//&& enem.getX() > player.getPosx() -400
                				if (enem.distancia(player) < 100 ) {
                					enem.setHealth(enem.getHealth()-10 - Jugador.getMejoraataque());
                					player.setGoplesefectivos(player.getGoplesefectivos() + 1);
                					player.setDanoinflingido(player.getDanoinflingido() + 10 + Jugador.getMejoraataque());
                					if (enem.getHealth() <= 0) {
                						enem.setArrayenuso(enem.muerte);
                						enem.setVivo(false);
                						player.setExperiencia(player.getExperiencia() + enem.getExperiencia());
                						
                						player.getEstadisticas().put(enem.getClass(), player.getEstadisticas().get(enem.getClass()) + 1);
                						
                						
                						//System.out.println(player.getEstadisticas());
                					}
                				}
                			}    
                			//ATAQUE A LA IZQUIERDA
                			else {	
                				//&& enem.getX() - anchoventana/2 <= player.getPosx()
                				if (enem.distancia(player) < 100 ) {
                					enem.setHealth(enem.getHealth()-10 - Jugador.getMejoraataque());
                					player.setGoplesefectivos(player.getGoplesefectivos() + 1);
                					player.setDanoinflingido(player.getDanoinflingido() + 10 + Jugador.getMejoraataque());
                					if (enem.getHealth() <= 0) {
                						enem.setVivo(false);
                						enem.setArrayenuso(enem.muerte);
                						player.setExperiencia(player.getExperiencia() + enem.getExperiencia());
                						if(player.getEstadisticas().containsKey(enem.getClass())) {
                							player.getEstadisticas().put(enem.getClass(), player.getEstadisticas().get(enem.getClass()) + 1);
                						}
                						else {
                							player.getEstadisticas().put(enem.getClass(), 1);
                						}
                						System.out.println(player.getEstadisticas());
                					}
                				}
                			}
                		}	          		
                	}
                }
            }
        });		
	}
	
	public void drawWall(){
		Graphics2D g2d = mapacolisiones.createGraphics();
		g2d.setColor(Color.red);
		g2d.fillRect(3380, 10200, 100, 100);
		g2d.dispose();
	}
	
	//generar DIALOGO
	public void keyPressed1(KeyEvent e1) {
		if(e1.getKeyCode() == KeyEvent.VK_ESCAPE) {
			cerrar();
		}
	}
	public void movimientoSprite() {
		
		Timer timer = new Timer(100, (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ele.incrementar();
				ele.getLabel().setIcon(ele.getActual());
				jo.incrementar();
				jo.getLabel().setIcon(jo.getActual());
			}
		});
		timer.start();
	}
	public void checkplayer(Jugador player) {
		if(player.getNivel() <7) {
			Rectangle playerb = lblplayer.getBounds();
			Rectangle wallb = redWall.getBounds();
			
			if(playerb.intersects(wallb)) {
				player.setPosx(wallb.x - playerb.width);
				JOptionPane.showMessageDialog(this, "necesitas ser nivel 7");
			}
			else {
			this.redWall.setVisible(false);
			}
		}
	}
	public void mostrarDialogo(Dialogo dialogo) {
		JLabel lbltxt = new JLabel( dialogo.getTxt());
		int alturaDialogo = 70; 
	    int alturaOpcion = 50;
	    Font fd = new Font("Arial", Font.BOLD,18);
	    
		int posy = altoventana-(dialogo.getOpc().size() * (alturaOpcion +5)) - alturaDialogo -100;
		lbltxt.setFont(fd);
		lbltxt.setBounds(100, posy, anchoventana-200, 50);
		lbltxt.setBackground(Color.white);
		lbltxt.setOpaque(true);
		panelfondo.add(lbltxt);
		panelfondo.setComponentZOrder(lbltxt, 3);
		cdialogo.add(lbltxt);
		posy +=70 +10;
		for(int i = 0; i <dialogo.getOpc().size(); i++) {
			JLabel lblop = new JLabel(dialogo.getOpc().get(i));
			lblop.setFont(fd);
			lblop.setBounds(100, posy, anchoventana-200, 50);
			lblop.setBackground(Color.LIGHT_GRAY);
			lblop.setOpaque(true);
			cdialogo.add(lblop);
			final int a = i;
			lblop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dialogo.setSelec(a);
					manageRespuesta(dialogo, a);
					//System.out.println("opcion" + dialogo.getOpc().get(a));
					panelfondo.remove(lbltxt);
					panelfondo.remove(lblop);
					panelfondo.repaint();
				}
			});
			panelfondo.add(lblop);
			panelfondo.setComponentZOrder(lblop, 3);
			posy +=alturaOpcion + 5;
			}
		panelfondo.repaint();
		this.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cerrar();
				}
			}
		});
		
	}
	public void cerrar() {
		for(Component c : cdialogo) {
			panelfondo.remove(c);
		}
		this.cdialogo.clear();
		//	this.removeKeyListener(this);
		panelfondo.repaint();
	}
	
	public void manageRespuesta(Dialogo d, int s) {
		Dialogo d1 = new Dialogo("¡Gracias! Por favor, ve al bosque oscuro y encuentra la cueva secreta.", Arrays.asList("Salir"));
		if(d.getTxt().equals("¡Hola, aventurero! Nuestra princesa Eleonore ha sido capturada por criaturas malvadas. ¿Puedes ayudarnos a rescatarla?")) {
			if(s == 0) {
				mostrarDialogo(new Dialogo("¡Gracias! Por favor, ve al bosque oscuro y encuentra la cueva secreta.", Arrays.asList("Entendido", "¿Alguna pista de dónde puedo empezar?")));
				
			}else if( s == 1) {
				mostrarDialogo(new Dialogo("Entiendo, quizás otro valiente aventurero pueda ayudarnos.", Arrays.asList("Quizás más tarde", "Buena suerte")));
	        }
			
		}else if(d.getTxt().equals("¡Gracias! Por favor, ve al bosque oscuro y encuentra la cueva secreta.")) {
			manageRespuesta(d1, 1);
			if(s == 1) {
				new Dialogo("Creo que puede que la tengan oculta en alguna de las numerosas cavermas repartidas por estos parajes...", null);
				
			}
			
		}else if(!d.getOpc().get(s).equals("Salir")) {
			
		}else {
			cerrar();
		}
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
					lblcartel.setText("<html><font color='red'>&#x2665;</font> " + enem.getHealth() +"</html>");
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
	Thread generarNpc = new Thread() {
		public void run() {
			while(true) {
				Joana j = new Joana(900,10000);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out.println("funciona");
						panelfondo.add(j.getLabel());
						panelfondo.setComponentZOrder(j.getLabel(), 1);
						j.getLabel().setVisible(true);
					}
				});
				return;
			}
		}
	};
	

	Thread generarEnemigos2 = new Thread() {
		public void run() {
		while(true) {
			
			/*int posJ = 900;
			int posYj = 10000;
			Joana j = new Joana(posJ, posYj);
			//j.getLabel().setLocation(3* posJ - player.getPosx(), 3* posYj - player.getPosy());
			j.getLabel().setLocation(posJ, posYj);
			j.getLabel().setVisible(true);
			VentanaMapa.this.panelfondo.add(j.getLabel());
			VentanaMapa.this.panelfondo.setComponentZOrder(j.getLabel(), 1);
			j.getLabel().setVisible(true);*/
			
			
			
		/*	int posE = 800;
			int posyE = 800;
			Eleanore ele = new Eleanore(posE, posyE);
			ele.getLabel().setLocation(posE, posyE);
			ele.getLabel().setVisible(true);
			VentanaMapa.this.panelfondo.add(ele.getLabel());
			VentanaMapa.this.panelfondo.setComponentZOrder(ele.getLabel(), 3);
			*/
			
			
			
			
			int contadorvivos = 0;
			for(Enemigos e : VentanaMapa.this.enemigos) {
				if(e.isVivo()) {
					contadorvivos++;
				}
			}
			if(contadorvivos < 200) {
				Random r = new Random();
				int n = (int)(Math.random()*7);
				int rx, ry;	
				rx = r.nextInt(4096) ; 
				ry = r.nextInt(4096) ;
				Enemigos e2 = new Enemigos();
				e2.setX(rx);
				e2.setY(ry);
				//&& e2.distancia(player) < 1000
				while(!areapermitida(rx, ry) ) {
					rx = r.nextInt(4096) ; 
					ry = r.nextInt(4096) ;
					e2.setX(rx);
					e2.setY(ry);
				}
				if(n == 0) {
					Slime e = new Slime();
					VentanaMapa.this.e = e;
				}
				else if(n == 1) {
					Bat e = new Bat();
					VentanaMapa.this.e = e;
				}
				else if(n == 2) {
					Goblin e = new Goblin();
					VentanaMapa.this.e = e;
				}
				else if(n == 3) {
					Caparazon e = new Caparazon();
					VentanaMapa.this.e = e;
				}
				else if(n == 4) {
					Puercoespin e = new Puercoespin();
					VentanaMapa.this.e = e;
				}
				else if(n == 10) {
					J2 e = new J2();
					VentanaMapa.this.e = e;
				}
				else {
					Pajaro e = new Pajaro();
					VentanaMapa.this.e = e;
				}
				e.getLabel().setVisible(false);
				VentanaMapa.this.e.setX(3*rx );
				VentanaMapa.this.e.setY(3*ry );
				enemigos.add(VentanaMapa.this.e);
				VentanaMapa.this.panelfondo.add(VentanaMapa.this.e.getLabel());
				VentanaMapa.this.panelfondo.setComponentZOrder(VentanaMapa.this.e.getLabel(),3);
				e.getLabel().setVisible(true);
				
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			 
			}
		}
	};
	private void actualizarEnemigos() {
		try {
		for(Enemigos e: enemigos) {		
			if(e.distancia(player) < 1000 ) {
				if(e instanceof Slime && e.isVivo() == false) {
					if (e.getContadorsprite() + 1> e.getArrayenuso().size()*40) {
						e.setContadorsprite(0);
					}
					if(e.getContadorsprite() % 40 == 0) {
						e.getLabel().setIcon(e.getArrayenuso().get(e.getContadorsprite()/40));
						e.getLabel().setVisible(true);
					}
					e.setContadorsprite(e.getContadorsprite()+1);
				}
				else if(!(e instanceof Caparazon) || e.getHealth() < 300) {
					if (e.getContadorsprite() + 1> e.getArrayenuso().size()*20) {
						e.setContadorsprite(0);
					}
					if(e.getContadorsprite() % 20 == 0) {
						e.getLabel().setIcon(e.getArrayenuso().get(e.getContadorsprite()/20));
						e.getLabel().setVisible(true);
					}
					e.setContadorsprite(e.getContadorsprite()+1);
//					System.out.println("Posicion   " + e.getX() + "  "+ e.getY());
//					System.out.println("Distancia   " + e.distancia(player));
//					System.out.println("Jugador" + player.getPosx() + "   " + player.getPosy());	
				}
				else if(b != null && b.isVivo()) {
					
				}
				else if(jo !=null && jo instanceof J2) {
					jo.incrementar();
					ImageIcon act = jo.getActual();
					jo.getLabel().setIcon(act);
				}
				else if(ele != null && ele instanceof E2) {
					ele.incrementar();
					ImageIcon act = ele.getActual();
					ele.getLabel().setIcon(act);
					}
				else {
					Caparazon c = (Caparazon) e;
					e.setArrayenuso(c.escondido);
					int valor = (int)(Math.random()*1000);
					if(valor == 1) {
						e.getLabel().setIcon(e.getArrayenuso().get(e.getContadorsprite()));
						e.getLabel().setVisible(true);
						e.setContadorsprite(e.getContadorsprite() + 1);
						if(e.getContadorsprite() > e.getMuerte().size()) {
							e.setContadorsprite(0);
						}
					}
				}
			}
		}
		}catch(ConcurrentModificationException e) {
			//System.out.println("salta");
		}
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
        		this.setArraymovimiento(this.getPlayer().getIzquierda());
        	} else if (keyChar == 'S') {
        		teclas = true;
        	} else if (keyChar == 'D') {
        		teclad = true;
        		this.setArraymovimiento(this.getPlayer().getDerecha());	
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
		System.out.println(player.getMejoraataque() + "   " + Jugador.getMejoravelocidad() + "   "+ player.getMejoravida());
		map.setLocation(-player.getPosx(), -player.getPosy());
		map.setVisible(true);
		Enemigos emascercano = enemigos.get(0);
		actualizarEnemigos();
		JLabel joana = jo.getLabel();
		int npx = jo.getX() -player.getPosx();
		int npy = jo.getY() - player.getPosy();
		joana.setLocation(npx, npy);
		
		int npxx = ele.getX() -player.getPosx();
		int npyy = ele.getY() - player.getPosy();
		JLabel eleonore = ele.getLabel();
		eleonore.setLocation(npxx, npyy);
		//enemigos.add(ele);
		//enemigos.add(jo);
		
		/**/
		int npxxx = 3235 -player.getPosx();
		int npyyy = 10100 -player.getPosy();
		JLabel w = this.redWall ;
		w.setLocation(npxxx, npyyy);
		
		
		
		if(player.getVidarestante() <= 0) {
			guardarDatosPartida();
			this.setContinuar(false);
			PanelMuerte panm = new PanelMuerte(this,(VentanaInicio) veninicio, veninicio.nombreUsuario);
			this.add(panm);
			panm.setVisible(true);
			this.setVisible(true);
			this.panelfondo.setVisible(false);
			this.pnlprincipal.setVisible(false);
			this.getLblplayer().setVisible(false); 
		}
		try {
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
					if(e instanceof Puercoespin) {
						for(Enemigos e2: enemigos) {
							if(e2.distancia(player) < 150) {
								e2.setHealth(e2.getHealth()-100);
								if (e2.getHealth() <= 0) {
	        						e2.setArrayenuso(e2.muerte);
	        						e2.setVivo(false);
	        						player.setExperiencia(player.getExperiencia() + e2.getExperiencia());
	        						if(player.getEstadisticas().containsKey(e2.getClass())) {
	        							player.getEstadisticas().put(e2.getClass(), player.getEstadisticas().get(e2.getClass()) + 1);
	        						}
	        						else {
	        							player.getEstadisticas().put(e2.getClass(), 1);
	        						}
	        						//System.out.println(player.getEstadisticas());
	        					}
							}
							
						}	
						if((int)(Math.random()*(15-Jugador.getMejoravida())) != 0){
							player.setVidarestante(player.getVidarestante()- e.getDaño());
							player.setDanorecibido(player.getDanorecibido() + e.getDaño());
							
						}
						e.setVivo(false);
						e.setArrayenuso(e.getMuerte());
						e.getLabel().setVisible(true);
					}			
					if((!(e instanceof Caparazon) || e.getHealth() < 300) && !(e instanceof Puercoespin)) {
						if((int)(Math.random()*(15-Jugador.getMejoravida())) != 0){
							player.setVidarestante(player.getVidarestante()- e.getDaño());
							player.setDanorecibido(player.getDanorecibido() + e.getDaño());
							e.setArrayenuso(e.getAtaquenemigo());
						}
						else {
							e.setArrayenuso(e.getAtaquenemigo());
						}
					}
				}
				if(e.distancia(player) < emascercano.distancia(player)) {
					emascercano = e;
				}
				if(e instanceof Caparazon && e.distancia(player) > 1000) {
					e.setHealth(300);
					Caparazon c = (Caparazon) e;
					c.getLabel().setIcon(c.escondido.get(0));
					c.setArrayenuso(c.escondido);
					c.setContadorsprite(0);				}		
			}
			else {
				JLabel lblenemigo = e.getLabel();
				int nPx = (int) (e.getX() + -player.getPosx() -anchoventana/20);
				int nPy = (int) (e.getY() + -player.getPosy() -altoventana/12);
				lblenemigo.setLocation(nPx, nPy);
				if (e.distancia(player) > 1000) {
					e.getLabel().setVisible(false);
				}	
			}	
		}
		
		/*joana.actualizarInter(player);
		if(joana.isEsInteractivo()) {
			joana.getDialogo();
		}
		npc1.actualizarInter(player);
		if(npc1.isEsInteractivo()) {
			//npc1.interactuar();
		}*/
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
				veninfo.barravida.setMaximum(player.getVidatotal());
				veninfo.barrastamina.setMaximum((int)player.getStaminatotal());
				veninfo.barravida.setVisible(true);
				veninfo.barrastamina.setVisible(true);
				player.setNivel(player.getNivel() + 1);
				player.setExperiencia(player.getExperiencia()-200);
				levelup.setVisible(true);
				HiloSubidaNivel hilosubidanivel = new HiloSubidaNivel(veninfo, this, player);
				hilosubidanivel.start();	
				levelup.setVisible(false);
				Jugador.setConsumibles(Jugador.getConsumibles()+2);				
			}
		}
		this.minimapa.actualizarPunto(player);
	}
	catch(ConcurrentModificationException e) {
		//System.out.println("salta");
	}
	}
	public void actualizarComponentes(Jugador player) {
		veninfo.actualizarPanelInfo(player);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	private void guardarDatosPartida() {
	    try {
	        Class.forName("org.sqlite.JDBC");
	    } catch (ClassNotFoundException e) {
	        // Manejar la excepción de una manera más específica o utilizar un sistema de registro adecuado
	        e.printStackTrace();
	        System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
	        return;
	    }

	    // Utilizar try-with-resources para garantizar el cierre de recursos
	    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db")) {
	        System.out.println("Conexión establecida con la base de datos");

	        // Verificar si el nombre ya existe en la base de datos
	        String nombrePlayer = this.getNombreplayer();
	        boolean estaba = false;

	        try (java.sql.Statement verificarStatement = connection.createStatement();
	             ResultSet verificarResultSet = verificarStatement.executeQuery("SELECT NOMBRE FROM PARTIDAS WHERE NOMBRE = '" + nombrePlayer + "'")) {

	            estaba = verificarResultSet.next();

	        }
	        if (!estaba) {
	            // Si el nombre no existe, realizar una inserción
	            String insertQuery = "INSERT INTO PARTIDAS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	                preparedStatement.setString(1, nombrePlayer);
	                preparedStatement.setInt(2, player.getNivel());
	                preparedStatement.setInt(3, player.getExperiencia());
	                preparedStatement.setInt(4, player.getVidarestante());
	                preparedStatement.setInt(5, player.getPosx());
	                preparedStatement.setInt(6, player.getPosy());
	                preparedStatement.setInt(7, player.getVidatotal());
	                preparedStatement.setInt(8, player.getNumerodegolpes());
	                preparedStatement.setInt(9, player.getDistance());
	                preparedStatement.setInt(10, player.getGoplesefectivos());
	                preparedStatement.setInt(11, player.getDanoinflingido());
	                preparedStatement.setInt(12, player.getDanorecibido());
	                preparedStatement.setInt(13,(int) player.getStaminatotal());
	                preparedStatement.setInt(14, player.getEstadisticas().get(Slime.class));
	                preparedStatement.setInt(15, player.getEstadisticas().get(Pajaro.class));
	                preparedStatement.setInt(16, player.getEstadisticas().get(Bat.class));
	                preparedStatement.setInt(17, player.getEstadisticas().get(Caparazon.class));
	                preparedStatement.setInt(18, player.getEstadisticas().get(Puercoespin.class));
	                preparedStatement.setInt(19, player.getEstadisticas().get(Goblin.class));
	                preparedStatement.setInt(20, Jugador.getMejoravida());
	                preparedStatement.setInt(21, Jugador.getMejoravelocidad());
	                preparedStatement.setInt(22, Jugador.getMejoraataque());
	                preparedStatement.setInt(23, Jugador.getConsumibles());
	                
	                
	                
	                preparedStatement.executeUpdate();
	            }
	        } else {
	            // Si el nombre ya existe, realizar una actualización
	            String updateQuery = "UPDATE PARTIDAS SET NIVEL=?, EXPERIENCIA=?, VIDA=?, POSX=?, POSY=?, VIDATOTAL=?, NUMERODEGOLPES=?, DISTANCE=?, GOLPESEFECTIVOS=?, DANOINFLINGIDO=?, DANORECIBIDO=?, STAMINATOTAL=?, SLIMES=?, PAJAROS=?, MURCIELAGOS=?,CAPARAZONES=?, PUERCOESPINES=?, GOBLINS=?, MVIDA=?, MVELOCIDAD=?, MATAQUE=?, CONSUMIBLES=? WHERE NOMBRE=?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                preparedStatement.setInt(1, player.getNivel());
	                preparedStatement.setInt(2, player.getExperiencia());
	                preparedStatement.setInt(3, player.getVidarestante());
	                preparedStatement.setInt(4, player.getPosx());
	                preparedStatement.setInt(5, player.getPosy());
	                preparedStatement.setInt(6, player.getVidatotal());
	                preparedStatement.setInt(7, player.getNumerodegolpes());
	                preparedStatement.setInt(8, player.getDistance());
	                preparedStatement.setInt(9, player.getGoplesefectivos());
	                preparedStatement.setInt(10, player.getDanoinflingido());
	                preparedStatement.setInt(11, player.getDanorecibido());
	                preparedStatement.setInt(12,(int) player.getStaminatotal());
	                preparedStatement.setString(23, nombrePlayer);
	                preparedStatement.setInt(13, player.getEstadisticas().get(Slime.class));
	                preparedStatement.setInt(14, player.getEstadisticas().get(Pajaro.class));
	                preparedStatement.setInt(15, player.getEstadisticas().get(Bat.class));
	                preparedStatement.setInt(16, player.getEstadisticas().get(Caparazon.class));
	                preparedStatement.setInt(17, player.getEstadisticas().get(Puercoespin.class));
	                preparedStatement.setInt(18, player.getEstadisticas().get(Goblin.class));
	                preparedStatement.setInt(19, Jugador.getMejoravida());
	                preparedStatement.setInt(20, Jugador.getMejoravelocidad());
	                preparedStatement.setInt(21, Jugador.getMejoraataque());
	                preparedStatement.setInt(22, Jugador.getConsumibles());

	                
	                
	                
	                
	                preparedStatement.executeUpdate();
	            }
				java.sql.Statement statement = connection.createStatement();
				if(Objetos.objetos != null) {
	            for(Item item: Objetos.objetos) {
	            	if(item.isComprado() == true) {
	            		statement.executeUpdate("INSERT INTO OBJETOS VALUES '" + item.getNombre().toString() + "','" + nombreplayer +"'");
	            	}
	            }
				}
	        }
	        connection.close();

	    } catch (SQLException e) {
	        // Manejar la excepción de una manera más específica o utilizar un sistema de registro adecuado
	        e.printStackTrace();
	        System.out.println("Error en la gestión de la base de datos: " + e.getMessage());
	    }
	}  
    public void actualizarJugadorDesdeArchivo() {
    	try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");			//ESTA URL PUEDE SER TANTO LOCVAL COMO REMOTA
			java.sql.Statement statement = connection.createStatement();
			ArrayList<String> nombres = new ArrayList<String>();
			ResultSet resultSet = statement.executeQuery("SELECT NOMBRE FROM PARTIDAS");
			while (resultSet.next()) {
				String nombre = resultSet.getString("NOMBRE");
	               	nombres.add(nombre);
	            }	
			boolean estaba = false;
			if(nombres.size() > 0) {
				for(String nombre : nombres) {
					if(nombre != null) {
						if(nombre.equals(this.getNombreplayer())) {
							estaba = true;
						}
					}
				}
			}
			if(estaba == true) {
				ResultSet resultSet2 = statement.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE LIKE '" + this.getNombreplayer() + "'");
				while (resultSet2.next()) {					
	                player.setNivel(resultSet2.getInt("NIVEL"));
	                player.setExperiencia(resultSet2.getInt("EXPERIENCIA"));
	                player.setVidarestante(resultSet2.getInt("VIDA"));
	                player.setPosx(resultSet2.getInt("POSX"));
	                player.setPosy(resultSet2.getInt("POSY"));
	                player.setVidatotal(resultSet2.getInt("VIDATOTAL"));
	                player.setNumerodegolpes(resultSet2.getInt("NUMERODEGOLPES"));
	                player.setDistance(resultSet2.getInt("DISTANCE"));
	                player.setGoplesefectivos(resultSet2.getInt("GOLPESEFECTIVOS"));
	                player.setDanoinflingido(resultSet2.getInt("DANOINFLINGIDO"));
	                player.setDanorecibido(resultSet2.getInt("DANORECIBIDO"));
	                player.setStaminatotal(resultSet2.getInt("STAMINATOTAL"));
	                player.getEstadisticas().put(Slime.class, resultSet2.getInt("SLIMES"));
	                player.getEstadisticas().put(Pajaro.class, resultSet2.getInt("PAJAROS"));
	                player.getEstadisticas().put(Bat.class, resultSet2.getInt("MURCIELAGOS"));
	                player.getEstadisticas().put(Caparazon.class, resultSet2.getInt("CAPARAZONES"));
	                player.getEstadisticas().put(Puercoespin.class, resultSet2.getInt("PUERCOESPINES"));
	                player.getEstadisticas().put(Goblin.class, resultSet2.getInt("GOBLINS"));
	                Jugador.setMejoravida(resultSet2.getInt("MVIDA"));
	                Jugador.setMejoravelocidad(resultSet2.getInt("MVELOCIDAD"));
	                Jugador.setMejoraataque(resultSet2.getInt("MATAQUE"));
	                Jugador.setConsumibles(resultSet2.getInt("CONSUMIBLES"));

	            }
			}
			ResultSet resultSet3 = statement.executeQuery("SELECT OBJ FROM OBJETOS WHERE NOMBRE LIKE '" + nombreplayer +"'");
			while (resultSet3.next()) {	
				 for(Item item: Objetos.objetos) {
					 if(item.getNombre().equals(resultSet3.getString("OBJ"))) {
						 item.setComprado(true);
					 }
				 }
			}
			statement.executeUpdate("DELETE FROM OBJETOS WHERE NOMBRE LIKE'"+ nombreplayer +"'");
			connection.close();
			//s
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS");

		}
    }
}