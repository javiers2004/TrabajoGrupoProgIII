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
	 protected int mostrado = 0;
	 protected Dialogo actual;
	 int cont=0;
	 private VentanaMapa v;
	 public E2() {
		 this.health = 800000000;
		 this.v = v;
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
	        //animacionDerecha.add(im4);
	        this.derecha = animacionDerecha;
	        this.derecha = derecha;
	    	ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
	    	ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/eIdle1.png");
	    	ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(102,80, Image.SCALE_SMOOTH));
	    	ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss//eIdle2.png");
	    	ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(102,80, Image.SCALE_SMOOTH));
	    	ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss/eIdle3.png");
	    	ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(102,80, Image.SCALE_SMOOTH));
	    	izquierda.add(imagen3);
	    	izquierda.add(imagen4);
	    	izquierda.add(imagen6);
	    	this.izquierda = izquierda;	
	    	ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss/105.png");
	    	ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(110,92, Image.SCALE_SMOOTH));
	    	ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss/106.png");
	    	ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(110,92, Image.SCALE_SMOOTH));
	    	ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss/107.png");
	    	ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(110,92, Image.SCALE_SMOOTH));
	    	ataquenemigo.add(imagen7);
	    	ataquenemigo.add(imagen8);
	    	ataquenemigo.add(imagen9);
	    	ImageIcon icono11 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/boss/144.png");
	    	ImageIcon image11 = new ImageIcon(icono11.getImage().getScaledInstance(64,164, Image.SCALE_SMOOTH));
	    	muerte.add(image11);
	        
	        
	        
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
		 
		 /*dialogoMisionAdicional = new Dialogo("Cada misión que completes te acercará a la fuerza necesaria para salvar a Eleonore. ¿Estás listo para tu primera tarea?",
                 Arrays.asList("Sí, ¿qué debo hacer primero?", "Todavía no, necesito prepararme."));

		 dialogoReaccionPostRescate = new Dialogo("¡Lo lograste! La aldea estará eternamente agradecida. ¿Cómo te sientes después de tal hazaña?",
                     Arrays.asList("Fue una batalla difícil, pero valió la pena.", "Solo hice lo que tenía que hacer."));*/

	 }
	 public void siguiente() {
		 if(mostrado == 0) {
			 actual = this.dialogoInicial;
			 mostrado++;
		 }else if(mostrado ==1) {
			 actual = this.dialogoRescate;
			 mostrado++;
		 }else if(mostrado ==2) {
			 actual = this.dialogoFinal;
			 mostrado++;
		 }else if(mostrado ==3 && !v.getB().isVivo() ) {
			 actual = this.dialogoReaccionPostRescate;
			 
		 }
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
