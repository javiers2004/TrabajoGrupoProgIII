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

public class VentanaTienda extends JFrame {

    private JLabel iconoProducto;
    private JTextArea detallesProducto;
    private JButton botonComprar;
    public int itembuffer;
    private static final int ICON_WIDTH = 32; // Ancho deseado para el ícono
    private static final int ICON_HEIGHT = 32; // Altura deseada para el ícono

    public VentanaTienda() {
        setTitle("Tienda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        Objetos inventario = new Objetos();
        inventario.cargarObjetosBD();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	inventario.guardarObjetosBD();
            }
        });

        // Crear el modelo de la tabla
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
        for (Item item : inventario.objetos) {
        	if (item.isComprado() == false){
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
        
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow != -1) {
                    	Item selectedItem = inventario.objetos.get(selectedRow);
                    	itembuffer = selectedRow;
                    	System.out.println(itembuffer);
                    	try {
                            Image img = ImageIO.read(new File(selectedItem.getIcono()));
                            Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            iconoProducto.setIcon(new ImageIcon(resizedImage));
                            StringBuilder detalles = new StringBuilder();
                            detalles.append("Nombre: ").append(selectedItem.getNombre());

                            if (selectedItem instanceof ItemAtaqueCorto) {
                                ItemAtaqueCorto ataqueCorto = (ItemAtaqueCorto) selectedItem;
                                detalles.append("\nDaño: ").append(ataqueCorto.getDaño());
                                detalles.append("\nCoste: ").append(ataqueCorto.getCoste());
                                detalles.append("\nCooldown: ").append(ataqueCorto.getCooldown());
                                detalles.append("\nDescripción:\n").append(agregarSaltosLineaDescripcion(ataqueCorto.getDescripcion(), 8)); // Por ejemplo, cada 10 palabras
                            } else if (selectedItem instanceof ItemCura) {
                                ItemCura cura = (ItemCura) selectedItem;
                                detalles.append("\nCuración: ").append(cura.getCuracion());
                                detalles.append("\nCoste: ").append(cura.getCoste());
                                detalles.append("\nCooldown: ").append(cura.getCooldown());
                                detalles.append("\nDescripción:\n").append(agregarSaltosLineaDescripcion(cura.getDescripcion(), 8)); // Por ejemplo, cada 10 palabras
                            }

                            detallesProducto.setText(detalles.toString());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

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
        
        

        // Crear la tabla
        

        // Configurar la parte derecha para mostrar detalles del producto
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        iconoProducto = new JLabel(); // Aquí irá el icono del producto
        detallesProducto = new JTextArea(10, 30);
        detallesProducto.setEditable(false);
        botonComprar = new JButton("Comprar");
        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (inventario.objetos.isEmpty()){
            		System.out.println("sin productos en la tienda");
            	}else {
            		if (itembuffer >= 0 && itembuffer < inventario.objetos.size()) {
            		    Item itemSeleccionado = inventario.objetos.get(itembuffer);
            		    itemSeleccionado.setComprado(true);
            		    System.out.println("Ítem actualizado: " + itemSeleccionado);
            		} else {
            		    System.out.println("Índice de ítem inválido.");
            		}

                	for (Item item : inventario.objetos) {
                    	if (item.isComprado() == false){
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
            	}
            	
            }
        });

        panelDerecho.add(iconoProducto);
        panelDerecho.add(new JScrollPane(detallesProducto));
        panelDerecho.add(botonComprar);

        // Crear un JSplitPane para dividir la tabla y los detalles del producto
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tabla), panelDerecho);
        splitPane.setDividerLocation(400); // Ajustar según sea necesario

        add(splitPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private String agregarSaltosLineaDescripcion(String descripcion, int palabrasPorLinea) {
        String[] palabras = descripcion.split(" ");
        StringBuilder descripcionConSaltos = new StringBuilder();
        
        for (int i = 0; i < palabras.length; i++) {
            descripcionConSaltos.append(palabras[i]).append(" ");
            if ((i + 1) % palabrasPorLinea == 0) {
                descripcionConSaltos.append("\n");
            }
        }

        return descripcionConSaltos.toString().trim();
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
    

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaTienda());
    }

}