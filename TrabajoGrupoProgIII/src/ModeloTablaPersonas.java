import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ModeloTablaPersonas extends DefaultTableModel {
    private List<Jugador>listaJugadores;
	public final List<String> titulos = Arrays.asList("NOMBRE","NIVEL","EXPERIENCIA","VIDARESTANTE","POSX","POSY","VIDATOTAL",
			"NUMERO DE GOLPES","DISTANCE","GOLPES EFECTIVOS","DAÑO INFLINGIDO","DAÑO RECIBIDO");

	
	public ModeloTablaPersonas(String nombreusuario) throws SQLException {
		 try (Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");
	                PreparedStatement psNombres = connection.prepareStatement("SELECT NOMBRE FROM PARTIDAS");
					java.sql.Statement statement = connection.createStatement();

	                ResultSet resultSetNombres = psNombres.executeQuery()) {

	            boolean estaba = false;
	            while (resultSetNombres.next()) {
	                String nombre = resultSetNombres.getString("NOMBRE");
	                if (nombre != null && nombre.equals(nombreusuario)) {
	                    estaba = true;
	                    System.out.println("name correcto");

	                    break;
	                }
	            }

	            if (estaba) {
	            	try {
	                    	ResultSet resultSetEstadisticas = statement.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE LIKE '"+ nombreusuario +"'");                 
	                        Vector<Object> v = new Vector<>();
	                        v.add(resultSetEstadisticas.getString("NOMBRE"));
	                        v.add(resultSetEstadisticas.getInt("NIVEL"));
	                        v.add(resultSetEstadisticas.getInt("EXPERIENCIA"));
	                        v.add(resultSetEstadisticas.getInt("VIDA"));
	                        v.add(resultSetEstadisticas.getInt("POSX"));
	                        v.add(resultSetEstadisticas.getInt("POSY"));
	                        v.add(resultSetEstadisticas.getInt("VIDATOTAL"));
	                        v.add(resultSetEstadisticas.getInt("NUMERODEGOLPES"));
	                        v.add(resultSetEstadisticas.getInt("DISTANCE"));
	                        v.add(resultSetEstadisticas.getInt("GOLPESEFECTIVOS"));
	                        v.add(resultSetEstadisticas.getInt("DANOINFLINGIDO"));
	                        v.add(resultSetEstadisticas.getInt("DANORECIBIDO"));
	                        System.out.println(v);
//	                        this.addRow(v);	                        
	                        this.addRow(new Object[] {resultSetEstadisticas.getString("NOMBRE"), resultSetEstadisticas.getInt("NIVEL"), resultSetEstadisticas.getInt("EXPERIENCIA"), resultSetEstadisticas.getInt("VIDA"), resultSetEstadisticas.getInt("POSX"), resultSetEstadisticas.getInt("POSY"), resultSetEstadisticas.getInt("VIDATOTAL"), resultSetEstadisticas.getInt("NUMERODEGOLPES"), resultSetEstadisticas.getInt("DISTANCE"), resultSetEstadisticas.getInt("GOLPESEFECTIVOS"), resultSetEstadisticas.getInt("DANOINFLINGIDO"), resultSetEstadisticas.getInt("DANORECIBIDO") });
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS: " + e.getMessage());
	                }
	            }
	        }
    }
	
//	@Override
//	public String getColumnName(int column) {
//		return titulos.get(column);
//	}
//	
//	@Override
//	public int getColumnCount() {
//		return titulos.size();
//	}
//	
//	@Override
//	public int getRowCount() {
//		if(listaJugadores == null)
//			return 0;
//		return listaJugadores.size();
//	}
	
//	@Override
//	public boolean isCellEditable(int row, int column) {
//		/*if(column==0)
//			return false;
//		return true;*/
//		return false;
//	}
	
//	@Override
//	public Object getValueAt(int row, int column) {
//		Jugador j = listaJugadores.get(row);
//		switch(column) {
//			case 0: return j.getNombre();
//			case 1: return j.getNivel();
//			case 2: return j.getExperiencia();
//			case 3: return j.getVidarestante();
//			case 4: return j.getPosx();
//			case 5: return j.getPosy();
//			case 6: return j.getVidatotal();
//			case 7: return j.getNumerodegolpes();
//			case 8: return j.getDistance();
//			case 9: return j.getGoplesefectivos();
//			case 10: return j.getDanoinflingido();
//			case 11: return j.getDanorecibido();
//
//
//
//			default: return null;
//		}
//	}
	
	
}
	


