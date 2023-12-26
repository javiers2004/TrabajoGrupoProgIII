import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;

public class npc {
    protected int x, y;
    protected boolean esInteractivo;
    protected Dialogo dialogo;
    protected JLabel label;
    protected ArrayList<ImageIcon> animacionDerecha;
    protected ArrayList<ImageIcon> animacionIzquierda;
    protected static final int DISTANCIA_INTERACTUAR = 100;
    protected int contadorAnimacion = 0;

    
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEsInteractivo() {
		return esInteractivo;
	}

	public void setEsInteractivo(boolean esInteractivo) {
		this.esInteractivo = esInteractivo;
	}

	public Dialogo getDialogo() {
		return dialogo;
	}

	public void setDialogo(Dialogo dialogo) {
		this.dialogo = dialogo;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ArrayList<ImageIcon> getAnimacionDerecha() {
		return animacionDerecha;
	}

	public void setAnimacionDerecha(ArrayList<ImageIcon> animacionDerecha) {
		this.animacionDerecha = animacionDerecha;
	}

	public ArrayList<ImageIcon> getAnimacionIzquierda() {
		return animacionIzquierda;
	}

	public void setAnimacionIzquierda(ArrayList<ImageIcon> animacionIzquierda) {
		this.animacionIzquierda = animacionIzquierda;
	}

	public int getContadorAnimacion() {
		return contadorAnimacion;
	}

	public void setContadorAnimacion(int contadorAnimacion) {
		this.contadorAnimacion = contadorAnimacion;
	}

	public static int getDistanciaInteractuar() {
		return DISTANCIA_INTERACTUAR;
	}

	public npc(int x, int y, Dialogo dialogo) {
        this.x = x;
        this.y = y;
        this.esInteractivo = false;
        this.dialogo = dialogo;
        this.label = new JLabel();

        // Inicializar las animaciones
        animacionDerecha = new ArrayList<>();
        //animacionIzquierda = new ArrayList<>();
        
            for (int i = 1; i <= 4; i++) {
            animacionDerecha.add(new ImageIcon("Idle" + i + ".png"));
            //animacionIzquierda.add(new ImageIcon("idle" + i + ".png"));
        }

        // Inicializar el JLabel con la primera imagen de una de las animaciones
        label.setIcon(animacionDerecha.get(0));
    }

    public void actualizarInter(Jugador player) {
        double distancia = Math.sqrt(Math.pow(player.getPosx() - x, 2) + Math.pow(player.getPosy() - y, 2));
        esInteractivo = distancia < DISTANCIA_INTERACTUAR;

        // Actualizar animación y posición del NPC
        //actualizarAnimacion(player);
        label.setLocation(x, y);
    }

   protected void actualizarAnimacion(Jugador player) {
        // Cambiar la imagen del JLabel según la dirección del movimiento
        if (player.getPosx() > x) {
            label.setIcon(animacionDerecha.get(contadorAnimacion % animacionDerecha.size()));
        } else {
            label.setIcon(animacionIzquierda.get(contadorAnimacion % animacionIzquierda.size()));
        }
        contadorAnimacion++;
    }
   public int distancua(Jugador player) {
	   return (int) Math.sqrt(Math.pow(player.getPosx()- (this.getX()-789), 2) + Math.pow(player.getPosy() - (this.getY()-417), 2));
   }

   
}
