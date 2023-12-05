import java.io.*;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Productos {
    protected ArrayList<Item> productos; // ArrayList público de items
    private String rutaArchivo = "Inventario.txt"; // Ruta del archivo para guardar y cargar el inventario
    

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
    
 
    public ArrayList<Item> getInventario() {
    	return productos;
    }
    
    public void setInventario(ArrayList<Item> productos) {
    	this.productos = productos;
    }

    //Metodo para guardar
    
    //Metodo para cargar
    
 // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
    	Productos productos = new Productos();
    	for(Item items: productos.productos) {
    		System.out.println(items.toString());
    	}
    }

}