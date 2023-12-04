import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class VentanaTienda extends JFrame {
    private Tienda tienda;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    public VentanaTienda(Tienda tienda) {
        this.tienda = tienda;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Configuración de la ventana
        setTitle("Inventario de la Tienda");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Modelo para el JTable
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Fecha de Compra");

        // Crear JTable con el modelo
        tablaProductos = new JTable(modeloTabla);

        // Agregar productos al modelo de la tabla
        cargarProductosEnTabla();

        // Agregar JTable a un JScrollPane y luego agregarlo a la ventana
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cargarProductosEnTabla() {
        // Limpiar la tabla antes de cargar los datos
        modeloTabla.setRowCount(0);

        for (Producto producto : tienda.getListaProductos()) { // Asegúrate de tener un método getListaProductos en Tienda
            modeloTabla.addRow(new Object[]{
                producto.getTipo(),
                producto.getPrecio(),
                producto.getFechaCompra().toString()
            });
        }
    }

    // Método principal para probar la ventana
    public static void main(String[] args) {
        // Crear una instancia de Tienda y agregar algunos productos
        Tienda miTienda = new Tienda(500.0);
        miTienda.agregarProducto("Pistola", 200.0, LocalDate.now());
        miTienda.agregarProducto("Rifle", 300.0, LocalDate.now());

        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            VentanaTienda ventana = new VentanaTienda(miTienda);
            ventana.setVisible(true);
        });
    }
}
