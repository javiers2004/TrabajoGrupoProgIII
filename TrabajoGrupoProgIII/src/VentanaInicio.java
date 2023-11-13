
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener {
   // private JPanel panel;
	private JPanel pSur,pNorte,pEste,pOeste,pCentro;
    private JButton botonPlay, boton4, botonEstads, botonNombre;
    private JLabel lblTitulo;
    private JFrame va;
    
    private String nombreUsuario; // Variable para almacenar el nombre
    private DefaultMutableTreeNode rootNode; // Nodo raíz para el árbol
    private static final String NOMBRES_FILE = "nombres.txt";
    private ArrayList<String> nombres; // Lista para almacenar los nombres

    
    private VentanaAudio player;
    private VentanaAjustes ventanaAjustes;
    
    
    public VentanaInicio(JFrame ven1, VentanaAudio player) {
        this.player = player;

        //super();
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

        botonPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonEstads.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonNombre.setCursor(new Cursor(Cursor.HAND_CURSOR));

    
        rootNode = new DefaultMutableTreeNode("Estadísticas"); // Inicializar rootNode
        nombres = new ArrayList<>();
        cargarArbolNombre();

    /*EVENTOS*/
        botonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar si el nombre ya se ha configurado
                if (nombreUsuario == null) {
                    // Si el nombre no se ha configurado, solicitarlo al usuario
                    nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre:");
                    if (nombreUsuario != null) {
                        JOptionPane.showMessageDialog(null, "Hola, " + nombreUsuario + "!");
                        botonNombre.setEnabled(false); // Deshabilitar el botón después de ingresar el nombre
                        nombres.add(nombreUsuario); // Agregar el nombre a la lista
                       // guardarArbolNombre();


                    }
                }
            }
        });
    
    
    
    botonEstads.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Verificar si el nombre ya se ha configurado
            if (nombreUsuario == null) {
                // Si el nombre no se ha configurado, solicitarlo al usuario
                nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre:");
                if (nombreUsuario != null) {
                    JOptionPane.showMessageDialog(null, "Hola, " + nombreUsuario + "!");
                    nombres.add(nombreUsuario); // Agregar el nombre a la lista

                }
            }

            // Crear un JTree con la carpeta inicial "estadisticas"
            rootNode = new DefaultMutableTreeNode("Estadísticas");
            
            cargarArbolNombre();
            
            // Si el nombre se ha configurado, agregarlo como un nodo
            if (nombreUsuario != null) {
                rootNode.add(new DefaultMutableTreeNode(nombreUsuario));
            }

            // Mostrar el árbol en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, new JScrollPane(new JTree(rootNode)));

            // Guardar el árbol con el nombre en el archivo
            guardarArbolNombre();
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
			            //robot.keyRelease(KeyEvent.VK_W);    
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				}
			};
			hilorobot.start();
		}
	});
 
 	
 	
      
    
    boton4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ventanaAjustes == null) {
                ventanaAjustes = new VentanaAjustes(player);
            } else {
                ventanaAjustes.setVisible(true);
            }
        }
    });


    
    
    
    
    }
    // Método para cargar el árbol con los nombres desde el archivo

 // Método para guardar los nombres en el archivo (solo una vez)
 // Método para cargar los nombres desde el archivo y agregarlos al árbol
 // Método para cargar los nombres desde el archivo y agregarlos al árbol
 // Método para cargar los nombres desde el archivo y agregarlos al árbol
    private void cargarArbolNombre() {
        File archivo = new File(NOMBRES_FILE);

        // Verificar si el archivo no existe y crearlo si es necesario
        if (!archivo.exists()) {
            try {
                archivo.createNewFile(); // Crea el archivo si no existe
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (archivo.exists() && archivo.isFile() && archivo.length() > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Agregar cada nombre como un nodo al árbol
                    DefaultMutableTreeNode nombreNode = new DefaultMutableTreeNode(linea);
                    rootNode.add(nombreNode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    // Método para guardar la lista completa de nombres en el archivo al cierre de la aplicación
    private void guardarArbolNombre() {
        File archivo = new File(NOMBRES_FILE);

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            for (String nombre : nombres) {
                pw.println(nombre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

  }  

