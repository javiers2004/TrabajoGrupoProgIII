import java.awt.Image;
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
	        ArrayList<ImageIcon> animacionDerecha = new ArrayList<ImageIcon>();
	        ImageIcon i1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	        ImageIcon im1 = new ImageIcon(i1.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
	        ImageIcon i2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	        ImageIcon im2 = new ImageIcon(i2.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
	        ImageIcon i3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	        ImageIcon im3 = new ImageIcon(i3.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
	        ImageIcon i4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	        ImageIcon im4 = new ImageIcon(i4.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
	        animacionDerecha.add(im1);
	        animacionDerecha.add(im2);
	        animacionDerecha.add(im3);
	        animacionDerecha.add(im4);
	        this.animacionDerecha = animacionDerecha;
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
