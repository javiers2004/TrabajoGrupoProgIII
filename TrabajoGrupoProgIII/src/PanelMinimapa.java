import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PanelMinimapa extends JPanel {
    JLabel punto = new JLabel();

    public PanelMinimapa(ImageIcon imagefinal) {
        this.setLayout(new BorderLayout());
        this.setSize(300, 300);

        ImageIcon icon = imagefinal;
        Image imagenEscalada = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

        JLabel map = new JLabel(new ImageIcon(imagenEscalada));
        map.setSize(getWidth(), getHeight());

        punto.setSize(30, 40);
        ImageIcon im =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/flecha.png");
        Image imagenEscalada2 = im.getImage().getScaledInstance(30,40, Image.SCALE_SMOOTH);
        punto.setIcon(new ImageIcon(imagenEscalada2));
        punto.setVisible(true);
        punto.setOpaque(false);  // Hacer el fondo transparente

    
        this.add(punto, BorderLayout.CENTER);  // Agregar el punto sobre el mapa
        this.add(map, BorderLayout.CENTER);
    }

    public void actualizarPunto(Jugador player) {
    	punto.setLocation((int)(player.getPosx()/(39)) , (int)(player.getPosy()/(39))-28 );
        System.out.println("Jugador   " + player.getPosx() + "   " + player.getPosy());
        System.out.println("Punto   " + punto.getLocation());
    	
    	
    }

}