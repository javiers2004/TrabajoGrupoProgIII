import java.io.Serializable;

public class ItemCura extends Item implements Serializable {
    private double curacion;
    private double cooldown;
    private int coste; // Coste añadido
    private String descripcion; // Descripción añadida

    public ItemCura(String nombre, String icono, double curacion, double cooldown, int coste, String descripcion) {
        super(nombre, icono);
        this.curacion = curacion;
        this.cooldown = cooldown;
        this.coste = coste; // Asignando el valor de coste
        this.descripcion = descripcion; // Asignando el valor de descripción
    }

    // Getters y Setters para curacion y cooldown
    public double getCuracion() {
        return curacion;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCuracion(double curacion) {
        this.curacion = curacion;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    // Getters y Setters para coste y descripcion
    public int getCoste() {
        return coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return "ItemCura{" +
               "nombre='" + getNombre() + '\'' +
               ", icono='" + getIcono() + '\'' +
               ", curacion=" + curacion +
               ", cooldown=" + cooldown +
               ", coste=" + coste +
               ", descripcion='" + descripcion + '\'' +
               '}';
    }
}
