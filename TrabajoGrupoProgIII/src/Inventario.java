import java.io.*;
import java.util.ArrayList;

public class Inventario {
	protected ArrayList<Item> inventario; // ArrayList público de items
   
    

    public Inventario() {
        inventario = new ArrayList<>();
        inventario.add(new ItemAtaqueCorto(
    			"Espada Corta Básica", 
    			"img/sword.png", 
    			50,
    			500,  
    			1.5, 
    			"Esta es una espada corta sencilla, común entre los aprendices y los guerreros principiantes. Con una hoja recta y un mango sin adornos, su diseño es funcional y práctico, ideal para aquellos que están empezando su camino en el arte del combate. Aunque no tiene las características avanzadas de las espadas más exóticas o poderosas, su fiabilidad y facilidad de manejo la hacen perfecta para aprender las habilidades básicas de esgrima y defensa personal. En las leyendas, se dice que algunos de los héroes más grandes comenzaron sus viajes con una espada como esta."
    			));
    }
    
    public ArrayList<Item> getInventario() {
    	return inventario;
    }
    
    public void setInventario(ArrayList<Item> inventario) {
    	this.inventario = inventario;
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
            return inventario // Cargar desde otra fuente si el archivo no existe
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
            return inventario; // Cargar desde otra fuente en caso de error de lectura
        }
        return items;
    }

 // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
    	Inventario inventario = new Inventario();
    	for(Item items: inventario.inventario) {
    		System.out.println(items.toString());
    	}
    }
}