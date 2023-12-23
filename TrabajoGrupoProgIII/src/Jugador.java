import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




public class Jugador {
	private String nombre;
	protected int posx;
	protected int posy;
	protected int vidatotal;
	protected int vidarestante;
	protected int experiencia;
	protected double staminatotal;
	protected double staminarestante;
	protected ArrayList<ImageIcon> derecha;
	protected ArrayList<ImageIcon> izquierda;
	protected ArrayList<ImageIcon> ataqueespadader;
	protected ArrayList<ImageIcon> ataqueespadaizq;
	protected int nivel;
	protected HashMap<Object, Integer> estadisticas = new HashMap<Object, Integer>();
	protected int numerodegolpes = 0;
	protected int distance = 0;
	protected int goplesefectivos = 0;
	protected int danoinflingido = 0;
	protected int danorecibido = 0;
	protected ArrayList<ImageIcon> arrayenuso;
	protected int contadorsprites = 0;
	
	
	
	protected int getDanorecibido() {
		return danorecibido;
	}
	protected void setDanorecibido(int danorecibido) {
		this.danorecibido = danorecibido;
	}
	protected int getDanoinflingido() {
		return danoinflingido;
	}
	protected void setDanoinflingido(int danoinflingido) {
		this.danoinflingido = danoinflingido;
	}
	protected int getGoplesefectivos() {
		return goplesefectivos;
	}
	protected void setGoplesefectivos(int goplesefectivos) {
		this.goplesefectivos = goplesefectivos;
	}
	protected int getNumerodegolpes() {
		return numerodegolpes;
	}
	protected void setNumerodegolpes(int numerodegolpes) {
		this.numerodegolpes = numerodegolpes;
	}
	protected int getDistance() {
		return distance;
	}
	protected void setDistance(int distance) {
		this.distance = distance;
	}
	protected int getContadorsprites() {
		return contadorsprites;
	}
	protected void setContadorsprites(int contadorsprites) {
		this.contadorsprites = contadorsprites;
	}
	protected ArrayList<ImageIcon> getArrayenuso() {
		return arrayenuso;
	}
	protected void setArrayenuso(ArrayList<ImageIcon> arrayenuso) {
		this.arrayenuso = arrayenuso;
	}
	protected HashMap<Object, Integer> getEstadisticas() {
		return estadisticas;
	}
	protected void setEstadisticas(HashMap<Object, Integer> estadisticas) {
		this.estadisticas = estadisticas;
	}
	public String getNombre() {
		return VentanaInicio.nombreUsuario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected ArrayList<ImageIcon> getAtaqueespadaizq() {
		return ataqueespadaizq;
	}
	protected void setAtaqueespadaizq(ArrayList<ImageIcon> ataqueespadaizq) {
		this.ataqueespadaizq = ataqueespadaizq;
	}
	protected ArrayList<ImageIcon> getAtaqueespadader() {
		return ataqueespadader;
	}
	protected void setAtaqueespadader(ArrayList<ImageIcon> ataqueespada) {
		this.ataqueespadader = ataqueespada;
	}
	protected int getNivel() {
		return nivel;
	}
	protected String getNivelStr() {
		return String.valueOf(nivel);
	}
	protected void setNivel(int nivel) {
		this.nivel = nivel;
	}
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
		this.posx = (int)(1000);
		this.posy = (int)(10000);
		
		this.vidatotal = 100;
		this.vidarestante = 100;
		this.experiencia = 0;
		this.staminatotal = 100;
		this.staminarestante = 100;	
		ArrayList<ImageIcon> derecha = new ArrayList<ImageIcon>();
		ImageIcon icono = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/right0.png");
		ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono2 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/right1.png");
		ImageIcon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono5 =new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/right2.png");
		ImageIcon imagen5 = new ImageIcon(icono5.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		derecha.add(imagen5);
		derecha.add(imagen);
		derecha.add(imagen2);
		this.derecha = derecha;
		ArrayList<ImageIcon> izquierda = new ArrayList<ImageIcon>();
		ImageIcon icono3 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/left0.png");
		ImageIcon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono4 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/left1.png");
		ImageIcon imagen4 = new ImageIcon(icono4.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		ImageIcon icono6 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/left2.png");
		ImageIcon imagen6 = new ImageIcon(icono6.getImage().getScaledInstance(30,46, Image.SCALE_SMOOTH));
		izquierda.add(imagen3);
		izquierda.add(imagen4);
		izquierda.add(imagen6);
		this.izquierda = izquierda;
		ArrayList<ImageIcon> ataqueespadader = new ArrayList<ImageIcon>();		
		ImageIcon icono7 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/aright2.png");
		ImageIcon imagen7 = new ImageIcon(icono7.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono8 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/aright1.png");
		ImageIcon imagen8 = new ImageIcon(icono8.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataqueespadader.add(imagen7);
		ataqueespadader.add(imagen8);
		this.ataqueespadader = ataqueespadader;	
		ArrayList<ImageIcon> ataqueespadaizq = new ArrayList<ImageIcon>();		
		ImageIcon icono9 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/aleft2.png");
		ImageIcon imagen9 = new ImageIcon(icono9.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ImageIcon icono10 = new ImageIcon("TrabajoGrupoProgIII/src/Imagenes/Jugador/aleft1.png");
		ImageIcon imagen10 = new ImageIcon(icono10.getImage().getScaledInstance(60,45, Image.SCALE_SMOOTH));
		ataqueespadaizq.add(imagen9);
		ataqueespadaizq.add(imagen10);
		this.ataqueespadaizq = ataqueespadaizq;
		this.nivel = 1;
		estadisticas.put(Slime.class, 0);
		estadisticas.put(Pajaro.class, 0);
		estadisticas.put(Bat.class, 0);
		estadisticas.put(Caparazon.class, 0);
		estadisticas.put(Puercoespin.class, 0);
		estadisticas.put(Goblin.class, 0);

	}
	public Jugador(String nombre, String nivel) {
		super();
		this.nombre = nombre;
		this.nivel = Integer.parseInt(nivel);
	}
	
	/*public static void actualizarDesdeArchivo(String rutaArchivo, Jugador jugador) {
        File archivo = new File(rutaArchivo);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	System.out.println("Nombre del jugador a buscar: " + jugador.getNombre());

                String[] datos = linea.split(";");
                System.out.println("Leyendo línea: " + linea);
                System.out.println("Encontrado jugador: " + datos[0]);
                System.out.println("Encontrado jugador: " + jugador.getNombre());

                if (datos[0].equals(jugador.getNombre())) {
                    System.out.println("Encontrado jugador: " + jugador.getNombre());

                    // Actualizar los datos del jugador usando métodos set
                    jugador.setNivel(Integer.parseInt(datos[1]));
                    jugador.setExperiencia(Integer.parseInt(datos[2]));
                    jugador.setVidarestante(Integer.parseInt(datos[3]));
                    jugador.setPosx(Integer.parseInt(datos[4]));
                    jugador.setPosy(Integer.parseInt(datos[5]));


                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
	

