import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Jugador extends Entity{
	protected int posx;
	protected int posy;
	protected int vidatotal;
	protected int vidarestante;
	protected int experiencia;
	protected double staminatotal;
	protected double staminarestante;
	protected KeyHandler keyh;
	
	
	public KeyHandler getKeyh() {
		return keyh;
	}
	public void setKeyh(KeyHandler keyh) {
		this.keyh = keyh;
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
		GetPlayerImage();
		direction = "right";
		//update();
	}	
	
	
	

	public void GetPlayerImage() {
		try {
			dcha1= ImageIO.read(getClass().getResourceAsStream("dcha1.png"));
			dcha2 = ImageIO.read(getClass().getResourceAsStream("dcha2.png"));
			//izk1 = ImageIO.read(getClass().getResourceAsStream("/sprites/guard_sword_3.png"));
			//izk2 = ImageIO.read(getClass().getResourceAsStream("/sprites/guard_sword_4.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyh.upPressed == true) {
			direction ="up";
		}
		if(keyh.downPressed == true) {
			direction ="down";
		}
		if(keyh.rightPressed == true) {
			direction ="right";
		}
		if(keyh.leftPressed == true) {
			direction ="left";
		}
		spriteCounter++;
		if(spriteCounter >12) {
			if(spriteNum == 1) {
				spriteNum=2;
			}else if(spriteNum ==2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	public BufferedImage draw () {
		BufferedImage image = null;
		switch(direction) {
		case "right": 
			if(spriteNum == 1) {
				image = dcha1;
			}if(spriteNum ==2) {
				image = dcha2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = izk1;
			}if(spriteNum ==2) {
				image = izk2;
			}
			
			break;
		}
		return image;
			
	}
}
