
public class Jugador {
	protected int posx;
	protected int posy;
	protected int vidatotal;
	protected int vidarestante;
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
	public Jugador() {
		super();
		this.posx = 0;
		this.posy = 3000;
		this.vidatotal = 100;
		this.vidarestante = 100;
	}
	
	
}
