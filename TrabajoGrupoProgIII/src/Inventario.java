import java.io.*;
import java.util.ArrayList;

public class Inventario {
    public ArrayList<Item> inventario; // ArrayList público de items
    private String rutaArchivo = "Inventario.txt"; // Ruta del archivo para guardar y cargar el inventario
    

    public Inventario() {
        inventario = new ArrayList<>();
        inventario.add(new ItemAtaqueCorto("Espada Corta", "img/sword.png", 100, 1.5, 50));
    }

    // Método para guardar la lista de items en un archivo
    public void guardarInventario() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            out.writeObject(inventario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de items desde un archivo
    public void cargarInventario() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
        	inventario = (ArrayList<Item>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos para manipular el inventario
}