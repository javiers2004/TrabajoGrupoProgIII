import java.io.Serializable;

public class ItemAtaqueCorto extends Item implements Serializable {
    private double daño;
    private double coste;
    private double cooldown;

    public ItemAtaqueCorto(String nombre, String icono, double daño, double coste, double cooldown) {
        super(nombre, icono);
        this.daño = daño;
        this.coste = coste;
        this.cooldown = cooldown;
    }
    // Getters
    @Override
    public double getDaño() {
        return daño;
    }
    @Override
    public double getCoste() {
        return coste;
    }
    @Override
    public double getCooldown() {
        return cooldown;
    }

    // Setters
    public void setDaño(double daño) {
        this.daño = daño;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
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
               '}';
    }
}
