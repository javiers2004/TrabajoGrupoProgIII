import java.io.*;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Productos {
    protected ArrayList<Item> productos; // ArrayList público de items
    private String rutaArchivo = "Productos.txt"; // Ruta del archivo para guardar y cargar el inventario
    

    public Productos() {
    	productos = new ArrayList<>();
    	productos.add(new ItemAtaqueCorto(
    			"Espada de Caballero Templario", 
    			"img/sword.png", 
    			75,
    			1000,  
    			1.5, 
    			"Esta espada perteneció a los caballeros templarios de la Edad Media. Con una hoja robusta y un mango adornado con símbolos cristianos, esta arma no solo era un símbolo de poder militar sino también de fe y devoción. Se dice que otorgaba valor y protección divina a su portador en las batallas"
    			));
    	productos.add(new ItemAtaqueCorto(
    			"Espada Vikinga", 
    			"img/sword.png", 
    			200,
    			2500,  
    			4, 
    			"Forjada en los fríos y místicos paisajes del norte, esta espada era la elección predilecta de los guerreros vikingos. Con una hoja ancha y un mango simple pero funcional, esta espada era conocida por su durabilidad y eficacia en combate. Se cuenta que cada espada llevaba grabadas las hazañas de sus anteriores portadores"
    			));
    	productos.add(new ItemAtaqueCorto(
    			"Espada Samurai Katana", 
    			"img/sword.png", 
    			150,
    			4000,  
    			1, 
    			"La katana, con su hoja curvada y filo excepcional, es una de las espadas más reconocibles del mundo. Utilizada por los samuráis del Japón feudal, no era solo un arma sino también un objeto de arte y un símbolo del honor guerrero. Se decía que el alma del samurái residía en su katana, convirtiéndola en una extensión de su ser."
    			));
    	
    }
    
 
    public ArrayList<Item> getProductos() {
    	return productos;
    }
    
    public void setProductos(ArrayList<Item> productos) {
    	this.productos = productos;
    }

    public static void guardarEnCSV(ArrayList<Item> items, String pathArchivo) {
        try (FileWriter writer = new FileWriter(pathArchivo)) {
            for (Item item : items) {
                writer.append(item.getNombre())
                      .append(',')
                      .append(item.getIcono());

                if (item instanceof ItemAtaqueCorto) {
                    ItemAtaqueCorto ataqueCorto = (ItemAtaqueCorto) item;
                    writer.append(',')
                          .append(String.valueOf(ataqueCorto.getDaño()))
                          .append(',')
                          .append(String.valueOf(ataqueCorto.getCoste()))
                          .append(',')
                          .append(String.valueOf(ataqueCorto.getCooldown()))
                          .append(',')
                          .append(ataqueCorto.getdescripcion());
                }

                writer.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Item> cargarDesdeCSV(String pathArchivo) {
        File archivo = new File(pathArchivo);
        if (!archivo.exists()) {
            return getProductos(); // Cargar desde otra fuente si el archivo no existe
        }

        ArrayList<Item> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] valores = line.split(",");
                // Aquí va el código para parsear la línea y agregar el objeto a la lista
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
            return getProductos(); // Cargar desde otra fuente en caso de error de lectura
        }
        return items;
    }
    
 // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
    	Productos productos = new Productos();
    	for(Item items: productos.productos) {
    		System.out.println(items.toString());
    	}
    }

}