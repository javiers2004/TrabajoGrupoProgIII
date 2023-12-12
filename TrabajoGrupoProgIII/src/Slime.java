import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Slime extends Enemigos{

	public Slime() {
		super();
		this.health = 50;
		this.label = new JLabel();
		this.label.setBounds(x,y,64,50);
		this.label.setBackground(Color.red);
		this.label.setOpaque(true);
		
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-0.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-1.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-2.png.");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		ImageIcon icono20 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-move-3.png.");
		ImageIcon imagen20 = new ImageIcon(icono20.getImage().getScaledInstance(64,50, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		derecha.add(imagen20);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left0.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left1.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/left2.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		this.izquierda = izquierda;	
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-0.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-1.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-2.png");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(imagen9);
		ImageIcon icono10 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/slime-attack-3.png");
		ImageIcon image10 = new ImageIcon(icono10.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataquenemigo.add(image10);
		ataquenemigo.add(imagen7);
		ataquenemigo.add(imagen8);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setAnchoventana(screenSize.width);
		this.setAltoventana(screenSize.height);
		this.getLabel().setIcon(this.getDerecha().get(0));
		this.setArrayenuso(this.getDerecha());
		this.getLabel().setOpaque(false);
	}
}
