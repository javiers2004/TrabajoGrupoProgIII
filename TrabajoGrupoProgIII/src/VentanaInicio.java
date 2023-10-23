
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener {
   // private JPanel panel;
	private JPanel pSur,pNorte,pEste,pOeste,pCentro;
    private JButton botonPlay, boton4, botonEstads, botonNombre;
    private JLabel lblTitulo;
    private JFrame va;
    
    public VentanaInicio(JFrame ven1) {
        super();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        //this.setUndecorated(true); // Quitar la barra de título
        va = this;
        setTitle("");
        setBounds(400,400,600,400);
        // CREACION DE LOS PANELES
        pNorte = new JPanel();
        //pNorte.setBackground(Color.DARK_GRAY);
		pSur = new JPanel();
		pCentro = new JPanel(new GridLayout(1, 2));
		pEste = new JPanel(new GridLayout(2,1));
		pOeste = new JPanel();
	
		
		/*AÑADIR LOS PANELES AL PANEL PRINCIPAL DE LA VENTANA*/
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		/*CREACIÓN DE COMPONENTES*/	
		lblTitulo = new JLabel("BIENVENIDO A +EL JUEGO+ ");
		lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		lblTitulo.setForeground(Color.LIGHT_GRAY);
		pNorte.add(lblTitulo);
		
        /*CREACIÓN BOTONES*/
		ImageIcon user1 = new ImageIcon("img/botonUser.png");
		Image u1 = user1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
		ImageIcon imagenUser = new ImageIcon(u1);
        botonNombre = new JButton();
        botonNombre.setIcon(imagenUser);
        botonNombre.setFocusPainted(false); // quitar resaltado al hacer clic
        botonNombre.setContentAreaFilled(false); // quitar fondo de color
        botonNombre.setBorderPainted(false); // quitar borde
        pCentro.add(botonNombre, BorderLayout.CENTER);
        
        
        ImageIcon play1 = new ImageIcon("img/botonPlay.png");
        Image p1 = play1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenPlay = new ImageIcon(p1);
        botonPlay = new JButton();
        botonPlay.setIcon(imagenPlay);
        botonPlay.setFocusPainted(false); // quitar resaltado al hacer clic
        botonPlay.setContentAreaFilled(false); // quitar fondo de color
        botonPlay.setBorderPainted(false); // quitar borde
        pCentro.add(botonPlay, BorderLayout.WEST);
        
        ImageIcon estads1 = new ImageIcon("img/botonEstads.png");
        Image e1 = estads1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenEstads = new ImageIcon(e1);
        botonEstads = new JButton();
        botonEstads.setIcon(imagenEstads);
        botonEstads.setFocusPainted(false); // quitar resaltado al hacer clic
        botonEstads.setContentAreaFilled(false); // quitar fondo de color
        botonEstads.setBorderPainted(false); // quitar borde
        pCentro.add(botonEstads, BorderLayout.EAST);
        
        ImageIcon set1 = new ImageIcon("img/botonAjustes.png");
        Image s1 = set1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenS = new ImageIcon(s1);
        boton4 = new JButton();
        boton4.setIcon(imagenS);
        boton4.setFocusPainted(false); // quitar resaltado al hacer clic
        boton4.setContentAreaFilled(false); // quitar fondo de color
        boton4.setBorderPainted(false); // quitar borde
        pCentro.add(boton4, BorderLayout.SOUTH);
  
        
        // Configurar ventana
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    
    
    /*EVENTOS*/
    botonNombre.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
            if (nombre != null) {
                JOptionPane.showMessageDialog(null, "Hola, " + nombre + "!");
            }
		}
	});
    
 botonPlay.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ven1.setVisible(true);		
			setVisible(false);
			ven1.repaint();
			ven1.revalidate();
			Thread hilorobot = new Thread() {
				public void run() {
			        try {
			            Robot robot = new Robot();    
			            robot.keyPress(KeyEvent.VK_S);
			            Thread.sleep(100);
			            robot.keyRelease(KeyEvent.VK_S);
			            //robot.keyPress(KeyEvent.VK_D);
			            //Thread.sleep(900);          
			            //robot.keyRelease(KeyEvent.VK_D);
			            //Thread.sleep(400);	
			            //robot.keyPress(KeyEvent.VK_W);
			            //Thread.sleep(2400);		            
			           // robot.keyRelease(KeyEvent.VK_W);    
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				}
			};
			hilorobot.start();
		}
	});
      
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

  }  

