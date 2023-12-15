import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ModeloTablaPersonas extends DefaultTableModel {
    private List<Jugador>listaJugadores;
	private final List<String> titulos = Arrays.asList("1","COLOR","CONSUMO");

	
	public ModeloTablaPersonas(List<Jugador>jugadores) {
        listaJugadores = jugadores; 
    }
	
	
	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
		
}
	


