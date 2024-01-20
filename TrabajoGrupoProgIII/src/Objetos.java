import java.awt.Image;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Objetos {
	protected static ArrayList<Item> objetos; // ArrayList público de items
	private static final int ICON_WIDTH = 32; // Ancho deseado para el ícono
    private static final int ICON_HEIGHT = 32; // Altura deseada para el ícono
   
    

    public Objetos() {
//        	try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("objetos.dat"))) {
//                salida.writeObject(objetos);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

          
            
            try {
            	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objetos.dat"));
            	Object objeto = ois.readObject();
            	if (objeto instanceof ArrayList<?>) {
            		objetos = (ArrayList<Item>) objeto;
            	}
            }
            catch (IOException | ClassNotFoundException e){
            	
            }
        
        
    }
    
    public ArrayList<Item> getInventario() {
    	return objetos;
    }
    
    public ArrayList<Item> getInventarioNoComprados() {
    	ArrayList<Item> objetosNoComprados = new ArrayList<>();

        for (Item item : this.getInventario()) {
            if (item.isComprado()==false) {
                objetosNoComprados.add(item);
            }
        }
        return objetosNoComprados;
    }
    
    public ArrayList<Item> getInventarioComprados() {
    	ArrayList<Item> objetosComprados = new ArrayList<>();

        for (Item item : this.getInventario()) {
            if (item.isComprado()==true) {
                objetosComprados.add(item);
            }
        }
        return objetosComprados;
    }
    
    public void setInventario(ArrayList<Item> inventario) {
    	this.objetos = inventario;
    }
    
    public void cargarObjetosBD() {
    	
    }
    public void guardarObjetosBD() {
    	 
    }
    
    public static void main(String[] args) {
        Objetos objetos = new Objetos();
        ArrayList<Item> inventario = objetos.getInventario();

        for (Item item : inventario) {
        	System.out.println("Nombre: " + item.getNombre());
            System.out.println("Icono: " + item.getIcono());
            System.out.println("Comprado: " + (item.isComprado() ? "Sí" : "No"));
            System.out.println("Dueño: " + item.getDueño());

            if (item instanceof ItemAtaqueCorto) {
                ItemAtaqueCorto ataqueCorto = (ItemAtaqueCorto) item;
                System.out.println("Daño: " + ataqueCorto.getDaño());
                System.out.println("Coste: " + ataqueCorto.getCoste());
                System.out.println("Cooldown: " + ataqueCorto.getCooldown());
                System.out.println("Descripción: " + ataqueCorto.getDescripcion());
            } else if (item instanceof ItemCura) {
                ItemCura cura = (ItemCura) item;
                System.out.println("Curación: " + cura.getCuracion());
                System.out.println("Coste: " + cura.getCoste());
                System.out.println("Cooldown: " + cura.getCooldown());
                System.out.println("Descripción: " + cura.getDescripcion());
            }

            System.out.println("-----------------------------------");
        }
    }
}