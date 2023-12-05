import java.io.*;
import java.util.ArrayList;

public class Inventario {
	protected ArrayList<Item> inventario; // ArrayList público de items
    private String rutaArchivo = "Inventario.txt"; // Ruta del archivo para guardar y cargar el inventario
    

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
    
    //Metodo para guardar
    
    //Metodo para cargar

 // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
    	Inventario inventario = new Inventario();
    	for(Item items: inventario.inventario) {
    		System.out.println(items.toString());
    	}
    }
}