import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	/**
	 * Método que realiza la conexión con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*Al ejecutar una sentencia sql tenemos 2 opciones:
	  - Modificar la base de datos: CREATE TABLE, UPDATE, DELETE, INSERT, DROP, MODIFY
	  				st.executeUpdate(sql);
	  				
	  - No modifica la base de datos, sólo accede al contenido: SELECT
	                ResultSet rs = st.executeQuery(sql);
	  */
	public static void crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Jugador ( nom String, nivel String)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearTablaPartida(Connection con) {
	    String sql = "CREATE TABLE IF NOT EXISTS Partida (" +
	        "nombre TEXT, " +
	        "nivel INTEGER" +
	        ");";

	    try {
	        Statement st = con.createStatement();
	        st.executeUpdate(sql);
	        st.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static Jugador buscarJugador(Connection con, String nombre) {
		
		String sql = String.format("SELECT * FROM Jugador WHERE nom='%s'", nombre);
		Jugador j = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { //Comprobamos si rs está apuntando a una tupla de la tabla
				String nomb = rs.getString("nom");
				String nive = rs.getString("nivel");
				j = new Jugador(nomb, nive);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}
	
	
	
	public static void insertarJugador(Connection con, Jugador j) {
		if(buscarJugador(con, j.getNombre())==null) {
			String sql = String.format("INSERT INTO Jugador VALUES('%s','%s');", j.getNombre(),j.getNivelStr());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void guardarPartida(Connection con, Jugador jugador) {
	    String sql = "INSERT INTO Partida (nombre, nivel) VALUES (?, ?)";
	    try (PreparedStatement pst = con.prepareStatement(sql)) {
	        pst.setString(1, jugador.getNombre());
	        pst.setInt(9, jugador.getNivel());
	        
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}






