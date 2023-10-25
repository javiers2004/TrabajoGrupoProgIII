import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Jugador {
	protected int posx;
	protected int posy;
	protected int vidatotal;
	protected int vidarestante;
	protected int experiencia;
	protected double staminatotal;
	protected double staminarestante;
	protected ArrayList<ImageIcon> derecha;
	protected ArrayList<ImageIcon> izquierda;
	
	
	
	protected ArrayList<ImageIcon> getIzquierda() {
		return izquierda;
	}
	protected void setIzquierda(ArrayList<ImageIcon> izquierda) {
		this.izquierda = izquierda;
	}
	protected ArrayList<ImageIcon> getDerecha() {
		return derecha;
	}
	protected void setDerecha(ArrayList<ImageIcon> derecha) {
		this.derecha = derecha;
	}
	protected double getStaminatotal() {
		return staminatotal;
	}
	protected void setStaminatotal(double staminatotal) {
		this.staminatotal = staminatotal;
	}
	protected double getStaminarestante() {
		return staminarestante;
	}
	protected void setStaminarestante(double staminarestante) {
		this.staminarestante = staminarestante;
	}
	protected int getPosx() {
		return posx;
	}
	protected void setPosx(int posx) {
		this.posx = posx;
	}
	protected int getPosy() {
		return posy;
	}
	protected void setPosy(int posy) {
		this.posy = posy;
	}
	protected int getVidatotal() {
		return vidatotal;
	}
	protected void setVidatotal(int vidatotal) {
		this.vidatotal = vidatotal;
	}
	protected int getVidarestante() {
		return vidarestante;
	}
	protected void setVidarestante(int vidarestante) {
		this.vidarestante = vidarestante;
	}
	
	protected int getExperiencia() {
		return experiencia;
	}
	protected void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	public Jugador() {
		super();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.posx = (int)(57);
		this.posy = (int)(431);
		this.vidatotal = 100;
		this.vidarestante = 100;
		this.experiencia = 0;
		this.staminatotal = 100;
		this.staminarestante = 100;	
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/dcha1.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/dcha2.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
		derecha.add(imagen);
		derecha.add(imagen2);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/izq1.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/izq2.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		this.izquierda = izquierda;
	}	
}
