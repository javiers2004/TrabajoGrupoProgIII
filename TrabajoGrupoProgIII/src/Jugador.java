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
	protected BufferedImage[] andar;
	
	
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
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
		//this.posx = (int)(1968 + screenWidth/1.5);
		//this.posy = (int)(2019 + screenHeight/1.5);
		this.posx = (int)(57);
		this.posy = (int)(411);
		this.vidatotal = 100;
		this.vidarestante = 100;
		this.experiencia = 0;
		
		
		andar = new BufferedImage[4];
		
		
	}
	
	
}
