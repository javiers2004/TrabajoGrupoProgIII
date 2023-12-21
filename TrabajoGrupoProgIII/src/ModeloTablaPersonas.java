import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ModeloTablaPersonas extends DefaultTableModel {
    private List<Jugador>listaJugadores;
	public final List<String> titulos = Arrays.asList("NOMBRE","NIVEL","EXPERIENCIA","VIDARESTANTE","POSX","POSY","VIDATOTAL",
			"NUMERO DE GOLPES","DISTANCE","GOLPES EFECTIVOS","DAÑO INFLINGIDO","DAÑO RECIBIDO");

	
	public ModeloTablaPersonas() {
    }
	
	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}
	
	@Override
	public int getColumnCount() {
		return titulos.size();
	}
	
	@Override
	public int getRowCount() {
		if(listaJugadores == null)
			return 0;
		return listaJugadores.size();
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		/*if(column==0)
			return false;
		return true;*/
		return false;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Jugador j = listaJugadores.get(row);
		switch(column) {
			case 0: return j.getNombre();
			case 1: return j.getNivel();
			case 2: return j.getExperiencia();
			case 3: return j.getVidarestante();
			case 4: return j.getPosx();
			case 5: return j.getPosy();
			case 6: return j.getVidatotal();
			case 7: return j.getNumerodegolpes();
			case 8: return j.getDistance();
			case 9: return j.getGoplesefectivos();
			case 10: return j.getDanoinflingido();
			case 11: return j.getDanorecibido();



			default: return null;
		}
	}
	
	
}
	


