import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	        "nivel INTEGER, " +
	        "experiencia INTEGER, " +
	        "vidaRestante INTEGER, " +
	        "posX INTEGER, " +
	        "posY INTEGER" +  // Asegúrate de que esta sentencia esté correcta
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
	
    public static void cargarDatosDesdeArchivoYGuardar(Connection con, String rutaArchivo) {
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                // Parsear los datos. Asegúrate de que coincidan con tu estructura de archivo.
                String nombre = datos[0];
                int nivel = Integer.parseInt(datos[1]);
                int experiencia = Integer.parseInt(datos[2]);
                int vidaRestante = Integer.parseInt(datos[3]);
                int posX = Integer.parseInt(datos[4]);
                int posY = Integer.parseInt(datos[5]);

                // Insertar los datos en la base de datos
                String sql = "INSERT INTO Partida (nombre, nivel, experiencia, vidaRestante, posX, posY) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, nombre);
                    pst.setInt(2, nivel);
                    pst.setInt(3, experiencia);
                    pst.setInt(4, vidaRestante);
                    pst.setInt(5, posX);
                    pst.setInt(6, posY);

                    pst.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






