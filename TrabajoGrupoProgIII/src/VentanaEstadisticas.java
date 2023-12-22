import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaEstadisticas extends JFrame {

    public VentanaEstadisticas(String nombreusuario) throws SQLException {
        int ancho = 1000;
        int alto = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (screenSize.width - ancho) / 2;
        int yPos = (screenSize.height - alto) / 2;
        setSize(ancho, alto);
        setLocation(xPos, yPos);
        
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"NOMBRE","NIVEL","EXPERIENCIA","VIDARESTANTE","POSX","POSY","VIDATOTAL",
				"NUMERO DE GOLPES","DISTANCE","GOLPES EFECTIVOS","DAÑO INFLINGIDO","DAÑO RECIBIDO"},0);
//		modelo.addRow(new Object[] {1,2,3,4,5,6,7,8,9,10,11,13});

		
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
                        System.out.println(v);
                      
                        
                        
                        modelo.addRow(v);      
//                        modelo.addRow(new Object[] {1,2,3,4,5,6,7,8,9,10,11,12});
//                        modelo.addRow(new Object[] {resultSetEstadisticas.getString("NOMBRE"), resultSetEstadisticas.getInt("NIVEL"), resultSetEstadisticas.getInt("EXPERIENCIA"), resultSetEstadisticas.getInt("VIDA"), resultSetEstadisticas.getInt("POSX"), resultSetEstadisticas.getInt("POSY"), resultSetEstadisticas.getInt("VIDATOTAL"), resultSetEstadisticas.getInt("NUMERODEGOLPES"), resultSetEstadisticas.getInt("DISTANCE"), resultSetEstadisticas.getInt("GOLPESEFECTIVOS"), resultSetEstadisticas.getInt("DANOINFLINGIDO"), resultSetEstadisticas.getInt("DANORECIBIDO") });
               } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS: " + e.getMessage());
                }
            }
		

//        ModeloTablaPersonas mod = new ModeloTablaPersonas(nombreusuario);
        JTable table = new JTable(modelo);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150); // Set your preferred width
            table.getColumnModel().getColumn(i).setMinWidth(100); // Set the minimum width
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
         
    }
}
