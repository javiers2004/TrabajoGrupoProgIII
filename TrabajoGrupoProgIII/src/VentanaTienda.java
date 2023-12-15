import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        

        // Crear el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Ícono", "Nombre", "Precio", "Daño", "Cooldown","Curacion"}, 0) {
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
        for (Item item : producto.producto) {
            modelo.addRow(new Object[]{createImageIcon(item.getIcono()), item.getNombre(), item.getCoste(), item.getNombre()});
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
                    	Item selectedItem = productos.productos.get(selectedRow);
                    	itembuffer = selectedRow;
                    	System.out.println(itembuffer);
                    	try {
                            Image img = ImageIO.read(new File(selectedItem.getIcono()));
                            Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            iconoProducto.setIcon(new ImageIcon(resizedImage));
                            detallesProducto.setText("Nombre: " + selectedItem.getNombre() + "\nDaño: ");
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
            	if (productos.productos.isEmpty()){
            		System.out.println("sin productos en la tienda");
            	}else {
            		System.out.println(inventario.inventario);
                	System.out.println(productos.productos);
                	inventario.inventario.add(productos.productos.get(itembuffer));
                	productos.productos.remove(itembuffer);
                	System.out.println(inventario.inventario);
                	System.out.println(productos.productos);
                	DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                	model.setRowCount(0);
                	for (Item item : productos.productos) {
                        modelo.addRow(new Object[]{createImageIcon(item.getIcono()), item.getDaño(), item.getDaño(), item.getNombre()});
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