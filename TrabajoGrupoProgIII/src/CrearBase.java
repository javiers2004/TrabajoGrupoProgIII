import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBase {
	//NO EJECUTAR MAS QUE UNA VEZ
public static void main(String[] args) {
	try {
		Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("NO ESTÁ CONECTADA LA LIBRERIA");
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");			//ESTA URL PUEDE SER TANTO LOCAL COMO REMOTA
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS PARTIDAS");
			statement.executeUpdate("CREATE TABLE PARTIDAS(NOMBRE VARCHAR, "
					+ "NIVEL INT, "
					+ "EXPERIENCIA INT,"
					+ "VIDA INT, "
					+ "POSX INT, "
					+ "POSY INT, "
					+ "VIDATOTAL INT,"
					+ "NUMERODEGOLPES INT, "
					+ "DISTANCE INT, "
					+ "GOLPESEFECTIVOS INT, "
					+ "DANOINFLINGIDO INT, "
					+ "DANORECIBIDO INT, "
					+ "STAMINATOTAL INT, "
					+ "SLIMES INT, "
					+ "PAJAROS INT, "
					+ "MURCIELAGOS INT, "
					+ "CAPARAZONES INT, "
					+ "PUERCOESPINES INT, "
					+ "GOBLINS INT, "
					+ "MVIDA INT, "
					+ "MVELOCIDAD INT, "
					+ "MATAQUE INT, "
					+ "CONSUMIBLES INT, "
					+ "PRIMARY KEY(NOMBRE))");
			statement.executeUpdate("DROP TABLE IF EXISTS OBJETOS");
			//statement.executeUpdate("CREATE TABLE OBJETOS(CODIGO INT, NOMBRE VARCHAR, PRIMARY KEY (CODIGO)");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR EN LA GESTIÓN DE LA BASE DE DATOS");

		}	
}
}
