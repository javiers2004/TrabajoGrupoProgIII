import java.io.Serializable;

public class ItemCura extends Item implements Serializable{
    private double curacion;
    private double cooldown;

    public ItemCura(String nombre, String icono, double curacion, double cooldown) {
        super(nombre, icono);
        this.curacion = curacion;
        this.cooldown = cooldown;
    }

    // Getters
    public double getCuracion() {
        return curacion;
    }

    public double getCooldown() {
        return cooldown;
    }

    // Setters
    public void setCuracion(double curacion) {
        this.curacion = curacion;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    // toString
    @Override
    public String toString() {
        return "ItemCura{" +
               "nombre='" + getNombre() + '\'' +
               ", icono='" + getIcono() + '\'' +
               ", curacion=" + curacion +
               ", cooldown=" + cooldown + '}';
    }
}
