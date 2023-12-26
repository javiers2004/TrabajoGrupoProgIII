import java.io.Serializable;

public class ItemAtaqueCorto extends Item implements Serializable {
    private int daño;
    private int coste;
    private double cooldown;
    private String descripcion;

    public ItemAtaqueCorto(String nombre, String icono, int daño, int coste, double cooldown, String descripcion, boolean comprado, String dueño) {
        super(nombre, icono, comprado, dueño);
        this.daño = daño;
        this.coste = coste;
        this.cooldown = cooldown;
        this.descripcion = descripcion;
    }

    public double getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ItemAtaqueCorto{" +
               "nombre='" + getNombre() + '\'' +
               ", icono='" + getIcono() + '\'' +
               ", danio=" + daño +
               ", coste=" + coste +
               ", cooldown=" + cooldown +
               ", descripcion='" + descripcion + '\'' +
               ", comprado=" + isComprado() +
               ", dueño='" + getDueño() + '\'' +
               '}';
    }
}
