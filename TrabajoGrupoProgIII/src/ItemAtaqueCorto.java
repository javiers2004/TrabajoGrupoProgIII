import java.io.Serializable;

public class ItemAtaqueCorto extends Item implements Serializable {
    private int daño;
    private int coste;
    private double cooldown;
    private String descripcion;

    public ItemAtaqueCorto(String nombre, String icono, int daño, int coste, double cooldown, String descripcion) {
        super(nombre, icono);
        this.daño = daño;
        this.coste = coste;
        this.cooldown = cooldown;
        this.descripcion = descripcion;
    }
    // Getters

    public double getDaño() {
        return daño;
    }

    public double getCoste() {
        return coste;
    }

    public double getCooldown() {
        return cooldown;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setDaño(int daño) {
        this.daño = daño;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }
    
    public void setCooldown(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return "ItemAtaqueCorto{" +
               "nombre='" + getNombre() + '\'' +
               ", icono='" + getIcono() + '\'' +
               ", danio=" + daño +
               ", coste=" + coste +
               ", cooldown=" + cooldown +
               ", descripcion=" + descripcion +
               '}';
    }
}
