import java.time.LocalDate;

public class Producto {
    private String tipo; // Puede ser "arma corta" o "arma larga"
    private double precio;
    private LocalDate fechaCompra;

    public Producto(String tipo, double precio, LocalDate fechaCompra) {
        this.tipo = tipo;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
