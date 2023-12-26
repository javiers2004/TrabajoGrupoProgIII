import java.io.*;
import java.util.ArrayList;

public class Objetos {
	protected ArrayList<Item> objetos; // ArrayList público de items
   
    

    public Objetos() {
        objetos = new ArrayList<>();
        objetos.add(new ItemAtaqueCorto(
    			"Espada Corta Básica", 
    			"img/sword.png", 
    			50,
    			500,  
    			1.5, 
    			"Esta es una espada corta sencilla, común entre los aprendices y los guerreros principiantes. Con una hoja recta y un mango sin adornos, su diseño es funcional y práctico, ideal para aquellos que están empezando su camino en el arte del combate. Aunque no tiene las características avanzadas de las espadas más exóticas o poderosas, su fiabilidad y facilidad de manejo la hacen perfecta para aprender las habilidades básicas de esgrima y defensa personal. En las leyendas, se dice que algunos de los héroes más grandes comenzaron sus viajes con una espada como esta."
        		,true,""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada de Caballero Templario", 
    			"img/sword.png", 
    			75,
    			1000,  
    			1.5, 
    			"Esta espada perteneció a los caballeros templarios de la Edad Media. Con una hoja robusta y un mango adornado con símbolos cristianos, esta arma no solo era un símbolo de poder militar sino también de fe y devoción. Se dice que otorgaba valor y protección divina a su portador en las batallas"
    			,false,""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada Vikinga", 
    			"img/sword.png", 
    			200,
    			2500,  
    			4, 
    			"Forjada en los fríos y místicos paisajes del norte, esta espada era la elección predilecta de los guerreros vikingos. Con una hoja ancha y un mango simple pero funcional, esta espada era conocida por su durabilidad y eficacia en combate. Se cuenta que cada espada llevaba grabadas las hazañas de sus anteriores portadores"
    			,false,""));
        objetos.add(new ItemAtaqueCorto(
    			"Espada Samurai Katana", 
    			"img/sword.png", 
    			150,
    			4000,  
    			1, 
    			"La katana, con su hoja curvada y filo excepcional, es una de las espadas más reconocibles del mundo. Utilizada por los samuráis del Japón feudal, no era solo un arma sino también un objeto de arte y un símbolo del honor guerrero. Se decía que el alma del samurái residía en su katana, convirtiéndola en una extensión de su ser."
    			,false,""));
        objetos.add(new ItemCura(
                "Poción de Vida Menor", 
                "img/potion.png", 
                50, 
                30, 
                200, 
                "Una poción roja brillante que restaura una cantidad pequeña de salud. Es un elixir común entre aventureros novatos y viajeros. Su efecto es instantáneo, proporcionando una sensación de calor y vigor al ser consumida. Ideal para situaciones de emergencia."
                ,false,""));
        objetos.add(new ItemCura(
                "Elixir de Sanación Avanzada", 
                "img/elixir.png", 
                150, 
                60, 
                500, 
                "Este elixir de color verde esmeralda es una mezcla más potente y rara. Es capaz de curar heridas graves y restaurar la vitalidad de forma casi milagrosa. Usado por guerreros experimentados y curanderos, es un tesoro en cualquier botiquín."
                ,false,""));
        objetos.add(new ItemCura(
                "Poción de Regeneración", 
                "img/regen_potion.png", 
                100, 
                45, 
                350, 
                "Una poción mágica de un tono azul suave. No solo cura al instante sino que también otorga una regeneración lenta de salud durante un período prolongado. Muy útil durante combates largos o expediciones peligrosas, proporciona una ventaja sustancial a quien la porta."
                ,false,""));
    }
    
    public ArrayList<Item> getInventario() {
    	return objetos;
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