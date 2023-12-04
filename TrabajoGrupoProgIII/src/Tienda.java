import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {
    private Map<String, Producto> inventario;
    private double dineroDisponible;

    public Tienda(double dineroInicialDelComprador) {
        this.inventario = new HashMap<>();
        this.dineroDisponible = dineroInicialDelComprador;
    }

    // Métodos para la gestión de productos
    public void agregarProducto(String tipo, double precio, LocalDate fechaCompra) {
        Producto producto = new Producto(tipo, precio, fechaCompra);
        inventario.put(tipo, producto);
    }

    public void comprarProducto(String tipo) {
        if (inventario.containsKey(tipo)) {
            Producto producto = inventario.get(tipo);
            if (dineroDisponible >= producto.getPrecio()) {
                dineroDisponible -= producto.getPrecio();
                System.out.println("Producto comprado: " + tipo + " por " + producto.getPrecio() + " en " + producto.getFechaCompra());
            } else {
                System.out.println("No tienes suficiente dinero para comprar este producto.");
            }
        } else {
            System.out.println("Producto no disponible.");
        }
    }

    // Getters y Setters para Tienda
    public List<Producto> getListaProductos() {
        return new ArrayList<>(inventario.values());
    }
    
    
    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    // Métodos adicionales
    public void mostrarInventario() {
        for (Producto producto : inventario.values()) {
            System.out.println("Tipo: " + producto.getTipo() +
                               ", Precio: " + producto.getPrecio() +
                               ", Fecha de Compra: " + producto.getFechaCompra());
        }
    }

    public void actualizarPrecio(String tipoArmaCorta, String tipoArmaLarga, double nuevoPrecio) {
        String clave = tipoArmaCorta + " " + tipoArmaLarga;
        if (inventario.containsKey(clave)) {
            Producto producto = inventario.get(clave);
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado para " + clave);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public boolean verificarDisponibilidad(String tipoArmaCorta, String tipoArmaLarga) {
        return inventario.containsKey(tipoArmaCorta + " " + tipoArmaLarga);
    }

    public void eliminarProducto(String tipoArmaCorta, String tipoArmaLarga) {
        String clave = tipoArmaCorta + " " + tipoArmaLarga;
        if (inventario.remove(clave) != null) {
            System.out.println("Producto eliminado: " + clave);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public double valorTotalInventario() {
        double total = 0.0;
        for (Producto producto : inventario.values()) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void aplicarDescuento(double porcentajeDescuento) {
        for (Producto producto : inventario.values()) {
            double nuevoPrecio = producto.getPrecio() * (1 - porcentajeDescuento / 100);
            producto.setPrecio(nuevoPrecio);
        }
        System.out.println("Descuento aplicado a todos los productos.");
    }

    // Método principal para probar la clase
   /* public static void main(String[] args) {
        Tienda miTienda = new Tienda(500.0); // Dinero inicial del comprador
        miTienda.agregarProducto("Pistola", "Rifle", 200.0, LocalDate.now());
        miTienda.agregarProducto("Cuchillo", "Escopeta", 300.0, LocalDate.now());

        miTienda.comprarProducto("Pistola", "Rifle");
        System.out.println("Dinero restante: " + miTienda.getDineroDisponible());

        miTienda.comprarProducto("Cuchillo", "Escopeta"); // Verificar si tiene suficiente dinero

        // Otros métodos pueden ser probados aquí
    }*/
}
