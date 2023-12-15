import java.io.Serializable;

public class Item implements Serializable {
    private String nombre;
    private String icono;

    public Item(String nombre, String icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getIcono() {
        return icono;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    // toString
    @Override
    public String toString() {
        return "Item{" +
               "nombre='" + nombre + '\'' +
               ", icono='" + icono + '\'' +
               '}';
    }
}