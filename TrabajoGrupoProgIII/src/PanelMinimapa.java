import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PanelMinimapa extends JPanel {
    JLabel punto = new JLabel();
    JLabel coords = new JLabel();
	JLabel zona;
	
    public PanelMinimapa(ImageIcon imagefinal) {
        this.setLayout(new BorderLayout());
        this.setSize(300, 300);

        ImageIcon icon = imagefinal;
        ImageIcon ic = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/MAPADEFINITIVO2.png");
        Image imagenEscalada = ic.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

        JLabel map = new JLabel(new ImageIcon(imagenEscalada));
        map.setSize(getWidth(), getHeight());

        punto.setSize(30, 40);
        ImageIcon im =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/flecha.png");
        Image imagenEscalada2 = im.getImage().getScaledInstance(30,40, Image.SCALE_SMOOTH);
        punto.setIcon(new ImageIcon(imagenEscalada2));
        punto.setVisible(true);
        punto.setOpaque(false);  // Hacer el fondo transparente
        map.setOpaque(false);
    
        
        ImageIcon im2 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Mapas/iconojoana.png");
        Image imagenEscalada3 = im2.getImage().getScaledInstance(30,40, Image.SCALE_SMOOTH);
        JLabel iconoj = new JLabel();
        iconoj.setIcon(new ImageIcon(imagenEscalada3));
        iconoj.setVisible(true);
        iconoj.setOpaque(false);
        this.add(iconoj, BorderLayout.CENTER);
        iconoj.setLocation(50,50);
        
        
        this.add(punto, BorderLayout.CENTER);  // Agregar el punto sobre el mapa
        this.add(map, BorderLayout.CENTER);
        coords = new JLabel();
        JPanel panelcoords = new JPanel();
        panelcoords.setOpaque(false);
        panelcoords.setLayout(new FlowLayout());
        panelcoords.add(coords);
        zona = new 	JLabel();
        panelcoords.add(zona);
        this.add(panelcoords, BorderLayout.CENTER);
        

    }

    public void actualizarPunto(Jugador player) {
    	punto.setLocation((int)(player.getPosx()/(39)+4) , (int)(player.getPosy()/(39))-32 );
    	
    	//System.out.println("Jugador   " + player.getPosx() + "   " + player.getPosy());
        //System.out.println("Punto   " + punto.getLocation());
    	coords.setText("                                                                      " + player.posx + ", " + player.getPosy());
    	//System.out.println(player.getPosx() + "   "+ player.getPosy());
    	if(player.getPosx() > -457 && player.getPosx() < 2150 && player.getPosy() > 4407 && player.getPosy() < 7144) {
            this.setBackground(Color.YELLOW);//ciudad
            zona.setText("                                                                     POBLADO ");

    	}
       	else if(player.getPosx() > 6894 && player.getPosx() < 8340 && player.getPosy()> 5546 && player.getPosy() < 8090) {
    		this.setBackground(Color.RED);//montañas del este
            zona.setText("                                                    MONTAÑAS DEL ESTE");

    	}
    	else if(player.getPosx() > 4720 && player.getPosx() < 6119 && player.getPosy()> 4786 && player.getPosy() < 5856) {
    		this.setBackground(Color.WHITE);//castillo
            zona.setText("                                                                    CASTILLO");

    	}
    	else if(player.getPosx() > 3760 && player.getPosx() < 7706 && player.getPosy()> 2891 && player.getPosy() < 6392) {
    		this.setBackground(Color.CYAN);//rivera
            zona.setText("                                                                    RIVERA");

    	}
    	else if(player.getPosx() > 4168 && player.getPosx() < 6740 && player.getPosy()> 9171 && player.getPosy() < 11724) {
    		this.setBackground(Color.LIGHT_GRAY);//charca de las estatuas
            zona.setText("                                        CHARCA DE LAS ESTATUAS");

    	}
    	else if(player.getPosx() > 6196 && player.getPosy()> 10781 ) {
    		this.setBackground(new Color(200, 174, 96));//cantera
            zona.setText("                                                                    CANTERA");

    	}
    	else if(player.getPosx() < 2506 && player.getPosy() < 2731) {
    		this.setBackground(new Color(113, 162, 92));//bosque
            zona.setText("                                                                      BOSQUE");

    	}	
    	else if(player.getPosx() < 2870  && player.getPosy() > 9149) {
    		this.setBackground(new Color(200, 174, 96));//arena
            zona.setText("                                                      			DESIERTO");

    	}
    	else {
    		this.setBackground(new Color(108, 205, 79));//prados
            zona.setText("                                                                    PRADERAS");
    	}
    	
    }

}