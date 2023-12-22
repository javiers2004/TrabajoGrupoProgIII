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

        ModeloTablaPersonas mod = new ModeloTablaPersonas(nombreusuario);
        JTable table = new JTable(mod);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
       

        
         
    }
}
