import java.awt.Image;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Objetos {
	protected ArrayList<Item> objetos; // ArrayList público de items
	private static final int ICON_WIDTH = 32; // Ancho deseado para el ícono
    private static final int ICON_HEIGHT = 32; // Altura deseada para el ícono
   
    

    public Objetos() {
        objetos = new ArrayList<>();
        objetos.add(new ItemAtaqueCorto(
    			"Espada Corta Básica", 
    			"img/sword.png", 
    			50,
    			500,  
    			1.5, 
    			"Esta es una espada corta sencilla, común entre los aprendices y los guerreros principiantes. "
    			+ "Con una hoja recta y un mango sin adornos, su diseño es funcional y práctico, ideal "
    			+ "para aquellos que están empezando su camino en el arte del combate. Aunque no tiene "
    			+ "las características avanzadas de las espadas más exóticas o poderosas, su fiabilidad y "
    			+ "facilidad de manejo la hacen perfecta para aprender las habilidades básicas de esgrima y "
    			+ "defensa personal. En las leyendas, se dice que algunos de los héroes más grandes comenzaron sus "
    			+ "viajes con una espada como esta."
        		,true,""));
        objetos.add(new ItemAtaqueCorto(
        	    "Espada Larga de Acero", 
        	    "img/sword.png", // Asegúrate de tener una imagen adecuada
        	    70,
        	    800,
        	    2.0,
        	    "Una espada larga forjada en acero de alta calidad, balanceada y letal. "
        	    + "Su hoja recta y afilada es capaz de cortar con gran eficacia, mientras "
        	    + "que su longitud proporciona un alcance superior en combate. Favorita entre "
        	    + "los caballeros y soldados profesionales, esta espada es un símbolo de fuerza y habilidad.",
        	    false, // Asumiendo que inicialmente no está comprada
        	    ""));
        objetos.add(new ItemAtaqueCorto(
        	    "Espada de Dos Manos", 
        	    "img/sword.png", // Asegúrate de tener una imagen adecuada
        	    85,
        	    1200,
        	    3.5,
        	    "Una imponente espada de dos manos, diseñada para ser utilizada con ambas "
        	    + "manos para maximizar su potencial destructivo. Su hoja larga y pesada puede "
        	    + "causar daños devastadores, capaz de atravesar armaduras y escudos con facilidad. "
        	    + "Requiere gran fuerza y habilidad para ser manejada correctamente.",
        	    false, // Asumiendo que inicialmente no está comprada
        	    ""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada de Caballero Templario", 
    			"img/sword.png", 
    			75,
    			1000,  
    			1.5, 
    			"Esta espada perteneció a los caballeros templarios de la Edad Media. "
    			+ "Con una hoja robusta y un mango adornado con símbolos cristianos, "
    			+ "esta arma no solo era un símbolo de poder militar sino también de fe "
    			+ "y devoción. Se dice que otorgaba valor y protección divina a su "
    			+ "portador en las batallas"
    			,false,""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada Vikinga", 
    			"img/sword.png", 
    			200,
    			2500,  
    			4, 
    			"Forjada en los fríos y místicos paisajes del norte, esta espada era "
    			+ "la elección predilecta de los guerreros vikingos. Con una hoja ancha "
    			+ "y un mango simple pero funcional, esta espada era conocida por su "
    			+ "durabilidad y eficacia en combate. Se cuenta que cada espada llevaba "
    			+ "grabadas las hazañas de sus anteriores portadores"
    			,false,""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada Samurai Katana", 
    			"img/sword.png", 
    			150,
    			4000,  
    			1, 
    			"La katana, con su hoja curvada y filo excepcional, es una de las espadas "
    			+ "más reconocibles del mundo. Utilizada por los samuráis del Japón feudal,"
    			+ " no era solo un arma sino también un objeto de arte y un símbolo del honor "
    			+ "guerrero. Se decía que el alma del samurái residía en su katana, convirtiéndola "
    			+ "en una extensión de su ser."
    			,false,""));
        objetos.add(new ItemCura(
                "Poción de Vida Menor", 
                "img/potion.png", 
                50, 
                30, 
                200, 
                "Una poción roja brillante que restaura una cantidad pequeña de salud. "
                + "Es un elixir común entre aventureros novatos y viajeros. Su efecto es "
                + "instantáneo, proporcionando una sensación de calor y vigor al ser consumida. "
                + "Ideal para situaciones de emergencia."
                ,false,""));
        objetos.add(new ItemCura(
        	    "Poción de Sanación Rápida", 
        	    "img/potion.png", // Asegúrate de tener una imagen adecuada
        	    50,
        	    20,
        	    150,
        	    "Una pequeña pero poderosa poción que cura moderadamente al instante."
        	    + " Ideal para situaciones de combate donde cada segundo cuenta. "
        	    + "Su efecto rápido puede ser la diferencia entre la victoria y la derrota,"
        	    + " especialmente útil para guerreros que necesitan mantenerse en movimiento.",
        	    false, // Asumiendo que inicialmente no está comprada
        	    ""));

        objetos.add(new ItemCura(
                "Elixir de Sanación Avanzada", 
                "img/potion.png", 
                150, 
                60, 
                500, 
                "Este elixir de color verde esmeralda es una mezcla más potente y rara. "
                + "Es capaz de curar heridas graves y restaurar la vitalidad de forma casi"
                + " milagrosa. Usado por guerreros experimentados y curanderos, es un tesoro "
                + "en cualquier botiquín."
                ,false,""));
        objetos.add(new ItemCura(
                "Poción de Regeneración", 
                "img/potion.png", 
                100, 
                45, 
                350, 
                "Una poción mágica de un tono azul suave. No solo cura al instante sino que "
                + "también otorga una regeneración lenta de salud durante un período prolongado."
                + " Muy útil durante combates largos o expediciones peligrosas, proporciona una"
                + " ventaja sustancial a quien la porta."
                ,false,""));
        objetos.add(new ItemCura(
        	    "Elixir de Vitalidad", 
        	    "img/potion.png", // Asegúrate de tener una imagen adecuada
        	    200,
        	    60,
        	    600,
        	    "Este elixir de un color verde vibrante no solo cura heridas, sino que también "
        	    + "aumenta temporalmente la vitalidad del usuario. Proporciona una sensación de "
        	    + "fortaleza y resistencia, permitiendo al consumidor soportar más daño y luchar "
        	    + "por más tiempo sin fatigarse.",
        	    false, // Asumiendo que inicialmente no está comprada
        	    ""));
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