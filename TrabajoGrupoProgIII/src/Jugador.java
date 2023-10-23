import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jugador {
	protected int posx;
	protected int posy;
	protected int vidatotal;
	protected int vidarestante;
	protected int experiencia;
	protected double staminatotal;
	protected double staminarestante;
	protected BufferedImage[] andar;
	
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
	
	public BufferedImage[] getAndar() {
		return andar;
	}
	public void setAndar(BufferedImage[] andar) {
		this.andar = andar;
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
		andar = new BufferedImage[4];	
	}	
}
