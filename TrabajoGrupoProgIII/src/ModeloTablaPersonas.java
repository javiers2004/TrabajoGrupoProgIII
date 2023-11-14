import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloTablaPersonas extends DefaultTableModel {
    public ModeloTablaPersonas() {
        super(new Object[]{"Columna 1", "Columna 2", "Columna 3", "Columna 4"}, 0);
        // Aquí puedes añadir datos a tu tabla si lo necesitas
    }
}

