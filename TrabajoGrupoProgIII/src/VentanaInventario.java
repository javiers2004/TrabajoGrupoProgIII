import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class VentanaInventario extends JFrame {

    private static final int ICON_WIDTH = 32; // Ancho deseado para el ícono
    private static final int ICON_HEIGHT = 32; // Altura deseada para el ícono
    public static int itembuffer;


    // Constructor de la ventana
    public VentanaInventario() {
        setTitle("Ventana de Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        
        Objetos inventario = Jugador.getInventario();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Jugador.setInventario(inventario);
            }
        });

        // Cargar y ajustar el tamaño de la imagen para el lado izquierdo
        ImageIcon iconoOriginal = new ImageIcon("img/descarga.png"); // Asegúrate de que la ruta relativa sea correcta.
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon imagenAjustada = new ImageIcon(imagenEscalada);
        JLabel etiquetaImagen = new JLabel(imagenAjustada);
        add(etiquetaImagen, BorderLayout.WEST);

        // Panel derecho con layout de caja para alinear verticalmente los subpaneles
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

        // Panel superior para consumibles y subpaneles de progreso
        JPanel panelConsumibles = new JPanel();
        panelConsumibles.setLayout(new GridLayout(4, 1)); // 4 filas para el título y cada subpanel
        JLabel etiquetaConsumibles = new JLabel("Consumibles: " + Jugador.getConsumibles());
        panelConsumibles.add(etiquetaConsumibles);

	    // Consumible 1
        JPanel subPanel1 = new JPanel();
        
        // Crear un icono para el JLabel
        ImageIcon iconoConsumible1 = createImageIcon("img/fuerza.png"); // Reemplaza con la ruta correcta del icono
        JLabel titulo1 = new JLabel(iconoConsumible1);

        JProgressBar progressBar1 = new JProgressBar(0, 100);
        progressBar1.setValue(Jugador.getMejoraataque()*10); // Valor inicial
        JButton boton1 = new JButton("+");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aumentar el valor de la barra de progreso
            	if (Jugador.getConsumibles() > 0) {
	                if (progressBar1.getValue() < 100) {
	                    progressBar1.setValue(progressBar1.getValue() + 10);
	                    Jugador.setConsumibles(Jugador.getConsumibles() - 1);;
	                    Jugador.setMejoraataque(Jugador.getMejoraataque() + 1);
	                    etiquetaConsumibles.setText("Consumibles: " + Jugador.getConsumibles());
	                }
            	}
            }
        });

        subPanel1.add(titulo1);
        subPanel1.add(progressBar1);
        subPanel1.add(boton1);
        panelConsumibles.add(subPanel1);
        
     // Consumible 1
        JPanel subPanel2 = new JPanel();
        
        // Crear un icono para el JLabel
        ImageIcon iconoConsumible2 = createImageIcon("img/velocidad.png"); // Reemplaza con la ruta correcta del icono
        JLabel titulo2 = new JLabel(iconoConsumible2);

        JProgressBar progressBar2 = new JProgressBar(0, 100);
        progressBar2.setValue(Jugador.getMejoravelocidad()*10); // Valor inicial
        JButton boton2 = new JButton("+");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aumentar el valor de la barra de progreso
            	if (Jugador.getConsumibles() > 0) {
	                if (progressBar2.getValue() < 100) {
	                    progressBar2.setValue(progressBar2.getValue() + 10);
	                    Jugador.setConsumibles(Jugador.getConsumibles() - 1);;
	                    Jugador.setMejoravelocidad(Jugador.getMejoravelocidad() + 1);
	                    etiquetaConsumibles.setText("Consumibles: " + Jugador.getConsumibles());
	                }
            	}
            }
        });

        subPanel2.add(titulo2);
        subPanel2.add(progressBar2);
        subPanel2.add(boton2);
        panelConsumibles.add(subPanel2);
        
     // Consumible 1
        JPanel subPanel3 = new JPanel();
        
        // Crear un icono para el JLabel
        ImageIcon iconoConsumible3 = createImageIcon("img/escudo.png"); // Reemplaza con la ruta correcta del icono
        JLabel titulo3 = new JLabel(iconoConsumible3);

        JProgressBar progressBar3 = new JProgressBar(0, 100);
        progressBar3.setValue(Jugador.getMejoravida()*10); // Valor inicial
        JButton boton3 = new JButton("+");
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aumentar el valor de la barra de progreso
            	if (Jugador.getConsumibles() > 0) {
	                if (progressBar3.getValue() < 100) {
	                    progressBar3.setValue(progressBar3.getValue() + 10);
	                    Jugador.setConsumibles(Jugador.getConsumibles() - 1);;
	                    Jugador.setMejoravida(Jugador.getMejoravida() + 1);
	                    etiquetaConsumibles.setText("Consumibles: " + Jugador.getConsumibles());
	                }
            	}
            }
        });

        subPanel3.add(titulo3);
        subPanel3.add(progressBar3);
        subPanel3.add(boton3);
        panelConsumibles.add(subPanel3);

        // Añadir el panel de consumibles al panel derecho
        panelDerecho.add(panelConsumibles);

        // Modelo de la tabla personalizado para manejar íconos
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Ícono", "Nombre", "Daño", "Cura", "Coste", "Descripción", "Cooldown"},0) {
            @Override
            public boolean isCellEditable(int row, int column) {
            	// TODO Auto-generated method stub
            	return false;
            }
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? ImageIcon.class : Object.class;
            }
        };

        // Crear y agregar los ítems al modelo de la tabla
        
        for (Item item : inventario.getInventario()) {
        	if (item.isComprado() == true){
        		if (item instanceof ItemAtaqueCorto) {
        	        ItemAtaqueCorto ataqueCorto = (ItemAtaqueCorto) item;
        	        modelo.addRow(new Object[]{
        	            createImageIcon(ataqueCorto.getIcono()), 
        	            ataqueCorto.getNombre(), 
        	            ataqueCorto.getDaño(), 
        	            "", // cura bacio
        	            ataqueCorto.getCoste(),
        	            ataqueCorto.getDescripcion(),
        	            ataqueCorto.getCooldown()
        	        });
        	    } else if (item instanceof ItemCura) {
        	        ItemCura cura = (ItemCura) item;
        	        modelo.addRow(new Object[]{
        	            createImageIcon(cura.getIcono()), 
        	            cura.getNombre(), 
        	            "", // daño bacio
        	            cura.getCuracion(), 
        	            cura.getCoste(),
        	            cura.getDescripcion(),
        	            cura.getCooldown()
        	        });
        	    }
        	}
            
        }

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(50); // Ajustar la altura de las filas para los íconos
        tabla.setSelectionBackground(Color.WHITE);
        tabla.setSelectionForeground(Color.RED); 

        // Renderizador de celdas para mostrar íconos
        tabla.setDefaultRenderer(ImageIcon.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null) {
                    JLabel label = new JLabel();
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setIcon((ImageIcon) value);
                    return label;
                }
                return new JLabel();
            }
        });
        
        ArrayList<Item> objetosComprados = inventario.getInventarioComprados();
        
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow != -1) {
                    	Item selectedItem = objetosComprados.get(selectedRow);
                    	itembuffer = selectedRow;
                    	System.out.println(itembuffer);
                    }
                }
            }
        });
 
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelDerecho.add(scrollPane);

        // Añadir el panel derecho al JFrame
        add(panelDerecho, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Método para crear un ImageIcon a partir de una ruta de archivo y redimensionarlo
    private ImageIcon createImageIcon(String path) {
        try {
            Image img = ImageIO.read(new File(path));
            Image resizedImage = img.getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int getObjetoselectdaño() {
    	Objetos inventario = new Objetos();
    	ArrayList<Item> objetosComprados = inventario.getInventarioComprados(); 
    	Item itemSeleccionado = objetosComprados.get(itembuffer);
    	return (int) ((ItemAtaqueCorto) itemSeleccionado).getDaño();
    }
}
