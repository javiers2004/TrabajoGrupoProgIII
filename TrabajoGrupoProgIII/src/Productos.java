import java.io.*;
import java.util.ArrayList;

public class Productos {
    public ArrayList<Item> productos; // ArrayList público de items
    private String rutaArchivo = "Inventario.txt"; // Ruta del archivo para guardar y cargar el inventario
    

    public Productos() {
    	productos = new ArrayList<>();
    	productos.add(new ItemAtaqueCorto("Daga Afilada", "img/sword.png", 50, 0.75, 30));
    	productos.add(new ItemAtaqueLargo("Arco", "img/arco.png", 30, 5, 40));
    }

    // Método para guardar la lista de items en un archivo
    public void guardarInventario() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            out.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de items desde un archivo
    public void cargarInventario() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
        	productos = (ArrayList<Item>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos para manipular el inventario
}