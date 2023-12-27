package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class testBaseDeDatos {

	
	@Test
	public void pruebaBase() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatosdelaspartidas.db");			//ESTA URL PUEDE SER TANTO LOCVAL COMO REMOTA
			java.sql.Statement statement = connection.createStatement();
			ArrayList<String> nombres = new ArrayList<String>();
			ResultSet resultSet = statement.executeQuery("SELECT NOMBRE FROM PARTIDAS");
			while (resultSet.next()) {
				String nombre = resultSet.getString("NOMBRE");
				nombres.add(nombre);
			}	
			for(String nombre: nombres) {
				ResultSet resultSet2 = statement.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE LIKE '" + nombre + "'");
				if(resultSet2.getInt("POSX") > 0 && resultSet2.getInt("POSX")<14400 && resultSet2.getInt("POSY") > 0 && resultSet2.getInt("POSY") < 14400) {
					}
				else {
				fail("POSICIONES NO VÁLIDAS"); //NOS ASEGURAMOS QUE LA POSICIÓN DE CADA UNO DE LOS USUARIOS ESTÉ DENTRO DEL MAPA
				}
				if(resultSet2.getInt("VIDA") <=resultSet2.getInt("VIDATOTAL") ) {
					
				}
				else {
				fail("VIDA NO VÁLIDA");	//TAMBIÉN QUE SU VIDA ACTUAL NO SEA MAYOR QUE LA MÁXIMA PERMITIDA
				}
				if(resultSet2.getInt("EXPERIENCIA") > 200 || resultSet2.getInt("EXPERIENCIA") < 0) {
					fail("CANTIDAD DE EXPERIENCIA NO VÁLIDA");	// Y QUE SU EXPERIENCIA ESTÉ DENTRO DE LOS VALORES POSIBLES(0-200)
				}
			}
			connection.close();
		}
		catch(SQLException e) {	
		}
	}
}

