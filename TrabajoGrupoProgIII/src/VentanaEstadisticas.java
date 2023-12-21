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
        int ancho = 800;
        int alto = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (screenSize.width - ancho) / 2;
        int yPos = (screenSize.height - alto) / 2;
        setSize(ancho, alto);
        setLocation(xPos, yPos);

        ModeloTablaPersonas mod = new ModeloTablaPersonas();
        JTable table = new JTable(mod);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");
             PreparedStatement psNombres = connection.prepareStatement("SELECT NOMBRE FROM PARTIDAS");
             ResultSet resultSetNombres = psNombres.executeQuery()) {

            boolean estaba = false;
            while (resultSetNombres.next()) {
                String nombre = resultSetNombres.getString("NOMBRE");
                if (nombre != null && nombre.equals(nombreusuario)) {
                    estaba = true;
                    break;
                }
            }

            if (estaba) {
            	try {
                    ResultSet resultSetEstadisticas =  psNombres.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE LIKE '" + nombreusuario+ "'");

                        Vector<Object> v = new Vector<>();
                        v.add(resultSetEstadisticas.getInt("NOMBRE"));
                        v.add(resultSetEstadisticas.getInt("EXPERIENCIA"));
                        v.add(resultSetEstadisticas.getInt("VIDA"));
                        v.add(resultSetEstadisticas.getInt("POSX"));
                        v.add(resultSetEstadisticas.getInt("POSY"));
                        v.add(resultSetEstadisticas.getInt("VIDATOTAL"));
                        v.add(resultSetEstadisticas.getInt("NUMERODEGOLPES"));
                        v.add(resultSetEstadisticas.getInt("DISTANCE"));
                        v.add(resultSetEstadisticas.getInt("GOPLESEFECTIVOS"));
                        v.add(resultSetEstadisticas.getInt("DANOINFLINGIDO"));
                        v.add(resultSetEstadisticas.getInt("DANORECIBIDO"));
                        ((DefaultTableModel) table.getModel()).addRow(v);
                    
                
            

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS: " + e.getMessage());
        }
         }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        }
    }
}
