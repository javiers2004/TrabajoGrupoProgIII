import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class J2 extends Enemigos{
	protected Dialogo dialogoInicial;
    protected Dialogo dialogoMisiones;
    protected Dialogo dialogoConsejos;
    protected int mostrado = 0;
    protected Dialogo actual;
    
    protected int cont = 0;
    public J2() {
    	this.health = 800000000;
    	this.daño=0;
    	this.experiencia=0;
    	this.vivo= true;

    	ArrayList<ImageIcon> animacionDerecha = new ArrayList<ImageIcon>();
        ImageIcon i1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle1.png");
        ImageIcon im1 = new ImageIcon(i1.getImage().getScaledInstance(102, 126, Image.SCALE_SMOOTH));
        ImageIcon i2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle2.png");
        ImageIcon im2 = new ImageIcon(i2.getImage().getScaledInstance(102, 126, Image.SCALE_SMOOTH));
        ImageIcon i3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle3.png");
        ImageIcon im3 = new ImageIcon(i3.getImage().getScaledInstance(102, 126, Image.SCALE_SMOOTH));
        ImageIcon i4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle4.png");
        ImageIcon im4 = new ImageIcon(i4.getImage().getScaledInstance(102, 126, Image.SCALE_SMOOTH));
        animacionDerecha.add(im1);
        animacionDerecha.add(im2);
        animacionDerecha.add(im3);
        animacionDerecha.add(im4);
        this.derecha = animacionDerecha;
        this.label = new JLabel();
        this.getLabel().setSize(136, 168);
        this.label.setIcon(this.getDerecha().get(0));
        this.label.setBounds(0,0,102,126);
        this.label.setOpaque(false);
        
        inicializarDialogos();
    	
    }
   public void siguiente() {
	   if(mostrado == 0) {
		   actual = this.dialogoInicial;
		   mostrado++;
	   }else if(mostrado == 1){
		   actual = this.dialogoMisiones;
		   mostrado++;
	   }else if(mostrado ==2) {
		   actual = this.dialogoConsejos;
		   mostrado++;
	   }else {
		   actual = new Dialogo("Sigue buscando!", null);
	   }
	   
   }

protected void inicializarDialogos() {
        
        dialogoInicial = new Dialogo("¡Hola, aventurero! Nuestra princesa Eleonore ha sido capturada por criaturas malvadas. ¿Puedes ayudarnos a rescatarla?",
                                     Arrays.asList("Claro, ¿qué necesito hacer?", "Lo siento, estoy ocupado ahora mismo."));

        dialogoMisiones = new Dialogo("La clave para rescatar a Eleonore es estar bien preparado. Asegúrate de entrenar y mejorar tu equipo constantemente.",
                Arrays.asList("Preguntar sobre entrenamientos específicos", "Preguntar sobre la calidad del equipo"));
        
        dialogoConsejos = new Dialogo("Recuerda, en tu viaje encontrarás objetos que pueden ser útiles. No subestimes su poder.",
                                      Arrays.asList("¿Puedes darme algún ejemplo?", "Lo tendré en mente, gracias."));
    }

    
    public Dialogo getDialogoInicial() {
        return dialogoInicial;
    }

    public Dialogo getDialogoMisiones() {
        return dialogoMisiones;
    }

    public Dialogo getDialogoConsejos() {
        return dialogoConsejos;
    }

    public void incrementar() {
    	cont = (cont +1)% derecha.size()
;    }

    public ImageIcon getActual() {
    	return derecha.get(cont);
    }
}
