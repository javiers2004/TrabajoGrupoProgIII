import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Eleanore extends npc {
	
	private Dialogo dialogoInicial;
	private Dialogo dialogoRescate;
	private Dialogo dialogoFinal;
	 private Dialogo dialogoMisionAdicional;
	 private Dialogo dialogoReaccionPostRescate;
	 //private Dialogo dialogoFinJuego;

	 public Eleanore(int x, int y) {
	        super(x, y, null);
	        setAnimacionDerecha(new ArrayList<>());
	        for(int i = 1 ; i<= 4; i++) {
	        	getAnimacionDerecha().add(new ImageIcon("eIdle" + i + ".png"));
	        }
	        getLabel().setIcon(getAnimacionDerecha().get(0));
	        inicializarDialogos();
}
	 private void inicializarDialogos() {
		 dialogoInicial = new Dialogo("Gracias por venir. Debes tener cuidado, las criaturas que me custodian son poderosas.",
                 Arrays.asList("Atacar con la espada", "Usar un hechizo mágico", "Usar un objeto de la mochila"));
		 dialogoRescate = new Dialogo("Gracias por salvarme. Has demostrado ser un verdadero héroe.",
                 Arrays.asList("Fue un honor ayudarte, princesa.", "Ahora, ¿qué aventuras nos esperan?"));
		 dialogoFinal = new Dialogo("¡Lo lograste! La aldea estará eternamente agradecida. ¿Cómo te sientes después de tal hazaña?",
                 Arrays.asList("Fue una batalla difícil, pero valió la pena.", "Solo hice lo que tenía que hacer."));
		 dialogoMisionAdicional = new Dialogo("Cada misión que completes te acercará a la fuerza necesaria para salvar a Eleonore. ¿Estás listo para tu primera tarea?",
                 Arrays.asList("Sí, ¿qué debo hacer primero?", "Todavía no, necesito prepararme."));

		 dialogoReaccionPostRescate = new Dialogo("¡Lo lograste! La aldea estará eternamente agradecida. ¿Cómo te sientes después de tal hazaña?",
                     Arrays.asList("Fue una batalla difícil, pero valió la pena.", "Solo hice lo que tenía que hacer."));

	 }
	 public Dialogo getDialogoInicial() {
	        return dialogoInicial;
	    }

	    public Dialogo getDialogoRescate() {
	        return dialogoRescate;
	    }

	    public Dialogo getDialogoFinal() {
	        return dialogoFinal;
	    }
	    public Dialogo getDialogoMisionAdicional() {
	        return dialogoMisionAdicional;
	    }

	    public Dialogo getDialogoReaccionPostRescate() {
	        return dialogoReaccionPostRescate;
	    }

}
