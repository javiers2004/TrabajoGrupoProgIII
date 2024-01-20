import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VentanaEstadisticas extends JFrame {

    public VentanaEstadisticas(String nombreusuario) throws SQLException {
        int ancho = 1000;
        int alto = 400;
        this.setTitle("ESTADÍSTICAS DE @" + nombreusuario);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (screenSize.width - ancho) / 2;
        int yPos = (screenSize.height - alto) / 2;
        setSize(ancho, alto);
        setLocation(xPos, yPos);
        
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"NOMBRE","NIVEL","EXPERIENCIA","VIDARESTANTE","POSX","POSY","VIDATOTAL",
				"NUMERO GOLPES","DISTANCE","GOLPES EFECTIVOS","DAÑO INFLINGIDO","DAÑO RECIBIDO", "ESTAMINA", "ENEMIGOS", "SLIMES","PAJAROS", "MURCIELAGOS", "CAPARAZONES", "PUERCOESPINES", "GOBLINS"},0) {
		
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Con esto, ninguna celda será editable.
		    }
		    
		    
		};
		
		
		
		modelo.addRow(new Object[] {"","","","","X","Y","","","","","","", "","","","","","",""});

		
				Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");
                PreparedStatement psNombres = connection.prepareStatement("SELECT NOMBRE FROM PARTIDAS");
				java.sql.Statement statement = connection.createStatement();
                ResultSet resultSetNombres = psNombres.executeQuery(); 

            boolean estaba = false;
            while (resultSetNombres.next()) {
                String nombre = resultSetNombres.getString("NOMBRE");
                if (nombre != null && nombre.equals(nombreusuario)) {
                    estaba = true;
                    System.out.println("name correcto");
                }
            }

            if (estaba) {
            	try {
                    	ResultSet resultSetEstadisticas = statement.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE LIKE '"+ nombreusuario +"'");                 
                        Vector<Object> v = new Vector<>();
                        v.add((String)resultSetEstadisticas.getString("NOMBRE"));
                        v.add((int)resultSetEstadisticas.getInt("NIVEL"));
                        v.add((int)resultSetEstadisticas.getInt("EXPERIENCIA"));
                        v.add((int)resultSetEstadisticas.getInt("VIDA"));
                        v.add((int)resultSetEstadisticas.getInt("POSX"));
                        v.add((int)resultSetEstadisticas.getInt("POSY"));
                        v.add((int)resultSetEstadisticas.getInt("VIDATOTAL"));
                        v.add((int)resultSetEstadisticas.getInt("NUMERODEGOLPES"));
                        v.add((int)resultSetEstadisticas.getInt("DISTANCE"));
                        v.add((int)resultSetEstadisticas.getInt("GOLPESEFECTIVOS"));
                        v.add((int)resultSetEstadisticas.getInt("DANOINFLINGIDO"));
                        v.add((int)resultSetEstadisticas.getInt("DANORECIBIDO"));
                        v.add((int)resultSetEstadisticas.getInt("STAMINATOTAL"));
                        v.add((int)resultSetEstadisticas.getInt("SLIMES")+ (int)resultSetEstadisticas.getInt("PAJAROS") +(int)resultSetEstadisticas.getInt("MURCIELAGOS")+(int)resultSetEstadisticas.getInt("CAPARAZONES")+(int)resultSetEstadisticas.getInt("PUERCOESPINES")+(int)resultSetEstadisticas.getInt("GOBLINS"));
                        v.add((int)resultSetEstadisticas.getInt("SLIMES"));
                        v.add((int)resultSetEstadisticas.getInt("PAJAROS"));
                        v.add((int)resultSetEstadisticas.getInt("MURCIELAGOS"));
                        v.add((int)resultSetEstadisticas.getInt("CAPARAZONES"));
                        v.add((int)resultSetEstadisticas.getInt("PUERCOESPINES"));
                        v.add((int)resultSetEstadisticas.getInt("GOBLINS"));
                        System.out.println(v);
                      
                        
                        
                        modelo.addRow(v);   
                        connection.close();
//                        modelo.addRow(new Object[] {1,2,3,4,5,6,7,8,9,10,11,12});
//                        modelo.addRow(new Object[] {resultSetEstadisticas.getString("NOMBRE"), resultSetEstadisticas.getInt("NIVEL"), resultSetEstadisticas.getInt("EXPERIENCIA"), resultSetEstadisticas.getInt("VIDA"), resultSetEstadisticas.getInt("POSX"), resultSetEstadisticas.getInt("POSY"), resultSetEstadisticas.getInt("VIDATOTAL"), resultSetEstadisticas.getInt("NUMERODEGOLPES"), resultSetEstadisticas.getInt("DISTANCE"), resultSetEstadisticas.getInt("GOLPESEFECTIVOS"), resultSetEstadisticas.getInt("DANOINFLINGIDO"), resultSetEstadisticas.getInt("DANORECIBIDO") });
               } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS: " + e.getMessage());
                }
            }
		
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {		
    			@Override
    			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    					boolean hasFocus, int row, int column) {
    				JLabel comp = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    				comp.setSize(100,100);
    				
    					comp.setHorizontalAlignment(JLabel.CENTER);
    				
    							  				
    				if (column == 0 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/NOMBRE.png");
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 1 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/NIVEL2.png");
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 2 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/NIVEL.png");
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 3 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/VIDARESTANTE.png");	
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 4 && row == 0) {
    					comp.setIcon(null);
    				}
    				else if (column == 5 && row == 0) {
    					comp.setIcon(null);
    				}
    				else if (column == 6 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/VIDA.png");
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 7 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/ATAQUE.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 8 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/DISTANCIA.png");	
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 9 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/GOLPES.png");		
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 10 && row ==0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/DANOINFLINGIDO.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 11 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/DANORECIVIDO.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 12 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/STAMINA.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 13 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/IconosEstadisticas/ENEMIGOS.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 14 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Slime/slime-attack-2.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 15 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Pajaro/pajarowalk0.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 16 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Bat/batmove1.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 17 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/caparazon/caparazonatack1.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 18 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Puercoespin/walk1.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else if (column == 19 && row == 0) {
    					ImageIcon icon = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Goblin/20.png");			
    					Image imagen = icon.getImage();
    					Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    					ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
    					comp.setIcon(iconRedimensionado);
    				}
    				else {
    					comp.setIcon(null);
    				}
    				if(isSelected) {
    					comp.setBackground(null);
    				}
    				return comp;
    			}	
    		};

    		
    		
    		
    		
    		
    		
//        ModeloTablaPersonas mod = new ModeloTablaPersonas(nombreusuario);
        JTable table = new JTable(modelo);
        
        
        
        
        table.setDefaultRenderer(Object.class, renderer);
		table.getTableHeader().setReorderingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150); // Set your preferred width
            table.getColumnModel().getColumn(i).setMinWidth(100); // Set the minimum width
        }
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            if(i == 6) {
            column.setMinWidth(190);
            column.setMaxWidth(190);
            }
            column.setMinWidth(120);
            column.setMaxWidth(120);
        }
        table.setRowHeight(100);
        
       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
         
    }
    
}
