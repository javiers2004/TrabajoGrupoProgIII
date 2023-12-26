import javax.swing.ImageIcon;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

public class Joana extends npc {
    
    protected Dialogo dialogoInicial;
    protected Dialogo dialogoMisiones;
    protected Dialogo dialogoConsejos;

    public Joana(int x, int y) {
        super(x, y, null); 
        
       ArrayList<ImageIcon> animacionDerecha = new ArrayList<ImageIcon>();
       ImageIcon i1 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle1.png");
       ImageIcon im1 = new ImageIcon(i1.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
       ImageIcon i2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle2.png");
       ImageIcon im2 = new ImageIcon(i2.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
       ImageIcon i3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle3.png");
       ImageIcon im3 = new ImageIcon(i3.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
       ImageIcon i4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/jIdle4.png");
       ImageIcon im4 = new ImageIcon(i4.getImage().getScaledInstance(70, 54, Image.SCALE_SMOOTH));
       animacionDerecha.add(im1);
       animacionDerecha.add(im2);
       animacionDerecha.add(im3);
       animacionDerecha.add(im4);
       this.animacionDerecha = animacionDerecha;
       


       
        inicializarDialogos();
    }

    protected void inicializarDialogos() {
        
        dialogoInicial = new Dialogo("¡Hola, aventurero! Nuestra princesa Eleonore ha sido capturada por criaturas malvadas. ¿Puedes ayudarnos a rescatarla?",
                                     Arrays.asList("Claro, ¿qué necesito hacer?", "Lo siento, estoy ocupado ahora mismo."));

        dialogoMisiones = new Dialogo("Necesitarás subir de nivel para enfrentarte a las criaturas. Completa estas misiones para ganar experiencia.",
                                      Arrays.asList("Recoger hierbas medicinales en el bosque", "Derrotar a los slimes que amenazan la aldea", "Encontrar un artefacto antiguo en la cueva misteriosa"));

        
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

    

}
