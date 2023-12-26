import java.io.Serializable;

public class ItemCura extends Item implements Serializable {
    private double curacion;
    private double cooldown;
    private int coste;
    private String descripcion;

    public ItemCura(String nombre, String icono, double curacion, double cooldown, int coste, String descripcion, boolean comprado, String dueño) {
        super(nombre, icono, comprado, dueño);
        this.curacion = curacion;
        this.cooldown = cooldown;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    public double getCuracion() {
        return curacion;
    }

    public void setCuracion(double curacion) {
        this.curacion = curacion;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ItemCura{" +
               "nombre='" + getNombre() + '\'' +
               ", icono='" + getIcono() + '\'' +
               ", curacion=" + curacion +
               ", cooldown=" + cooldown +
               ", coste=" + coste +
               ", descripcion='" + descripcion + '\'' +
               ", comprado=" + isComprado() +
               ", dueño='" + getDueño() + '\'' +
               '}';
    }
}
