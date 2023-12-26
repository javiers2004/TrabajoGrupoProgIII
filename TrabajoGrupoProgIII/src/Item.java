import java.io.Serializable;

public class Item implements Serializable {
    private String nombre;
    private String icono;
    private boolean comprado;
    private String dueño;

    public Item(String nombre, String icono, boolean comprado, String dueño) {
        this.nombre = nombre;
        this.icono = icono;
        this.comprado = comprado;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    @Override
    public String toString() {
        return "Item{" +
               "nombre='" + nombre + '\'' +
               ", icono='" + icono + '\'' +
               ", comprado=" + comprado +
               ", dueño='" + dueño + '\'' +
               '}';
    }
}
