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
    JLabel coords = new JLabel();
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
        map.setOpaque(false);
    
        this.add(punto, BorderLayout.CENTER);  // Agregar el punto sobre el mapa
        this.add(map, BorderLayout.CENTER);
        coords = new JLabel();
        JPanel panelcoords = new JPanel();
        panelcoords.setOpaque(false);
        panelcoords.setLayout(new BorderLayout());
        panelcoords.add(coords, BorderLayout.NORTH);
        this.add(panelcoords, BorderLayout.CENTER);
    }

    public void actualizarPunto(Jugador player) {
    	punto.setLocation((int)(player.getPosx()/(39)+4) , (int)(player.getPosy()/(39))-32 );
        //System.out.println("Jugador   " + player.getPosx() + "   " + player.getPosy());
        //System.out.println("Punto   " + punto.getLocation());
    	coords.setText("                                             " + player.posx + ", " + player.getPosy());
    	System.out.println(player.getPosx() + "   "+ player.getPosy());
    	if(player.getPosx() > -457 && player.getPosx() < 2150 && player.getPosy() > 4407 && player.getPosy() < 7144) {
            this.setBackground(Color.CYAN);//ciudad

    	}
    	else if(player.getPosx() > 4720 && player.getPosx() < 6119 && player.getPosy()> 4786 && player.getPosy() < 5856) {
    		this.setBackground(Color.WHITE);//castillo
    	}
    	else if(player.getPosx() < 2506 && player.getPosy() < 2731) {
    		this.setBackground(new Color(43, 95, 75));//bosque
    	}	
    	else if(player.getPosx() < 2870  && player.getPosy() > 9149) {
    		this.setBackground(new Color(200, 174, 96));//arena
    	}
    	else {
    		this.setBackground(new Color(108, 205, 79));//prados
    	}
    }

}