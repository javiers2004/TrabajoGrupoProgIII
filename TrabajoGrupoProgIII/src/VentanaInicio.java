
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener {
   // private JPanel panel;
	private JPanel pSur,pNorte,pEste,pOeste,pCentro;
    private JButton botonPlay, boton4, botonEstads, botonNombre;
    private JLabel lblTitulo;
    private JFrame va;
    
    public static String nombreUsuario;
    private DefaultMutableTreeNode rootNode; // Nodo raíz para el árbol
    private static final String NOMBRES_FILE = "nombres.txt";
    private ArrayList<String> nombres; // Lista para almacenar los nombres
    private ArrayList<Jugador> listaJugadores = new ArrayList<>(); // Lista para almacenar los jugadores

    private boolean tablaAbierta = false;
    private boolean botonPlayPresionado = false;

    
    private VentanaAudio player;
    private VentanaAjustes ventanaAjustes;
    
    private boolean insertado;
    public VentanaInicio(JFrame ven1, VentanaAudio player) {
        this.player = player;
        this.insertado = false;
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
		pNorte.setPreferredSize(new Dimension(this.getWidth(), 100)); // Establece aquí la altura que prefieras

		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pSur, BorderLayout.SOUTH);
			
		
		
		
        /*CREACIÓN BOTONES*/
		ImageIcon user1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/BotonesInicio/botonUser.png");
		Image u1 = user1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
		ImageIcon imagenUser = new ImageIcon(u1);
        botonNombre = new JButton();
        botonNombre.setIcon(imagenUser);
        botonNombre.setFocusPainted(false); // quitar resaltado al hacer clic
        botonNombre.setContentAreaFilled(false); // quitar fondo de color
        botonNombre.setBorderPainted(false); // quitar borde
        pCentro.add(botonNombre, BorderLayout.CENTER);
        
        
        ImageIcon play1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/BotonesInicio/botonPlay.png");
        Image p1 = play1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenPlay = new ImageIcon(p1);
        botonPlay = new JButton();
        botonPlay.setIcon(imagenPlay);
        botonPlay.setFocusPainted(false); // quitar resaltado al hacer clic
        botonPlay.setContentAreaFilled(false); // quitar fondo de color
        botonPlay.setBorderPainted(false); // quitar borde
        pCentro.add(botonPlay, BorderLayout.WEST);
        
        ImageIcon estads1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/BotonesInicio/botonEstads.png");
        Image e1 = estads1.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenEstads = new ImageIcon(e1);
        botonEstads = new JButton();
        botonEstads.setIcon(imagenEstads);
        botonEstads.setFocusPainted(false); // quitar resaltado al hacer clic
        botonEstads.setContentAreaFilled(false); // quitar fondo de color
        botonEstads.setBorderPainted(false); // quitar borde
        pCentro.add(botonEstads, BorderLayout.EAST);
        
        ImageIcon set1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/BotonesInicio/botonAjustes.png");
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
		
		/*CREACIÓN DE COMPONENTES*/	
			
		pNorte.setLayout(null);
		//lblTitulo = new JLabel("乇NΙGMΔ");
		lblTitulo = new JLabel("𝕮𝖆𝖓𝖙𝖆𝖗𝖊𝖘 𝖉𝖊 𝕴𝖇𝖊𝖗𝖎𝖆");
		lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
		lblTitulo.setForeground(Color.LIGHT_GRAY);

		// Ajustar el tamaño del label al tamaño preferido basado en el contenido
		lblTitulo.setSize(1000,100);
		// Establecer la posición inicial del label en el centro horizontal del pNorte
		lblTitulo.setLocation(0, pNorte.getHeight() / 2 - lblTitulo.getHeight() / 2);
		pNorte.add(lblTitulo);

		// Timer para mover el label de izquierda a derecha
		Timer timer = new Timer(10, new ActionListener() {
		    int deltaX = 1; // Velocidad de desplazamiento del label

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Calcula la nueva posición x del label
		        int newX = lblTitulo.getLocation().x + deltaX;

		        // Revisa si el label ha alcanzado los bordes del panel pNorte y cambia la dirección si es necesario
		        if (newX < 0 || newX + lblTitulo.getWidth() > pNorte.getWidth()) {
		            deltaX *= -1;
		        }

		        // Actualiza la posición x del label
		        lblTitulo.setLocation(newX, lblTitulo.getLocation().y);
		    }
		});

		// Iniciar el Timer
		timer.start();
					
	


    /*EVENTOS*/
        botonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre:");
                    if (nombreUsuario != null && nombreUsuario.length()> 0) {
                    	if(nombreUsuario.length() < 15) {
                    		JOptionPane.showMessageDialog(null, "Hola, " + nombreUsuario + "!");
                            nombres.add(nombreUsuario); // Agregar el nombre a la lista
                    	}
                    	else {
                    		JOptionPane.showMessageDialog(null, "Introduce un nombre más corto", "Información", JOptionPane.INFORMATION_MESSAGE);
                    		nombreUsuario = null;
                    	}
                    }
                    else {
                		JOptionPane.showMessageDialog(null, "Introduce un nombre válido", "Información", JOptionPane.INFORMATION_MESSAGE);
                		nombreUsuario = null;
                    }
            	}
        });
    
    
    
        botonEstads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(nombreUsuario == null) {
            		//NO SE HA INTRODUCIDO NOMBRE DE USUARIO
            		JOptionPane.showMessageDialog(null, "Introduce antes tu nombre de usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		try {
						VentanaEstadisticas venest = new VentanaEstadisticas(nombreUsuario);
						venest.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });


            
            

 
 botonPlay.addActionListener(new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(nombreUsuario != null) {
			VentanaMapa v1 = (VentanaMapa) ven1;
			if(v1.getNombreplayer() == null) {
				v1.setNombreplayer(nombreUsuario);
				v1.actualizarJugadorDesdeArchivo();
			}
			v1.continuar = true;
			botonPlayPresionado = true;
			v1.setVisible(true);	
			v1.setExtendedState(JFrame.MAXIMIZED_BOTH);

			
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
			dispose();
		}
			else {
				//NO SE HA INTRODUCIDO NOMBRE DE USUARIO
        		JOptionPane.showMessageDialog(null, "Introduce antes tu nombre de usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
        	
			}
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
    
    

    
    
    tablaAbierta = false;

    
    }

    
    
    
 // Método para cargar los nombres desde el archivo y agregarlos al árbol
    
    public String getNombreUsuario() {
		return nombreUsuario;
	}




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

    private void mostrarTabla() {
        if (tablaAbierta) {
            return; // Si la tabla ya está abierta, no hacer nada
        }

    }


    public void crearJugadoresDesdeNombres() {
        for (String nombre : nombres) {
            Jugador jugador = new Jugador(); // Crear un objeto Jugador sin nombre
            jugador.setNombre(nombre); // Establecer el nombre del jugador
            listaJugadores.add(jugador); // Añadir el jugador a la lista
        }
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    
    

	

  }  

