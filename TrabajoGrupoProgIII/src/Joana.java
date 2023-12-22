import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Arrays;

public class Joana extends npc {
    
    // Diálogos específicos para Joana
    private Dialogo dialogoInicial;
    private Dialogo dialogoMisiones;
    private Dialogo dialogoConsejos;

    public Joana(int x, int y) {
        super(x, y, null); 
        
        setAnimacionDerecha(new ArrayList<>());
        setAnimacionIzquierda(new ArrayList<>());

        for (int i = 1; i <= 4; i++) {
            getAnimacionDerecha().add(new ImageIcon("jIdle" + i + ".png"));
           // getAnimacionIzquierda().add(new ImageIcon("jIdle" + i + ".png"));
        }

        getLabel().setIcon(getAnimacionDerecha().get(0));

       
        inicializarDialogos();
    }

    private void inicializarDialogos() {
        
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
