import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class E2 extends Enemigos{
	protected Dialogo dialogoInicial;
	protected Dialogo dialogoRescate;
	protected Dialogo dialogoFinal;
	 protected Dialogo dialogoMisionAdicional;
	 protected Dialogo dialogoReaccionPostRescate;
	 
	 protected int cont=0;
	 public E2() {
		 this.health = 800000000;
	    	this.daño=0;
	    	this.experiencia=0;
	    	this.vivo= true;

	    	ArrayList<ImageIcon> animacionDerecha = new ArrayList<ImageIcon>();
	        ImageIcon i1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	        ImageIcon im1 = new ImageIcon(i1.getImage().getScaledInstance(102, 102, Image.SCALE_SMOOTH));
	        ImageIcon i2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle2.png");
	        ImageIcon im2 = new ImageIcon(i2.getImage().getScaledInstance(102, 102, Image.SCALE_SMOOTH));
	        ImageIcon i3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle3.png");
	        ImageIcon im3 = new ImageIcon(i3.getImage().getScaledInstance(102, 102, Image.SCALE_SMOOTH));
	        ImageIcon i4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle4.png");
	        ImageIcon im4 = new ImageIcon(i4.getImage().getScaledInstance(102, 102, Image.SCALE_SMOOTH));
	        animacionDerecha.add(im1);
	        animacionDerecha.add(im2);
	        animacionDerecha.add(im3);
	        animacionDerecha.add(im4);
	        this.derecha = animacionDerecha;
	        this.label = new JLabel();
	        this.getLabel().setSize(136, 168);
	        this.label.setIcon(this.getDerecha().get(0));
	        this.label.setBounds(0,0,102,102);
	        this.label.setOpaque(false);
	        
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
	    public void incrementar() {
	    	cont = (cont +1)% derecha.size()
	;    }

	    public ImageIcon getActual() {
	    	return derecha.get(cont);
	    }
}
